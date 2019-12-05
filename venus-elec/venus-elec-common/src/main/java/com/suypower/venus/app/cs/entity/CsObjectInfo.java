package com.suypower.venus.app.cs.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.suypower.venus.elec.common.common.converter.LongToStringSerializer;
import com.suypower.venus.platform.share.entity.Node;

/**
 * @auther:maofukai
 * @date:2019-08-13 基础档案信息
 */
public class CsObjectInfo extends Node {

    /**
     * 档案标识
     */
    @JsonSerialize(using = LongToStringSerializer.class)
    private Long arcId;

    /**
     * 用户编号
     */
    private String consNo;

    /**
     * 档案所属表
     */
    private String arcTable;

    /**
     * 档案名称
     */
    private String arcName;

    /**
     * 档案别名
     */
    private String arcAliasName;

    /**
     * 档案编号
     */
    private String arcNo;
    /**
     * 档案权重
     */
    private int arcWeight;
    /**
     * 档案状态
     */
    private int arcStatus;
    /**
     * 档案分类标识
     */
    @JsonSerialize(using = LongToStringSerializer.class)
    private Long clsId;
    /**
     * 档案描述
     */
    private String arcDesc;
    /**
     * 档案关联点数
     */
    @JsonSerialize(using = LongToStringSerializer.class)
    private Long arcNumRelation;
    /**
     * 档案是否显示
     */
    private String arcShow;

    /**
     * 档案内容
     */
    private String arcData;
    /**
     * 档案标签
     */
    private String arcTags;

    /**
     * 档案日期
     */
    private String arcDate;

    /**
     * 档案位置
     */
    private String arcPlace;

    /**
     * 档案备注
     */
    private String arcRemark;

    public Long getArcId() {
        return arcId;
    }

    public void setArcId(Long arcId) {
        this.arcId = arcId;
    }

    public String getConsNo() {
        return consNo;
    }

    public void setConsNo(String consNo) {
        this.consNo = consNo;
    }

    public String getArcTable() {
        return arcTable;
    }

    public void setArcTable(String arcTable) {
        this.arcTable = arcTable;
    }

    public String getArcName() {
        return arcName;
    }

    public void setArcName(String arcName) {
        this.arcName = arcName;
    }

    public String getArcAliasName() {
        return arcAliasName;
    }

    public void setArcAliasName(String arcAliasName) {
        this.arcAliasName = arcAliasName;
    }

    public String getArcNo() {
        return arcNo;
    }

    public void setArcNo(String arcNo) {
        this.arcNo = arcNo;
    }

    public int getArcWeight() {
        return arcWeight;
    }

    public void setArcWeight(int arcWeight) {
        this.arcWeight = arcWeight;
    }

    public int getArcStatus() {
        return arcStatus;
    }

    public void setArcStatus(int arcStatus) {
        this.arcStatus = arcStatus;
    }

    public Long getClsId() {
        return clsId;
    }

    public void setClsId(Long clsId) {
        this.clsId = clsId;
    }

    public String getArcDesc() {
        return arcDesc;
    }

    public void setArcDesc(String arcDesc) {
        this.arcDesc = arcDesc;
    }

    public Long getArcNumRelation() {
        return arcNumRelation;
    }

    public void setArcNumRelation(Long arcNumRelation) {
        this.arcNumRelation = arcNumRelation;
    }

    public String getArcShow() {
        return arcShow;
    }

    public void setArcShow(String arcShow) {
        this.arcShow = arcShow;
    }

    public String getArcData() {
        return arcData;
    }

    public void setArcData(String arcData) {
        this.arcData = arcData;
    }

    public String getArcTags() {
        return arcTags;
    }

    public void setArcTags(String arcTags) {
        this.arcTags = arcTags;
    }

    public String getArcDate() {
        return arcDate;
    }

    public void setArcDate(String arcDate) {
        this.arcDate = arcDate;
    }

    public String getArcPlace() {
        return arcPlace;
    }

    public void setArcPlace(String arcPlace) {
        this.arcPlace = arcPlace;
    }

    public String getArcRemark() {
        return arcRemark;
    }

    public void setArcRemark(String arcRemark) {
        this.arcRemark = arcRemark;
    }
}
