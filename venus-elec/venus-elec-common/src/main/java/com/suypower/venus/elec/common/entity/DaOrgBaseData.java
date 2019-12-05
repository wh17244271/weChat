package com.suypower.venus.elec.common.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.suypower.venus.elec.common.common.Index;
import com.suypower.venus.elec.common.common.UnitType;
import com.suypower.venus.elec.common.common.converter.IndexSerializer;
import com.suypower.venus.elec.common.common.converter.UnitTypeSerializer;

public class DaOrgBaseData extends DaOrgBaseInfo {

    /**
     * 单元类型编号
     */
    @JsonSerialize(using = UnitTypeSerializer.class)
    private UnitType unitType;

    /**
     * 基础指标编号
     */
    @JsonSerialize(using = IndexSerializer.class)
    private Index index;

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
     * 代码中不要使用该方法!!!
     * @param unitTypeNo
     */
    @Deprecated
    public void setUnitTypeNo(String unitTypeNo){
        UnitType[] unitTypes =  UnitType.parseOf(unitTypeNo);
        if(unitTypes.length>0){
            this.unitType = unitTypes[0];
        }
    }

    public Index getIndex() {
        return index;
    }

    public void setIndex(Index index) {
        this.index = index;
    }

    @JsonProperty("indBNo")
    public String getIndBNo(){
        return index!=null ? index.getIndBNo() : null;
    }

    /**
     * 由于Mybatis映射枚举问题、临时解决方案、后期该方案会移除
     * 代码中不要使用该方法!!!
     * @param indBNo
     */
    @Deprecated
    public void setIndBNo(String indBNo){
        Index[] indexes =  Index.parseOf(indBNo);
        if(indexes.length>0){
            this.index = indexes[0];
        }
    }
}
