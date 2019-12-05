package com.suypower.venus.platform.web.response;

public enum  VenusResponseHttpCode implements VenusResponseCode{
    OK(200,"成功"),

    InternalServerError(500,"错误的请求"),

    BadRequest(400,"错误的请求"),

    NotFound(404,"请求不存在"),
    NoPermission(600,"没有权限"),
    AccountLock(800,"账号已被锁定"),
    AccountPasswordError(810,"账号密码错误"),
    CoodError(820,"验证码错误"),
    ;

    private int code;

    private String message;

    VenusResponseHttpCode(int code,String message){
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }


    @Override
    public String getMessage() {
        return message;
    }

}
