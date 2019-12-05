package com.suypower.venus.elec.common.service.impl;

import com.suypower.venus.elec.common.common.TimeType;
import com.suypower.venus.elec.common.dao.DaConsDataDao;
import com.suypower.venus.elec.common.entity.*;
import com.suypower.venus.elec.common.query.DaConsQuery;
import com.suypower.venus.elec.common.service.IDaConsAdvDataService;
import com.suypower.venus.elec.common.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service( "daConsAdvDataService" )
public class DaConsAdvDataServiceImpl implements IDaConsAdvDataService {
    final int MAXDIGITS = 1;
    @Autowired
    private DaConsDataDao daConsDataDao;

    /**
     * 获取企业日用量数据(含同比、环比、月份每天用量数据集合)
     *
     * @return
     */
    @Override
    public List<DaConsDayDosageMonthData> queryConsDayDosageMonthDataa(DaConsQuery daConsQuery) {
        String timeType = daConsQuery.getTimeType();
        List<DaConsDayDosageMonthData> resultList = new ArrayList<>();
        String fill = daConsQuery.getFill();
        //todo 只补 单条 item，其他暂时不考虑
        if (!StringUtils.isEmpty(fill)) {
            daConsQuery.setFill(null);
        }
        if (StringUtils.isEmpty(timeType) || TimeType.Day.getTimeTypeNo().equals(timeType)) {
            List<DaConsDayDosageData> dayList = daConsDataDao.queryConsDayDosageData(daConsQuery); //正常查询日期的数据
            LocalDate[] dataDates = daConsQuery.getDataDates();
            daConsQuery.setDataDates(Times.parseYearOnYearOrRatio(dataDates));
            String[] months = new String[dataDates.length];
            List<DaConsDayDosageData> yearOnYearOrRatioData = daConsDataDao.queryConsDayDosageData(daConsQuery);//同比环比后的数据
            for (int i = 0; i < dataDates.length; i++) {
                months[i] = Times.parse(dataDates[i], TimeConstant.SelfMonth);
            }
            daConsQuery.setDataMonths(months);
            daConsQuery.setDataDates(null);
            if (!StringUtils.isEmpty(fill)) {
                daConsQuery.setFill("true");
            }
            List<DaConsDayDosageData> theSameMonth = daConsDataDao.queryConsDayDosageData(daConsQuery);//查找相同月份的数据

            resultList = assembleList(resultList, dayList, yearOnYearOrRatioData, theSameMonth);

        } else if (TimeType.Month.getTimeTypeNo().equals(timeType)) {

            List<DaConsDayDosageData> dayList = daConsDataDao.queryConsDayDosageData(daConsQuery); //正常查询日期的数据
            String[] dataMonths = daConsQuery.getDataMonths();
            daConsQuery.setDataMonths(Times.parseYearOnYearOrRatio(dataMonths));
            List<DaConsDayDosageData> yearOnYearOrRatioData = daConsDataDao.queryConsDayDosageData(daConsQuery);//同比环比后的数据

            resultList = assembleList(resultList, dayList, yearOnYearOrRatioData, dayList);
        }


        return resultList;
    }


