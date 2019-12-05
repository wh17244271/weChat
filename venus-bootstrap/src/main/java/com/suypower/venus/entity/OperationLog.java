package com.suypower.venus.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.suypower.venus.common.ConstantUser;
import com.suypower.venus.utils.ServletUtils;
import com.suypower.venus.utils.UserUtils;

import java.time.LocalDateTime;

public class OperationLog {
    private String id;
    private String userId;
    private String userName;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private LocalDateTime time;
    private String disc;

    public OperationLog(String id,String disc) {
        this.id = id;
        this.userId = (String)ServletUtils.getSessionAttribute(ConstantUser.login_user);
        this.time = LocalDateTime.now();
        this.disc = disc;
    }

    public OperationLog() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return UserUtils.getUserNicename(this.userId);
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getDisc() {
        return disc;
    }

    public void setDisc(String disc) {
        this.disc = disc;
    }
}
