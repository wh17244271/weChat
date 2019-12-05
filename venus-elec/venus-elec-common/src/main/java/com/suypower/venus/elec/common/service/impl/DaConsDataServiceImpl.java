package com.suypower.venus.elec.common.service.impl;

import com.suypower.venus.elec.common.common.Index;
import com.suypower.venus.elec.common.dao.DaConsDataDao;
import com.suypower.venus.elec.common.entity.*;
import com.suypower.venus.elec.common.query.DaConsQuery;
import com.suypower.venus.elec.common.service.IDaConsDataService;
import com.suypower.venus.elec.common.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service( "daConsDataService" )
public class DaConsDataServiceImpl implements IDaConsDataService {

    @Autowired
    private DaConsDataDao daConsDataDao;

    /**
     * 获取企业日数据
     *
     * @param daConsQuery 参数实体
     * @return
     */
    @Override
    public List<DaConsDayData> queryConsDayData(DaConsQuery daConsQuery) {
        //给indexes分组 是否含有有功
        Map<String, Set<Index>> stringListMap = IndexMappingConsTables.parseIndex(daConsQuery.getIndexes());

        List<Map<String, Object>> list = daConsDataDao.queryConsDayData(daConsQuery, stringListMap);
        //将表中所有字段的数据封装到 DaConsDayData 实体类中
        List<DaConsDayData> daConsDayData = MapToDataEntityUtils.mapToDaConsDayData(list, daConsQuery.getPointCount());
        return daConsDayData;
    }

    /**
     * 按月获取企业日数据
     *
     * @param daConsQuery
     * @return
     */
    @Override
    public List<DaConsDayData> queryConsDayDataByMonth(DaConsQuery daConsQuery) {

        //给indexes分组 是否含有有功
        Map<String, Set<Index>> stringListMap = IndexMappingConsTables.parseIndex(daConsQuery.getIndexes());


        List<Map<String, Object>> list = daConsDataDao.queryConsDayData(daConsQuery, stringListMap);

        List<DaConsDayData> daConsDayData = MapToDataEntityUtils.mapToDaConsDayData(list, daConsQuery.getPointCount());
        return daConsDayData;
    }

    /**
     * 获取企业日最值数据
     *
     * @return
     */
    @Override
    public List<DaConsDayMostData> queryConsDayMostData(DaConsQuery daConsQuery) {
        //给indexes分组 是否含有有功
        Map<String, Set<Index>> stringListMap = IndexMappingConsTables.parseIndex(daConsQuery.getIndexes());
        List<DaConsDayMostData> data = daConsDataDao.queryConsMostData(daConsQuery, stringListMap);

        return data;
    }

    /**
     * 按月获取企业日最值数据
     *
     * @return
     */
    @Override
    public List<DaConsDayMostData> queryConsDayMostDataByMonth(DaConsQuery daConsQuery) {
        Map<String, Set<Index>> stringListMap = IndexMappingConsTables.parseIndex(daConsQuery.getIndexes());
        List<DaConsDayMostData> daConsDayMostData = daConsDataDao.queryConsMostData(daConsQuery, stringListMap);
        return daConsDayMostData;
    }


    /**
     * 获取企业月数据
     *
     * @return
     */
    @Override
    public List<DaConsMonthData> queryConsMonthData(DaConsQuery daConsQuery) {
        List<DaConsMonthData> daConsMonthData = daConsDataDao.queryConsMonthData(daConsQuery);
        return daConsMonthData;
    }

    /**
     * 按年获取企业月数据
     *
     * @return
     */
    @Override
    public List<DaConsMonthData> queryConsMonthDataByYear(DaConsQuery daConsQuery) {
        List<DaConsMonthData> daConsMonthData = daConsDataDao.queryConsMonthData(daConsQuery);
        return daConsMonthData;
    }

    /**
     * 获取企业日用量数据
     *
     * @return
     */
    @Override
    public List<DaConsDayDosageData> queryConsDayDosageData(DaConsQuery daConsQuery) {
        List<DaConsDayDosageData> daConsDayDosageData = daConsDataDao.queryConsDayDosageData(daConsQuery);
        return daConsDayDosageData;
    }

    /**
     * 按月获取企业日用量数据
     *
     * @return
     */
    @Override
    public List<DaConsDayDosageData> queryConsDayDosageDataByMonth(DaConsQuery daConsQuery) {
        List<DaConsDayDosageData> daConsDayDosageData = daConsDataDao.queryConsDayDosageData(daConsQuery);
        return daConsDayDosageData;
    }


    /**
     * 获取企业月用量数据
     *
     * @return
     */
    @Override
    public List<DaConsMonthDosageData> queryConsMonthDosageData(DaConsQuery daConsQuery) {
        List<DaConsMonthDosageData> daConsMonthData = daConsDataDao.queryConsMonthDosageData(daConsQuery);
        return daConsMonthData;
    }


    /**
     * 按年获取企业月用量数据
     *
     * @return
     */
    @Override
    public List<DaConsMonthDosageData> queryConsMonthDosageDataByYear(DaConsQuery daConsQuery) {
        List<DaConsMonthDosageData> daConsMonthDosageData = daConsDataDao.queryConsMonthDosageData(daConsQuery);
        return daConsMonthDosageData;
    }