    /**
     * 获取企业日用量数据(含同比、环比)
     *
     * @param daConsQuery
     * @return
     */
    @Override
    public List<DaConsDayDosageMonthData> queryConsDayDosageDataa(DaConsQuery daConsQuery) {
        String timeType = daConsQuery.getTimeType();
        List<DaConsDayDosageMonthData> resultList = new ArrayList<>();
        if (StringUtils.isEmpty(timeType) || TimeType.Day.getTimeTypeNo().equals(timeType)) {
            List<DaConsDayDosageData> dayList = daConsDataDao.queryConsDayDosageData(daConsQuery); //正常查询日期的数据
            LocalDate[] dataDates = daConsQuery.getDataDates();
            daConsQuery.setDataDates(Times.parseYearOnYearOrRatio(dataDates));
            List<DaConsDayDosageData> yearOnYearOrRatioData = daConsDataDao.queryConsDayDosageData(daConsQuery);//同比环比后的数据
            resultList = assembleList(resultList, dayList, yearOnYearOrRatioData, null);
        } else if (TimeType.Month.getTimeTypeNo().equals(timeType)) {
            List<DaConsDayDosageData> dayList = daConsDataDao.queryConsDayDosageData(daConsQuery); //正常查询日期的数据
            String[] dataMonths = daConsQuery.getDataMonths();
            daConsQuery.setDataMonths(Times.parseYearOnYearOrRatio(dataMonths));
            List<DaConsDayDosageData> yearOnYearOrRatioData = daConsDataDao.queryConsDayDosageData(daConsQuery);//同比环比后的数据
            resultList = assembleList(resultList, dayList, yearOnYearOrRatioData, null);
        }


        return resultList;
    }


    /**
     * 获取企业月用量数据(含同比、环比)
     *
     * @param daConsQuery
     * @return
     */
    @Override
    public List<DaConsMonthDosageYearData> queryConsMonthDosageDataa(DaConsQuery daConsQuery) {
        List<DaConsMonthDosageYearData> result = null;
        String timeType = daConsQuery.getTimeType();
        if (StringUtils.isEmpty(timeType) || TimeType.Month.getTimeTypeNo().equals(timeType)) {
            List<DaConsMonthDosageData> theMonthList = daConsDataDao.queryConsMonthDosageData(daConsQuery);//查询正常日期的值
            String[] dataMonths = daConsQuery.getDataMonths();
            daConsQuery.setDataMonths(Times.parseYearOnYearOrRatio(dataMonths));
            List<DaConsMonthDosageData> lastMonthOrLastYearMonthList = daConsDataDao.queryConsMonthDosageData(daConsQuery);//同比环比后的数据

            result = assembleMonthList(theMonthList, lastMonthOrLastYearMonthList, null);
        }
        return result;
    }

    /**
     * 获取企业年用量数据(含环比)
     *
     * @param daConsQuery
     * @return
     */
    @Override
    public List<DaConsYearDosageData> queryConsYearDosageDataa(DaConsQuery daConsQuery) {
        List<DaConsYearDosageData> result = new ArrayList<>();
        String timeType = daConsQuery.getTimeType();
        if (StringUtils.isEmpty(timeType) || TimeType.Year.getTimeTypeNo().equals(timeType)) {
            String[] dataYears = daConsQuery.getDataYears();
            List<DaConsMonthDosageData> theYearDataList = daConsDataDao.queryConsYearDosageData(daConsQuery);
            daConsQuery.setDataYears(Times.parseYearRatio(dataYears));
            List<DaConsMonthDosageData> lastYearDataList = daConsDataDao.queryConsYearDosageData(daConsQuery);
            result= assembleYearList(theYearDataList, lastYearDataList);
        }

        return result;
    }

