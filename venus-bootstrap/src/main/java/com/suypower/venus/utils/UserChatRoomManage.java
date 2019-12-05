package com.suypower.venus.utils;

import com.suypower.venus.common.ConstantChatRoomType;
import com.suypower.venus.entity.ChatMessage;
import com.suypower.venus.entity.ChatRoom;
import com.suypower.venus.entity.User;
import com.suypower.venus.entity.UserChatRoom;

import java.util.*;

public class UserChatRoomManage {
    /**
     * 以用户的姓名为key，UserChatRoomManage为对象保存起来
     */
    public static Map<String, UserChatRoomManage> clients = new LinkedHashMap<>();
    /**
     * 用来管理所有聊天室
     */
    private List<UserChatRoom> userChatRoomList = new ArrayList<>();


    /**
     * 获取 UserChatRoomManage 对象，如果没有，则创建
     *
     * @param userId
     * @return
     */
    public static UserChatRoomManage getOrCreate(String userId) {
        User userByUserId = UserUtils.getUserByUserId(userId);
        if (null == userByUserId) {
            System.err.println(userId + "该用户不存在，无法获取聊天室信息");
            throw new RuntimeException(userId + "该用户不存在，无法获取聊天室信息");
        }

        UserChatRoomManage userChatRoomManage = clients.get(userId);
        if (userChatRoomManage == null) {
            userChatRoomManage = new UserChatRoomManage();
            clients.put(userId, userChatRoomManage);
        }
        return userChatRoomManage;
    }

    /**
     * 通过用户id，聊天室id给聊天室添加消息
     * 前提条件: 已经存在两个人私聊聊天室
     *
     * @param userId
     * @param roomId
     * @param chatMessage
     */
    public static void addMessage(String userId, String roomId, ChatMessage chatMessage) {
        //获取UserChatRoomManage
        UserChatRoomManage userChatRoomManage = getOrCreate(userId);
        List<UserChatRoom> userChatRooms = userChatRoomManage.getUserChatRoomList();

        for (UserChatRoom userChatRoom : userChatRooms) {
            if (null != userChatRoom) {
                //匹配房间
                if (userChatRoom.getChatRoom().getRoomId().equals(roomId)) {
                    ChatRoom chatRoom = userChatRoom.getChatRoom();
                    if (null != chatRoom) {
                        chatRoom.getMsg().add(chatMessage);
                        break;
                    }

                }
            }
        }

    }


    /**
     * 删除聊天室
     *
     * @param userId
     * @param roomId
     * @return
     */
    public static boolean delChatRoom(String userId, String roomId) {
        List<ChatMessage> chatMessageList = UserChatRoomManage.getChatMessageList(userId, roomId);
        if (null != chatMessageList) {
            for (ChatMessage chatMessage : chatMessageList) {
                Set<String> delUserIdList = chatMessage.getDelUserIdList();
                if (delUserIdList == null)
                    delUserIdList = new HashSet<>();
                delUserIdList.add(userId);
                chatMessage.setDelUserIdList(delUserIdList);
            }
        }

        return true;
    }

    public static boolean userIsDelChatMessage(ChatMessage chatMessage, String userId) {
        if (chatMessage != null) {
            Set<String> delUserIdList = chatMessage.getDelUserIdList();
            if (null == delUserIdList) return false;
            return delUserIdList.contains(userId);
        }
        return false;
    }

