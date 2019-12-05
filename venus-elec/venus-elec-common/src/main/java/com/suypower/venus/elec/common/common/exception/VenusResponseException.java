package com.suypower.venus.elec.common.common.exception;

/**
 * 自定义异常，对前台参数进行解析时出现的相关错误
 */
public class VenusResponseException extends RuntimeException {
    public VenusResponseException() {
        super();
    }

    public VenusResponseException(String msg) {
        super(msg);
    }
}
