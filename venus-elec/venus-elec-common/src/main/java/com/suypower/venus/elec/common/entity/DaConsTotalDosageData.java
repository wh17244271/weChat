package com.suypower.venus.elec.common.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

/**
 * @author maofukai
 * @date   2019-07-12
 * 企业汇总用量数据
 */
public class DaConsTotalDosageData extends DaConsBaseData {

    /**
     * 本日(yyyy-MM-dd)
     */
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate selfDataDate;
    /**
     * 本日尖峰用量对应数据库字段SP_Q
     */
    private Double selfDateTip;
    /**
     * 本日峰用量对应数据库字段SP_Q
     */
    private Double selfDatePeak;
    /**
     * 本日平用量对应数据库字段M_Q
     */
    private Double selfDateFlat;
    /**
     * 本日谷用量对应数据库字段V_Q
     */
    private Double selfDateValley;
    /**
     * 本日合计用量对应数据库字段TOTAL_Q
     */
    private Double selfDateTotal;

    /**
     * 本月(yyyy-MM)
     */
    private String selfDataMonth;
    /**
     * 本月尖峰用量对应数据库字段SP_Q
     */
    private Double selfMonthTip;
    /**
     * 本月峰用量对应数据库字段SP_Q
     */
    private Double selfMonthPeak;
    /**
     * 本月平用量对应数据库字段M_Q
     */
    private Double selfMonthFlat;
    /**
     * 本月谷用量对应数据库字段V_Q
     */
    private Double selfMonthValley;
    /**
     * 本月合计用量对应数据库字段TOTAL_Q
     */
    private Double selfMonthTotal;

    /**
     * 本年(yyyy)
     */
    private String selfDataYear;
    /**
     * 本年尖峰用量对应数据库字段SP_Q
     */
    private Double selfYearTip;
    /**
     * 本年峰用量对应数据库字段SP_Q
     */
    private Double selfYearPeak;
    /**
     * 本年平用量对应数据库字段M_Q
     */
    private Double selfYearFlat;
    /**
     * 本年谷用量对应数据库字段V_Q
     */
    private Double selfYearValley;
    /**
     * 本年合计用量对应数据库字段TOTAL_Q
     */
    private Double selfYearTotal;

    /**
     * 上日(yyyy-MM-dd)
     */
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate prevDataDate;
    /**
     * 上日尖峰用量对应数据库字段SP_Q
     */
    private Double prevDateTip;
    /**
     * 上日峰用量对应数据库字段SP_Q
     */
    private Double prevDatePeak;
    /**
     * 上日平用量对应数据库字段M_Q
     */
    private Double prevDateFlat;
    /**
     * 上日谷用量对应数据库字段V_Q
     */
    private Double prevDateValley;
    /**
     * 上日合计用量对应数据库字段TOTAL_Q
     */
    private Double prevDateTotal;

    /**
     * 上月(yyyy-MM)
     */
    private String prevDataMonth;
    /**
     * 上月尖峰用量对应数据库字段SP_Q
     */
    private Double prevMonthTip;
    /**
     * 上月峰用量对应数据库字段SP_Q
     */
    private Double prevMonthPeak;
    /**
     * 上月平用量对应数据库字段M_Q
     */
    private Double prevMonthFlat;
    /**
     * 上月谷用量对应数据库字段V_Q
     */
    private Double prevMonthValley;
    /**
     * 上月合计用量对应数据库字段TOTAL_Q
     */
    private Double prevMonthTotal;

    /**
     * 上年(yyyy)
     */
    private String prevDataYear;
    /**
     * 上年尖峰用量对应数据库字段SP_Q
     */
    private Double prevYearTip;
    /**
     * 上年峰用量对应数据库字段SP_Q
     */
    private Double prevYearPeak;
    /**
     * 上年平用量对应数据库字段M_Q
     */
    private Double prevYearFlat;
    /**
     * 上年谷用量对应数据库字段V_Q
     */
    private Double prevYearValley;
    /**
     * 上年合计用量对应数据库字段TOTAL_Q
     */
    private Double prevYearTotal;

    public LocalDate getSelfDataDate() {
        return selfDataDate;
    }

    public void setSelfDataDate(LocalDate selfDataDate) {
        this.selfDataDate = selfDataDate;
    }

    public Double getSelfDateTip() {
        return selfDateTip;
    }

    public void setSelfDateTip(Double selfDateTip) {
        this.selfDateTip = selfDateTip;
    }

    public Double getSelfDatePeak() {
        return selfDatePeak;
    }

    public void setSelfDatePeak(Double selfDatePeak) {
        this.selfDatePeak = selfDatePeak;
    }

    public Double getSelfDateFlat() {
        return selfDateFlat;
    }

    public void setSelfDateFlat(Double selfDateFlat) {
        this.selfDateFlat = selfDateFlat;
    }

    public Double getSelfDateValley() {
        return selfDateValley;
    }

    public void setSelfDateValley(Double selfDateValley) {
        this.selfDateValley = selfDateValley;
    }

    public Double getSelfDateTotal() {
        return selfDateTotal;
    }

    public void setSelfDateTotal(Double selfDateTotal) {
        this.selfDateTotal = selfDateTotal;
    }

    public String getSelfDataMonth() {
        return selfDataMonth;
    }

    public void setSelfDataMonth(String selfDataMonth) {
        this.selfDataMonth = selfDataMonth;
    }

    public Double getSelfMonthTip() {
        return selfMonthTip;
    }

