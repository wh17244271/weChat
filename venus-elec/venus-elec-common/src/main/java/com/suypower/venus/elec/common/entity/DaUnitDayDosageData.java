package com.suypower.venus.elec.common.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

/**
 * @author maofukai
 * @date   2019-07-12
 * 单元日用量数据
 */
public class DaUnitDayDosageData extends DaUnitBaseData{

    /**
     * 数据日期(yyyy-MM-dd)
     */
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dataDate;

    /**
     * 数据月份(yyyy-MM)
     */
    private String month;

    /**
     * 尖峰用量对应数据库字段SP_Q
     */
    private Double tip;

    /**
     * 峰用量对应数据库字段SP_Q
     */
    private Double peak;

    /**
     * 平用量对应数据库字段M_Q
     */
    private Double flat;

    /**
     * 谷用量对应数据库字段V_Q
     */
    private Double valley;

    /**
     * 合计用量对应数据库字段TOTAL_Q
     */
    private Double total;

    public LocalDate getDataDate() {
        return dataDate;
    }

    public void setDataDate(LocalDate dataDate) {
        this.dataDate = dataDate;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Double getTip() {
        return tip;
    }

    public void setTip(Double tip) {
        this.tip = tip;
    }

    public Double getPeak() {
        return peak;
    }

    public void setPeak(Double peak) {
        this.peak = peak;
    }

    public Double getFlat() {
        return flat;
    }

    public void setFlat(Double flat) {
        this.flat = flat;
    }

    public Double getValley() {
        return valley;
    }

    public void setValley(Double valley) {
        this.valley = valley;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
