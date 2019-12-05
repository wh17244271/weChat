package com.suypower.venus.sys.common.exception;

import org.apache.shiro.authc.AuthenticationException;

/**
 * 自定义异常，对前台参数进行解析时出现的相关错误
 */
public class LoginErrorException extends AuthenticationException {
    public LoginErrorException() {
        super();
    }

    public LoginErrorException(String msg) {
        super(msg);
    }
}
