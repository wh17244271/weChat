package com.suypower.venus.elec.common.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

/**
 * @author maofukai
 * @date   2019-07-12
 * 测点月抄表示数
 */
public class DaMpMonthReadingsData extends DaMpBaseData {

    /**
     * 抄表月份(yyyy-MM)(对应数据库字段R_YM)
     */
    private String dataMonth;

    /**
     * 上期示数抄表时间(yyyy-MM-dd hh:mm:ss)
     */
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private LocalDateTime lDataTime;

    /**
     * 上期示数
     */
    private Double lNum;

    /**
     * 本期示数抄表时间(yyyy-MM-dd hh:mm:ss)
     */
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private LocalDateTime tDataTime;

    /**
     * 本期示数
     */
    private Double tNum;

    /**
     * 倍率(对应数据库字段MULT_PW)
     */
    private Double rate;

    public String getDataMonth() {
        return dataMonth;
    }

    public void setDataMonth(String dataMonth) {
        this.dataMonth = dataMonth;
    }

    public LocalDateTime getlDataTime() {
        return lDataTime;
    }

    public void setlDataTime(LocalDateTime lDataTime) {
        this.lDataTime = lDataTime;
    }

    public Double getlNum() {
        return lNum;
    }

    public void setlNum(Double lNum) {
        this.lNum = lNum;
    }

    public LocalDateTime gettDataTime() {
        return tDataTime;
    }

    public void settDataTime(LocalDateTime tDataTime) {
        this.tDataTime = tDataTime;
    }

    public Double gettNum() {
        return tNum;
    }

    public void settNum(Double tNum) {
        this.tNum = tNum;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