    /**
     * 通过Userid 和 roomId找到聊天室的所有聊天记录(不包含用户删除的)
     *
     * @param userId
     * @param roomId
     * @return
     */
    public static List<ChatMessage> getChatMessageExceptDel(String userId, String roomId, String lastMsgId, Long limit, boolean isLimit) {
        UserChatRoom userChatRoom = UserChatRoomManage.getUserChatRoom(userId, roomId);

        List<ChatMessage> find = new ArrayList<>();
        List<ChatMessage> chatMessageList = UserChatRoomManage.getChatMessageList(userId, roomId);
        if (null == chatMessageList) return find;
//        Collections.reverse(chatMessageList); //先倒序
        int count = 0;

        boolean flag = false;
        for (int i = chatMessageList.size() - 1; i >= 0; i--) {
            Long time = chatMessageList.get(i).getTime();
            ChatMessage chatMessage = chatMessageList.get(i);
            //用户没有删除的信息
            boolean msgIsDel = UserChatRoomManage.userIsDelChatMessage(chatMessage, userId);

            if (isLimit) {
                String id = chatMessage.getId();
                //开始分页
                //初始化进来
                if (StringUtils.isEmpty(lastMsgId)) {
                    flag = true;
                    if (!msgIsDel) {
                        find.add(chatMessage);
                        count++;
                    }


                    lastMsgId = id;
                    //若果不小零
                    if ((i - 1) >= 0) {
                        ChatMessage prevMsg = chatMessageList.get(i - 1);
                        lastMsgId = prevMsg.getId();
                    }

                    //满足结束
                    if (count == limit) {
                        break;
                    }
                }
                //传递页数进来
                else if (lastMsgId.equals(id)) {
                    //判断后面还有没有数据:即判断i是否==0了，如果==0，则结束
                    if ((i - 1) < 0) {
                        if (!flag) {
                            break;
                        }

                        //说明是最后一条
                        if (!msgIsDel) {
                            find.add(chatMessage);
                        }

                        break;
                    } else {
                        ChatMessage prevMsg = chatMessageList.get(i - 1);
                        //判断是不是初始化进来
                        ChatMessage shoudPut = null;
                        if (flag) {
                            shoudPut = chatMessage;
//                            flag = false;
                        } else {
                            shoudPut = prevMsg;
                        }

                        if (!msgIsDel) {
                            find.add(shoudPut);
                            count++;
                        }

                        lastMsgId = prevMsg.getId();
                        //满足结束
                        if (count == limit) {
                            break;
                        }
                    }

                }
            }
            //不用管，其他接口使用的,固定传no
            else {
                if (!msgIsDel) {
                    find.add(chatMessage);
                    count++;
                }

            }


        }
        Collections.reverse(find); //再正回来
        return find;

    }

    /**
     * 是否被踢
     *
     * @param userId
     * @param roomId
     * @return
     */
    public static boolean isKicked(String userId, String roomId) {
        UserChatRoom userChatRoom = UserChatRoomManage.getUserChatRoom(userId, roomId);
        if (userChatRoom != null) {
            return userChatRoom.isKickOut();
        }
        return false;
    }

    /**
     * 获取聊天室中被踢出的用户
     *
     * @param roomId
     * @return
     */
    public static Set<String> getUserIdSetIsKicked(String roomId) {
        Set<String> userList = new HashSet<>();
        for (Map.Entry<String, UserChatRoomManage> entry : clients.entrySet()) {

            UserChatRoomManage userChatRoomManage = entry.getValue();
            if (null == userChatRoomManage) {
                continue;
            }
            List<UserChatRoom> userChatRooms = userChatRoomManage.getUserChatRoomList();
            if (null != userChatRooms && userChatRooms.size() > 0) {
                for (UserChatRoom userChatRoom : userChatRooms) {
                    if (null != userChatRoom) {
                        ChatRoom chatRoom = userChatRoom.getChatRoom();
                        if (chatRoom != null && chatRoom.getRoomId().equals(roomId)) {
                            boolean kickOut = userChatRoom.isKickOut();
                            if (kickOut) {
                                userList.add(userChatRoom.getUser().getUserId());
                            }
                        }
                    }


                }
            }
        }
        return userList;
    }

    /**
     * 通过房间id查找房间的所有用户
     * 除去被剔除的
     *
     * @param roomId
     * @return
     */
    public static List<User> getUserList(String roomId) {
        List<User> userList = new ArrayList<>();
        for (Map.Entry<String, UserChatRoomManage> entry : clients.entrySet()) {

            UserChatRoomManage userChatRoomManage = entry.getValue();
            if (null == userChatRoomManage) {
                continue;
            }
            List<UserChatRoom> userChatRooms = userChatRoomManage.getUserChatRoomList();
            if (null != userChatRooms && userChatRooms.size() > 0) {
                for (UserChatRoom userChatRoom : userChatRooms) {
                    if (null != userChatRoom) {
                        boolean kickOut = userChatRoom.isKickOut(); //是否被剔除
                        ChatRoom chatRoom = userChatRoom.getChatRoom();
                        if (!kickOut && chatRoom != null && chatRoom.getRoomId().equals(roomId)) {
                            userList.add(userChatRoom.getUser());
                        }
                    }


                }
            }
        }
        return userList;
    }

