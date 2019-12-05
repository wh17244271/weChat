package com.suypower.venus.elec.common.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 企业年用量高级数据（含环比)
 */
public class DaConsYearDosageData extends DaConsMonthDosageData{

    /**
     * 当年每年用量数据集合
     */
    private List<DaConsMonthDosageData> items  = new ArrayList<>();

    /**
     * 【按年环比】数据年份(yyyy)
     */
    private String yoyYear;
    /**
     * 【按年环比】尖峰用量对应数据库字段SP_Q
     */
    private Double yoyTip;
    /**
     * 【按年环比】尖峰用量比(百分数,默认最多保留一位小数)
     */
    private Double yoyTipRatio;
    /**
     * 【按年环比】峰用量对应数据库字段P_Q
     */
    private Double yoyPeak;
    /**
     * 【按年环比】峰用量比(百分数,默认最多保留一位小数)
     */
    private Double yoyPeakRatio;
    /**
     * 【按年环比】平用量对应数据库字段M_Q
     */
    private Double yoyFlat;
    /**
     * 【按年环比】平用量比(百分数,默认最多保留一位小数)
     */
    private Double yoyFlatRatio;
    /**
     * 【按年环比】谷用量对应数据库字段V_Q
     */
    private Double yoyValley;
    /**
     * 【按年环比】谷用量比(百分数,默认最多保留一位小数)
     */
    private Double yoyValleyRatio;
    /**
     * 【按年环比】合计用量对应数据库字段TOTAL_Q
     */
    private Double yoyTotal;
    /**
     * 【按年环比】合计用量比(百分数,默认最多保留一位小数)
     */
    private Double yoyTotalRatio;

    public List<DaConsMonthDosageData> getItems() {
        return items;
    }

    public void setItems(List<DaConsMonthDosageData> items) {
        this.items = items;
    }

    public String getYoyYear() {
        return yoyYear;
    }

    public void setYoyYear(String yoyYear) {
        this.yoyYear = yoyYear;
    }

    public Double getYoyTip() {
        return yoyTip;
    }

    public void setYoyTip(Double yoyTip) {
        this.yoyTip = yoyTip;
    }

    public Double getYoyTipRatio() {
        return yoyTipRatio;
    }

    public void setYoyTipRatio(Double yoyTipRatio) {
        this.yoyTipRatio = yoyTipRatio;
    }

    public Double getYoyPeak() {
        return yoyPeak;
    }

    public void setYoyPeak(Double yoyPeak) {
        this.yoyPeak = yoyPeak;
    }

    public Double getYoyPeakRatio() {
        return yoyPeakRatio;
    }

    public void setYoyPeakRatio(Double yoyPeakRatio) {
        this.yoyPeakRatio = yoyPeakRatio;
    }

    public Double getYoyFlat() {
        return yoyFlat;
    }

    public void setYoyFlat(Double yoyFlat) {
        this.yoyFlat = yoyFlat;
    }

    public Double getYoyFlatRatio() {
        return yoyFlatRatio;
    }

    public void setYoyFlatRatio(Double yoyFlatRatio) {
        this.yoyFlatRatio = yoyFlatRatio;
    }

    public Double getYoyValley() {
        return yoyValley;
    }

    public void setYoyValley(Double yoyValley) {
        this.yoyValley = yoyValley;
    }

    public Double getYoyValleyRatio() {
        return yoyValleyRatio;
    }

    public void setYoyValleyRatio(Double yoyValleyRatio) {
        this.yoyValleyRatio = yoyValleyRatio;
    }

    public Double getYoyTotal() {
        return yoyTotal;
    }

    public void setYoyTotal(Double yoyTotal) {
        this.yoyTotal = yoyTotal;
    }

    public Double getYoyTotalRatio() {
        return yoyTotalRatio;
    }

    public void setYoyTotalRatio(Double yoyTotalRatio) {
        this.yoyTotalRatio = yoyTotalRatio;
    }
}
