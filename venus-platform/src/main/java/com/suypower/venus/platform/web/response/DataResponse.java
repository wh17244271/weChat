package com.suypower.venus.platform.web.response;

public class DataResponse extends VenusResponse{
    /**
     * 数据分组
     */
    private String dataGroup;
    /**
     * 数据类型
     */
    private String dataType;



    public DataResponse(){};

    public DataResponse(String dataGroup, String dataType) {
        this.dataGroup = dataGroup;
        this.dataType = dataType;
    }

    public DataResponse(int code, String message, Object data, String dataGroup, String dataType) {
        super(code, message, data);
        this.dataGroup = dataGroup;
        this.dataType = dataType;
    }

    public DataResponse(int code, Exception exception, Object data, String dataGroup, String dataType) {
        super(code, exception, data);
        this.dataGroup = dataGroup;
        this.dataType = dataType;
    }

    public DataResponse(VenusResponseCode venusResponseCode, String dataGroup, String dataType) {
        super(venusResponseCode);
        this.dataGroup = dataGroup;
        this.dataType = dataType;
    }

    public DataResponse(VenusResponseCode venusResponseCode, Object data, String dataGroup, String dataType) {
        super(venusResponseCode, data);
        this.dataGroup = dataGroup;
        this.dataType = dataType;
    }

    public DataResponse(VenusResponseCode venusResponseCode, String message, String dataGroup, String dataType) {
        super(venusResponseCode, message);
        this.dataGroup = dataGroup;
        this.dataType = dataType;
    }

    public DataResponse(VenusResponseCode venusResponseCode, Exception e, String dataGroup, String dataType) {
        super(venusResponseCode, e);
        this.dataGroup = dataGroup;
        this.dataType = dataType;
    }

    public DataResponse(int code, boolean success, String message, Object data, String dataGroup, String dataType) {
        super(code, success, message, data);
        this.dataGroup = dataGroup;
        this.dataType = dataType;
    }

    public String getDataGroup() {
        return dataGroup;
    }

    public void setDataGroup(String dataGroup) {
        this.dataGroup = dataGroup;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
}
