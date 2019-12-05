package com.suypower.venus.elec.common.entity;

/**
 * @author maofukai
 * @date   2019-07-12
 * 供电单位(行政区域)基本信息
 */
public class DaOrgBaseInfo {

    /**
     * 供电单位编码(行政区域编码)
     */
    private String orgNo;

    /**
     * 供电单位名称
     */
    private String orgName;

    public String getOrgNo() {
        return orgNo;
    }

    public void setOrgNo(String orgNo) {
        this.orgNo = orgNo;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
}
