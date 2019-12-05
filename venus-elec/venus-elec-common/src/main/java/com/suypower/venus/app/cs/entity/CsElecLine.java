package com.suypower.venus.app.cs.entity;


/**
 * @auther:maofukai
 * @date:2019-07-29 档案信息-电力线路
 */
public class CsElecLine extends CsObjectInfo {

    /**
     * 线路编号
     */
    private String lineNo;

    /**
     * 线路电压等级
     */
    private String lineVoltage;

    public String getLineNo() {
        return lineNo;
    }

    public void setLineNo(String lineNo) {
        this.lineNo = lineNo;
    }

    public String getLineVoltage() {
        return lineVoltage;
    }

    public void setLineVoltage(String lineVoltage) {
        this.lineVoltage = lineVoltage;
    }
}
