package com.suypower.venus.entity;

import java.util.List;

public class GroupInfo {
    private String roomId;
    private boolean isGroupOwner;
    private String groupName;
    private List<User> groupMemberList;
    private boolean top;

    public GroupInfo() {
    }

    public GroupInfo(String roomId, boolean isGroupOwner, String groupName, List<User> groupMemberList, boolean top) {
        this.roomId = roomId;
        this.isGroupOwner = isGroupOwner;
        this.groupName = groupName;
        this.groupMemberList = groupMemberList;
        this.top = top;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public boolean isGroupOwner() {
        return isGroupOwner;
    }

    public void setGroupOwner(boolean groupOwner) {
        isGroupOwner = groupOwner;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<User> getGroupMemberList() {
        return groupMemberList;
    }

    public void setGroupMemberList(List<User> groupMemberList) {
        this.groupMemberList = groupMemberList;
    }

    public boolean isTop() {
        return top;
    }

    public void setTop(boolean top) {
        this.top = top;
    }
}
