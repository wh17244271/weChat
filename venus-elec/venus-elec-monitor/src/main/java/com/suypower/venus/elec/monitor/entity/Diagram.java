package com.suypower.venus.elec.monitor.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.suypower.venus.elec.common.common.converter.LongToStringSerializer;

/**
 * 一次接线图信息
 */
public class Diagram {

    /**
     * 接线图标识
     */
    @JsonSerialize(using = LongToStringSerializer.class)
    private Long gId;

    /**
     * 企业编号
     */
    private String consNo;

    /**
     * 企业名称
     */
    private String consName;

    /**
     * 接线图级别
     */
    private String gLevel;

    /**
     * 接线图级别
     */
    private String gClassify;

    /**
     * 接线图排序 对应数据库字段DISP_SN
     */
    private int gSort;
    /**
     * 接线图名称 对应数据库字段MAP_NAME
     */
    private String gName;
    /**
     * 接线图描述 对应数据库字段MAP_DESC
      */
    private String gDesc;
    /**
     * 父接线图标识
     */
    private Long pGId;

    public Long getgId() {
        return gId;
    }

    public void setgId(Long gId) {
        this.gId = gId;
    }

    public String getConsNo() {
        return consNo;
    }

    public void setConsNo(String consNo) {
        this.consNo = consNo;
    }

    public String getConsName() {
        return consName;
    }

    public void setConsName(String consName) {
        this.consName = consName;
    }

    public String getgLevel() {
        return gLevel;
    }

    public void setgLevel(String gLevel) {
        this.gLevel = gLevel;
    }

    public String getgClassify() {
        return gClassify;
    }

    public void setgClassify(String gClassify) {
        this.gClassify = gClassify;
    }

    public int getgSort() {
        return gSort;
    }

    public void setgSort(int gSort) {
        this.gSort = gSort;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public String getgDesc() {
        return gDesc;
    }

    public void setgDesc(String gDesc) {
        this.gDesc = gDesc;
    }

    public Long getpGId() {
        return pGId;
    }

    public void setpGId(Long pGId) {
        this.pGId = pGId;
    }
}
