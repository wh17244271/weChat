package com.suypower.venus.common;

import com.suypower.venus.entity.*;
import com.suypower.venus.utils.FriendManage;
import com.suypower.venus.utils.ListUtils;
import com.suypower.venus.utils.StringUtils;
import com.suypower.venus.utils.UserChatRoomManage;

import java.util.ArrayList;
import java.util.List;

public class ChatCommonMethod {

    public static List<ChatRoom> getChatList(String userId) {
//        List<ChatList> chatLists = new ArrayList<>();

        List<ChatRoom> resultList = new ArrayList<>();
        UserChatRoomManage userChatRoomManage = UserChatRoomManage.getOrCreate(userId);
        List<UserChatRoom> userChatRoomList = userChatRoomManage.getUserChatRoomList();//需要排序的集合

        String [] sortNameArr = {"top","updateTime"};
        boolean [] isAscArr = {false,false};
        ListUtils.sort(userChatRoomList,sortNameArr,isAscArr); //排序，置顶，时间

        for (UserChatRoom userChatRoom :userChatRoomList) {
            if (null == userChatRoom) continue;
            ChatRoom chatRoom = userChatRoom.getChatRoom();
            if (null == chatRoom) continue;
            //判断是否被踢，被踢的话获取被踢前的最后一天记录
            boolean kickOut = userChatRoom.isKickOut();
            ChatMessage chatMsg;
            if(kickOut){
                chatMsg = chatRoom.lastMessage(userId,userChatRoom.getKickOutTime()); //取最后一条消息
            }else{
                chatMsg = chatRoom.lastMessage(userId); //取最后一条消息
            }
            if (chatMsg != null) {
                if (null!=chatMsg.getMsg() && StringUtils.isEmpty(String.valueOf(chatMsg.getMsg()))){
                    continue;
                }

                String roomIdSend = chatRoom.getRoomId();
                String chatRoomType = UserChatRoomManage.getChatRoomType(userId, roomIdSend);
                List<User> userList  = UserChatRoomManage.getUserList(chatRoomType,roomIdSend, userId);
                List<ChatMessage> ChatMsgList = new ArrayList<>();
                ChatMsgList.add(chatMsg);
                ChatRoom newFind ;
                try {
                    newFind = (ChatRoom)chatRoom.clone();
                } catch (CloneNotSupportedException e) {
                    throw  new RuntimeException("克隆 ChatRoom失败");
                }

                //给用户设置备注
                ChatCommonMethod.getUserListRemark(userId, userList);

                newFind.setOwnerId(userId);
                newFind.setUser(userList);
                newFind.setMsg(ChatMsgList);
                newFind.setTop(userChatRoom.isTop());
                newFind.setTime(userChatRoom.getUpdateTime());
                newFind.setNewMsgCount(userChatRoom.getNewMsgCount());

                resultList.add(newFind);
            }


        }
        return resultList;
    }


    public static void getUserListRemark(String userId, List<User> userList) {
        //给用户设置备注
        for(User user:userList){
            if(user.getUserId().equals(userId))continue;
            Friend friend = FriendManage.getFriend(userId, user.getUserId());
            if(null!=friend){
                user.setRemark(friend.getFriendRemark());
            }

        }
    }
}
