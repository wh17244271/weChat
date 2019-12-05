package com.suypower.venus.elec.common.service.impl;

import com.suypower.venus.elec.common.common.Index;
import com.suypower.venus.elec.common.dao.DaMpDataDao;
import com.suypower.venus.elec.common.entity.*;
import com.suypower.venus.elec.common.query.DaMpQuery;
import com.suypower.venus.elec.common.service.IDaMpDataService;
import com.suypower.venus.elec.common.utils.IndexMappingMpTables;
import com.suypower.venus.elec.common.utils.MapToDataEntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service( "daMpDataService" )
public class DaMpDataServiceImpl implements IDaMpDataService {

    @Autowired
    private DaMpDataDao daMpDataDao;

    /**
     * 获取单个测点日数据
     *
     * @return
     */
    @Override
    public List<DaMpDayData> queryMpDayData(DaMpQuery daMpQuery) {
        String pointCount = daMpQuery.getPointCount();
        Map<String, Set<Index>> stringSetMap = IndexMappingMpTables.parseIndex(daMpQuery.getIndexes());
        long l = System.currentTimeMillis();
        List<Map<String, Object>> list = daMpDataDao.queryMpDayData(daMpQuery,stringSetMap);
        System.err.println(System.currentTimeMillis()-l);
        List<DaMpDayData> daMpDayData = MapToDataEntityUtils.mapToDaMpDayData(list, pointCount);
        return daMpDayData;
    }

    /**
     * 获取单个测点日最值数据
     *
     * @return
     */
    @Override
    public List<DaMpDayMostData> queryMpDayMostData(DaMpQuery daMpQuery) {
        Map<String, Set<Index>> stringSetMap = IndexMappingMpTables.parseIndex(daMpQuery.getIndexes());
        List<DaMpDayMostData> daMpDayMostData = daMpDataDao.queryMpDayMostData(daMpQuery,stringSetMap);
        return daMpDayMostData;
    }

    /**
     * 获取单个测点日抄表示数数据
     */
    @Override
    public List<DaMpDayReadingsData> queryMpDayReadingsData(DaMpQuery daMpQuery) {
        List<DaMpDayReadingsData> daMpDayReadingsData = daMpDataDao.queryMpDayReadingsData(daMpQuery);
        return daMpDayReadingsData;
    }

    /**
     * 获取单个测点日用量数据
     *
     * @return
     */
    @Override
    public List<DaMpDayDosageData> queryMpDayDosageData(DaMpQuery daMpQuery) {
        List<DaMpDayDosageData> daMpDayDosageData = daMpDataDao.queryMpDayDosageData(daMpQuery);
        return daMpDayDosageData;
    }

    /**
     * 获取单个测点月数据
     *
     * @return
     */
    @Override
    public List<DaMpMonthData> queryMpMonthData(DaMpQuery daMpQuery) {
        List<DaMpMonthData> daMpMonthData = daMpDataDao.queryMpMonthData(daMpQuery);
        return daMpMonthData;
    }

    /**
     * 获取单个测点月抄表示数数据
     *
     * @return
     */
    @Override
    public List<DaMpMonthReadingsData> queryMpMonthReadingsData(DaMpQuery daMpQuery) {
        List<DaMpMonthReadingsData> daMpMonthReadingsData = daMpDataDao.queryMpMonthReadingsData(daMpQuery);
        return daMpMonthReadingsData;
    }

    /**
     * 获取单个测点月用量数据
     *
     * @return
     */
    @Override
    public List<DaMpMonthDosageData> queryMpMonthDosageData(DaMpQuery daMpQuery) {
        List<DaMpMonthDosageData> daMpMonthDosageData = daMpDataDao.queryMpMonthDosageData(daMpQuery);
        return daMpMonthDosageData;
    }

    /**
     * 获取企业全部测点日数据
     *
     * @return
     */
    @Override
    public List<DaMpDayData> queryMpDayDataByCons(DaMpQuery daMpQuery) {
        Map<String, Set<Index>> stringSetMap = IndexMappingMpTables.parseIndex(daMpQuery.getIndexes());
        List<Map<String, Object>> list = daMpDataDao.queryMpDayData(daMpQuery,stringSetMap);
        List<DaMpDayData> daMpDayData = MapToDataEntityUtils.mapToDaMpDayData(list, daMpQuery.getPointCount());
        return daMpDayData;
    }

    /**
     * 取企业全部测点日最值数据
     *
     * @return
     */
    @Override
    public List<DaMpDayMostData> queryMpDayMostDataByCons(DaMpQuery daMpQuery) {
        Map<String, Set<Index>> stringSetMap = IndexMappingMpTables.parseIndex(daMpQuery.getIndexes());
        List<DaMpDayMostData> daMpDayMostData = daMpDataDao.queryMpDayMostData(daMpQuery,stringSetMap);
        return daMpDayMostData;
    }

