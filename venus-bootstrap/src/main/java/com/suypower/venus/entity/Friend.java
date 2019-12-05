package com.suypower.venus.entity;

import com.suypower.venus.utils.StringUtils;

public class Friend {

    private String friendId;
    /**
     * 朋友信息
     */
    private User user;
    /**
     * 朋友备注
     */
    private String friendRemark;

    public Friend() {
    }

    public Friend( User user, String friendRemark) {
        this.friendId = StringUtils.uuid();
        this.user = user;
        this.friendRemark = friendRemark;
    }

    public String getFriendId() {
        return friendId;
    }

    public void setFriendId(String friendId) {
        this.friendId = friendId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFriendRemark() {
        return friendRemark;
    }

    public void setFriendRemark(String friendRemark) {
        this.friendRemark = friendRemark;
    }
}
