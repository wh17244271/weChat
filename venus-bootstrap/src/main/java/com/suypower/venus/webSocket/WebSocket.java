package com.suypower.venus.webSocket;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.suypower.venus.common.ChatCommonMethod;
import com.suypower.venus.common.ConstantChatRoomType;
import com.suypower.venus.entity.ChatMessage;
import com.suypower.venus.entity.ChatRoom;
import com.suypower.venus.entity.User;
import com.suypower.venus.platform.web.response.DataResponse;
import com.suypower.venus.platform.web.response.DataTypeCode;
import com.suypower.venus.platform.web.response.VenusResponseHttpCode;
import com.suypower.venus.utils.StringUtils;
import com.suypower.venus.utils.UserChatRoomManage;
import com.suypower.venus.utils.UserUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * websocket类
 *
 * @ServerEndpoint: socket链接地址
 */
@ServerEndpoint( "/websocket/{userId}" )
@Component
public class WebSocket {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private static Map<String, Session> client = new ConcurrentHashMap<>();
    private static Map<String, String> client_user = new ConcurrentHashMap<>();


    /**
     * 监听连接（有用户连接，立马到来执行这个方法）
     * session 发生变化
     *
     * @param session
     */
    @OnOpen
    public void onOpen(@PathParam( "userId" ) String userId, Session session) {
        User userByUserId = UserUtils.getUserByUserId(userId);
        if (userByUserId == null) {
            logger.info("进入聊天通道，用户:" + userId + ",不存在");
            return;
        }
        System.err.println(userId + "上线了");
        client.put(userId, session);
        client_user.put(session.getId(), userId);

    }


    /**
     * 监听连接断开（有用户退出，会立马到来执行这个方法）
     */
    @OnClose
    public void onClose(Session session) {
        String id = session.getId();
        String userId = client_user.get(id);
        client.remove(userId);
        client_user.remove(session.getId());
        //下线关闭所有聊天室窗口
        UserChatRoomManage.setAllUserChatRoomActive(userId, false);
        System.err.println(userId + "下线");
//        logger.info(userId + "下线");
    }


