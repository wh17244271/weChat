package com.suypower.venus.elec.common.utils;

import com.suypower.venus.elec.common.common.Constant;
import com.suypower.venus.elec.common.common.Index;
import com.suypower.venus.elec.common.common.UnitType;
import com.suypower.venus.elec.common.common.exception.VenusResponseException;
import com.suypower.venus.elec.common.entity.DaConsDayData;
import com.suypower.venus.elec.common.entity.DaMpDayData;
import com.suypower.venus.elec.common.entity.DaUnitDayData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class MapToDataEntityUtils {

    static Pattern POINT_PATTERN = Pattern.compile("^[P]\\d{4}$");

    /**
     * 将表中所有字段的数据封装到 DaConsDayData 实体类中
     *
     * @param list
     * @param pointCount   数据频度 24 96 288
     * @return
     */
    public static List<DaConsDayData> mapToDaConsDayData(List<Map<String, Object>> list,String pointCount) {
        List<DaConsDayData> newList = new ArrayList<>();
        DaConsDayData dataEntity = null;
        if (newList != null) {
            for (Map<String, Object> map : list) {
                dataEntity = new DaConsDayData();
                dataEntity.setOrgNo(Types.String(map.get("ORG_NO")));
                dataEntity.setOrgName(Types.String(map.get("ORG_NAME")));
                dataEntity.setConsNo(Types.String(map.get("CONS_NO")));
                dataEntity.setConsName(Types.String(map.get("CONS_NAME")));
                String indBNo = Types.String(map.get("IND_B_NO"));
                dataEntity.setIndex(Index.parse(indBNo));
                String uTypeNo = Types.String(map.get("U_TYPE_NO"));
                dataEntity.setUnitType( UnitType.parse(uTypeNo));

                dataEntity.setLastTime(Types.localDateTime(map.get("LAST_TIME")));
                dataEntity.setLastVal(Types.Double(map.get("LAST_VAL")));
                dataEntity.setMaxTime(Types.localDateTime(map.get("MAX_TIME")));
                dataEntity.setMaxVal(Types.Double(map.get("MAX_VAL")));
                dataEntity.setMinTime(Types.localDateTime(map.get("MIN_TIME")));
                dataEntity.setMinVal(Types.Double(map.get("MIN_VAL")));
                dataEntity.setAvgVal(Types.Double(map.get("AVG_VAL")));
                dataEntity.setDataDate(Types.LocalDate(map.get("DATA_DATE")));
                dataEntity.setMonth(Types.String(map.get("MONTH")));
                dataEntity.setDate(Types.LocalDate(map.get("DATE")));
                dataEntity.setYear(Types.String(map.get("YEAR")));
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    if (POINT_PATTERN.matcher(key).matches()) {
                        //key : P1130 >>> 11:30
                        key = new StringBuffer(key).delete(0,1).insert(2,":").toString();

                        String point = key.substring(3); //取 P1010 最后两个字符，判断时间点
                        if(StringUtils.isEmpty(pointCount)){
                            dataEntity.putPoint(key, Types.Double(value));
                        }else if(Constant.POINTCOUNT_24.equals(pointCount)){
                           if(Constant.POINTCOUNT_24_LIST.contains(point)){
                               dataEntity.putPoint(key, Types.Double(value));
                           }
                        }else if(Constant.POINTCOUNT_96.equals(pointCount)){
                            if(Constant.POINTCOUNT_96_LIST.contains(point)){
                                dataEntity.putPoint(key, Types.Double(value));
                            }
                        }else if(Constant.POINTCOUNT_288.equals(pointCount)){
                            if(Constant.POINTCOUNT_288_LIST.contains(point)){
                                dataEntity.putPoint(key, Types.Double(value));
                            }
                        }else{
                            throw new VenusResponseException("请选择正确的数据频度");
                        }


                    }
                }
                newList.add(dataEntity);
            }
        }
        return newList;
    }



    /**
     * 将表中所有字段的数据封装到 DaMpDayData 实体类中
     *
     * @param list
     * @return
     */
    public static List<DaMpDayData> mapToDaMpDayData(List<Map<String, Object>> list,String pointCount) {
        List<DaMpDayData> newList = new ArrayList<>();
        DaMpDayData dataEntity = null;
        if (newList != null) {
            for (Map<String, Object> map : list) {
                dataEntity = new DaMpDayData();
                dataEntity.setIndex(Index.parse(Types.String(map.get("IND_B_NO"))));
                dataEntity.setLastTime(Types.localDateTime(map.get("LAST_TIME")));
                dataEntity.setLastVal(Types.Double(map.get("LAST_VAL")));
                dataEntity.setMaxTime(Types.localDateTime(map.get("MAX_TIME")));
                dataEntity.setMaxVal(Types.Double(map.get("MAX_VAL")));
                dataEntity.setMinTime(Types.localDateTime(map.get("MIN_TIME")));
                dataEntity.setMinVal(Types.Double(map.get("MIN_VAL")));
                dataEntity.setAvgVal(Types.Double(map.get("AVG_VAL")));
                dataEntity.setDataDate(Types.LocalDate(map.get("DATA_DATE")));
                dataEntity.setMonth(Types.String(map.get("MONTH")));
                dataEntity.setMpId(Types.Long(map.get("MP_ID")));
                dataEntity.setConsNo(Types.String(map.get("CONS_NO")));
                dataEntity.setDate(Types.LocalDate(map.get("DATE")));
                dataEntity.setYear(Types.String(map.get("YEAR")));
                dataEntity.setMpName(Types.String(map.get("MP_NAME")));
//                dataEntity.setMpNo(Types.(map.get("MP_NO")));

                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    if (POINT_PATTERN.matcher(key).matches()) {
                        //key : P1130 >>> 11:30
                        key = new StringBuffer(key).delete(0,1).insert(2,":").toString();

                        String point = key.substring(3); //取 P1010 最后两个字符，判断时间点
                        if(StringUtils.isEmpty(pointCount)){
                            dataEntity.putPoint(key, Types.Double(value));
                        }else if(Constant.POINTCOUNT_24.equals(pointCount)){
                            if(Constant.POINTCOUNT_24_LIST.contains(point)){
                                dataEntity.putPoint(key, Types.Double(value));
                            }
                        }else if(Constant.POINTCOUNT_96.equals(pointCount)){
                            if(Constant.POINTCOUNT_96_LIST.contains(point)){
                                dataEntity.putPoint(key, Types.Double(value));
                            }
                        }else if(Constant.POINTCOUNT_288.equals(pointCount)){
                            if(Constant.POINTCOUNT_288_LIST.contains(point)){
                                dataEntity.putPoint(key, Types.Double(value));
                            }
                        }else{
                            throw new VenusResponseException("请选择正确的数据频度");
                        }
                    }
                }
                newList.add(dataEntity);
            }
        }
        return newList;
    }

    /**
     * 将表中所有字段的数据封装到 DaUnitDayData 实体类中
     * @param list
     * @return
     */
    public static List<DaUnitDayData> mapToDaUnitDayData(List<Map<String, Object>> list,String pointCount) {
        List<DaUnitDayData> newList = new ArrayList<>();
        DaUnitDayData dataEntity = null;
        if (newList != null) {
            for (Map<String, Object> map : list) {
                dataEntity = new DaUnitDayData();

                dataEntity.setIndex(Index.parse(Types.String(map.get("IND_B_NO"))));
                dataEntity.setLastTime(Types.localDateTime(map.get("LAST_TIME")));
                dataEntity.setLastVal(Types.Double(map.get("LAST_VAL")));
                dataEntity.setMaxTime(Types.localDateTime(map.get("MAX_TIME")));
                dataEntity.setMaxVal(Types.Double(map.get("MAX_VAL")));
                dataEntity.setMinTime(Types.localDateTime(map.get("MIN_TIME")));
                dataEntity.setMinVal(Types.Double(map.get("MIN_VAL")));
                dataEntity.setAvgVal(Types.Double(map.get("AVG_VAL")));
                dataEntity.setDataDate(Types.LocalDate(map.get("DATA_DATE")));
                dataEntity.setMonth(Types.String(map.get("MONTH")));

                dataEntity.setUnitId(Types.String(map.get("UNIT_ID")));
                dataEntity.setUnitName(Types.String(map.get("UNIT_NAME")));
                dataEntity.setConsNo(Types.String(map.get("CONS_NO")));
                dataEntity.setConsName(Types.String(map.get("CONS_NAME")));

                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    if (POINT_PATTERN.matcher(key).matches()) {
                        //key : P1130 >>> 11:30
                        key = new StringBuffer(key).delete(0,1).insert(2,":").toString();

                        String point = key.substring(3); //取 P1010 最后两个字符，判断时间点
                        if(StringUtils.isEmpty(pointCount)){
                            dataEntity.putPoint(key, Types.Double(value));
                        }else if(Constant.POINTCOUNT_24.equals(pointCount)){
                            if(Constant.POINTCOUNT_24_LIST.contains(point)){
                                dataEntity.putPoint(key, Types.Double(value));
                            }
                        }else if(Constant.POINTCOUNT_96.equals(pointCount)){
                            if(Constant.POINTCOUNT_96_LIST.contains(point)){
                                dataEntity.putPoint(key, Types.Double(value));
                            }
                        }else if(Constant.POINTCOUNT_288.equals(pointCount)){
                            if(Constant.POINTCOUNT_288_LIST.contains(point)){
                                dataEntity.putPoint(key, Types.Double(value));
                            }
                        }else{
                            throw new VenusResponseException("请选择正确的数据频度");
                        }
                    }
                }
                newList.add(dataEntity);
            }
        }
        return newList;
    }


}
