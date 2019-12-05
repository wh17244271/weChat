package com.suypower.venus.sys.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.suypower.venus.elec.common.common.converter.LongToStringSerializer;

public class System {
    /**
     *系统id
     */
    @JsonSerialize(using= LongToStringSerializer.class )
    private Long sysId;
    /**
     * 系统平台编码
     */
    private String sysNo;

    /**
     * 系统平台名称
     */
    private String sysName;

    /**
     * 系统平台地址
     */
    private String sysUrl;
    /**
     * 系统平台描述
     */
    private String sysDesc;
    /**
     * 系统平台备注
     */
    private String sysRemark;
    /**
     * 系统平台状态 1：正常
     *             2：不可用
     */
    private String sysStatus;

    public Long getSysId() {
        return sysId;
    }

    public void setSysId(Long sysId) {
        this.sysId = sysId;
    }

    public String getSysNo() {
        return sysNo;
    }

    public void setSysNo(String sysNo) {
        this.sysNo = sysNo;
    }

    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName;
    }

    public String getSysUrl() {
        return sysUrl;
    }

    public void setSysUrl(String sysUrl) {
        this.sysUrl = sysUrl;
    }

    public String getSysDesc() {
        return sysDesc;
    }

    public void setSysDesc(String sysDesc) {
        this.sysDesc = sysDesc;
    }

    public String getSysRemark() {
        return sysRemark;
    }

    public void setSysRemark(String sysRemark) {
        this.sysRemark = sysRemark;
    }

    public String getSysStatus() {
        return sysStatus;
    }

    public void setSysStatus(String sysStatus) {
        this.sysStatus = sysStatus;
    }
}