    /**
     * 监听消息（收到客户端的消息立即执行）
     *
     * @param message 消息
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        try {
            //处理消息
            ChatMessage chatMessage = SocketUtils.formatMsg(message);
            String dataGroup = chatMessage.getDataGroup();
            String dataType = chatMessage.getDataType();
            //用户发送的信息
            String fromUserId = chatMessage.getFrom();
            String toUserId = chatMessage.getTo();
            System.err.println("》》》》》》》》》》》》》》  有消息进来,分组代码:   " + dataGroup + "  ,实体代码:" + dataType);
            //######################################################   聊天组    ######################################################
            if (DataTypeCode.chat.equals(dataGroup)) {
                // ******************************单人聊天*********************************
                if (DataTypeCode.chat_chatData.equals(dataType)) {

                    //正常窗口聊天
                    this.saveAndSendChatMsg(chatMessage, fromUserId, toUserId);
                    //第一次建立窗口聊天
                    String roomId = chatMessage.getRoomId();
                    String chatRoomType = UserChatRoomManage.getChatRoomType(fromUserId, roomId);
                    //给另一个发送一份
                    ChatRoom otherRoom = this.creatNewChatMsg(chatMessage, toUserId, chatRoomType, "");
                    List<User> userList = UserChatRoomManage.getUserList(chatRoomType, roomId, toUserId);
                    otherRoom.setUser(userList);
                    this.sendMessageToUser(otherRoom, toUserId, DataTypeCode.chat, DataTypeCode.chat_newChatData);
                    //给自己发送一份
                    ChatRoom myRoom = this.creatNewChatMsg(chatMessage, fromUserId, chatRoomType, "");
                    List<User> myList = UserChatRoomManage.getUserList(chatRoomType, roomId, fromUserId);
                    myRoom.setUser(myList);
                    this.sendMessageToUser(myRoom, fromUserId, DataTypeCode.chat, DataTypeCode.chat_newChatData);
                    // 更新新消息条数
                    if (!UserChatRoomManage.getUserChatRoomIsActive(toUserId, roomId)) {
                        UserChatRoomManage.addUserChatRoomNewMsgCount(toUserId, roomId);
                        this.sendMessageToUser(roomId, toUserId, DataTypeCode.chat, DataTypeCode.chat_new_chat_count);
                    }


                }
                // ******************************   多人聊天  *********************************
                else if (DataTypeCode.chat_groupchatData.equals(dataType)) {
                    String roomId = chatMessage.getRoomId();

                    Set<String> userIdSetIsKicked = UserChatRoomManage.getUserIdSetIsKicked(roomId);
                    //设置踢出群的人不可发送这条消息
                    for (String kickUserId : userIdSetIsKicked) {
                        if (kickUserId.equals(fromUserId)) {
                            this.sendMessageToUser("您以被踢出群聊", fromUserId, DataTypeCode.chat, DataTypeCode.chat_group_kick);
                            return;
                        }
                    }
                    //设置踢出群的人,不可接收这条消息
                    chatMessage.setDelUserIdList(userIdSetIsKicked);


                    List<User> userList = UserChatRoomManage.getUserList(roomId); //聊天室里的所有人
                    String chatRoomName = UserChatRoomManage.getChatRoomName(fromUserId, roomId);
                    //1)发送新的窗口 (必须第一个执行,因为一旦发送了消息无法判读他是不是左滑删除了
                    List<User> userListNoChatRecord = UserChatRoomManage.getUserListNoChatRecord(roomId, userList);
                    if (null != userListNoChatRecord && userListNoChatRecord.size() > 0) {
                        for (User user : userListNoChatRecord) {
                            String userId = user.getUserId();
                            ChatRoom myRoom = this.creatNewChatMsg(chatMessage, userId, ConstantChatRoomType.chat_type_group, chatRoomName);
                            List<User> myList = UserChatRoomManage.getUserList(ConstantChatRoomType.chat_type_group, roomId, userId);
                            myRoom.setUser(myList);
                            this.sendMessageToUser(myRoom, userId, DataTypeCode.chat, DataTypeCode.chat_newChatData);
                        }
                    }

                    //2)存储消息
                    UserChatRoomManage.addMessage(fromUserId, roomId, chatMessage);
                    //3）更新多人聊天室时间  //  更新新消息条数
                    for (User user : userList) {
                        String userId = user.getUserId();
                        UserChatRoomManage.updateUserChatRoomTime(userId, roomId);
                        //更新消息条数
                        if (!UserChatRoomManage.getUserChatRoomIsActive(userId, roomId)) {
                            UserChatRoomManage.addUserChatRoomNewMsgCount(userId, roomId);
                            this.sendMessageToUser(roomId, userId, DataTypeCode.chat, DataTypeCode.chat_new_chat_count);
                        }
                    }
                    //4)发送给多人
                    this.sendMessageToGroupRoom(chatMessage, userList, DataTypeCode.chat, DataTypeCode.chat_groupchatData);
                }


                // ******************************撤回消息*********************************
                else if (DataTypeCode.chat_recall.equals(dataType)) {
                    //1）彻底删除这条聊天记录
                    String roomId = chatMessage.getRoomId();
                    String msgId = String.valueOf( chatMessage.getMsg());
                    boolean result = UserChatRoomManage.recallChat(fromUserId, roomId, msgId);
                    //2）角标需要消失   : 群聊要每个人发送一遍
                    if(result){
                        List<User> userList = UserChatRoomManage.getUserList(fromUserId);
                        for(User user:userList){
                            String userId = user.getUserId();
                            //判断这个人聊天室有没有被激活
                            if(!UserChatRoomManage.getUserChatRoomIsActive(userId, roomId)){
                                UserChatRoomManage.subUserChatRoomNewMsgCount(userId, roomId);
                                String msg = "\""+UserUtils.getUserNicename(fromUserId)+"\"撤回了一条消息";
                                this.sendMessageToUser(msg, userId, DataTypeCode.chat, DataTypeCode.chat_recall);
                            }
                        }
                    }
                    //3) 告诉自己撤回成功
                    this.sendMessageToUser("你撤回了一条消息", fromUserId, DataTypeCode.chat, DataTypeCode.chat_recall);

                }
                // ******************************拉人聊天*********************************
                else if (DataTypeCode.chat_group_pull.equals(dataType)) {
                    //1)存储数据：拉人
                    String roomId = chatMessage.getRoomId();
                    String[] pullers = StringUtils.parseArray(chatMessage.getPullers(), ",");
                    UserChatRoomManage.pullToGroup(fromUserId, roomId, pullers);
                    List<User> oldUserList = UserChatRoomManage.getUserList(roomId, new String[]{fromUserId});
                    //2)更新多人聊天室时间
                    List<User> userList = UserChatRoomManage.getUserList(roomId);
                    for (User user : userList) {
                        UserChatRoomManage.updateUserChatRoomTime(user.getUserId(), roomId);
                    }
                    //3)发送给多人
                    //原班人马，告诉谁拉了谁
                    for (User user : oldUserList) {
                        String msg = UserUtils.whoInviteWho(user.getUserId(), fromUserId, pullers);
                        this.sendMessageToUser(msg, user.getUserId(), DataTypeCode.chat, DataTypeCode.chat_group_pull);
                    }
                    //告诉自己，邀请了谁
                    this.sendMessageToUser(UserUtils.youInviteWho(fromUserId, pullers), fromUserId, DataTypeCode.chat, DataTypeCode.chat_group_pull);

                }

                // ******************************踢人聊天*********************************
                else if (DataTypeCode.chat_group_kick.equals(dataType)) {
                    String roomId = chatMessage.getRoomId();
                    //1)更新被踢人聊天室相关信息 如：是否被踢，被踢时间
                    String[] kickers = StringUtils.parseArray(chatMessage.getKickers(), ",");
                    if (kickers == null) return;
                    UserChatRoomManage.dealKickUserChatRoom(kickers, roomId);
                    //2）告知该用户已被剔除
                    //3）告诉群主，用户已被剔除
                    for (String kicker : kickers) {
                        this.sendMessageToUser(UserUtils.youKickedByWho(kicker, fromUserId), kicker, DataTypeCode.chat, DataTypeCode.chat_group_kick);
                        this.sendMessageToUser(UserUtils.youKickWho(fromUserId, kicker), fromUserId, DataTypeCode.chat, DataTypeCode.chat_group_kick);
                    }
                }

                // ******************************主动退出群聊*********************************
                else if (DataTypeCode.chat_group_out.equals(dataType)) {
                    //1)删除整个聊天室
                    String roomId = chatMessage.getRoomId();
                    UserChatRoomManage.delUserChatRoom(fromUserId, roomId);
                    //2)发送消息告诉xxx退出了群聊
                    List<User> userList = UserChatRoomManage.getUserList(roomId);
                    for (User user : userList) {
                        String userId = user.getUserId();
                        String sendMsg = "\"" + UserUtils.getUserRemark(userId, fromUserId) + "\"退出了群聊";
                        this.sendMessageToUser(sendMsg, userId, DataTypeCode.chat, DataTypeCode.chat_group_out);
                    }

                }

                // ******************************激活聊天窗口*********************************
                else if (DataTypeCode.chat_chatRoom_active.equals(dataType)) {
                    String roomId = chatMessage.getRoomId();
                    UserChatRoomManage.setUserChatRoomActive(fromUserId, roomId, true);
                    //清零
                    UserChatRoomManage.clearUserChatRoomNewMsgCount(fromUserId, roomId);
                }
                // ******************************关闭聊天窗口*********************************
                else if (DataTypeCode.chat_chatRoom_close.equals(dataType)) {
                    String roomId = chatMessage.getRoomId();
                    UserChatRoomManage.setUserChatRoomActive(fromUserId, roomId, false);
                }

                // ****************************** 更改群名称 *********************************
                else if (DataTypeCode.chat_edit_groupName.equals(dataType)) {
                    String roomId = chatMessage.getRoomId();
                    String roomName = String.valueOf(chatMessage.getMsg());
                    UserChatRoomManage.updateChatRoomName(fromUserId, roomId, roomName);
                    String youMsg = "你修改群名为\"" + roomName + "\"";
                    this.sendMessageToUser(youMsg, fromUserId, DataTypeCode.chat, DataTypeCode.chat_edit_groupName);

                    List<User> otherUserList = UserChatRoomManage.getUserList(roomId, new String[]{fromUserId});
                    for (User user : otherUserList) {
                        String oherMsg = "\"" + UserUtils.getUserRemark(user.getUserId(), fromUserId) + "\"修改群名为\"" + roomName + "\"";
                        this.sendMessageToGroupRoom(oherMsg, otherUserList, DataTypeCode.chat, DataTypeCode.chat_edit_groupName);
                    }

                }

                // ******************************聊天列表*********************************
                else if (DataTypeCode.chat_chatList.equals(dataType)) {
                    //用户列表需要刷新
                    List<ChatRoom> chatList = ChatCommonMethod.getChatList(fromUserId);
                    this.sendMessageToUser(chatList, fromUserId, DataTypeCode.chat, DataTypeCode.chat_chatList);
                }
            }


            //######################################################    好友组     ######################################################
            else if (DataTypeCode.friend.equals(dataGroup)) {
                // ******************************添加好友*********************************
                if (DataTypeCode.friend_add.equals(dataType)) {

                }
            }


            //######################################################连接相关组######################################################
            //连接相关组
            else if (DataTypeCode.beat.equals(dataGroup)) {
                // ******************************小分类*********************************
                if (DataTypeCode.beat_link.equals(dataType)) {

                    logger.info(fromUserId + "  进入测试心跳 ！");
                    this.sendMessageToUser("ok", fromUserId, DataTypeCode.beat, DataTypeCode.beat_link);
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("发生了错误了");
//            logger.error("发生了错误了");
        }
    }

    /**
     * 新增窗口
     *
     * @param chatMessage
     * @param toUserId
     * @return
     */
    private ChatRoom creatNewChatMsg(ChatMessage chatMessage, String toUserId, String roomType, String roomName) {
        String roomId = chatMessage.getRoomId();
//        String chatRoomType = UserChatRoomManage.getChatRoomType(toUserId, roomId);
        List<User> userList = UserChatRoomManage.getUserList(roomType, roomId, toUserId);
        List<ChatMessage> ChatMsgList = new ArrayList<>();
        ChatMsgList.add(chatMessage);

        ChatRoom chatRoom = new ChatRoom(roomId, roomType, ChatMsgList, userList, toUserId, roomName);
        return chatRoom;
    }