    /**
     * 通过房间id查找房间的所有用户，排除自己本身、排除被踢的人
     * 如果是群聊，则不排除自己，因为群聊列表，需要显示自己的头像
     *
     * @param chatRoomType
     * @param roomId
     * @param excUserId    需要去掉的用户
     * @return
     */
    public static List<User> getUserList(String chatRoomType, String roomId, String excUserId) {
        List<User> userList = getUserList(roomId);
        if (ConstantChatRoomType.chat_type_friend.equals(chatRoomType)) {
            Iterator<User> iterator = userList.iterator();
            while (iterator.hasNext()) {
                String userId = iterator.next().getUserId();
                if (userId.equals(excUserId)) {
                    iterator.remove();
                }
            }
            return userList;
        } else if (ConstantChatRoomType.chat_type_group.equals(chatRoomType)) {
            return userList;
        }
        return userList;

    }

    /**
     * 获取聊天室所有成员信息(除去指定人)
     * 也排除被剔除的人
     *
     * @param roomId
     * @param excUserIds
     * @return
     */
    public static List<User> getUserList(String roomId, String[] excUserIds) {
        List<User> userList = getUserList(roomId);
        Iterator<User> iterator = userList.iterator();
        while (iterator.hasNext()) {
            String userId = iterator.next().getUserId();
            if (null != excUserIds && excUserIds.length > 0) {
                for (String excUserId : excUserIds) {
                    if (userId.equals(excUserId)) {
                        iterator.remove();
                    }
                }
            }

        }
        return userList;


    }


    /**
     * 通过用户id查找用户聊天室
     *
     * @param userId
     * @return
     */
    public UserChatRoom getUserChatRoomByUserId(String userId) {
        for (UserChatRoom userChatRoom : userChatRoomList) {
            if (null == userChatRoom || null == userChatRoom.getUser()) {
                continue;
            }
            String sessionUserId = userChatRoom.getUser().getUserId();
            if (sessionUserId.equals(userId)) {
                return userChatRoom;
            }
        }
        return null;
    }


    /**
     * 创建用户聊天室列表
     *
     * @param room
     */
    public void addUserChatRoom(UserChatRoom room) {

        userChatRoomList.add(room);
    }


    /**
     * 获取聊天室所有列表
     *
     * @return
     */
    public List<UserChatRoom> getUserChatRoomList() {
        return userChatRoomList;
    }

    public void setUserChatRoomList(List<UserChatRoom> userChatRoomList) {
        this.userChatRoomList = userChatRoomList;
    }

    /**
     * 获取聊天室指定用户聊天室
     *
     * @param userId
     * @return
     */
    public static List<UserChatRoom> getUserChatRooms(String userId) {
        UserChatRoomManage orCreate = UserChatRoomManage.getOrCreate(userId);
        List<UserChatRoom> userChatRooms = orCreate.getUserChatRoomList();
        return userChatRooms;
    }


    /**
     * 判断两个人是否建立聊天室
     * 注意：线程安全问题
     *
     * @param oneUserId
     * @param otherUserid
     * @return
     */
    public static boolean IsMatchingChatRoom(String oneUserId, String otherUserid, String roomType) {
        String roomId = getRoomId(oneUserId, otherUserid, roomType);
        if (StringUtils.isEmpty(roomId)) {
            return false;
        }


        return true;
    }

