package com.suypower.venus.entity;


public class UserChatRoom {
    /**
     * 聊天室用户
     */
    private  User user;
    /**
     * 聊天室
     */
    private  ChatRoom chatRoom;
    /**
     * 聊天室更新时间
     */
    private Long updateTime;
    /**
     * 置顶
     */
    private boolean top;
    /**
     * 是否为群主
     */
    private boolean isGroupOwner;
    /**
     * 是否被踢
     */
    private boolean isKickOut;
    /**
     * 被踢出时间
     */
    private Long kickOutTime;
    /**
     * 聊天窗口是否激活中
     */
    private boolean isActive;

    /**
     * 新消息条数
     */
    private int  newMsgCount;


    public UserChatRoom() {
    }

    public UserChatRoom(User user, ChatRoom chatRoom, Long updateTime, boolean top,boolean isGroupOwner) {
        this.user = user;
        this.chatRoom = chatRoom;
        this.updateTime = updateTime;
        this.top = top;
        this.isGroupOwner = isGroupOwner;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ChatRoom getChatRoom() {
        return chatRoom;
    }

    public void setChatRoom(ChatRoom chatRoom) {
        this.chatRoom = chatRoom;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public boolean isTop() {
        return top;
    }

    public void setTop(boolean top) {
        this.top = top;
    }


    public boolean isKickOut() {
        return isKickOut;
    }

    public void setKickOut(boolean kickOut) {
        isKickOut = kickOut;
    }

    public Long getKickOutTime() {
        return kickOutTime;
    }

    public void setKickOutTime(Long kickOutTime) {
        this.kickOutTime = kickOutTime;
    }

    public boolean isGroupOwner() {
        return isGroupOwner;
    }

    public void setGroupOwner(boolean groupOwner) {
        isGroupOwner = groupOwner;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getNewMsgCount() {
        return newMsgCount;
    }

    public void setNewMsgCount(int newMsgCount) {
        this.newMsgCount = newMsgCount;
    }

    @Override
    public String toString() {
        return "UserChatRoom{" +
                "user=" + user +
                ", chatRoom=" + chatRoom +
                ", updateTime=" + updateTime +
                ", top=" + top +
                '}';
    }
}