    /**
     * 保存聊天记录并发送给接收方
     *
     * @param chatMessage
     * @param fromUserId
     * @param toUserId
     */
    private void saveAndSendChatMsg(ChatMessage chatMessage, String fromUserId, String toUserId) {
        logger.info("《   " + fromUserId + "    》给《     " + toUserId + "    》发送了消息：     " + String.valueOf(chatMessage.getMsg()));
        Session session1 = client.get(toUserId);
        if (null == session1) {
            System.err.println(toUserId + "   不在线!");
        } else {
            System.err.println(toUserId + "   在线!");
        }
        Session sessionGet = client.get(fromUserId);
        if (null == sessionGet) {
            System.err.println(fromUserId + "   不在线!");
        } else {
            System.err.println(fromUserId + "   在线!");
        }


        String roomId = chatMessage.getRoomId();
        //存储消息
        UserChatRoomManage.addMessage(fromUserId, roomId, chatMessage);
        //更新用户聊天室时间
        UserChatRoomManage.updateUserChatRoomTime(fromUserId, roomId);
        UserChatRoomManage.updateUserChatRoomTime(toUserId, roomId);
        //发送给自己处理结果
        ChatMessage toMess = null;
        //发送给指定用户
        ChatMessage fromMess = null;
        try {
            fromMess = (ChatMessage) chatMessage.clone();
            fromMess.setUser(UserUtils.getUserByUserId(fromUserId));
            this.sendMessageToUser(fromMess, toUserId, DataTypeCode.chat, DataTypeCode.chat_chatData);

            toMess = (ChatMessage) chatMessage.clone();
            toMess.setUser(UserUtils.getUserByUserId(toUserId));
            this.sendMessageToUser(toMess, fromUserId, DataTypeCode.chat, DataTypeCode.chat_chatData);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            throw new RuntimeException("克隆 ChatMessage失败");
        }

    }


