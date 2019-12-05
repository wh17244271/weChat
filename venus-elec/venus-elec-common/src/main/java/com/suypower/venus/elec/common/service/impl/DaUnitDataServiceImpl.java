package com.suypower.venus.elec.common.service.impl;

import com.suypower.venus.elec.common.common.Index;
import com.suypower.venus.elec.common.common.UnitType;
import com.suypower.venus.elec.common.dao.DaUnitDataDao;
import com.suypower.venus.elec.common.entity.*;
import com.suypower.venus.elec.common.service.IDaUnitDataService;
import com.suypower.venus.elec.common.utils.MapToDataEntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service( "daUnitDataService" )
public class DaUnitDataServiceImpl implements IDaUnitDataService {
    @Autowired
    private DaUnitDataDao daUnitDataDao;

    /**
     * 获取单元日数据
     *
     * @param unitId     单元标识
     * @param dates      数据日期(yyyy-MM-dd)
     * @param indexes    指标编码
     * @param pointCount 数据频度
     * @return
     */
    @Override
    public List<DaUnitDayData> queryUnitDayData(String unitId, LocalDate[] dates, Index[] indexes, String pointCount) {
        List<Map<String, Object>> list = daUnitDataDao.queryUnitDayData(unitId, null, null, dates, indexes);
        List<DaUnitDayData> daUnitDayData = MapToDataEntityUtils.mapToDaUnitDayData(list, pointCount);
        return daUnitDayData;
    }

    /**
     * 获取单元日最值数据
     *
     * @param unitId  单元标识
     * @param dates   数据日期(yyyy-MM-dd)
     * @param indexes 指标编码
     * @return
     */
    @Override
    public List<DaUnitDayMostData> queryUnitDayMostData(String unitId, LocalDate[] dates, Index[] indexes) {
        List<DaUnitDayMostData> daUnitDayMostData = daUnitDataDao.queryUnitDayMostData(unitId, null, null, dates, indexes);
        return daUnitDayMostData;
    }

    /**
     * 获取单元日用量数据
     *
     * @param unitId  单元标识
     * @param dates   数据日期(yyyy-MM-dd)
     * @param indexes 指标编码
     * @return
     */
    @Override
    public List<DaUnitDayDosageData> queryUnitDayDosageData(String unitId, LocalDate[] dates, Index[] indexes) {
        List<DaUnitDayDosageData> daUnitDayDosageData = daUnitDataDao.queryUnitDayDosageData(unitId, null, null, dates, indexes);
        return daUnitDayDosageData;
    }

    /**
     * 获取单元月数据
     *
     * @param unitId     单元标识
     * @param dataMonths 数据日期(yyyy-MM)
     * @param indexes    指标编码
     * @return
     */
    @Override
    public List<DaUnitMonthData> queryUnitMonthData(String unitId, String[] dataMonths, Index[] indexes) {
        List<DaUnitMonthData> daUnitMonthData = daUnitDataDao.queryUnitMonthData(unitId, null, null, dataMonths, indexes);
        return daUnitMonthData;
    }

    /**
     * 获取单元月用量数据
     *
     * @param unitId     单元标识
     * @param dataMonths 数据日期(yyyy-MM)
     * @param indexes    指标编码
     * @return
     */
    @Override
    public List<DaUnitMonthDosageData> queryUnitMonthDosageData(String unitId, String[] dataMonths, Index[] indexes) {
        List<DaUnitMonthDosageData> daUnitMonthDosageData = daUnitDataDao.queryUnitMonthDosageData(unitId, null, null, dataMonths, indexes);
        return daUnitMonthDosageData;
    }

    /**
     * 获取企业单元日数据
     *
     * @param consNo    企业编号
     * @param dates     数据日期(yyyy-MM-dd)
     * @param unitTypes 单元类型编号(单元类型为空查询企业所有类型单元)
     * @param indexes   指标编码
     * @return
     */
    @Override
    public List<DaUnitDayData> queryUnitDayDataByCons(String consNo, LocalDate[] dates, UnitType[] unitTypes, Index[] indexes) {
        List<Map<String, Object>> list = daUnitDataDao.queryUnitDayData(null, consNo, unitTypes, dates, indexes);
        List<DaUnitDayData> daUnitDayData = MapToDataEntityUtils.mapToDaUnitDayData(list, null);
        return daUnitDayData;
    }

    /**
     * 获取企业单元日最值数据
     *
     * @param consNo    企业编号
     * @param dates     数据日期(yyyy-MM-dd)
     * @param unitTypes 单元类型编号(单元类型为空查询企业所有类型单元)
     * @param indexes   指标编码
     * @return
     */
    @Override
    public List<DaUnitDayMostData> queryUnitDayMostDataByCons(String consNo, LocalDate[] dates, UnitType[] unitTypes, Index[] indexes) {
        List<DaUnitDayMostData> daUnitDayMostData = daUnitDataDao.queryUnitDayMostData(null, consNo, unitTypes, dates, indexes);
        return daUnitDayMostData;
    }

    /**
     * 获取企业单元日用量数据
     *
     * @param consNo     企业编号
     * @param dataMonths 数据日期(YYYY-MM-dd)
     * @param unitTypes  单元类型编号(单元类型为空查询企业所有类型单元)
     * @param indexes    指标编码
     * @return
     */
    @Override
    public List<DaUnitDayDosageData> queryUnitDayDosageDataByCons(String consNo, LocalDate[] dataMonths, UnitType[] unitTypes, Index[] indexes) {
        List<DaUnitDayDosageData> daUnitDayDosageData = daUnitDataDao.queryUnitDayDosageData(null, consNo, unitTypes, dataMonths, indexes);
        return daUnitDayDosageData;
    }

    /**
     * 获取企业单元月数据
     *
     * @param consNo     单元标识
     * @param dataMonths 数据日期(yyyy-MM)
     * @param unitTypes  单元类型编号(单元类型为空查询企业所有类型单元)
     * @param indexes    指标编码
     * @return
     */
    @Override
    public List<DaUnitMonthData> queryUnitMonthDataByCons(String consNo, String[] dataMonths, UnitType[] unitTypes, Index[] indexes) {
        List<DaUnitMonthData> daUnitMonthData = daUnitDataDao.queryUnitMonthData(null, consNo, unitTypes, dataMonths, indexes);
        return daUnitMonthData;
    }

    /**
     * 获取企业单元月用量数据
     *
     * @param consNo     单元标识
     * @param dataMonths 数据日期(yyyy-MM)
     * @param unitTypes  单元类型编号(单元类型为空查询企业所有类型单元)
     * @param indexes    指标编码
     * @return
     */
    @Override
    public List<DaUnitMonthDosageData> queryUnitMonthDosageDataByCons(String consNo, String[] dataMonths, UnitType[] unitTypes, Index[] indexes) {
        List<DaUnitMonthDosageData> daUnitMonthDosageData = daUnitDataDao.queryUnitMonthDosageData(null, consNo, unitTypes, dataMonths, indexes);
        return daUnitMonthDosageData;
    }
}