    /**
     * 获取统计企业用量数据(当日、当月、当年、上日、上月、上年)
     *
     * @return
     */
    @Override
    public DaConsTotalDosageData queryConsTotalDosageData(DaConsQuery daConsQuery) {
        DaConsTotalDosageData result = new DaConsTotalDosageData();
        //处理日
        LocalDate selfDataDate = daConsQuery.getDataDates()[0];
        LocalDate prevDataDate = selfDataDate.minusDays(1);
        daConsQuery.setDataMonths(null);
        daConsQuery.setDataYears(null);
        daConsQuery.setDataDates(new LocalDate[]{selfDataDate, prevDataDate});
        //获取指定日期和前一天
        List<DaConsDayDosageData> theDayAndPrevDay = daConsDataDao.queryConsDayDosageData(daConsQuery);
        for (DaConsDayDosageData inData : theDayAndPrevDay) {
            LocalDate dataDate = inData.getDataDate();
            if (null == dataDate) {
                dataDate = inData.getDate();
            }
            Double tip = inData.getTip();
            Double peak = inData.getPeak();
            Double flat = inData.getFlat();
            Double valley = inData.getValley();
            Double total = inData.getTotal();
            //判断是今日还是昨日
            if (selfDataDate.isEqual(dataDate)) {
                result.setOrgName(inData.getOrgName());
                result.setOrgNo(inData.getOrgNo());
                result.setConsName(inData.getConsName());
                result.setConsNo(inData.getConsNo());
                result.setIndex(inData.getIndex());
                result.setUnitType(inData.getUnitType());

                result.setSelfDataDate(dataDate);
                result.setSelfDateTip(tip);
                result.setSelfDatePeak(peak);
                result.setSelfDateFlat(flat);
                result.setSelfDateValley(valley);
                result.setSelfDateTotal(total);
            } else if (prevDataDate.isEqual(dataDate)) {
                result.setPrevDataDate(dataDate);
                result.setPrevDateTip(tip);
                result.setPrevDatePeak(peak);
                result.setPrevDateFlat(flat);
                result.setPrevDateValley(valley);
                result.setPrevDateTotal(total);
            }

        }
        //处理月
        String selfMonth = Times.parse(selfDataDate, TimeConstant.SelfMonth);
        String prevMonth = Times.parse(prevDataDate, TimeConstant.PrevMonth);
        daConsQuery.setDataYears(null);
        daConsQuery.setDataDates(null);
        daConsQuery.setDataMonths(new String[]{selfMonth, prevMonth});
        List<DaConsMonthDosageData> selfMonthAndprevMonthDataList = daConsDataDao.queryConsMonthDosageData(daConsQuery);
        for(DaConsMonthDosageData inData:selfMonthAndprevMonthDataList){
            String dataMonth = inData.getDataMonth();
            if(StringUtils.isEmpty(dataMonth)){
                dataMonth = inData.getMonth();
            }
            Double tip = inData.getTip();
            Double peak = inData.getPeak();
            Double flat = inData.getFlat();
            Double valley = inData.getValley();
            Double total = inData.getTotal();

            if(selfMonth.equals(dataMonth)){
                result.setSelfDataMonth(selfMonth);
                result.setSelfMonthTip(tip);
                result.setSelfMonthPeak(peak);
                result.setSelfMonthFlat(flat);
                result.setSelfMonthValley(valley);
                result.setSelfMonthTotal(total);
            }else if(prevMonth.equals(dataMonth)){
                result.setPrevDataMonth(prevMonth);
                result.setPrevMonthTip(tip);
                result.setPrevMonthPeak(peak);
                result.setPrevMonthFlat(flat);
                result.setPrevMonthValley(valley);
                result.setPrevMonthTotal(total);
            }
        }
        //处理年
        String SelfYear = Times.parse(selfDataDate, TimeConstant.SelfYear);
        String PrevYear = Times.parse(prevDataDate, TimeConstant.PrevYear);
        daConsQuery.setDataDates(null);
        daConsQuery.setDataMonths(null);
        daConsQuery.setDataYears(new String[]{SelfYear, PrevYear});
        List<DaConsMonthDosageData> SelfYearAndPrevYearDataList = daConsDataDao.queryConsYearDosageData(daConsQuery);
        for(DaConsMonthDosageData inData:SelfYearAndPrevYearDataList){
            String year = inData.getYear();
            Double tip = inData.getTip();
            Double peak = inData.getPeak();
            Double flat = inData.getFlat();
            Double valley = inData.getValley();
            Double total = inData.getTotal();
            if(SelfYear.equals(year)){
                result.setSelfDataYear(SelfYear);
                result.setSelfYearTip(tip);
                result.setSelfYearPeak(peak);
                result.setSelfYearFlat(flat);
                result.setSelfYearValley(valley);
                result.setSelfYearTotal(total);
            }else if(PrevYear.equals(year)){
                result.setPrevDataYear(PrevYear);
                result.setPrevYearTip(tip);
                result.setPrevYearPeak(peak);
                result.setPrevYearFlat(flat);
                result.setPrevYearValley(valley);
                result.setPrevYearTotal(total);
            }
        }

        return result;

    }


}
