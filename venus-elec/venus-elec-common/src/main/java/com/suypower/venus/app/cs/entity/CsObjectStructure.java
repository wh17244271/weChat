package com.suypower.venus.app.cs.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.suypower.venus.elec.common.common.converter.LongToStringSerializer;

/**
 * @auther:maofukai
 * @date:2019-08-13 档案结构
 */
public class CsObjectStructure {

    /**
     * 档案结构标识
     */
    @JsonSerialize(using = LongToStringSerializer.class)
    private Long stId;

    /**
     * 档案分类标识
     */
    private String stClsId;

    /**
     * 档案分类编号(视图字段)
     */
    private String stClsNo;

    /**
     * 用户编号
     */
    private String consNo;

    /**
     * 档案标识
     */
    private Long arcId;

    /**
     * 父档案结构标识
     */
    private Long arcPid;

    /**
     * 父档案结构标识集合
     */
    private String arcPids;

    /**
     * 档案结构权重
     */
    private int stWeight;

    public Long getStId() {
        return stId;
    }

    public void setStId(Long stId) {
        this.stId = stId;
    }

    public String getStClsId() {
        return stClsId;
    }

    public void setStClsId(String stClsId) {
        this.stClsId = stClsId;
    }

    public String getStClsNo() {
        return stClsNo;
    }

    public void setStClsNo(String stClsNo) {
        this.stClsNo = stClsNo;
    }

    public String getConsNo() {
        return consNo;
    }

    public void setConsNo(String consNo) {
        this.consNo = consNo;
    }

    public Long getArcId() {
        return arcId;
    }

    public void setArcId(Long arcId) {
        this.arcId = arcId;
    }

    public Long getArcPid() {
        return arcPid;
    }

    public void setArcPid(Long arcPid) {
        this.arcPid = arcPid;
    }

    public String getArcPids() {
        return arcPids;
    }

    public void setArcPids(String arcPids) {
        this.arcPids = arcPids;
    }

    public int getStWeight() {
        return stWeight;
    }

    public void setStWeight(int stWeight) {
        this.stWeight = stWeight;
    }
}
