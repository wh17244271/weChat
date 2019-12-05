package com.suypower.venus.elec.common.query;

import com.suypower.venus.elec.common.common.Index;
import com.suypower.venus.elec.common.common.UnitType;
import com.suypower.venus.elec.common.common.exception.VenusResponseException;
import com.suypower.venus.elec.common.utils.Assert;
import com.suypower.venus.elec.common.utils.StringUtils;
import com.suypower.venus.elec.common.utils.Times;

import java.time.LocalDate;

/**
 * @author maofukai
 * @date 2019-08-01
 * 企业查询原始对象(单个查询)
 */
public class DaConsSingleRawQuery {
    /**
     * 按日查询
     * 1.dataDate     | 必填参数 | 数据日期  | (today=今日数据,yesterday=昨日数据,2019-07-12=指定某天)
     */
    private String dataDate;
    /**
     * 按月查询
     * dataMonth  | 必填参数 | 数据日期  | (theMonth=当月,lastMonth=上月,2019-07=指定月份)
     */
    private String dataMonth;
    /**
     * 按年查询
     * dataYear  | 必填参数 | 数据日期  | (theYear=当年,lastYear=去年,2019=指定年份)
     */
    private String dataYear;

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
     * 点数类型
     * (24=24个点,96=96个点,288=288个点,控制points数据显示数量)
     */
    private String pointCount;
    /**
     * 填充数据
     */
    private String fill;

    public DaConsQuery parse() {
        DaConsQuery daConsQuery = new DaConsQuery();
        daConsQuery.setIndexes(Index.parseOf(getIndBNo()));
        daConsQuery.setUnitTypes(UnitType.parseOf(getUnitTypeNo()));
        daConsQuery.setPointCount(getPointCount());
        daConsQuery.setFill(getFill());
        //开始时间处理
        String dataDate = getDataDate();
        String dataMonth = getDataMonth();
        String dataYear = getDataYear();
        if (StringUtils.isEmpty(dataDate) && StringUtils.isEmpty(dataMonth)&& StringUtils.isEmpty(dataYear)) {
            Assert.isEmpty(dataDate, "数据日期不能为空");
        } else if (!StringUtils.isEmpty(dataDate) && !StringUtils.isEmpty(dataMonth)) {
            throw new VenusResponseException("数据日期只能输入一个");
        }
        else if (!StringUtils.isEmpty(dataDate) && !StringUtils.isEmpty(dataYear)) {
            throw new VenusResponseException("数据日期只能输入一个");
        }
        else if (!StringUtils.isEmpty(dataMonth) && !StringUtils.isEmpty(dataYear)) {
            throw new VenusResponseException("数据日期只能输入一个");
        }
        LocalDate[] dataDates = Times.parseArray(dataDate);
        String[] dataMonths = Times.parseArray(dataMonth);
        String[] dataYears = Times.parseArray(dataYear);
        daConsQuery.setDataDates(dataDates);
        daConsQuery.setDataMonths(dataMonths);
        daConsQuery.setDataYears(dataYears);
        return daConsQuery;
    }

    public String getDataDate() {
        return dataDate;
    }

    public void setDataDate(String dataDate) {
        this.dataDate = dataDate;
    }

    public String getDataMonth() {
        return dataMonth;
    }

    public void setDataMonth(String dataMonth) {
        this.dataMonth = dataMonth;
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

    public String getDataYear() {
        return dataYear;
    }

    public void setDataYear(String dataYear) {
        this.dataYear = dataYear;
    }
}

