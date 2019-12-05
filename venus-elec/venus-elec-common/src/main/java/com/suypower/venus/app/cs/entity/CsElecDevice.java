package com.suypower.venus.app.cs.entity;


/**
 * @auther:maofukai
 * @date:2019-07-29 档案信息-电力设备
 */
public class CsElecDevice extends CsObjectInfo {

    /**
     * 设备类别
     */
    private String devClassify;

    /**
     * 设备类型
     */
    private String devType;

    /**
     * 设备电压等级
     */
    private String devVoltage;

    /**
     * 设备额定功率
     */
    private String devRatedPower;

    /**
     * 设备安装日期
     */
    private String devInstallDate;

    /**
     * 设置安装位置
     */
    private String devInstallPlace;


    public String getDevClassify() {
        return devClassify;
    }

    public void setDevClassify(String devClassify) {
        this.devClassify = devClassify;
    }

    public String getDevType() {
        return devType;
    }

    public void setDevType(String devType) {
        this.devType = devType;
    }

    public String getDevVoltage() {
        return devVoltage;
    }

    public void setDevVoltage(String devVoltage) {
        this.devVoltage = devVoltage;
    }

    public String getDevRatedPower() {
        return devRatedPower;
    }

    public void setDevRatedPower(String devRatedPower) {
        this.devRatedPower = devRatedPower;
    }


}