    /**
     * 拼装数据集合（年)
     *
     * @param theYearDataList  用户需要查询的数据集合
     * @param lastYearDataList 查询环比后的数据集合（需要拼装的数据）
     */
    private List<DaConsYearDosageData> assembleYearList(List<DaConsMonthDosageData> theYearDataList,
                                                        List<DaConsMonthDosageData> lastYearDataList) {
        List<DaConsYearDosageData> result = new ArrayList<>();
        DaConsYearDosageData needEntiyData;
        for (DaConsMonthDosageData theYearData : theYearDataList) {
            needEntiyData = new DaConsYearDosageData();
            String indBNo = theYearData.getIndBNo();
            String consNo = theYearData.getConsNo();
            String unitTypeNo = theYearData.getUnitTypeNo();
            String year = theYearData.getYear();
            String lastYear = "";
            if (!StringUtils.isEmpty(year)) {
                lastYear = Times.parseYearRatio(new String[]{year})[0];
            }

            for (DaConsMonthDosageData dayDataIn : lastYearDataList) {
                if (dayDataIn.getConsNo().equals(consNo) && dayDataIn.getIndBNo().equals(indBNo)
                        && dayDataIn.getUnitTypeNo().equals(unitTypeNo)) {
                    if(lastYear.equals(dayDataIn.getYear())){
                        needEntiyData.setYoyYear(lastYear);
                        needEntiyData.setYoyTip(dayDataIn.getTip());
                        needEntiyData.setYoyPeak(dayDataIn.getPeak());
                        needEntiyData.setYoyFlat(dayDataIn.getFlat());
                        needEntiyData.setYoyValley(dayDataIn.getValley());
                        needEntiyData.setYoyTotal(dayDataIn.getTotal());
                        needEntiyData.setYoyTipRatio(Maths.yearOnYearOrRatio(theYearData.getTip(), dayDataIn.getTip(), MAXDIGITS));
                        needEntiyData.setYoyPeakRatio(Maths.yearOnYearOrRatio(theYearData.getPeak(), dayDataIn.getPeak(), MAXDIGITS));
                        needEntiyData.setYoyFlatRatio(Maths.yearOnYearOrRatio(theYearData.getFlat(), dayDataIn.getFlat(), MAXDIGITS));
                        needEntiyData.setYoyValleyRatio(Maths.yearOnYearOrRatio(theYearData.getValley(), dayDataIn.getValley(), MAXDIGITS));
                        needEntiyData.setYoyTotalRatio(Maths.yearOnYearOrRatio(theYearData.getTotal(), dayDataIn.getTotal(), MAXDIGITS));
                    }

                }

            }
            needEntiyData.setOrgNo(theYearData.getOrgNo());
            needEntiyData.setOrgName(theYearData.getOrgName());
            needEntiyData.setConsName(theYearData.getConsName());
            needEntiyData.setConsNo(theYearData.getConsNo());
            needEntiyData.setUnitType(theYearData.getUnitType());
            needEntiyData.setIndex(theYearData.getIndex());
            needEntiyData.setYear(year);
            needEntiyData.setTip(theYearData.getTip());
            needEntiyData.setPeak(theYearData.getPeak());
            needEntiyData.setFlat(theYearData.getFlat());
            needEntiyData.setValley(theYearData.getValley());
            needEntiyData.setTotal(theYearData.getTotal());

            result.add(needEntiyData);
        }
        return result;

    }


