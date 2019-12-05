package com.suypower.venus.elec.common.common;

import com.suypower.venus.elec.common.utils.Assert;
import com.suypower.venus.elec.common.utils.StringUtils;
import com.suypower.venus.platform.share.entity.IEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther:maofukai
 * @date:2019-07-09
 * 时间类型定义
 */
public enum TimeType implements IEnum<String> {

       Day("day","日"),
       Week("week","周"),
       Month("month","月"),
       Year("year","年");

       private String timeTypeNo;

       private String timeTypeName;

    TimeType(String timeTypeNo, String timeTypeName){
        this.timeTypeNo   = timeTypeNo;
        this.timeTypeName = timeTypeName;
    }

    public String getTimeTypeNo() {
        return timeTypeNo;
    }

    public String getTimeTypeName() {
        return timeTypeName;
    }

    public static TimeType[] list(TimeType... timeTypes){
        return timeTypes;
    }

    public static TimeType[] parse(String ... values){
        List<TimeType> timeTypes = new ArrayList();
        for(String value  : values){
            for(TimeType timeType : values()){
                if(timeType.getTimeTypeNo().equals(value)){
                    timeTypes.add(timeType);
                    break;
                }
            }
        }
        return timeTypes.toArray(new TimeType[0]);
    }

    /**
     * 通过编号获取 TimeType
     * @param value
     * @return
     */
    public static TimeType parse(String  value){
        TimeType find = null;
            for(TimeType timeType : values()){
                if(timeType.getTimeTypeNo().equals(value)){
                    find = timeType;
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
    public static TimeType[] parseOf(String  values){
        if(StringUtils.isEmpty(values)){
            return null;
        }
        List<TimeType>  timeTypes = new ArrayList();
        String[] newValues =values.split(",");
        boolean isExist = false; //判断单元编号是否存在，不存在则抛异常
        for(String value  : newValues){
            for(TimeType timeType : values()){
                if(timeType.getTimeTypeNo().equals(value)){
                    timeTypes.add(timeType);
                    isExist = true;
                    break;
                }
            }
            Assert.isFalse(isExist,"该日期类型不存在");
//            if(!isExist){
//                throw new VenusResponseException(value+":该日期类型不存在");
//            }
            isExist = false;
        }
        return timeTypes.toArray(new TimeType[0]);
    }

    @Override
    public String getId() {
        return getTimeTypeNo();
    }
}
