package com.suypower.venus.elec.common.query;

import com.suypower.venus.elec.common.common.Index;
import com.suypower.venus.elec.common.common.exception.VenusResponseException;
import com.suypower.venus.elec.common.utils.Assert;
import com.suypower.venus.elec.common.utils.StringUtils;
import com.suypower.venus.elec.common.utils.Times;

import java.time.LocalDate;

public class DaMpSingleRawQuery {

    private String dataDate;

    private String dataMonth;

    private String mpId;
    private String unitId;

    private String indBNo;


    private String pointCount;


    public DaMpQuery parse() {
        DaMpQuery daMpQuery = new DaMpQuery();
        daMpQuery.setMpIds(StringUtils.parseArray(getMpId()));
        daMpQuery.setUnitIds(StringUtils.parseArray(getUnitId()));
        daMpQuery.setIndexes(Index.parseOf(getIndBNo()));
        daMpQuery.setPointCount(getPointCount());
        //开始时间处理
        String dataDate = getDataDate();
        String dataMonth = getDataMonth();
        if (StringUtils.isEmpty(dataDate) && StringUtils.isEmpty(dataMonth)) {
            Assert.isEmpty(dataDate, "数据日期不能为空");
        } else if (!StringUtils.isEmpty(dataDate) && !StringUtils.isEmpty(dataMonth)) {
            throw new VenusResponseException("数据日期只能输入一个");
        }
        LocalDate[] dataDates = Times.parseArray(dataDate);
        String[] dataMonths = Times.parseArray(dataMonth);
        daMpQuery.setDataDates(dataDates);
        daMpQuery.setDataMonths(dataMonths);
        return daMpQuery;
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

    public String getPointCount() {
        return pointCount;
    }

    public void setPointCount(String pointCount) {
        this.pointCount = pointCount;
    }


}
