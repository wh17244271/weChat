package com.suypower.venus.elec.common.common;

import com.suypower.venus.elec.common.utils.Assert;
import com.suypower.venus.elec.common.utils.StringUtils;
import com.suypower.venus.platform.share.entity.IEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther:maofukai
 * @date:2019-07-09
 * 单元类型定义
 */
public enum  UnitType implements IEnum<String> {
//    466182899747971072	402760961221459968	1	用户	1		1
//            466182899747971073	402760961221459968	2	建筑	2		1
//            466182899747971074	402760961221459968	3	厂房	3		1
//            466182899747971075	402760961221459968	4	生产线	4		1
//            466182899747971076	402760961221459968	5	空调系统	5		1
//            466182899747971077	402760961221459968	6	电机	6		2
//            466182899747971078	402760961221459968	7	锅炉	7		2
//            466182899747971079	402760961221459968	8	房间	8		2
//            466182899747971080	402760961221459968	9	站点	9		1
//            466182899747971081	402760961221459968	10	配电室	10		1
       UNKNOWN("0","未知",1),
       USER("1","用户",1),
       BUILDING("2","建筑",2),
       FACTORY("3","厂房",3);

        private String unitTypeNo;

        private String unitTypeName;

        private int sort;

    UnitType(String unitTypeNo,String unitTypeName,int sort){
        this.unitTypeNo   = unitTypeNo;
        this.unitTypeName = unitTypeName;
        this.sort         = sort;
    }

    public String getUnitTypeNo() {
        return unitTypeNo;
    }

    public String getUnitTypeName() {
        return unitTypeName;
    }

    public int getSort() {
        return sort;
    }

    public static UnitType[] list(UnitType ... unitTypes){
        return unitTypes;
    }

    public static UnitType[] parseOf(String ... values){
        List<UnitType> newUnitTypes = new ArrayList();
        UnitType[]  unitTypes = values();
        for(String value  : values){
            for(UnitType unitType : unitTypes){
                if(unitType.getUnitTypeNo().equals(value)){
                    newUnitTypes.add(unitType);
                    break;
                }
            }
        }
        return newUnitTypes.toArray(new UnitType[0]);
    }

    /**
     * 通过编号获取 UnitType
     * @param value
     * @return
     */
    public static UnitType parse(String  value){
        UnitType find = null;
        UnitType[]  unitTypes = values();
            for(UnitType unitType : unitTypes){
                if(unitType.getUnitTypeNo().equals(value)){
                    find = unitType;
                    break;
                }
        }
        return find;
    }

    /**
     * 判断单元编号是否存在，并转化成 UnitType[]数组形式
     * @param values
     * @return
     */
    public static UnitType[] parseOf(String  values){
        if(StringUtils.isEmpty(values))return null;
        List<UnitType> newUnitTypes = new ArrayList();
        UnitType[]  unitTypes = values();
        String[] newValues =values.split(",");
        boolean isExist = false; //判断单元编号是否存在，不存在则抛异常
        for(String value  : newValues){
            for(UnitType unitType : unitTypes){
                if(unitType.getUnitTypeNo().equals(value)){
                    newUnitTypes.add(unitType);
                    isExist = true;
                    break;
                }
            }
            Assert.isFalse(isExist,"该单元编号不存在");
//            if(!isExist){
//                throw new VenusResponseException(value+":该单元编号不存在");
//            }
            isExist = false;
        }
        return newUnitTypes.toArray(new UnitType[0]);
    }

    @Override
    public String getId() {
        return getUnitTypeNo();
    }
}
