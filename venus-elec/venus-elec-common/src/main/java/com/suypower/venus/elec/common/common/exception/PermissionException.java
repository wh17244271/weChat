package com.suypower.venus.elec.common.common.exception;

/**
 * 自定义异常，对前台参数进行解析时出现的相关错误
 */
public class PermissionException extends RuntimeException {
    public PermissionException() {
        super();
    }

    public PermissionException(String msg) {
        super(msg);
    }
}
