package com.suypower.venus.elec.common.query;

import com.suypower.venus.elec.common.common.Index;
import com.suypower.venus.elec.common.common.UnitType;

import java.time.LocalDate;

public class DaConsQuery {

    private String timeType;
    private String consNo;

    private LocalDate[] dataDates;
    private String[] dataMonths;
    private String[] dataYears;

    private Index[] indexes;

    private UnitType[] unitTypes;

    private String dataDateCycle;

    private String pointCount;

    private String fill;

    private String orderBy;
    private String[] groupBys;


    public String getTimeType() {
        return timeType;
    }

    public void setTimeType(String timeType) {
        this.timeType = timeType;
    }

    public String getConsNo() {
        return consNo;
    }

    public void setConsNo(String consNo) {
        this.consNo = consNo;
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

    public UnitType[] getUnitTypes() {
        return unitTypes;
    }

    public void setUnitTypes(UnitType[] unitTypes) {
        this.unitTypes = unitTypes;
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

