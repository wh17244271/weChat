package com.suypower.venus.sys.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.suypower.venus.elec.common.common.converter.LongToStringSerializer;

/**
 * 用户配置
 */
public class UserConfig {
    /**
     * 用户配置标志
     */
    @JsonSerialize(using= LongToStringSerializer.class )
    private Long ucfgId;
    /**
     * 系统平台标志
     */
    @JsonSerialize(using= LongToStringSerializer.class )
    private Long sysId;
    /**
     * 用户配置分类
     */
    private String ucfgCls;

    /**
     * 用户配置编码
     */
    private String ucfgCode;

    /**
     * 用户配置索引名称
     */
    private String ucfgKey;
    /**
     * 用户配置内容值
     */
    private String ucfgValue;
    /**
     * 用户配置状态
     */
    private String ucfgStatus;
    /**
     * 用户配置是否共享
     */
    private String ucfgSharing;
    /**
     * 用户配置备注
     */
    private String ucfgRemark;

    public Long getUcfgId() {
        return ucfgId;
    }

    public void setUcfgId(Long ucfgId) {
        this.ucfgId = ucfgId;
    }

    public Long getSysId() {
        return sysId;
    }

    public void setSysId(Long sysId) {
        this.sysId = sysId;
    }

    public String getUcfgCls() {
        return ucfgCls;
    }

    public void setUcfgCls(String ucfgCls) {
        this.ucfgCls = ucfgCls;
    }

    public String getUcfgCode() {
        return ucfgCode;
    }

    public void setUcfgCode(String ucfgCode) {
        this.ucfgCode = ucfgCode;
    }

    public String getUcfgKey() {
        return ucfgKey;
    }

    public void setUcfgKey(String ucfgKey) {
        this.ucfgKey = ucfgKey;
    }

    public String getUcfgValue() {
        return ucfgValue;
    }

    public void setUcfgValue(String ucfgValue) {
        this.ucfgValue = ucfgValue;
    }

    public String getUcfgStatus() {
        return ucfgStatus;
    }

    public void setUcfgStatus(String ucfgStatus) {
        this.ucfgStatus = ucfgStatus;
    }

    public String getUcfgSharing() {
        return ucfgSharing;
    }

    public void setUcfgSharing(String ucfgSharing) {
        this.ucfgSharing = ucfgSharing;
    }

    public String getUcfgRemark() {
        return ucfgRemark;
    }

    public void setUcfgRemark(String ucfgRemark) {
        this.ucfgRemark = ucfgRemark;
    }
}
