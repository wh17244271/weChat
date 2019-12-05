package com.suypower.venus.elec.common.utils;

import com.suypower.venus.elec.common.common.Index;
import com.suypower.venus.elec.common.common.exception.VenusResponseException;
import com.suypower.venus.elec.common.entity.DaConsDayDosageData;
import org.apache.commons.collections.CollectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.*;

public class DataGroupUtils {

    private static final String[] METHODNAMES = {"rDate"};

    /**
     * 将 List<Object>对象 根据属性分组,如果 groups参数为空，则返回原先数据集合
     *
     * @param mates
     * @param groups 分组属性 例如： indBNo,data
     * @param <T>
     * @return List<Map < String, Object>> 或者  List<Object>
     */
    public static <T> Object originalOrgroupByField(List<T> mates, String[] groups) {

        Map<String, Object> map = null;
        List<Map<String, Object>> resultList = new ArrayList<>();
        if(StringUtils.isEmpty(mates)){
            return mates;
        }
        String[] groupCloums = parseGroupColum(mates.get(0), groups);
        if (StringUtils.isEmpty(groupCloums) ){
            return mates;
        }

        try {

            Class<?> clazz = mates.get(0).getClass(); //获取第一个属性
            String valueId = ""; //存储  key 由 对应属性值相加
            Map<String,Method> methods = new HashMap<>(); //判断方法是否已经反射了。
            Method method = null;
            for (T mate : mates) {
                String key = "";
                Map<String, String> groupCloumAndValue = new LinkedHashMap<>();

                int i = 0;
                for (String groupCloum : groupCloums) {
                    String methodname = "";

                    if(Arrays.asList(METHODNAMES).contains(groupCloum) ){
                        methodname="get"+groupCloum;
                    }else{
                        methodname = "get" + Character.toUpperCase(groupCloum.charAt(0)) + groupCloum.substring(1);
                    }

                    if(methods.containsKey(methodname)){
                        method = methods.get(methodname);
                    }else{
                        method = getMethod(clazz, methodname, new Class[]{});// 获取定义的方法
                        methods.put(methodname,method);
                    }


                    String value = method.invoke(mate).toString();
                    groupCloumAndValue.put(groupCloum, value);
                    if (StringUtils.isEmpty(key)) {
                        key += value;
                    } else {
                        key += "_" + value;
                    }

                    i++;
                }
                valueId = key;

                List<T> list = null;
                boolean boo = false;
                for (Map<String, Object> groupMap : resultList) {
                    String keyT = "";
                    for (Map.Entry<String, String> entry : groupCloumAndValue.entrySet()) {
                        String mapKey = entry.getKey();
                        if (StringUtils.isEmpty(keyT)) {
                            keyT += groupMap.get(mapKey);
                        } else {
                            keyT += "_" + groupMap.get(mapKey);
                        }

                    }
                    if (valueId.equals(keyT)) {
                        list = (List<T>) groupMap.get("list");
                        list.add(mate);
                        groupMap.put("list", list);
                        boo = true;
                        break;
                    }


                }

                //判断是否需要创建分组
                if (map == null || !boo) {
                    map = new LinkedHashMap<>();
                    List<T> listData = new ArrayList<>();
                    listData.add(mate);
                    map.put("id", valueId);
                    map.putAll(groupCloumAndValue);
                    map.put("list", listData);
                    resultList.add(map);
                }
            }

        } catch (Exception e) {
            throw new VenusResponseException("该属性不支持分组，请切换");
        }
        return resultList;
    }


