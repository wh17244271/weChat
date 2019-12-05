package com.suypower.venus.app.cs.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.suypower.venus.elec.common.common.converter.LongToStringSerializer;

/**
 * @auther:maofukai
 * @date:2019-08-13 档案分类
 */
public class CsObjectClassify {

    /**
     * 档案分类标识
     */
    @JsonSerialize(using = LongToStringSerializer.class)
    private Long clsId;

    /**
     * 档案分类编码
     */
    private String clsNo;

    /**
     * 档案分类名称
     */
    private String clsName;

    /**
     * 档案分类别名
     */
    private String clsAliasName;

    /**
     * 档案分类父标识
     */
    private Long clsPid;

    /**
     * 档案分类所有父标识
     */
    private String clsPids;

    /**
     * 档案分类权重
     */
    private int clsWeight;

    public Long getClsId() {
        return clsId;
    }

    public void setClsId(Long clsId) {
        this.clsId = clsId;
    }

    public String getClsNo() {
        return clsNo;
    }

    public void setClsNo(String clsNo) {
        this.clsNo = clsNo;
    }

    public String getClsName() {
        return clsName;
    }

    public void setClsName(String clsName) {
        this.clsName = clsName;
    }

    public String getClsAliasName() {
        return clsAliasName;
    }

    public void setClsAliasName(String clsAliasName) {
        this.clsAliasName = clsAliasName;
    }

    public Long getClsPid() {
        return clsPid;
    }

    public void setClsPid(Long clsPid) {
        this.clsPid = clsPid;
    }

    public String getClsPids() {
        return clsPids;
    }

    public void setClsPids(String clsPids) {
        this.clsPids = clsPids;
    }

    public int getClsWeight() {
        return clsWeight;
    }

    public void setClsWeight(int clsWeight) {
        this.clsWeight = clsWeight;
    }
}
