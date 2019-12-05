package com.suypower.venus.elec.common.query;


import com.suypower.venus.elec.common.common.Index;

import java.time.LocalDate;

public class DaMpQuery {

//    private TimeType timeType;
//
//    private String timeData;
    private String consNo;

    private String[] mpIds;
    private String[] unitIds;
    private LocalDate[] dataDates;
    private String[] dataMonths;
    private String[] dataYears;

    private Index[] indexes;

    private String dataDateCycle;

    private String pointCount;

    private String fill;

    private String orderBy;
    private String[] groupBys;


    public String getConsNo() {
        return consNo;
    }

    public void setConsNo(String consNo) {
        this.consNo = consNo;
    }

    public String[] getMpIds() {
        return mpIds;
    }

    public void setMpIds(String[] mpIds) {
        this.mpIds = mpIds;
    }

    public String[] getUnitIds() {
        return unitIds;
    }

    public void setUnitIds(String[] unitIds) {
        this.unitIds = unitIds;
    }

    public LocalDate[] getDataDates() {
        return dataDates;
    }

    public void setDataDates(LocalDate[] dataDates) {
        this.dataDates = dataDates;
    }

    public String[] getDataMonths() {
        return dataMonths;
    }

    public void setDataMonths(String[] dataMonths) {
        this.dataMonths = dataMonths;
    }

    public String[] getDataYears() {
        return dataYears;
    }

    public void setDataYears(String[] dataYears) {
        this.dataYears = dataYears;
    }

    public Index[] getIndexes() {
        return indexes;
    }

    public void setIndexes(Index[] indexes) {
        this.indexes = indexes;
    }

    public String getDataDateCycle() {
        return dataDateCycle;
    }

    public void setDataDateCycle(String dataDateCycle) {
        this.dataDateCycle = dataDateCycle;
    }

    public String getPointCount() {
        return pointCount;
    }

    public void setPointCount(String pointCount) {
        this.pointCount = pointCount;
    }

    public String getFill() {
        return fill;
    }

    public void setFill(String fill) {
        this.fill = fill;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String[] getGroupBys() {
        return groupBys;
    }

    public void setGroupBys(String[] groupBys) {
        this.groupBys = groupBys;
    }
}