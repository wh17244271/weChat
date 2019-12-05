package com.suypower.venus.sys.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.suypower.venus.elec.common.common.converter.LongToStringSerializer;

/**
 * 系统资源
 */
public class SystemResource {
    /**
     *系统平台资源标志
     */
    @JsonSerialize(using= LongToStringSerializer.class )
    private Long sysRsourId;
    /**
     * 系统平台标志
     */
    private Long sysId;

    /**
     * 系统资源标志
     */
    private Long rsourId;


    /**
     * 系统平台资源状态
     */
    private String sysRsourStatus;

    public Long getSysRsourId() {
        return sysRsourId;
    }

    public void setSysRsourId(Long sysRsourId) {
        this.sysRsourId = sysRsourId;
    }

    public Long getSysId() {
        return sysId;
    }

    public void setSysId(Long sysId) {
        this.sysId = sysId;
    }

    public Long getRsourId() {
        return rsourId;
    }

    public void setRsourId(Long rsourId) {
        this.rsourId = rsourId;
    }

    public String getSysRsourStatus() {
        return sysRsourStatus;
    }

    public void setSysRsourStatus(String sysRsourStatus) {
        this.sysRsourStatus = sysRsourStatus;
    }
}