    /**
     * 拼装数据集合（月)
     *
     * @param theMonthList                 用户需要查询的数据集合
     * @param lastMonthOrLastYearMonthList 查询同比环比后的数据集合（需要拼装的数据）
     * @param theSameYearMonth             查找相同月份的数据
     */
    private List<DaConsMonthDosageYearData> assembleMonthList(List<DaConsMonthDosageData> theMonthList,
                                                              List<DaConsMonthDosageData> lastMonthOrLastYearMonthList,
                                                              List<DaConsMonthDosageData> theSameYearMonth) {
        List<DaConsMonthDosageYearData> resultList = new ArrayList<>();
        DaConsMonthDosageYearData daConsMonthDosageMonthData;
        List<DaConsMonthDosageData> items = null;
        for (DaConsMonthDosageData monthData : theMonthList) {
            daConsMonthDosageMonthData = new DaConsMonthDosageYearData();
            String indBNo = monthData.getIndBNo();
            String consNo = monthData.getConsNo();
            String unitTypeNo = monthData.getUnitTypeNo();

            String dataMonth = monthData.getDataMonth();
            if (StringUtils.isEmpty(dataMonth)) {
                dataMonth = monthData.getMonth();
            }

            LocalDate parse = LocalDate.parse(dataMonth + "-01", Times.defaultDateFormatter);
            String lastMonth = parse.minusMonths(1).format(Times.defaultMonthFormatter);
            String lastYearMonth = parse.minusYears(1).format(Times.defaultMonthFormatter);


            //补充item
            items = new ArrayList<>();
            if (!StringUtils.isEmpty(theSameYearMonth)) {
                for (DaConsMonthDosageData MonthDataIn : theSameYearMonth) {
                    if (MonthDataIn.getConsNo().equals(consNo) && MonthDataIn.getIndBNo().equals(indBNo) && MonthDataIn.getUnitTypeNo().equals(unitTypeNo)) {
                        //取值同一个月
                        if (MonthDataIn.getMonth().equals(dataMonth)) {
                            items.add(MonthDataIn);
                        }
                    }
                }
            }


            for (DaConsMonthDosageData dayDataIn : lastMonthOrLastYearMonthList) {
                if (dayDataIn.getConsNo().equals(consNo) && dayDataIn.getIndBNo().equals(indBNo) && dayDataIn.getUnitTypeNo().equals(unitTypeNo)) {
                    //取上个月同一天
                    String monthIn = dayDataIn.getDataMonth();
                    if (StringUtils.isEmpty(monthIn)) {
                        monthIn = dayDataIn.getMonth();
                    }
                    if (lastMonth.equals(monthIn)) {

                        daConsMonthDosageMonthData.setMomDataMonth(monthIn);
                        daConsMonthDosageMonthData.setMomTip(dayDataIn.getTip());
                        daConsMonthDosageMonthData.setMomPeak(dayDataIn.getPeak());
                        daConsMonthDosageMonthData.setMomFlat(dayDataIn.getFlat());
                        daConsMonthDosageMonthData.setMomValley(dayDataIn.getValley());
                        daConsMonthDosageMonthData.setMomTotal(dayDataIn.getTotal());
                        daConsMonthDosageMonthData.setMomTipRatio(Maths.yearOnYearOrRatio(monthData.getTip(), dayDataIn.getTip(), MAXDIGITS));
                        daConsMonthDosageMonthData.setMomPeakRatio(Maths.yearOnYearOrRatio(monthData.getPeak(), dayDataIn.getPeak(), MAXDIGITS));
                        daConsMonthDosageMonthData.setMomFlatRatio(Maths.yearOnYearOrRatio(monthData.getFlat(), dayDataIn.getFlat(), MAXDIGITS));
                        daConsMonthDosageMonthData.setMomValleyRatio(Maths.yearOnYearOrRatio(monthData.getValley(), dayDataIn.getValley(), MAXDIGITS));
                        daConsMonthDosageMonthData.setMomTotalRatio(Maths.yearOnYearOrRatio(monthData.getTotal(), dayDataIn.getTotal(), MAXDIGITS));
                    }
                    //取去年同一天
                    else if (lastYearMonth.equals(monthIn)) {
                        daConsMonthDosageMonthData.setYoyDataMonth(monthIn);
                        daConsMonthDosageMonthData.setYoyTip(dayDataIn.getTip());
                        daConsMonthDosageMonthData.setYoyPeak(dayDataIn.getPeak());
                        daConsMonthDosageMonthData.setYoyFlat(dayDataIn.getFlat());
                        daConsMonthDosageMonthData.setYoyValley(dayDataIn.getValley());
                        daConsMonthDosageMonthData.setYoyTotal(dayDataIn.getTotal());
                        daConsMonthDosageMonthData.setYoyTipRatio(Maths.yearOnYearOrRatio(monthData.getTip(), dayDataIn.getTip(), MAXDIGITS));
                        daConsMonthDosageMonthData.setYoyPeakRatio(Maths.yearOnYearOrRatio(monthData.getPeak(), dayDataIn.getPeak(), MAXDIGITS));
                        daConsMonthDosageMonthData.setYoyFlatRatio(Maths.yearOnYearOrRatio(monthData.getFlat(), dayDataIn.getFlat(), MAXDIGITS));
                        daConsMonthDosageMonthData.setYoyValleyRatio(Maths.yearOnYearOrRatio(monthData.getValley(), dayDataIn.getValley(), MAXDIGITS));
                        daConsMonthDosageMonthData.setYoyTotalRatio(Maths.yearOnYearOrRatio(monthData.getTotal(), dayDataIn.getTotal(), MAXDIGITS));
                    }

                }

            }
            daConsMonthDosageMonthData.setOrgNo(monthData.getOrgNo());
            daConsMonthDosageMonthData.setOrgName(monthData.getOrgName());
            daConsMonthDosageMonthData.setConsName(monthData.getConsName());
            daConsMonthDosageMonthData.setConsNo(monthData.getConsNo());
            daConsMonthDosageMonthData.setUnitType(monthData.getUnitType());
            daConsMonthDosageMonthData.setIndex(monthData.getIndex());
            daConsMonthDosageMonthData.setMonth(dataMonth);
            daConsMonthDosageMonthData.setDataMonth(dataMonth);
            daConsMonthDosageMonthData.setTip(monthData.getTip());
            daConsMonthDosageMonthData.setPeak(monthData.getPeak());
            daConsMonthDosageMonthData.setFlat(monthData.getFlat());
            daConsMonthDosageMonthData.setValley(monthData.getValley());
            daConsMonthDosageMonthData.setTotal(monthData.getTotal());


            daConsMonthDosageMonthData.setItems(items);
            resultList.add(daConsMonthDosageMonthData);
        }
        return resultList;
    }

