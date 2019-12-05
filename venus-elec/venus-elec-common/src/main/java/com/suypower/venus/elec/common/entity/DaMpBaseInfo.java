package com.suypower.venus.elec.common.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.suypower.venus.elec.common.common.converter.LongToStringSerializer;

/**
 * @author maofukai
 * @date   2019-07-12
 * 测点基本信息
 */
public class DaMpBaseInfo extends CalendarInfo{

    /**
     * 测点标识
     */
    @JsonSerialize(using = LongToStringSerializer.class)
    private Long mpId;

    /**
     * 测点序号
     */
    private int mpNo;

    /**
     * 测点名称
     */
    private String mpName;

    /**
     * 企业编号
     */
    private String consNo;

    public Long getMpId() {
        return mpId;
    }

    public void setMpId(Long mpId) {
        this.mpId = mpId;
    }

    public int getMpNo() {
        return mpNo;
    }

    public void setMpNo(int mpNo) {
        this.mpNo = mpNo;
    }

    public String getMpName() {
        return mpName;
    }

    public void setMpName(String mpName) {
        this.mpName = mpName;
    }

    public String getConsNo() {
        return consNo;
    }

    public void setConsNo(String consNo) {
        this.consNo = consNo;
    }
}