    /**
     * 获取企业全部测点日抄表示数数据
     *
     * @return
     */
    @Override
    public List<DaMpDayReadingsData> queryMpDayReadingsDataByCons(DaMpQuery daMpQuery) {
        List<DaMpDayReadingsData> daMpDayReadingsData = daMpDataDao.queryMpDayReadingsData(daMpQuery);
        return daMpDayReadingsData;
    }

    /**
     * 获取企业全部测点日用量数据
     *
     * @return
     */
    @Override
    public List<DaMpDayDosageData> queryMpDayDosageDataByCons(DaMpQuery daMpQuery) {
        List<DaMpDayDosageData> daMpDayDosageData = daMpDataDao.queryMpDayDosageData(daMpQuery);
        return daMpDayDosageData;
    }

    /**
     * 获取企业全部测点月数据
     *
     * @return
     */
    @Override
    public List<DaMpMonthData> queryMpMonthDataByCons(DaMpQuery daMpQuery) {
        List<DaMpMonthData> daMpMonthData = daMpDataDao.queryMpMonthData(daMpQuery);
        return daMpMonthData;
    }

    /**
     * 获取企业全部测点月抄表示数数据
     *
     * @return
     */
    @Override
    public List<DaMpMonthReadingsData> queryMpMonthReadingsDataByCons(DaMpQuery daMpQuery) {
        List<DaMpMonthReadingsData> daMpMonthReadingsData = daMpDataDao.queryMpMonthReadingsData(daMpQuery);
        return daMpMonthReadingsData;
    }

    /**
     * 获取企业全部测点月用量数据
     *
     * @return
     */
    @Override
    public List<DaMpMonthDosageData> queryMpMonthDosageDataByCons(DaMpQuery daMpQuery) {
        List<DaMpMonthDosageData> daMpMonthDosageData = daMpDataDao.queryMpMonthDosageData(daMpQuery);
        return daMpMonthDosageData;
    }

    /**
     * 获取单元全部测点日数据
     *
     * @return
     */
    @Override
    public List<DaMpDayData> queryMpDayDataByUnit(DaMpQuery daMpQuery) {
        Map<String, Set<Index>> stringSetMap = IndexMappingMpTables.parseIndex(daMpQuery.getIndexes());
        List<Map<String, Object>> maps = daMpDataDao.queryMpDayData(daMpQuery,stringSetMap);
        List<DaMpDayData> daMpDayData = MapToDataEntityUtils.mapToDaMpDayData(maps, null);
        return daMpDayData;
    }

    /**
     * 获取单元全部测点日最值数据
     *
     * @return
     */
    @Override
    public List<DaMpDayMostData> queryMpDayMostDataByUnit(DaMpQuery daMpQuery) {
        Map<String, Set<Index>> stringSetMap = IndexMappingMpTables.parseIndex(daMpQuery.getIndexes());
        List<DaMpDayMostData> daMpDayMostData = daMpDataDao.queryMpDayMostData(daMpQuery,stringSetMap);
        return daMpDayMostData;
    }

    /**
     * 获取单元全部测点日抄表示数数据
     *
     * @return
     */
    @Override
    public List<DaMpDayReadingsData> queryMpDayReadingsDataByUnit(DaMpQuery daMpQuery) {
        List<DaMpDayReadingsData> daMpDayReadingsData = daMpDataDao.queryMpDayReadingsData(daMpQuery);
        return daMpDayReadingsData;
    }

    /**
     * 获取单元全部测点日用量数据
     *
     * @return
     */
    @Override
    public List<DaMpDayDosageData> queryMpDayDosageDataByUnit(DaMpQuery daMpQuery) {
        List<DaMpDayDosageData> daMpDayDosageData = daMpDataDao.queryMpDayDosageData(daMpQuery);
        return daMpDayDosageData;
    }

    /**
     * 获取单元全部测点月数据
     *
     * @return
     */
    @Override
    public List<DaMpMonthData> queryMpMonthDataByUnit(DaMpQuery daMpQuery) {
        List<DaMpMonthData> daMpMonthData = daMpDataDao.queryMpMonthData(daMpQuery);
        return daMpMonthData;
    }

    /**
     * 获取单元全部测点月抄表示数数据
     *
     * @return
     */
    @Override
    public List<DaMpMonthReadingsData> queryMpMonthReadingsDataByUnit(DaMpQuery daMpQuery) {
        List<DaMpMonthReadingsData> daMpMonthReadingsData = daMpDataDao.queryMpMonthReadingsData(daMpQuery);
        return daMpMonthReadingsData;
    }

    /**
     * 获取单元全部测点月用量数据
     *
     * @return
     */
    @Override
    public List<DaMpMonthDosageData> queryMpMonthDosageDataByUnit(DaMpQuery daMpQuery) {
        List<DaMpMonthDosageData> daMpMonthDosageData = daMpDataDao.queryMpMonthDosageData(daMpQuery);
        return daMpMonthDosageData;
    }
}
