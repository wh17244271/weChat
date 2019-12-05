package com.suypower.venus.app.cs.entity;


/**
 * @auther:maofukai
 * @date:2019-07-29 档案信息-电力变压器
 */
public class CsElecTrans extends CsObjectInfo {

    /**
     * 变压器编号
     */
    private String transNo;

    /**
     * 变压器额定容量
     */
    private String transRatedCapacity;

    /**
     * 变压器电压等级
     */
    private String transVoltage;

    /**
     * 变压器分类
     */
    private String transClassify;

    /**
     * 变压器类型
     */
    private String transType;

    /**
     * 变压器型号
     */
    private String transModel;

    /**
     * 变压器用途
     */
    private String transUse;

    /**
     * 变压器主备性质
     */
    private String transActiveStandby;

    public String getTransNo() {
        return transNo;
    }

    public void setTransNo(String transNo) {
        this.transNo = transNo;
    }

    public String getTransRatedCapacity() {
        return transRatedCapacity;
    }

    public void setTransRatedCapacity(String transRatedCapacity) {
        this.transRatedCapacity = transRatedCapacity;
    }

    public String getTransVoltage() {
        return transVoltage;
    }

    public void setTransVoltage(String transVoltage) {
        this.transVoltage = transVoltage;
    }

    public String getTransClassify() {
        return transClassify;
    }

    public void setTransClassify(String transClassify) {
        this.transClassify = transClassify;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public String getTransModel() {
        return transModel;
    }

    public void setTransModel(String transModel) {
        this.transModel = transModel;
    }

    public String getTransUse() {
        return transUse;
    }

    public void setTransUse(String transUse) {
        this.transUse = transUse;
    }

    public String getTransActiveStandby() {
        return transActiveStandby;
    }

    public void setTransActiveStandby(String transActiveStandby) {
        this.transActiveStandby = transActiveStandby;
    }
}
