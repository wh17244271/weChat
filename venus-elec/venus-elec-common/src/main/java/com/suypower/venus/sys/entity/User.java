package com.suypower.venus.sys.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.suypower.venus.elec.common.common.converter.LongToStringSerializer;

import java.time.LocalDateTime;
import java.util.List;

public class User {
    private String token;
    /**
     * 用户id
     */
    @JsonSerialize(using= LongToStringSerializer.class )
    private Long userId;

    /**
     * 批量删除用到
     */
    private String[] userIds;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String userPassword;
    /**
     * 昵称
     */
    private String userNickname;
    private String url;
    /**
     * 用户状态
     */
    private String userStatus;
    /**
     * 用户头像
     */
    private String userAvatar; //头像
    /**
     * 用户邮箱
     */
    private String userEmail;
    /**
     * 用户手机
     */
    private String userPhone;
    /**
     * 组织id
     */
    @JsonSerialize(using= LongToStringSerializer.class )
    private long orgId;
    /**
     * 部门id
     */
    @JsonSerialize(using= LongToStringSerializer.class )
    private long partId;

    /**
     * 登陆错误次数
     */
    private int loginErrorCount;

    /**
     * 用户登陆错误时间
     */
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private LocalDateTime loginErrorTime;
    /**
     * 用户建立时间
     */
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private LocalDateTime createTime;

    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private LocalDateTime loginTime;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private LocalDateTime expire;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private LocalDateTime logoutTime;
    /**
     * 用户拥有的角色集合
     */
    private List<Role> roles;
    /**
     * 用户拥有的资源集合
     */
    private List<SystemResource> sysRsour;
    private List<Accesses> accesses;
    private List<Menu> menus;


    public User() {
    }

    public List<Accesses> getAccesses() {
        return accesses;
    }

    public void setAccesses(List<Accesses> accesses) {
        this.accesses = accesses;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public long getOrgId() {
        return orgId;
    }

    public void setOrgId(long orgId) {
        this.orgId = orgId;
    }

    public long getPartId() {
        return partId;
    }

    public void setPartId(long partId) {
        this.partId = partId;
    }

    public int getLoginErrorCount() {
        return loginErrorCount;
    }

    public void setLoginErrorCount(int loginErrorCount) {
        this.loginErrorCount = loginErrorCount;
    }

    public LocalDateTime getLoginErrorTime() {
        return loginErrorTime;
    }

    public void setLoginErrorTime(LocalDateTime loginErrorTime) {
        this.loginErrorTime = loginErrorTime;
    }

    public LocalDateTime getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalDateTime loginTime) {
        this.loginTime = loginTime;
    }

    public LocalDateTime getExpire() {
        return expire;
    }

    public void setExpire(LocalDateTime expire) {
        this.expire = expire;
    }

    public LocalDateTime getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(LocalDateTime logoutTime) {
        this.logoutTime = logoutTime;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String[] getUserIds() {
        return userIds;
    }

    public void setUserIds(String[] userIds) {
        this.userIds = userIds;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
