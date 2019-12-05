package com.suypower.venus.elec.common.query;

import com.suypower.venus.elec.common.common.Index;
import com.suypower.venus.elec.common.common.TimeType;
import com.suypower.venus.elec.common.common.UnitType;
import com.suypower.venus.elec.common.common.exception.VenusResponseException;
import com.suypower.venus.elec.common.utils.Assert;
import com.suypower.venus.elec.common.utils.DataCycleUtils;
import com.suypower.venus.elec.common.utils.StringUtils;
import com.suypower.venus.elec.common.utils.Times;

import java.time.LocalDate;

/**
 * @author maofukai
 * @date 2019-08-01
 * 企业查询原始对象(多个查询)
 */
public class DaConsMultiRawQuery {

    /**
     * 日期类型
     * @see com.suypower.venus.elec.common.common.TimeType
     */
    private String timeType;
    /**
     * 日期内容
     * day     = (today=今日数据,yesterday=昨日数据,[today,yesterday][2019-07-11,2019-07-11]=指定多天)
     * week   =  (2=第二周)
     * month  =  (theMonth=当月,lastMonth=上月,[2019-07,2019-08]=指定多个月份)
     * year   =  (theYear =当年,lastYear =上年|去年,2018=2018年数据,2019=2019年数据)
     */
    private String timeData;
    /**
     * 指标编号
     * @see com.suypower.venus.elec.common.common.Index
     */
    private String indBNo;
    /**
     * 单元编号
     * @see com.suypower.venus.elec.common.common.UnitType
     */
    private String unitTypeNo;
    /**
     * 数据周期
     * (1=同比,2=环比 ......) 自动增加同比、环比查询参数
     */
    private String dataDateCycle;
    /**
     * 点数类型
     * (24=24个点,96=96个点,288=288个点,控制points数据显示数量)
     */
    private String pointCount;
    /**
     * 填充数据
     */
    private String fill;
    /**
     * 排序
     */
    private String orderBy;

    private String groupBy;

    public DaConsQuery parse() {
        DaConsQuery daConsQuery = new DaConsQuery();
        daConsQuery.setTimeType(getTimeType());
        daConsQuery.setIndexes(Index.parseOf(getIndBNo()));
        daConsQuery.setUnitTypes(UnitType.parseOf(getUnitTypeNo()));
        daConsQuery.setDataDateCycle(getDataDateCycle());
        daConsQuery.setPointCount(getPointCount());
        daConsQuery.setFill(getFill());
        daConsQuery.setOrderBy(getOrderBy());
        daConsQuery.setGroupBys(StringUtils.parseArray(getGroupBy()));
        //开始时间处理
        String timeType = getTimeType();
        String timeData = getTimeData();
        Assert.isEmpty(timeType, "日期类型不能为空");
        Assert.isEmpty(timeData, "数据日期不能为空");
        if (TimeType.Day.getTimeTypeNo().equals(timeType)) {
            LocalDate[] localDate = Times.parseArray(timeData);
            localDate = DataCycleUtils.localDate(dataDateCycle, localDate);
            daConsQuery.setDataDates(localDate);

        } else if (TimeType.Month.getTimeTypeNo().equals(timeType)) {
            String[] dataMonth = Times.parseArray(timeData);
            //检查时间格式
            if(!Times.checkFormatIsTrue(dataMonth, TimeType.Month.getTimeTypeNo())){
                throw new VenusResponseException("数据日期和日期类型不匹配");
            }
            dataMonth = DataCycleUtils.localMonth(dataDateCycle, dataMonth);
            daConsQuery.setDataMonths(dataMonth);
        } else if (TimeType.Year.getTimeTypeNo().equals(timeType)) {
            String[] dataYears = Times.parseArray(timeData);
            //检查时间格式
            Assert.isFalse(Times.checkFormatIsTrue(dataYears, TimeType.Year.getTimeTypeNo()),"数据日期和日期类型不匹配");
            dataYears = DataCycleUtils.localYear(dataDateCycle, dataYears);
            daConsQuery.setDataYears(dataYears);
        } else {
            throw new VenusResponseException("日期类型不正确");
        }

        return daConsQuery;
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

    public String getIndBNo() {
        return indBNo;
    }

    public void setIndBNo(String indBNo) {
        this.indBNo = indBNo;
    }

    public String getUnitTypeNo() {
        return unitTypeNo;
    }

    public void setUnitTypeNo(String unitTypeNo) {
        this.unitTypeNo = unitTypeNo;
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

