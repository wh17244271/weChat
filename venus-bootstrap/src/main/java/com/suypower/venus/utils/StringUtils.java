package com.suypower.venus.utils;

import java.io.UnsupportedEncodingException;
import java.text.NumberFormat;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;

public class StringUtils {

    /**
     * 获取uuid
     * @return
     */
    public static String uuid(){
        return UUID.randomUUID().toString().replace("-","");
    }

    /**
     * 替换风速单位
     * @param value
     * @return
     */
    public static String replaceWin(String value) {
        return value.replace("级", "")
                .replace("<", "").
                        replace(">", "")
                .replace("=", "");
    }

    /**
     * 将以 ‘，’拼接的字符串转换成 String[] 形式
     *
     * @param value
     * @return
     */
    public static String[] parseArray(String value) {
        try {
            if (isEmpty(value)) return null;

            String[] split = value.split(",");
            return split;
        }catch (Exception e){
            return null;
        }

    }

    /**
     * 将以 指定拼接的字符串转换成 String[] 形式
     * @param value 需要拆分的字符串
     * @param arg   拆分的字符标准
     * @return
     */
    public static String[] parseArray(String value,String arg) {
        try {
            if (isEmpty(value)) return null;
            if(isEmpty(arg)){
                return parseArray(value);
            }

            String[] split = value.split(arg);
            return split;
        }catch (Exception e){
            return null;
        }

    }



    /**
     * 判断字符串是否为空，并返回字符串，如果为空，返回指定字符串
     *
     * @param value    需要判断的内容
     * @param newValue 返回的内容
     * @return
     */
    public static String isEmpty(String value, String newValue) {
        return isEmpty(value) ? newValue : value;
    }



    /**
     * 判断字符串是否为空 包含：null 、 "" 、 "null"
     *
     * @param value
     * @return
     */
    public static boolean isEmpty(String value) {
        return value == null || "".equals(value) || "null".equals(value) || value.length() == 0;
    }

    /**
     * 判读集合是否为空
     *
     * @param value
     * @return
     */
    public static boolean isEmpty(Collection value) {
        return null == value || value.size() == 0;
    }

    /**
     * 判断Map是否为空
     *
     * @param value
     * @return
     */
    public static boolean isEmpty(Map value) {
        return null == value || value.size() == 0;
    }

    /**
     * 判断数组对象是否为空
     *
     * @param value
     * @param <T>
     * @return
     */
    public static <T> boolean isEmpty(T[] value) {
        return value == null || value.length == 0;
    }



    /**
     * 判断字符串是否为纯整数
     *
     * @param str
     * @return
     */
    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

    /**
     * 将double转换成String,并取消科学计数法显示
     *
     * @param d
     * @return
     */
    public static String doubleformatString(double d) {
        NumberFormat nf = NumberFormat.getInstance();
        //设置保留多少位小数
        nf.setMaximumFractionDigits(6);
        // 取消科学计数法
        nf.setGroupingUsed(false);
        //返回结果
        String format = nf.format(d);

        return format;
    }

    public static String fixed(String s, int length) {
        StringBuffer sb = new StringBuffer(s);
        int len = 0;
        try {
            len = s.getBytes("GBK").length;
            while (len < length) {
                sb.append(" ");
                len++;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static String fixed(Object o, int length) {
        return fixed(String.valueOf(o), length);
    }


}