    public static void main(String[] args) {
        List<DaConsDayDosageData> list = new ArrayList<>();
        DaConsDayDosageData d1 = new DaConsDayDosageData();
        d1.setDataDate(LocalDate.of(2019, 8, 1));
        d1.setIndex(Index.P);
        d1.setConsName("张三");
        d1.setTotal(20.0);
        d1.setMonth("2019-08");
        DaConsDayDosageData d2 = new DaConsDayDosageData();
        d2.setDataDate(LocalDate.of(2019, 8, 2));
        d2.setIndex(Index.P);
        d2.setConsName("张三");
        d2.setTotal(30.0);
        d2.setMonth("2019-08");
        DaConsDayDosageData d3 = new DaConsDayDosageData();
        d3.setDataDate(LocalDate.of(2019, 9, 1));
        d3.setIndex(Index.SPZW);
        d3.setConsName("李四");
        d3.setTotal(40.0);
        d3.setMonth("2019-09");
        DaConsDayDosageData d4 = new DaConsDayDosageData();
        d4.setDataDate(LocalDate.of(2019, 9, 2));
        d4.setIndex(Index.SPZW);
        d4.setConsName("李四");
        d4.setTotal(50.0);
        d4.setMonth("2019-09");
        list.add(d1);
        list.add(d2);
        list.add(d3);
        list.add(d4);
//        DataGroupUtils.groupBy(list, "indBNo");
        String[] colums = {"indBNo","month"};

        Object o = DataGroupUtils.originalOrgroupByField(list, colums);

        System.out.println("");
        /*for (Iterator<String> iterator = indBNo.keySet().iterator(); iterator.hasNext(); ) {
            String key = (String) iterator.next();

            List<DaConsDayDosageData> list1 = indBNo.get(key);
            for (DaConsDayDosageData ob : list1) {
                System.out.println("分组:" + key + ">>>>>>>" + "对象值:" + ob.toString());
            }
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        }*/


    }


    /**
     * 获取反射调用的方法-包含父类的
     *
     * @param clazz
     * @param methodName
     * @param classes
     * @return
     * @throws Exception
     */
    private static Method getMethod(Class clazz, String methodName,
                                    final Class[] classes) throws Exception {
        Method method = null;
        try {
            method = clazz.getDeclaredMethod(methodName, classes);
        } catch (NoSuchMethodException e) {
            try {
                method = clazz.getMethod(methodName, classes);
            } catch (NoSuchMethodException ex) {
                if (clazz.getSuperclass() == null) {
                    return method;
                } else {
                    method = getMethod(clazz.getSuperclass(), methodName,
                            classes);
                }
            }
        }
        return method;
    }

    /**
     * 通过反射获取属性的名字集合
     *
     * @param object
     * @param <T>
     * @return
     */
    private static <T> Set<String> groupBy(T object) {
        try {
            Set<String> groupFileds = new TreeSet<>(); //存储需要分组的字段
            Set<Field[]> fieldsList = ReflexUtils.getFiledName(object);
            for (Field[] fileds : fieldsList) {
                for (Field file : fileds) {
                    groupFileds.add(file.getName());
                }
            }
            return groupFileds;
        } catch (Exception e) {
            return null;
        }


    }


    /**
     * 将前台传递过来的字段进行对象属性匹配
     *
     * @param object
     * @param groupColums
     * @param <T>
     * @return
     */
    private static <T> String[] parseGroupColum(T object, String[] groupColums) {
        Set<String> fields = groupBy(object);
        if (CollectionUtils.isEmpty(fields) || StringUtils.isEmpty(groupColums) ) return null;



        String[] newGroupColums = new String[groupColums.length];
        int i = 0;
        for (String groupColum : groupColums) {
            groupColum = groupColum.trim();
            for (String field : fields) {
                if ("day".equals(groupColum)) {
                    groupColum = "dataDate";
                    break;
                } /*else if ("month".equals(groupColum) && field.toLowerCase().equals("dataMonth".toLowerCase())) {
                    groupColum = "dataMonth";
                    break;
                } else if ("month".equals(groupColum) && field.toLowerCase().equals("month".toLowerCase())) {
                    groupColum = "month";
                    break;
                } */else if ("indBNo".equals(groupColum)) {
                    groupColum = "index";
                    break;
                } else if ("unitTypeNo".equals(groupColum)) {
                    groupColum = "unitType";
                    break;
                }
            }
            newGroupColums[i] = groupColum;
            i++;
        }


        return newGroupColums;
    }
}
