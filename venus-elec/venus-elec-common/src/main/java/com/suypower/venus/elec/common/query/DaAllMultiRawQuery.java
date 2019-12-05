package com.suypower.venus.elec.common.query;

import com.suypower.venus.app.cs.common.RelationTypeConstant;
import com.suypower.venus.elec.common.common.Index;
import com.suypower.venus.elec.common.common.TimeType;
import com.suypower.venus.elec.common.common.UnitType;
import com.suypower.venus.elec.common.common.exception.VenusResponseException;
import com.suypower.venus.elec.common.utils.Assert;
import com.suypower.venus.elec.common.utils.DataCycleUtils;
import com.suypower.venus.elec.common.utils.StringUtils;
import com.suypower.venus.elec.common.utils.Times;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * @author maofukai
 * @date 2019-08-01
 * 企业查询原始对象(多个查询)
 */
public class DaAllMultiRawQuery {

    /**
     * 日期类型
     *
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
     *
     * @see com.suypower.venus.elec.common.common.Index
     */
    private String indBNo;
    /**
     * 单元编号
     *
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


    private String mpId;

    private String unitId;
    /**
     * 关联类型
     */
    private String relationType;

    /**
     * 关联标识
     */
    private String relationId;

    /**
     * 关联标识
     */
    private String[] relationIds;
    /**
     * 档案ID
     */
    private String arcIds;

    public <T> T parse() {
        //关联条件处理处理
        Assert.isEmpty(getRelationType(), "关联类型不能为空");
        if (RelationTypeConstant.CONS_TYPE.equals(getRelationType())) {
            Assert.isEmpty(getRelationId(), "查询的关联ID不能为空");
            DaConsQuery daConsQuery = new DaConsQuery();
            daConsQuery.setConsNo(getRelationId()); //给RelationId赋值
            daConsQuery.setTimeType(getTimeType());
            daConsQuery.setIndexes(Index.parseOf(getIndBNo()));
            daConsQuery.setUnitTypes(UnitType.parseOf(getUnitTypeNo()));
            daConsQuery.setDataDateCycle(getDataDateCycle());
            daConsQuery.setPointCount(getPointCount());
            daConsQuery.setFill(getFill());
            daConsQuery.setOrderBy(getOrderBy());
            daConsQuery.setGroupBys(analysisGroup(getGroupBy(),RelationTypeConstant.CONS_TYPE));
            //处理分组


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
                if (!Times.checkFormatIsTrue(dataMonth, TimeType.Month.getTimeTypeNo())) {
                    throw new VenusResponseException("数据日期和日期类型不匹配");
                }
                dataMonth = DataCycleUtils.localMonth(dataDateCycle, dataMonth);
                daConsQuery.setDataMonths(dataMonth);
            } else if (TimeType.Year.getTimeTypeNo().equals(timeType)) {
                String[] dataYears = Times.parseArray(timeData);
                Assert.isFalse(Times.checkFormatIsTrue(dataYears, TimeType.Year.getTimeTypeNo()), "数据日期和日期类型不匹配");
                dataYears = DataCycleUtils.localYear(dataDateCycle, dataYears);
                daConsQuery.setDataYears(dataYears);
            } else {
                throw new VenusResponseException("日期类型不正确");
            }

            return (T) daConsQuery;
        } else if (RelationTypeConstant.MP_TYPE.equals(getRelationType())) {
            Assert.isEmpty(getRelationIds(), "查询的关联ID不能为空");
            DaMpQuery daMpQuery = new DaMpQuery();
            daMpQuery.setMpIds(getRelationIds()); //给RelationId赋值
            daMpQuery.setUnitIds(StringUtils.parseArray(getUnitId()));
            daMpQuery.setIndexes(Index.parseOf(getIndBNo()));
            daMpQuery.setDataDateCycle(getDataDateCycle());
            daMpQuery.setPointCount(getPointCount());
            daMpQuery.setFill(getFill());
            daMpQuery.setOrderBy(getOrderBy());
            daMpQuery.setGroupBys(analysisGroup(getGroupBy(),RelationTypeConstant.MP_TYPE));
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
                Assert.isFalse(Times.checkFormatIsTrue(dataMonth, TimeType.Month.getTimeTypeNo()), "数据日期和日期类型不匹配");
                dataMonth = DataCycleUtils.localMonth(dataDateCycle, dataMonth);
                daMpQuery.setDataMonths(dataMonth);
            } else if (TimeType.Year.getTimeTypeNo().equals(timeType)) {
                String[] dataYears = Times.parseArray(timeData);
                Assert.isFalse(Times.checkFormatIsTrue(dataYears, TimeType.Year.getTimeTypeNo()), "数据日期和日期类型不匹配");
                dataYears = DataCycleUtils.localYear(dataDateCycle, dataYears);
                daMpQuery.setDataYears(dataYears);
            } else {
                throw new VenusResponseException("日期类型不正确");
            }
            return (T) daMpQuery;
        } else {
            throw new VenusResponseException("关联类型不存在");
        }
    }

    public static void main(String[] args) {
        String groupBy = "cons:cons-dataDate,mp:mpId-cons";
        String[] mps = analysisGroup(groupBy, "mp");

        for (String str : mps) {
            System.out.println(str);
        }
    }

    /**
     * 解析分组类型
     * @param groupValue
     * @param type
     * @return
     */
    private static String[] analysisGroup(String groupValue, String type) {
        try {
            if(StringUtils.isEmpty(groupValue))return null;
            String[] stringTypes = StringUtils.parseArray(groupValue);
            Set<String> set = new HashSet<>();
            for (String typeStr : stringTypes) {
                //mp-cons:cons-dataDate
                String[] resultType = typeStr.split(":");
                String groupByCloums = resultType[1]; //cons-dataDate
                if (type.equals(resultType[0])) {
                    String[] groupByCloum = groupByCloums.split("-");
                    for (String cloum : groupByCloum) {
                        set.add(cloum);
                    }
                }
            }
            String[] groupBys = set.toArray(new String[set.size()]);
            return groupBys;
        } catch (Exception e) {
            throw new VenusResponseException("分组解析失败，请重新传递正确的分组格式");
        }
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

    public String getRelationType() {
        return relationType;
    }

    public void setRelationType(String relationType) {
        this.relationType = relationType;
    }

    public String getRelationId() {
        return relationId;
    }

    public void setRelationId(String relationId) {
        this.relationId = relationId;
    }

    public String[] getRelationIds() {
        return relationIds;
    }

    public void setRelationIds(String[] relationIds) {
        this.relationIds = relationIds;
    }

    public String getArcIds() {
        return arcIds;
    }

    public void setArcIds(String arcIds) {
        this.arcIds = arcIds;
    }
}

