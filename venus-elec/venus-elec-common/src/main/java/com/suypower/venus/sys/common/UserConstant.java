package com.suypower.venus.sys.common;

public interface UserConstant {
    /**
     * 用户状态：正常
     */
    String status_normal = "1";
    /**
     * 用户状态：锁定
     */
    String status_lock = "2";
    /**
     * 用户状态：冻结
     */
    String status_frozen = "3";
    /**
     * 用户状态：离职
     */
    String status_quit = "4";


    /**
     * RSA加密私钥
     */
    String RSA_PRIVATE_KEY = "RSA_PRIVATE_KEY";
    /**
     * RSA加密私钥
     */
    String RSA_PUBLIC_KEY = "RSA_PUBLIC_KEY";
    /**
     * 验证码
     */
    String KEY_CAPTCHA = "KEY_CAPTCHA";
    /**
     * 用户前台传送的，需要在密码次数的时候验证
     */
    String USER_CAPTCHA = "USER_CAPTCHA";

    /**
     * 用户TOKEN,用来验证用户
     */
    String USER_TOKEN = "USER_TOKEN";
    /**
     * 错误次数
     */
    String ERROR_COUNT = "ERROR_COUNT";
    /**
     * 记录锁定时间
     */
    String LOCK_TIME = "LOCK_TIME";
    /**
     * 记录错误时间
     */
    String ERROR_TIME = "ERROR_TIME";
}