    /**
     * 获取两个人共同的roomId
     *
     * @param oneUserId
     * @param otherUserid
     * @return
     */
    public static String getRoomId(String oneUserId, String otherUserid, String roomType) {

        String find = null;
        List<UserChatRoom> oneUserChatRoomList = UserChatRoomManage.getUserChatRooms(oneUserId);
        List<UserChatRoom> otherUserChatRoomList = UserChatRoomManage.getUserChatRooms(otherUserid);
        if (null != oneUserChatRoomList && oneUserChatRoomList.size() > 0
                && null != otherUserChatRoomList && oneUserChatRoomList.size() > 0
        ) {
            for (UserChatRoom oneRoom : oneUserChatRoomList) {
                if (null != oneRoom && oneRoom.getChatRoom() != null) {
                    String roomId = oneRoom.getChatRoom().getRoomId();
                    String roomTypeIn = oneRoom.getChatRoom().getRoomType();
                    if (!roomTypeIn.equals(roomType)) continue; //判断聊天室类型是否满足

                    for (UserChatRoom otherRoom : otherUserChatRoomList) {
                        if (null != otherRoom && otherRoom.getChatRoom() != null
                                && roomId.equals(otherRoom.getChatRoom().getRoomId())) {
                            String otherRoomTypeIn = otherRoom.getChatRoom().getRoomType();
                            if (!otherRoomTypeIn.equals(roomType)) continue;//判断聊天室类型是否满足
                            return roomId;
                        }

                    }
                }

            }
        }
        return find;
    }

    /**
     * 群聊拉人
     * 备注: 之前存在的人，不应该被拉，而是 将被踢字段设置为 正常
     *
     * @param userId
     * @param roomId
     * @param pullers 被拉者的 userId
     */
    public static void pullToGroup(String userId, String roomId, String[] pullers) {
        ChatRoom chatRoom = UserChatRoomManage.getChatRoom(userId, roomId);
//        List<ChatMessage> chatMessageList = UserChatRoomManage.getChatMessageList(userId, roomId);

        if (null != pullers) {
            for (String puller : pullers) {
                UserChatRoom userChatRoom = UserChatRoomManage.getUserChatRoom(puller, roomId);
                if (userChatRoom != null) {
                    //不等于 null,又能被拉，说明被踢过
                    //将此用户重新激活
                    userChatRoom.setKickOut(false);
                    continue;
                }

                //创建用户群聊室
                User userByUserId = UserUtils.getUserByUserId(puller);
                if (null == userByUserId) throw new RuntimeException("该用户不存在：" + puller);

                UserChatRoomManage.creatChatRoom(puller, chatRoom);
                //历史记录不可看
                UserChatRoomManage.delChatRoom(puller, roomId);
            }
        }

    }

    /**
     * 创建群聊
     *
     * @param userId
     * @param pullers
     * @return roomId
     */
    public static String creatGroupChatRoom(String userId, String[] pullers) {
        if (pullers == null || pullers.length < 2) throw new RuntimeException("创建群聊，拉取人数不得少于2人");
        String roomId = StringUtils.uuid();
        String msgOfPull = UserUtils.youInviteWho(userId, pullers);
        ChatMessage msg = new ChatMessage(StringUtils.uuid(), userId, "", "", msgOfPull, new Date().getTime(), roomId);
        msg.setDelUserIdList(new HashSet<String>() {{
//            this.add(userId); //自己不需要屏蔽
            for (String puller : pullers) {
                this.add(puller);
            }

        }});
        List<ChatMessage> msgList = new ArrayList<ChatMessage>() {{
            this.add(msg);
        }};

        List<User> userList = new ArrayList<User>() {{

            this.add(UserUtils.getUserByUserId(userId));
            for (String puller : pullers) {
                this.add(UserUtils.getUserByUserId(puller));
            }
        }};
        ChatRoom chatRoom = new ChatRoom(roomId, ConstantChatRoomType.chat_type_group, msgList, userList, userId, "群聊");
        UserChatRoomManage.creatChatRoom(userId, chatRoom);
        for (String puller : pullers) {
            UserChatRoomManage.creatChatRoom(puller, chatRoom);
        }
        return roomId;
    }