    public void setSelfMonthTip(Double selfMonthTip) {
        this.selfMonthTip = selfMonthTip;
    }

    public Double getSelfMonthPeak() {
        return selfMonthPeak;
    }

    public void setSelfMonthPeak(Double selfMonthPeak) {
        this.selfMonthPeak = selfMonthPeak;
    }

    public Double getSelfMonthFlat() {
        return selfMonthFlat;
    }

    public void setSelfMonthFlat(Double selfMonthFlat) {
        this.selfMonthFlat = selfMonthFlat;
    }

    public Double getSelfMonthValley() {
        return selfMonthValley;
    }

    public void setSelfMonthValley(Double selfMonthValley) {
        this.selfMonthValley = selfMonthValley;
    }

    public Double getSelfMonthTotal() {
        return selfMonthTotal;
    }

    public void setSelfMonthTotal(Double selfMonthTotal) {
        this.selfMonthTotal = selfMonthTotal;
    }

    public String getSelfDataYear() {
        return selfDataYear;
    }

    public void setSelfDataYear(String selfDataYear) {
        this.selfDataYear = selfDataYear;
    }

    public Double getSelfYearTip() {
        return selfYearTip;
    }

    public void setSelfYearTip(Double selfYearTip) {
        this.selfYearTip = selfYearTip;
    }

    public Double getSelfYearPeak() {
        return selfYearPeak;
    }

    public void setSelfYearPeak(Double selfYearPeak) {
        this.selfYearPeak = selfYearPeak;
    }

    public Double getSelfYearFlat() {
        return selfYearFlat;
    }

    public void setSelfYearFlat(Double selfYearFlat) {
        this.selfYearFlat = selfYearFlat;
    }

    public Double getSelfYearValley() {
        return selfYearValley;
    }

    public void setSelfYearValley(Double selfYearValley) {
        this.selfYearValley = selfYearValley;
    }

    public Double getSelfYearTotal() {
        return selfYearTotal;
    }

    public void setSelfYearTotal(Double selfYearTotal) {
        this.selfYearTotal = selfYearTotal;
    }

    public LocalDate getPrevDataDate() {
        return prevDataDate;
    }

    public void setPrevDataDate(LocalDate prevDataDate) {
        this.prevDataDate = prevDataDate;
    }

    public Double getPrevDateTip() {
        return prevDateTip;
    }

    public void setPrevDateTip(Double prevDateTip) {
        this.prevDateTip = prevDateTip;
    }

    public Double getPrevDatePeak() {
        return prevDatePeak;
    }

    public void setPrevDatePeak(Double prevDatePeak) {
        this.prevDatePeak = prevDatePeak;
    }

    public Double getPrevDateFlat() {
        return prevDateFlat;
    }

    public void setPrevDateFlat(Double prevDateFlat) {
        this.prevDateFlat = prevDateFlat;
    }

    public Double getPrevDateValley() {
        return prevDateValley;
    }

    public void setPrevDateValley(Double prevDateValley) {
        this.prevDateValley = prevDateValley;
    }

    public Double getPrevDateTotal() {
        return prevDateTotal;
    }

    public void setPrevDateTotal(Double prevDateTotal) {
        this.prevDateTotal = prevDateTotal;
    }

    public String getPrevDataMonth() {
        return prevDataMonth;
    }

    public void setPrevDataMonth(String prevDataMonth) {
        this.prevDataMonth = prevDataMonth;
    }

    public Double getPrevMonthTip() {
        return prevMonthTip;
    }

    public void setPrevMonthTip(Double prevMonthTip) {
        this.prevMonthTip = prevMonthTip;
    }

    public Double getPrevMonthPeak() {
        return prevMonthPeak;
    }

    public void setPrevMonthPeak(Double prevMonthPeak) {
        this.prevMonthPeak = prevMonthPeak;
    }

    public Double getPrevMonthFlat() {
        return prevMonthFlat;
    }

    public void setPrevMonthFlat(Double prevMonthFlat) {
        this.prevMonthFlat = prevMonthFlat;
    }

    public Double getPrevMonthValley() {
        return prevMonthValley;
    }

    public void setPrevMonthValley(Double prevMonthValley) {
        this.prevMonthValley = prevMonthValley;
    }

    public Double getPrevMonthTotal() {
        return prevMonthTotal;
    }

    public void setPrevMonthTotal(Double prevMonthTotal) {
        this.prevMonthTotal = prevMonthTotal;
    }

    public String getPrevDataYear() {
        return prevDataYear;
    }

    public void setPrevDataYear(String prevDataYear) {
        this.prevDataYear = prevDataYear;
    }

    public Double getPrevYearTip() {
        return prevYearTip;
    }

    public void setPrevYearTip(Double prevYearTip) {
        this.prevYearTip = prevYearTip;
    }

    public Double getPrevYearPeak() {
        return prevYearPeak;
    }

    public void setPrevYearPeak(Double prevYearPeak) {
        this.prevYearPeak = prevYearPeak;
    }

    public Double getPrevYearFlat() {
        return prevYearFlat;
    }

    public void setPrevYearFlat(Double prevYearFlat) {
        this.prevYearFlat = prevYearFlat;
    }

    public Double getPrevYearValley() {
        return prevYearValley;
    }

    public void setPrevYearValley(Double prevYearValley) {
        this.prevYearValley = prevYearValley;
    }

    public Double getPrevYearTotal() {
        return prevYearTotal;
    }

    public void setPrevYearTotal(Double prevYearTotal) {
        this.prevYearTotal = prevYearTotal;
    }
}
