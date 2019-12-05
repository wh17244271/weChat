package com.suypower.venus.elec.common.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.suypower.venus.elec.common.common.UnitType;
import com.suypower.venus.elec.common.common.converter.LongToStringSerializer;
import com.suypower.venus.elec.common.common.converter.UnitTypeSerializer;

/**
 * @author maofukai
 * @date   2019-07-12
 * 单元基本信息
 */
public class DaUnitBaseInfo {
    /**
     * 单元标识
     */
    @JsonSerialize(using = LongToStringSerializer.class)
    private String unitId;

    /**
     * 单元名称
     */
    private String unitName;

    /**
     * 单元类型编号
     */
    /**
     * 单元类型编号
     */
    @JsonSerialize(using = UnitTypeSerializer.class)
    private UnitType unitType;

    /**
     * 企业编号
     */
    private String consNo;

    /**
     * 企业名称
     */
    private String consName;

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
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

    public UnitType getUnitType() {
        return unitType;
    }

    public void setUnitType(UnitType unitType) {
        this.unitType = unitType;
    }

    @JsonProperty("unitTypeNo")
    public String getUnitTypeNo() {
        return unitType!=null ? unitType.getUnitTypeNo() : null;
    }

    /**
     * 由于Mybatis映射枚举问题、临时解决方案、后期该方案会移除
     * @param unitTypeNo
     */
    @Deprecated()
    public void setUnitTypeNo(String unitTypeNo){
        UnitType[] unitTypes =  UnitType.parseOf(unitTypeNo);
        if(unitTypes.length>0){
            this.unitType = unitTypes[0];
        }
    }
}
