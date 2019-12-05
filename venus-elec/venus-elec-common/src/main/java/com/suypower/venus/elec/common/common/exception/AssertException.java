package com.suypower.venus.elec.common.common.exception;

/**
 * 自定义异常，对前台参数进行解析时出现的相关错误
 */
public class AssertException extends RuntimeException {
    public AssertException() {
        super();
    }

    public AssertException(String msg) {
        super(msg);
    }
}
