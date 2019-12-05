package com.suypower.venus.elec.common.service;

import com.suypower.venus.elec.common.entity.*;
import com.suypower.venus.elec.common.query.DaConsQuery;

import java.util.List;

/**
 * @author maofukai
 * @date 2019-07-09
 * 企业采集数据
 */
public interface IDaConsDataService {

    /**
     * 获取企业日数据
     *
     * @param daConsQuery     参数实体
     * @return
     */
    List<DaConsDayData> queryConsDayData(DaConsQuery daConsQuery);

    /**
     * 按月获取企业日数据
     *
     * @param daConsQuery
     * @return
     */
    List<DaConsDayData> queryConsDayDataByMonth(DaConsQuery daConsQuery);

    /**
     * 获取企业日最值数据
     *
     * @return
     */
    List<DaConsDayMostData> queryConsDayMostData(DaConsQuery daConsQuery);

    /**
     * 按月获取企业日最值数据
     *
     *
     * @return
     */
    List<DaConsDayMostData> queryConsDayMostDataByMonth(DaConsQuery daConsQuery);

    /**
     * 获取企业日用量数据
     *
     * @return
     */
    List<DaConsDayDosageData> queryConsDayDosageData(DaConsQuery daConsQuery);


    /**
     * 按月获取企业日用量数据
     *
     * @return
     */
    List<DaConsDayDosageData> queryConsDayDosageDataByMonth(DaConsQuery daConsQuery);


    /**
     * 获取企业月数据
     *
     * @return
     */
    List<DaConsMonthData> queryConsMonthData(DaConsQuery daConsQuery);

    /**
     * 按年获取企业月数据
     *
     * @return
     */
    List<DaConsMonthData> queryConsMonthDataByYear(DaConsQuery daConsQuery);


    /**
     * 获取企业月用量数据
     *
     * @return
     */
    List<DaConsMonthDosageData> queryConsMonthDosageData(DaConsQuery daConsQuery);


    /**
     * 按年获取企业月用量数据
     *
     * @return
     */
    List<DaConsMonthDosageData> queryConsMonthDosageDataByYear(DaConsQuery daConsQuery);

    /**
     * 获取统计企业用量数据(当日、当月、当年、上日、上月、上年)
     *
     * @return
     */
    DaConsTotalDosageData queryConsTotalDosageData(DaConsQuery daConsQuery);
}