    /**
     * 给指定人发送消息
     *
     * @param objMsg
     * @param userId
     * @param dataGroup
     * @param dataType
     */
    public void sendMessageToUser(Object objMsg, String userId, String dataGroup, String dataType) {
        DataResponse dataResponse = new DataResponse(VenusResponseHttpCode.OK, objMsg, dataGroup, dataType);

        String message = "";
        try {
            message = JSON.toJSONString(dataResponse, SerializerFeature.DisableCircularReferenceDetect);
        } catch (Exception e) {
            System.err.println("消息格式转换失败");

        }
        try {
            client.get(userId).getBasicRemote().sendText(message);
            System.err.println("发送给:    " + userId + "   的消息成功");
        } catch (Exception e) {
            System.err.println("发给：" + userId + "------>信息失败,原因:" + userId + "不在线");
        }


    }

    /**
     * 发送消息给聊天组
     *
     * @param objMsg
     * @param userList
     * @param dataGroup
     * @param dataType
     */
    public void sendMessageToGroupRoom(Object objMsg, List<User> userList, String dataGroup, String dataType) {
        if (userList != null) {
            for (User user : userList) {
                if (user == null) continue;
                this.sendMessageToUser(objMsg, user.getUserId(), dataGroup, dataType);
            }
        }
    }

