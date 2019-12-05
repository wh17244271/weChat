package com.suypower.venus.elec.common.entity;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

/**
 * @author maofukai
 * @date   2019-07-12
 * 测点月数据
 */
public class DaMpMonthData extends DaMpBaseData{

    /**
     * 数据月份(yyyy-MM)
     */
    private String dataMonth;

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

    public String getDataMonth() {
        return dataMonth;
    }

    public void setDataMonth(String dataMonth) {
        this.dataMonth = dataMonth;
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
