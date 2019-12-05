package com.suypower.venus.elec.common.service;

import com.suypower.venus.elec.common.entity.*;
import com.suypower.venus.elec.common.query.DaMpQuery;

import java.util.List;

/**
 * @author maofukai
 * @date 2019-07-12
 * 测点采集数据
 */
public interface IDaMpDataService {


    /**
     * 获取单个测点日数据
     *
     * @return
     */
    List<DaMpDayData> queryMpDayData(DaMpQuery daMpQuery);

    /**
     * 获取单个测点日最值数据
     *
     * @return
     */
    List<DaMpDayMostData> queryMpDayMostData(DaMpQuery daMpQuery);

    /**
     * 获取单个测点日抄表示数数据
     *
     * @return
     */
    List<DaMpDayReadingsData> queryMpDayReadingsData(DaMpQuery daMpQuery);
//

    /**
     * 获取单个测点日用量数据
     *
     * @return
     */
    List<DaMpDayDosageData> queryMpDayDosageData(DaMpQuery daMpQuery);


    /**
     * 获取单个测点月数据
     *
     * @return
     */
    List<DaMpMonthData> queryMpMonthData(DaMpQuery daMpQuery);


    /**
     * 获取单个测点月抄表示数数据
     *
     * @return
     */
    List<DaMpMonthReadingsData> queryMpMonthReadingsData(DaMpQuery daMpQuery);


    /**
     * 获取单个测点月用量数据
     *
     * @return
     */
    List<DaMpMonthDosageData> queryMpMonthDosageData(DaMpQuery daMpQuery);


    /**
     * 获取企业全部测点日数据
     *
     * @return
     */
    List<DaMpDayData> queryMpDayDataByCons(DaMpQuery daMpQuery);

    /**
     * 获取企业全部测点日最值数据
     *
     * @return
     */
    List<DaMpDayMostData> queryMpDayMostDataByCons(DaMpQuery daMpQuery);

    /**
     * 获取企业全部测点日抄表示数数据
     *
     * @return
     */
    List<DaMpDayReadingsData> queryMpDayReadingsDataByCons(DaMpQuery daMpQuery);

    /**
     * 获取企业全部测点日用量数据
     *
     * @return
     */
    List<DaMpDayDosageData> queryMpDayDosageDataByCons(DaMpQuery daMpQuery);


    /**
     * 获取企业全部测点月数据
     *
     * @return
     */
    List<DaMpMonthData> queryMpMonthDataByCons(DaMpQuery daMpQuery);


    /**
     * 获取企业全部测点月抄表示数数据
     *
     * @return
     */
    List<DaMpMonthReadingsData> queryMpMonthReadingsDataByCons(DaMpQuery daMpQuery);


    /**
     * 获取企业全部测点月用量数据
     *
     * @return
     */
    List<DaMpMonthDosageData> queryMpMonthDosageDataByCons(DaMpQuery daMpQuery);


    /**
     * 获取单元全部测点日数据
     *
     * @return
     */
    List<DaMpDayData> queryMpDayDataByUnit(DaMpQuery daMpQuery);

    /**
     * 获取单元全部测点日最值数据
     *
     * @return
     */
    List<DaMpDayMostData> queryMpDayMostDataByUnit(DaMpQuery daMpQuery);

    /**
     * 获取单元全部测点日抄表示数数据
     *
     * @return
     */
    List<DaMpDayReadingsData> queryMpDayReadingsDataByUnit(DaMpQuery daMpQuery);

    /**
     * 获取单元全部测点日用量数据
     *
     * @return
     */
    List<DaMpDayDosageData> queryMpDayDosageDataByUnit(DaMpQuery daMpQuery);


    /**
     * 获取单元全部测点月数据
     *
     * @return
     */
    List<DaMpMonthData> queryMpMonthDataByUnit(DaMpQuery daMpQuery);


    /**
     * 获取单元全部测点月抄表示数数据
     *
     * @return
     */
    List<DaMpMonthReadingsData> queryMpMonthReadingsDataByUnit(DaMpQuery daMpQuery);


    /**
     * 获取单元全部测点月用量数据
     *
     * @return
     */
    List<DaMpMonthDosageData> queryMpMonthDosageDataByUnit(DaMpQuery daMpQuery);
}
