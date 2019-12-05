package com.suypower.venus.app.cs.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.suypower.venus.elec.common.common.converter.LongToStringSerializer;

/**
 * @auther:maofukai
 * @date:2019-08-13 档案结构分类
 */
public class CsObjectStrucureClassify {

    /**
     * 档案结构分类标识
     */
    @JsonSerialize(using = LongToStringSerializer.class)
    private Long stClsId;

    /**
     * 档案结构分类名称
     */
    private String stClsName;

    /**
     * 档案结构分类别名
     */
    private String stClsAliasName;

    /**
     * 档案结构分类编号
     */
    private String stClsNo;

    /**
     * 档案结构分类权重
     */
    private int stClsWeight;

    /**
     * 档案结构分类状态
     */
    private String stClsStatus;

    /**
     * 档案结构分类描述
     */
    private String stClsDesc;

    /**
     * 档案结构分类是否显示
     */
    private String stClsShow;


    /**
     * 档案结构分类标签
     */
    private String stClsTags;

    public Long getStClsId() {
        return stClsId;
    }

    public void setStClsId(Long stClsId) {
        this.stClsId = stClsId;
    }

    public String getStClsName() {
        return stClsName;
    }

    public void setStClsName(String stClsName) {
        this.stClsName = stClsName;
    }

    public String getStClsAliasName() {
        return stClsAliasName;
    }

    public void setStClsAliasName(String stClsAliasName) {
        this.stClsAliasName = stClsAliasName;
    }

    public String getStClsNo() {
        return stClsNo;
    }

    public void setStClsNo(String stClsNo) {
        this.stClsNo = stClsNo;
    }

    public int getStClsWeight() {
        return stClsWeight;
    }

    public void setStClsWeight(int stClsWeight) {
        this.stClsWeight = stClsWeight;
    }

    public String getStClsStatus() {
        return stClsStatus;
    }

    public void setStClsStatus(String stClsStatus) {
        this.stClsStatus = stClsStatus;
    }

    public String getStClsDesc() {
        return stClsDesc;
    }

    public void setStClsDesc(String stClsDesc) {
        this.stClsDesc = stClsDesc;
    }

    public String getStClsShow() {
        return stClsShow;
    }

    public void setStClsShow(String stClsShow) {
        this.stClsShow = stClsShow;
    }

    public String getStClsTags() {
        return stClsTags;
    }

    public void setStClsTags(String stClsTags) {
        this.stClsTags = stClsTags;
    }
}
