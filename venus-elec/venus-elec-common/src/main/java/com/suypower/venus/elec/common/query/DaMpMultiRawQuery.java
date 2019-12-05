package com.suypower.venus.elec.common.query;

import com.suypower.venus.elec.common.common.Index;
import com.suypower.venus.elec.common.common.TimeType;
import com.suypower.venus.elec.common.common.exception.VenusResponseException;
import com.suypower.venus.elec.common.utils.Assert;
import com.suypower.venus.elec.common.utils.DataCycleUtils;
import com.suypower.venus.elec.common.utils.StringUtils;
import com.suypower.venus.elec.common.utils.Times;

import java.time.LocalDate;

public class DaMpMultiRawQuery {

    private String timeType;

    private String timeData;

    private String mpId;

    private String unitId;

    private String indBNo;

    private String dataDateCycle;

    private String pointCount;

    private String fill;

    private String orderBy;

    private String groupBy;

    public DaMpQuery parse() {
        DaMpQuery daMpQuery = new DaMpQuery();
        daMpQuery.setMpIds(StringUtils.parseArray(getMpId()));
        daMpQuery.setUnitIds(StringUtils.parseArray(getUnitId()));
        daMpQuery.setIndexes(Index.parseOf(getIndBNo()));
        daMpQuery.setDataDateCycle(getDataDateCycle());
        daMpQuery.setPointCount(getPointCount());
        daMpQuery.setFill(getFill());
        daMpQuery.setOrderBy(getOrderBy());
        daMpQuery.setGroupBys(StringUtils.parseArray(getGroupBy()));
        //开始时间处理
        String timeType = getTimeType();
        String timeData = getTimeData();
        Assert.isEmpty(timeType, "日期类型不能为空");
        Assert.isEmpty(timeData, "数据日期不能为空");
        if (TimeType.Day.getTimeTypeNo().equals(timeType)) {
            LocalDate[] localDate = Times.parseArray(timeData);
            localDate = DataCycleUtils.localDate(dataDateCycle, localDate);
            daMpQuery.setDataDates(localDate);

        } else if (TimeType.Month.getTimeTypeNo().equals(timeType)) {
            String[] dataMonth = Times.parseArray(timeData);
            //检查时间格式
            Assert.isFalse(Times.checkFormatIsTrue(dataMonth, TimeType.Month.getTimeTypeNo()),"数据日期和日期类型不匹配");
//            if(!Times.checkFormatIsTrue(dataMonth, TimeType.Month.getTimeTypeNo())){
//                throw new VenusResponseException("数据日期和日期类型不匹配");
//            }
            dataMonth = DataCycleUtils.localMonth(dataDateCycle, dataMonth);
            daMpQuery.setDataMonths(dataMonth);
        } else if (TimeType.Year.getTimeTypeNo().equals(timeType)) {
            String[] dataYears = Times.parseArray(timeData);
            //检查时间格式
            Assert.isFalse(Times.checkFormatIsTrue(dataYears, TimeType.Year.getTimeTypeNo()),"数据日期和日期类型不匹配");
//            if(!Times.checkFormatIsTrue(dataYears, TimeType.Year.getTimeTypeNo())){
//                throw new VenusResponseException("数据日期和日期类型不匹配");
//            }
            dataYears = DataCycleUtils.localYear(dataDateCycle, dataYears);
            daMpQuery.setDataYears(dataYears);
        } else {
            throw new VenusResponseException("日期类型不正确");
        }

        return daMpQuery;
    }

    public String getTimeType() {
        return timeType;
    }

    public void setTimeType(String timeType) {
        this.timeType = timeType;
    }

    public String getTimeData() {
        return timeData;
    }

    public void setTimeData(String timeData) {
        this.timeData = timeData;
    }

    public String getMpId() {
        return mpId;
    }

    public void setMpId(String mpId) {
        this.mpId = mpId;
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public String getIndBNo() {
        return indBNo;
    }

    public void setIndBNo(String indBNo) {
        this.indBNo = indBNo;
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

    public String getGroupBy() {
        return groupBy;
    }

    public void setGroupBy(String groupBy) {
        this.groupBy = groupBy;
    }
}