    @OnError
    public void onError(Session session, Throwable error) {
        logger.info("服务端发生了错误" + error.getMessage());
        error.printStackTrace();
    }

    /**
     * 进入聊天室 --> 项目中读取用户信息获取用户名
     */
   /* @RequestMapping( "/websocket/{username}" )
    public String webSocket(Model model, @PathVariable( "username" ) String username) {

        //定义随机时间戳名称
        String name = username + ":";
        //String  datename = new SimpleDateFormat("yyyyMMddHHmmsss").format(new Date());
        String datename = new SimpleDateFormat("msss").format(new Date());
        name = name + datename;

        //websock链接地址+游客名-->  项目中请定义在配置文件 -->或直接读取服务器，ip 端口
        // 读取服务器,ip 端口可看：https://blog.csdn.net/qq_41463655/article/details/92002474
        String path = "ws://127.0.0.1:8000/websocket/";
        model.addAttribute("path", path);
        model.addAttribute("username", name);
        return "websocket";
    }*/
}



/*
 *  注解说明
 *  @MessageMapping(value = "/chat")   // 匹配客户端 send 消息时的URL
 *  @SendTo("/topic/getResponse")      //用于给客户端订阅广播消息
 *  @SendToUser(value = "/personal")   //用于给客户端订阅点对点消息；
 *  @Payload：使用客户端 STOMP 帧的 body 赋值
 *  @Header(“xxx”)：使用客户端 STOMP 帧的 headers 中的 xxx 赋值
 *
 **/

//    @MessageMapping(value = "/chat") // 匹配客户端 send 消息时的URL
//    @SendTo("/topic/getResponse")   //分别用于给客户端订阅广播消息
//    public String talk(@Payload String text, @Header("simpSessionId") String sessionId) throws Exception {
//        return "【" + sessionId + "】说:【" + text + "】";
//    }

/**
 * 点对点推送
 * <p>
 * 异常信息推送
 * <p>
 * 异常信息推送
 */
/*
    @MessageMapping(value = "/speak")  // 匹配客户端 send 消息时的URL
    @SendToUser(value = "/personal")   //分别用于给客户端订阅点对点消息；
    public String speak(@Payload String text, @Header("simpSessionId") String sessionId) throws Exception {
        return text;
    }
    */

/**
 * 异常信息推送
 */
/*
    @MessageExceptionHandler
    @SendToUser(value = "/errors")
    public String handleException(Throwable exception) {
        return exception.getChatMessageExceptDel();
    }*/