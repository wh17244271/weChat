package com.suypower.venus.elec.common.entity;

/**
 * @author maofukai
 * @date   2019-07-12
 * 企业用户基本信息
 */
public class DaConsBaseInfo extends CalendarInfo{

    /**
     * 供电单位编码(行政区域编号)
     */
    private String orgNo;

    /**
     * 供电单位名称
     */
    private String orgName;

    /**
     * 企业编号
     */
    private String consNo;

    /**
     * 企业名称
     */
    private String consName;

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
}