    /**
     * 拼装数据集合(日)
     *
     * @param resultList            拼装好的数据结构 集合
     * @param dayList               用户需要查询的数据集合
     * @param yearOnYearOrRatioData 查询同比环比后的数据集合（需要拼装的数据）
     * @param theSameMonth          查找相同月份的数据
     */
    private List<DaConsDayDosageMonthData> assembleList(List<DaConsDayDosageMonthData> resultList,
                                                        List<DaConsDayDosageData> dayList, List<DaConsDayDosageData> yearOnYearOrRatioData, List<DaConsDayDosageData> theSameMonth) {
        DaConsDayDosageMonthData daConsDayDosageMonthData;
        List<DaConsDayDosageData> items = null;
        for (DaConsDayDosageData dayData : dayList) {
            daConsDayDosageMonthData = new DaConsDayDosageMonthData();
            String indBNo = dayData.getIndBNo();
            String consNo = dayData.getConsNo();
            String unitTypeNo = dayData.getUnitTypeNo();
            LocalDate dataDate = dayData.getDataDate();
            LocalDate lastMonthDataDate = dataDate.minusMonths(1);
            LocalDate lastYearDataDate = dataDate.minusYears(1);
            String month1 = dayData.getMonth();


            //补充item
            items = new ArrayList<>();
            if (!StringUtils.isEmpty(theSameMonth)) {
                for (DaConsDayDosageData dayDataIn : theSameMonth) {
                    if (dayDataIn.getConsNo().equals(consNo) && dayDataIn.getIndBNo().equals(indBNo) && dayDataIn.getUnitTypeNo().equals(unitTypeNo)) {
                        //取值同一个月
                        if (dayDataIn.getMonth().equals(month1)) {
                            items.add(dayDataIn);
                        }
                    }
                }
            }


            for (DaConsDayDosageData dayDataIn : yearOnYearOrRatioData) {
                if (dayDataIn.getConsNo().equals(consNo) && dayDataIn.getIndBNo().equals(indBNo) && dayDataIn.getUnitTypeNo().equals(unitTypeNo)) {
                    //取上个月同一天
                    if (dayDataIn.getDataDate().isEqual(lastMonthDataDate)) {
                        daConsDayDosageMonthData.setMomDataDate(dayDataIn.getDataDate());
                        daConsDayDosageMonthData.setMomMonth(dayDataIn.getMonth());
                        daConsDayDosageMonthData.setMomTip(dayDataIn.getTip());
                        daConsDayDosageMonthData.setMomPeak(dayDataIn.getPeak());
                        daConsDayDosageMonthData.setMomFlat(dayDataIn.getFlat());
                        daConsDayDosageMonthData.setMomValley(dayDataIn.getValley());
                        daConsDayDosageMonthData.setMomTotal(dayDataIn.getTotal());
                        daConsDayDosageMonthData.setMomTipRatio(Maths.yearOnYearOrRatio(dayData.getTip(), dayDataIn.getTip(), MAXDIGITS));
                        daConsDayDosageMonthData.setMomPeakRatio(Maths.yearOnYearOrRatio(dayData.getPeak(), dayDataIn.getPeak(), MAXDIGITS));
                        daConsDayDosageMonthData.setMomFlatRatio(Maths.yearOnYearOrRatio(dayData.getFlat(), dayDataIn.getFlat(), MAXDIGITS));
                        daConsDayDosageMonthData.setMomValleyRatio(Maths.yearOnYearOrRatio(dayData.getValley(), dayDataIn.getValley(), MAXDIGITS));
                        daConsDayDosageMonthData.setMomTotalRatio(Maths.yearOnYearOrRatio(dayData.getTotal(), dayDataIn.getTotal(), MAXDIGITS));
                    }
                    //取去年同一天
                    else if (dayDataIn.getDataDate().isEqual(lastYearDataDate)) {
                        daConsDayDosageMonthData.setYoyDataDate(dayDataIn.getDataDate());
                        daConsDayDosageMonthData.setYoyMonth(dayDataIn.getMonth());
                        daConsDayDosageMonthData.setYoyTip(dayDataIn.getTip());
                        daConsDayDosageMonthData.setYoyPeak(dayDataIn.getPeak());
                        daConsDayDosageMonthData.setYoyFlat(dayDataIn.getFlat());
                        daConsDayDosageMonthData.setYoyValley(dayDataIn.getValley());
                        daConsDayDosageMonthData.setYoyTotal(dayDataIn.getTotal());
                        daConsDayDosageMonthData.setYoyTipRatio(Maths.yearOnYearOrRatio(dayData.getTip(), dayDataIn.getTip(), MAXDIGITS));
                        daConsDayDosageMonthData.setYoyPeakRatio(Maths.yearOnYearOrRatio(dayData.getPeak(), dayDataIn.getPeak(), MAXDIGITS));
                        daConsDayDosageMonthData.setYoyFlatRatio(Maths.yearOnYearOrRatio(dayData.getFlat(), dayDataIn.getFlat(), MAXDIGITS));
                        daConsDayDosageMonthData.setYoyValleyRatio(Maths.yearOnYearOrRatio(dayData.getValley(), dayDataIn.getValley(), MAXDIGITS));
                        daConsDayDosageMonthData.setYoyTotalRatio(Maths.yearOnYearOrRatio(dayData.getTotal(), dayDataIn.getTotal(), MAXDIGITS));
                    }

                }

            }
            daConsDayDosageMonthData.setOrgNo(dayData.getOrgNo());
            daConsDayDosageMonthData.setOrgName(dayData.getOrgName());
            daConsDayDosageMonthData.setConsName(dayData.getConsName());
            daConsDayDosageMonthData.setConsNo(dayData.getConsNo());
            daConsDayDosageMonthData.setUnitType(dayData.getUnitType());
            daConsDayDosageMonthData.setIndex(dayData.getIndex());
            daConsDayDosageMonthData.setDataDate(dayData.getDataDate());
            daConsDayDosageMonthData.setMonth(dayData.getMonth());
            daConsDayDosageMonthData.setTip(dayData.getTip());
            daConsDayDosageMonthData.setPeak(dayData.getPeak());
            daConsDayDosageMonthData.setFlat(dayData.getFlat());
            daConsDayDosageMonthData.setValley(dayData.getValley());
            daConsDayDosageMonthData.setTotal(dayData.getTotal());


            daConsDayDosageMonthData.setItems(items);
            resultList.add(daConsDayDosageMonthData);
        }
        return resultList;
    }

}
