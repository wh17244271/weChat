package com.suypower.venus.platform.web.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class VenusResponse<T> {

    private int version = 1;

    private String requestId;

    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private LocalDateTime time;

    private int code;

    private boolean success;

    private String message;

    private T data;

    private Object dataExt;

    public VenusResponse(){}


    public VenusResponse( int code, String message, T data) {
        this.time = LocalDateTime.now();
        this.code = code;
        this.success = code == 200;
        this.message = message;
        this.data = data;
    }

    public VenusResponse( int code, Exception exception, T data) {
        this.time = LocalDateTime.now();
        this.code = code;
        this.success = code == 200;
        this.message = exception.getMessage();
        this.data = data;
    }

    public VenusResponse(VenusResponseCode venusResponseCode) {
        this.time = LocalDateTime.now();
        this.code = venusResponseCode.getCode();
        this.success = code == 200;
        this.message = venusResponseCode.getMessage();
    }

    public VenusResponse(VenusResponseCode venusResponseCode,T data) {
        this.time = LocalDateTime.now();
        this.code = venusResponseCode.getCode();
        this.success = code == 200;
        this.message = venusResponseCode.getMessage();
        this.data   = data;
    }
    public VenusResponse(VenusResponseCode venusResponseCode,String message) {
        this.time = LocalDateTime.now();
        this.code = venusResponseCode.getCode();
        this.success = code == 200;
        this.message = message;
    }

    public VenusResponse(VenusResponseCode venusResponseCode, Exception e) {
        this.time = LocalDateTime.now();
        this.code = venusResponseCode.getCode();
        this.success = code == 200;
        this.message = e.getMessage();
    }

    protected VenusResponse( int code, boolean success, String message, T data ) {
        this.time = LocalDateTime.now();
        this.code = code;
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Object getDataExt() {
        return dataExt;
    }

    public void setDataExt(Object dataExt) {
        this.dataExt = dataExt;
    }
}
