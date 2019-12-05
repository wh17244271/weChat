package com.suypower.venus.elec.common.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 企业月用量高级数据
 */
public class DaConsMonthDosageYearData extends DaConsMonthDosageData{

    /**
     * 当年每月用量数据集合
     */
    private List<DaConsMonthDosageData> items  = new ArrayList<>();


    /**
     *【按月环比】数据月份(yyyy-MM)
     */
    private String momDataMonth;
    /**
     * 【按月环比】尖峰用量对应数据库字段SP_Q
     */
    private Double momTip;
    /**
     * 【按月环比】尖峰用量比(百分数,默认最多保留一位小数)
     */
    private Double momTipRatio;
    /**
     * 【按月环比】峰用量对应数据库字段P_Q
     */
    private Double momPeak;
    /**
     * 【按月环比】峰用量比(百分数,默认最多保留一位小数)
     */
    private Double momPeakRatio;
    /**
     * 【按月环比】平用量对应数据库字段M_Q
     */
    private Double momFlat;
    /**
     * 【按月环比】平用量比(百分数,默认最多保留一位小数)
     */
    private Double momFlatRatio;
    /**
     * 【按月环比】谷用量对应数据库字段V_Q
     */
    private Double momValley;
    /**
     * 【按月环比】谷用量比(百分数,默认最多保留一位小数)
     */
    private Double momValleyRatio;
    /**
     * 【按月环比】合计用量对应数据库字段TOTAL_Q
     */
    private Double momTotal;
    /**
     * 【按月环比】合计用量比(百分数,默认最多保留一位小数)
     */
    private Double momTotalRatio;


    /**
     * 【按年同比】数据月份(yyyy-MM)
     */
    private String yoyDataMonth;
    /**
     * 【按年同比】尖峰用量对应数据库字段SP_Q
     */
    private Double yoyTip;
    /**
     * 【按月环比】尖峰用量比(百分数,默认最多保留一位小数)
     */
    private Double yoyTipRatio;
    /**
     * 【按年同比】峰用量对应数据库字段P_Q
     */
    private Double yoyPeak;
    /**
     * 【按年同比】峰用量比(百分数,默认最多保留一位小数)
     */
    private Double yoyPeakRatio;
    /**
     * 【按年同比】平用量对应数据库字段M_Q
     */
    private Double yoyFlat;
    /**
     * 【按年同比】平用量比(百分数,默认最多保留一位小数)
     */
    private Double yoyFlatRatio;
    /**
     * 【按年同比】谷用量对应数据库字段V_Q
     */
    private Double yoyValley;
    /**
     * 【按年同比】谷用量比(百分数,默认最多保留一位小数)
     */
    private Double yoyValleyRatio;
    /**
     * 【按年同比】合计用量对应数据库字段TOTAL_Q
     */
    private Double yoyTotal;
    /**
     * 【按年同比】合计用量比(百分数,默认最多保留一位小数)
     */
    private Double yoyTotalRatio;

    public List<DaConsMonthDosageData> getItems() {
        return items;
    }

    public void setItems(List<DaConsMonthDosageData> items) {
        this.items = items;
    }

    public String getMomDataMonth() {
        return momDataMonth;
    }

    public void setMomDataMonth(String momDataMonth) {
        this.momDataMonth = momDataMonth;
    }

    public Double getMomTip() {
        return momTip;
    }

    public void setMomTip(Double momTip) {
        this.momTip = momTip;
    }

    public Double getMomTipRatio() {
        return momTipRatio;
    }

    public void setMomTipRatio(Double momTipRatio) {
        this.momTipRatio = momTipRatio;
    }

    public Double getMomPeak() {
        return momPeak;
    }

    public void setMomPeak(Double momPeak) {
        this.momPeak = momPeak;
    }

    public Double getMomPeakRatio() {
        return momPeakRatio;
    }

    public void setMomPeakRatio(Double momPeakRatio) {
        this.momPeakRatio = momPeakRatio;
    }

    public Double getMomFlat() {
        return momFlat;
    }

    public void setMomFlat(Double momFlat) {
        this.momFlat = momFlat;
    }

    public Double getMomFlatRatio() {
        return momFlatRatio;
    }

    public void setMomFlatRatio(Double momFlatRatio) {
        this.momFlatRatio = momFlatRatio;
    }

    public Double getMomValley() {
        return momValley;
    }

    public void setMomValley(Double momValley) {
        this.momValley = momValley;
    }

    public Double getMomValleyRatio() {
        return momValleyRatio;
    }

    public void setMomValleyRatio(Double momValleyRatio) {
        this.momValleyRatio = momValleyRatio;
    }

    public Double getMomTotal() {
        return momTotal;
    }

    public void setMomTotal(Double momTotal) {
        this.momTotal = momTotal;
    }

    public Double getMomTotalRatio() {
        return momTotalRatio;
    }

    public void setMomTotalRatio(Double momTotalRatio) {
        this.momTotalRatio = momTotalRatio;
    }

    public String getYoyDataMonth() {
        return yoyDataMonth;
    }

    public void setYoyDataMonth(String yoyDataMonth) {
        this.yoyDataMonth = yoyDataMonth;
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
