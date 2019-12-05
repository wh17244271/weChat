package com.suypower.venus.elec.common.entity;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

/**
 * @author maofukai
 * @date   2019-07-12
 * 供电单位(行政区域)月数据
 */
public class DaOrgMonthData extends DaOrgBaseData{

    /**
     * 数据月份(yyyy-MM)
     */
    private String month;

    /**
     * 最新值时间
     */
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private LocalDateTime lastTime;

    /**
     * 最新值
     */
    private Double lastVal;

    /**
     * 最小值时间
     */
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private LocalDateTime minTime;

    /**
     * 最小值
     */
    private Double minVal;

    /**
     * 最大值时间
     */
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private LocalDateTime maxTime;

    /**
     * 最大值
     */
    private Double maxVal;

    /**
     * 平均值
     */
    private Double avgVal;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public LocalDateTime getLastTime() {
        return lastTime;
    }

    public void setLastTime(LocalDateTime lastTime) {
        this.lastTime = lastTime;
    }

    public Double getLastVal() {
        return lastVal;
    }

    public void setLastVal(Double lastVal) {
        this.lastVal = lastVal;
    }

    public LocalDateTime getMinTime() {
        return minTime;
    }

    public void setMinTime(LocalDateTime minTime) {
        this.minTime = minTime;
    }

    public Double getMinVal() {
        return minVal;
    }

    public void setMinVal(Double minVal) {
        this.minVal = minVal;
    }

    public LocalDateTime getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(LocalDateTime maxTime) {
        this.maxTime = maxTime;
    }

    public Double getMaxVal() {
        return maxVal;
    }

    public void setMaxVal(Double maxVal) {
        this.maxVal = maxVal;
    }

    public Double getAvgVal() {
        return avgVal;
    }

    public void setAvgVal(Double avgVal) {
        this.avgVal = avgVal;
    }

}