    /**
     * 创建新的聊天窗口
     *
     * @param fromUserId
     * @param toUserId
     * @return
     */
    public static String creatChatRoom(String fromUserId, String toUserId, String roomType) {
        try {
            if (null == UserUtils.getUserByUserId(fromUserId) || null == UserUtils.getUserByUserId(toUserId)) {
                throw new RuntimeException("用户不存在，建立聊天窗口失败!");
            }

            boolean flag = false;
            String roomIdFind = UserChatRoomManage.getRoomId(fromUserId, toUserId, roomType);
            if (!StringUtils.isEmpty(roomIdFind)) {
                flag = true;
            }

            //不存在才创建
            if (!flag) {
                //创建
                String roomId = StringUtils.uuid();
                ChatMessage msg = new ChatMessage(StringUtils.uuid(), fromUserId, toUserId, "", "", new Date().getTime(), roomId);
                msg.setDelUserIdList(new HashSet<String>() {{
                    this.add(fromUserId);
                    this.add(toUserId);
                }});
                List<ChatMessage> msgList = new ArrayList<ChatMessage>() {{
                    this.add(msg);
                }};
                List<User> userList = new ArrayList<User>() {{
                    this.add(UserUtils.getUserByUserId(fromUserId));
                    this.add(UserUtils.getUserByUserId(toUserId));
                }};
                ChatRoom chatRoom = new ChatRoom(roomId, roomType, msgList, userList, fromUserId, "");
                UserChatRoomManage.creatChatRoom(fromUserId, chatRoom);
                UserChatRoomManage.creatChatRoom(toUserId, chatRoom);

                return roomId;
            }
            return roomIdFind;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    //创建用户聊天窗口
    private static void creatChatRoom(String fromUserId, ChatRoom chatRoom) {
        UserChatRoomManage userChatRoomManage = UserChatRoomManage.getOrCreate(fromUserId);
        UserChatRoom userChatRoom = new UserChatRoom(UserUtils.getUserByUserId(fromUserId),
                chatRoom, new Date().getTime(), false, true);
        userChatRoomManage.addUserChatRoom(userChatRoom);
    }


    /**
     * 获取聊天室
     *
     * @param userId
     * @param roomId
     * @return
     */
    public static ChatRoom getChatRoom(String userId, String roomId) {
        List<UserChatRoom> userChatRooms = UserChatRoomManage.getUserChatRooms(userId);
        if (null != userChatRooms && userChatRooms.size() > 0) {
            for (UserChatRoom userChatRoom : userChatRooms) {
                if (null != userChatRoom) {
                    ChatRoom chatRoom = userChatRoom.getChatRoom();
                    if (null != chatRoom) {
                        if (chatRoom.getRoomId().equals(roomId)) {
                            return chatRoom;
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * 获取聊天室类型
     * 通过用户和聊天室roomId
     *
     * @param userId
     * @param roomId
     * @return
     */
    public static String getChatRoomType(String userId, String roomId) {
        ChatRoom chatRoom = UserChatRoomManage.getChatRoom(userId, roomId);
        if (null != chatRoom) return chatRoom.getRoomType();
        return null;
    }

    /**
     * 获取聊天室名字
     *
     * @param userId
     * @param roomId
     * @return
     */
    public static String getChatRoomName(String userId, String roomId) {
        ChatRoom chatRoom = UserChatRoomManage.getChatRoom(userId, roomId);
        if (null != chatRoom) return chatRoom.getRoomName();
        return null;
    }

    /**
     * 获取UserChatRoom
     *
     * @param userId
     * @param roomId
     * @return
     */
    public static UserChatRoom getUserChatRoom(String userId, String roomId) {
        List<UserChatRoom> userChatRooms = UserChatRoomManage.getUserChatRooms(userId);
        if (null != userChatRooms && userChatRooms.size() > 0) {
            for (UserChatRoom userChatRoom : userChatRooms) {
                if (userChatRoom == null) continue;
                if (userChatRoom.getChatRoom().getRoomId().equals(roomId)) {
                    return userChatRoom;
                }
            }
        }
        return null;
    }


    /**
     * 更新用户聊天室时间
     *
     * @param userId
     * @param roomId
     */
    public static void updateUserChatRoomTime(String userId, String roomId) {
        UserChatRoom userChatRoom = UserChatRoomManage.getUserChatRoom(userId, roomId);
        userChatRoom.setUpdateTime(TimeUtils.getCurrentTimeMillis());
    }

    /**
     * 用户聊天室设置置顶
     *
     * @param userId
     * @param roomId
     * @param isTop
     */
    public static void setTop(String userId, String roomId, boolean isTop) {
        UserChatRoom userChatRoom = UserChatRoomManage.getUserChatRoom(userId, roomId);
        userChatRoom.setTop(isTop);
    }

    /**
     * 查找聊天室的信息列表
     *
     * @param userId
     * @param roomId
     * @return
     */
    public static List<ChatMessage> getChatMessageList(String userId, String roomId) {
        ChatRoom chatRoom = UserChatRoomManage.getChatRoom(userId, roomId);
        if (chatRoom != null) {
            return chatRoom.getMsg();

        }
        return null;
    }

    /**
     * 查找信息类
     *
     * @param userId
     * @param roomId
     * @param msgId
     * @return
     */
    public static ChatMessage getChatMessage(String userId, String roomId, String msgId) {
        List<ChatMessage> chatMessageList = UserChatRoomManage.getChatMessageList(userId, roomId);
        if (null != chatMessageList) {
            for (ChatMessage chatMessage : chatMessageList) {
                if (null == chatMessage) continue;
                if (chatMessage.getId().equals(msgId)) {
                    return chatMessage;
                }
            }
        }
        return null;
    }


    /**
     * 批量删除聊天信息
     * 条件: 聊天室 id ；删除人 用户 id；  删除的消息信息
     *
     * @param userId
     * @param roomId
     * @param msgIds 多条信息以逗号隔开  123423223,343434434
     */
    public static void delMessage(String userId, String roomId, String[] msgIds) {
        if (null != msgIds) {
            for (String msgId : msgIds) {
                ChatMessage chatMessage = UserChatRoomManage.getChatMessage(userId, roomId, msgId);
                Set<String> delUserIdList = chatMessage.getDelUserIdList();
                if (null == delUserIdList) delUserIdList = new HashSet<>();
                delUserIdList.add(userId);
                chatMessage.setDelUserIdList(delUserIdList);
            }

        }

    }

    /**
     * 撤回聊天信息，即彻底删除聊天记录
     *
     * @param userId
     * @param roomId
     * @param msgId
     */
    public static boolean recallChat(String userId, String roomId, String msgId) {
        ChatRoom chatRoom = UserChatRoomManage.getChatRoom(userId, roomId);
        if (null != chatRoom) {
            List<ChatMessage> msg = chatRoom.getMsg();
            if (msg != null) {
                for (ChatMessage chatMessage : msg) {
                    String id = chatMessage.getId();
                    if (id.equals(msgId)) {
                        //超过1分钟不允许撤回
                        Long time = chatMessage.getTime();
                        if(TimeUtils.getCurrentTimeMillis()-time> 1*60*1000){
                            continue;
                        }
                        msg.remove(chatMessage);
                        return true;
                    }

                }
            }
        }
        return false;
    }



    /**
     * 更新群聊被踢相关信息
     *
     * @param kickUserid
     * @param roomId
     */
    public static void dealKickUserChatRoom(String kickUserid, String roomId) {
        UserChatRoom userChatRoom = UserChatRoomManage.getUserChatRoom(kickUserid, roomId);
        if (null != userChatRoom) {
            userChatRoom.setKickOut(true);
            userChatRoom.setKickOutTime(TimeUtils.getCurrentTimeMillis());
        }
    }

    /**
     * 更新群聊被踢相关信息
     *
     * @param kickUserids
     * @param roomId
     */
    public static void dealKickUserChatRoom(String[] kickUserids, String roomId) {
        if (kickUserids != null && kickUserids.length > 0) {
            for (String userId : kickUserids) {
                UserChatRoomManage.dealKickUserChatRoom(userId, roomId);
            }
        }
    }

    /**
     * 删除用户聊天室
     *
     * @param userId
     * @param roomId
     */
    public static void delUserChatRoom(String userId, String roomId) {
        UserChatRoom userChatRoom = UserChatRoomManage.getUserChatRoom(userId, roomId);
        List<UserChatRoom> userChatRooms = UserChatRoomManage.getUserChatRooms(userId);
        Iterator<UserChatRoom> iterator = userChatRooms.iterator();
        while (iterator.hasNext()) {
            UserChatRoom next = iterator.next();
            if (next.equals(userChatRoom)) {
                iterator.remove();
            }
        }
    }

    /**
     * 获取用户列表
     * 有对应的聊天室，但是聊天记录被删除的
     *
     * @param roomId
     * @param userList
     * @return
     */
    //查看用户集合 ：属于聊天室里的人，却没有自己的用户聊天室
    //得考虑线程安全问题
    public static List<User> getUserListNoChatRecord(String roomId, List<User> userList) {
        List<User> find = new ArrayList<>();
        if (userList == null) return find;
        for (User user : userList) {
            List<ChatMessage> messageList = UserChatRoomManage.getChatMessageExceptDel(user.getUserId(), roomId, null, null, false);
            if (null == messageList || messageList.size() < 1) {
                find.add(user);
            }
        }
        return find;
    }


    public static boolean getUserChatRoomIsActive(String userId, String roomId) {
        UserChatRoom userChatRoom = UserChatRoomManage.getUserChatRoom(userId, roomId);
        if (userChatRoom != null)
            return userChatRoom.isActive();
        return false;
    }

    /**
     * 设置用户所有聊天室窗口激活状态
     *
     * @param userId
     * @param isAcitve
     */
    public static void setAllUserChatRoomActive(String userId, boolean isAcitve) {
        List<UserChatRoom> userChatRooms = UserChatRoomManage.getUserChatRooms(userId);
        if (null != userChatRooms) {
            for (UserChatRoom userChatRoom : userChatRooms) {
                userChatRoom.setActive(isAcitve);
            }
        }

    }

    /**
     * 设置用户聊天室窗口激活状态
     *
     * @param userId
     * @param roomId
     * @param isAcitve
     */
    public static void setUserChatRoomActive(String userId, String roomId, boolean isAcitve) {
        UserChatRoom userChatRoom = UserChatRoomManage.getUserChatRoom(userId, roomId);
        if (userChatRoom != null)
            userChatRoom.setActive(isAcitve);
    }

    /**
     * 添加用户聊天室未读消息数
     *
     * @param userId
     * @param roomId
     */
    public static void addUserChatRoomNewMsgCount(String userId, String roomId) {
        UserChatRoom userChatRoom = UserChatRoomManage.getUserChatRoom(userId, roomId);
        if (userChatRoom != null)
            userChatRoom.setNewMsgCount(userChatRoom.getNewMsgCount() + 1);
    }

    /**
     * 减去用户聊天室未读消息数
     *
     * @param userId
     * @param roomId
     */
    public static void subUserChatRoomNewMsgCount(String userId, String roomId) {
        UserChatRoom userChatRoom = UserChatRoomManage.getUserChatRoom(userId, roomId);
        if (userChatRoom != null) {
            int newMsgCount = userChatRoom.getNewMsgCount();
            if (newMsgCount > 0) {
                userChatRoom.setNewMsgCount(newMsgCount - 1);
            }
        }

    }


    /**
     * 清空用户聊天室未读消息数
     *
     * @param userId
     * @param roomId
     */
    public static void clearUserChatRoomNewMsgCount(String userId, String roomId) {
        UserChatRoom userChatRoom = UserChatRoomManage.getUserChatRoom(userId, roomId);
        if (userChatRoom != null)
            userChatRoom.setNewMsgCount(0);
    }

    /**
     * 更改群聊名称
     *
     * @param userId
     * @param roomId
     * @param roomName
     */
    public static void updateChatRoomName(String userId, String roomId, String roomName) {
        ChatRoom chatRoom = UserChatRoomManage.getChatRoom(userId, roomId);
        if (chatRoom != null)
            chatRoom.setRoomName(roomName);
    }

    /**
     * 获取指定类型聊天记录
     *
     * @param userId
     * @param roomId
     * @param type
     * @return
     */
    public static List<ChatMessage> getChatRecord(String userId, String roomId, String type) {
        List<ChatMessage> find = new ArrayList<>();
        List<ChatMessage> chatMessageExceptDel = UserChatRoomManage.getChatMessageExceptDel(userId, roomId, null, null, false);
        for (ChatMessage chatMessage : chatMessageExceptDel) {
            String msgType = chatMessage.getMsgType();
            if (msgType.equals(type)) {
                find.add(chatMessage);
            }
        }
        return find;
    }

}
