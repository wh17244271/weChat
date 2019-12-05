package com.suypower.venus.elec.common.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class ReflexUtils {


    /**
     * 返回object实际类
     * @param o
     * @return
     */
    public static String getObjectClassName(Object o){
        Class<?> aClass = o.getClass();
        if(aClass!=null){
            String name = aClass.getName();
            return name;
        }
        return "";
    }

    /**
     * 获取属性名数组
     * */
    public static Set<Field[]> getFiledName(Object o)throws Exception{
        Set<Field[]> set = new HashSet<>();
        try {
            Class<?> aClass = o.getClass();
            while (aClass != null) {//当父类为null的时候说明到达了最上层的父类(Object类).
                Field[] fields = aClass.getDeclaredFields();
                set.add(fields);
                aClass = aClass.getSuperclass(); //得到父类,然后赋给自己
            }
           return set;


        } catch (Exception e) {
            e.printStackTrace();
            return set;
        }

        /*Field[] fields=o.getClass().getFields();
        String[] fieldNames=new String[fields.length];
        for(int i=0;i<fields.length;i++){
            fieldNames[i]=fields[i].getName();
        }
        return fieldNames;*/
    }

    /* 根据属性名获取属性值
     * */
    private static Object getFieldValueByName(String fieldName, Object o) throws Exception{
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter, new Class[] {});
            Object value = method.invoke(o, new Object[] {});
            return value;
        } catch (Exception e) {

            return null;
        }
    }

    /**
     * 获取属性类型名字
     * @param filed
     * @return
     */
    private static String getFiledTypeName(Field filed)throws Exception{
        String name = filed.getType().getName();
        name = name.substring(name.lastIndexOf(".")+1); //取最后类名
        return name;
    }

    /**
     * 获取属性名字
     * @param filed
     * @return
     */
    public static String getFiledName(Field filed)throws Exception{
        String name = filed.getName();
        return name;
    }





}
