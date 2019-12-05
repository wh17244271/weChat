package com.suypower.venus.sys.common.exception;

import org.apache.shiro.authc.AuthenticationException;

/**
 * 验证码错误异常
 */
public class CaptchaErrorException extends AuthenticationException {
    public CaptchaErrorException() {
        super();
    }

    public CaptchaErrorException(String msg) {
        super(msg);
    }
}
