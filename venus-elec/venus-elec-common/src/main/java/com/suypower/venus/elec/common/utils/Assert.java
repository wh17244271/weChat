package com.suypower.venus.elec.common.utils;

import com.suypower.venus.elec.common.common.exception.VenusResponseException;

import java.util.Collection;
import java.util.Map;

public class Assert {

    /**
     * 判断手机格式是否正确
     * @param phone
     * @return
     */
    public static void rightPhone(String phone,String errorMessage){
        if(StringUtils.isEmpty(phone) || phone.length()!=11){
            throw new VenusResponseException(errorMessage);
        }
    }

    /**
     * 用户登录、登出、获取用户信息时，判断token是否存在
     * @param token
     * @param errorMessage
     */
    public static void TokenIsEmpty(String token,String errorMessage){
        if (StringUtils.isEmpty(token)) {
            throw new VenusResponseException(errorMessage);
        }
    }


    /**
     * 判断字符串是否为空
     *
     * @param value
     * @param errorMessage
     */
    public static void isEmpty(String value, String errorMessage) {
        if (StringUtils.isEmpty(value)) {
            throw new VenusResponseException(errorMessage);
        }
    }

    /**
     * 判断Collection集合是否为空
     *
     * @param value
     * @param errorMessage
     */
    public static <T> void isEmpty(Collection<T> value, String errorMessage) {
        if (value == null || value.size() == 0) {
            throw new VenusResponseException(errorMessage);
        }
    }

    /**
     * 判断Map集合是否为空
     *
     * @param value
     * @param errorMessage
     */
    public static <K, V> void isEmpty(Map<K, V> value, String errorMessage) {
        if (value == null || value.size() == 0) {
            throw new VenusResponseException(errorMessage);
        }
    }

    /**
     * 判断数组是否为空
     *
     * @param value
     * @param errorMessage
     */
    public static <T> void isEmpty(T[] value, String errorMessage) {
        if (value == null || value.length == 0) {
            throw new VenusResponseException(errorMessage);
        }
    }

    /**
     * 判断对象是否为空
     *
     * @param value
     * @param errorMessage
     */
    public static void isNull(Object value, String errorMessage) {
        if (value == null) {
            throw new VenusResponseException(errorMessage);
        }
    }

    /**
     * 判断对象是否不为空
     *
     * @param value
     * @param errorMessage
     */
    public static void isNotNull(Object value, String errorMessage) {
        if (value != null) {
            throw new VenusResponseException(errorMessage);
        }
    }

    /**
     * 判断是否为真
     *
     * @param value
     * @param errorMessage
     */
    public static void isTrue(boolean value, String errorMessage) {
        if (value) {
            throw new VenusResponseException(errorMessage);
        }
    }

    /**
     * 判断是否为假
     *
     * @param value
     * @param errorMessage
     */
    public static void isFalse(boolean value, String errorMessage) {
        if (!value ) {
            throw new VenusResponseException(errorMessage);
        }
    }
}
