package com.suypower.venus.entity;

import com.suypower.venus.utils.StringUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class User  implements Cloneable{
    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    private String userId;
    private String username;
    private String password;
    private String initial;
    private String headerUrl;
    private String nickname;
    private String sex; //性别
    private String remark; //备注
    private String signature; //签名
    private String telphone;
    private List<Map> album;
    private List<String> area; //地址
    private String from;
    private String tag;
    private Map desc;
    /**
     * 1=OA系统  2=库管系统
     */
    private int type;

    private String homeUrl;




    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String userId, String username, String password, String nickname,String initial,
                String headerUrl, int type, String homeUrl,String sex,String signature,String  areas) {
        this.initial = initial;
        this.userId = userId;
        this.headerUrl = headerUrl;
        this.nickname = nickname;
        this.username = username;
        this.password = password;
        this.type=type;
        this.homeUrl = homeUrl;
        this.sex = sex;
        this.signature = signature;
        if(!StringUtils.isEmpty(areas)){
            String[] split = areas.split(",");
            List<String> strings = Arrays.asList(split);
            this.area = strings;
        }


    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    public String getHeaderUrl() {
        return headerUrl;
    }

    public void setHeaderUrl(String headerUrl) {
        this.headerUrl = headerUrl;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public List<Map> getAlbum() {
        return album;
    }

    public void setAlbum(List<Map> album) {
        this.album = album;
    }

    public List<String> getArea() {
        return area;
    }

    public void setArea(List<String> area) {
        this.area = area;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Map getDesc() {
        return desc;
    }

    public void setDesc(Map desc) {
        this.desc = desc;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getHomeUrl() {
        return homeUrl;
    }

    public void setHomeUrl(String homeUrl) {
        this.homeUrl = homeUrl;
    }
}
