package com.suypower.venus.entity;

import com.suypower.venus.utils.StringUtils;
import com.suypower.venus.utils.UserChatRoomManage;

import java.util.List;

/**
 * 一个聊天室里的所有聊天记录
 */
public class ChatRoom implements Cloneable{
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    /**
     * 聊天室id (共享)
     */
    private String roomId;
    /**
     * 聊天室类型 (共享)
     */
    private String roomType;
    /**
     * 聊天室名称 (共享)
     */
    private String roomName;
    /**
     * 分组编码 (共享)
     */
    private String  roomQrCode;
    /**
     * 聊天室中所有消息列表  (共享)
     */
    private List<ChatMessage> msg;

    /**
     * 聊天室里都有哪些人  (共享)
     */
    private List<User>  user;


    /**
     * 是否置顶
     */
    private boolean top;

    /**
     * 已读未读 （true:已读  ,  false:未读)
     */
    private boolean read;
    /**
     * 最近聊天时间
     */
    private long time;
    /**
     * 是否屏蔽消息
     */
    private boolean quiet;
    /**
     * 新消息条数
     */
    private int  newMsgCount;
    /**
     * 当前聊天室所属人
     */
    private String ownerId;


    public ChatRoom() {
    }

    public ChatRoom(String roomId, String roomType, List<ChatMessage> msg, List<User> user, String ownerId,String roomName) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.msg = msg;
        this.user = user;
        this.ownerId = ownerId;
        this.roomName=roomName;
    }



    /**
     * 取最后一条消息
     * @return
     */
    public ChatMessage lastMessage(){
        if(this.msg !=null && this.msg.size()>0){
            return this.msg.get(this.msg.size()-1);
        }
        else{
            return null;
        }
    }

    /**
     * 取最后一条本人没有删除的消息
     * @param userId
     * @return
     */
    public ChatMessage lastMessage(String userId){
        if(StringUtils.isEmpty(userId))return null;
        if(this.msg !=null && this.msg.size()>0){
            for(int i = msg.size()-1; i>=0; i--){
                ChatMessage chatMessage = msg.get(i);
                boolean b = UserChatRoomManage.userIsDelChatMessage(chatMessage, userId);
                if(!b){
                    return chatMessage;
                }
            }
        }
        return null;
    }

    /**
     *获取退出群聊最后一天消息
     * @param userId
     * @param kickTime
     * @return
     */
    public ChatMessage lastMessage(String userId,Long kickTime){
        if(StringUtils.isEmpty(userId))return null;
        if(this.msg !=null && this.msg.size()>0){
            for(int i = msg.size()-1; i>=0; i--){
                ChatMessage chatMessage = msg.get(i);
                boolean b = UserChatRoomManage.userIsDelChatMessage(chatMessage, userId);
                Long msgTime = chatMessage.getTime();
                if(kickTime>msgTime && !b ){
                    return chatMessage;
                }
            }
        }
        return null;
    }


    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public List<ChatMessage> getMsg() {
        return msg;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
    public void setMsg(List<ChatMessage> msg) {
        this.msg = msg;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomQrCode() {
        return roomQrCode;
    }

    public void setRoomQrCode(String roomQrCode) {
        this.roomQrCode = roomQrCode;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public int getNewMsgCount() {
        return newMsgCount;
    }

    public void setNewMsgCount(int newMsgCount) {
        this.newMsgCount = newMsgCount;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public boolean isQuiet() {
        return quiet;
    }

    public void setQuiet(boolean quiet) {
        this.quiet = quiet;
    }

    public boolean isTop() {
        return top;
    }

    public void setTop(boolean top) {
        this.top = top;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
