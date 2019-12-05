package com.suypower.venus.sys.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.suypower.venus.elec.common.common.converter.LongToStringSerializer;

/**
 * 系统配置
 */
public class SysConfig {
    /**
     * 系统配置标志
     */
    @JsonSerialize(using= LongToStringSerializer.class )
    private Long scfgId;
    /**
     * 系统平台标志
     */
    @JsonSerialize(using= LongToStringSerializer.class )
    private Long sysId;
    /**
     * 系统配置分类
     */
    private String scfgCls;

    /**
     * 系统配置编码
     */
    private String scfgCode;

    /**
     * 系统配置索引名称
     */
    private String scfgKey;
    /**
     * 系统配置内容值
     */
    private String scfgValue;
    /**
     * 系统配置状态
     */
    private String scfgStatus;
    /**
     * 系统配置是否共享
     */
    private String scfgSharing;
    /**
     * 系统配置备注
     */
    private String scfgRemark;

    public Long getScfgId() {
        return scfgId;
    }

    public void setScfgId(Long scfgId) {
        this.scfgId = scfgId;
    }

    public Long getSysId() {
        return sysId;
    }

    public void setSysId(Long sysId) {
        this.sysId = sysId;
    }

    public String getScfgCls() {
        return scfgCls;
    }

    public void setScfgCls(String scfgCls) {
        this.scfgCls = scfgCls;
    }

    public String getScfgCode() {
        return scfgCode;
    }

    public void setScfgCode(String scfgCode) {
        this.scfgCode = scfgCode;
    }

    public String getScfgKey() {
        return scfgKey;
    }

    public void setScfgKey(String scfgKey) {
        this.scfgKey = scfgKey;
    }

    public String getScfgValue() {
        return scfgValue;
    }

    public void setScfgValue(String scfgValue) {
        this.scfgValue = scfgValue;
    }

    public String getScfgStatus() {
        return scfgStatus;
    }

    public void setScfgStatus(String scfgStatus) {
        this.scfgStatus = scfgStatus;
    }

    public String getScfgSharing() {
        return scfgSharing;
    }

    public void setScfgSharing(String scfgSharing) {
        this.scfgSharing = scfgSharing;
    }

    public String getScfgRemark() {
        return scfgRemark;
    }

    public void setScfgRemark(String scfgRemark) {
        this.scfgRemark = scfgRemark;
    }
}
