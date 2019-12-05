package com.suypower.venus.elec.common.query;

import com.suypower.venus.app.cs.common.RelationTypeConstant;
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
public class DaAllSingleRawQuery {
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
     * 指标编号
     * @see Index
     */
    private String indBNo;
    /**
     * 单元编号
     * @see UnitType
     */
    private String unitTypeNo;

    /**
     * 点数类型
     * (24=24个点,96=96个点,288=288个点,控制points数据显示数量)
     */
    private String pointCount;

    private String mpId;
    private String unitId;

    /**
     * 档案ID
     */
    private String arcIds;

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


    public <T>T parse(){

        //关联条件处理处理
        Assert.isEmpty(getRelationType() ,"关联类型不能为空");

        if(RelationTypeConstant.CONS_TYPE.equals(getRelationType())){
            Assert.isEmpty(getRelationId(),"查询的关联ID不能为空");
            DaConsQuery daConsQuery = new DaConsQuery();
            daConsQuery.setIndexes(Index.parseOf(getIndBNo()));
            daConsQuery.setUnitTypes(UnitType.parseOf(getUnitTypeNo()));
            daConsQuery.setPointCount(getPointCount());
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
            daConsQuery.setDataDates(dataDates);
            daConsQuery.setDataMonths(dataMonths);
            daConsQuery.setConsNo(getRelationId());

            return (T)daConsQuery;
        }else if(RelationTypeConstant.MP_TYPE.equals(getRelationType())){
            Assert.isEmpty(getRelationIds(),"查询的关联ID不能为空");
            DaMpQuery daMpQuery = new DaMpQuery();
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

            daMpQuery.setMpIds(getRelationIds());
            return (T)daMpQuery;
        }else{
            throw new VenusResponseException("关联类型不存在");
        }

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

    public String getArcIds() {
        return arcIds;
    }

    public void setArcIds(String arcIds) {
        this.arcIds = arcIds;
    }

    public String[] getRelationIds() {
        return relationIds;
    }

    public void setRelationIds(String[] relationIds) {
        this.relationIds = relationIds;
    }
}

