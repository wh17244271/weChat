package com.suypower.venus.elec.common.service;

import com.suypower.venus.elec.common.entity.DaConsDayDosageMonthData;
import com.suypower.venus.elec.common.entity.DaConsMonthDosageYearData;
import com.suypower.venus.elec.common.entity.DaConsYearDosageData;
import com.suypower.venus.elec.common.query.DaConsQuery;

import java.util.List;

/**
 * @author maofukai
 * @date 2019-08-06
 * 企业采集数据高级接口
 */
public interface IDaConsAdvDataService {

    /**
     *
     * 获取企业日用量数据(含同比、环比、月份每天用量数据集合)
     * @return
     */
    List<DaConsDayDosageMonthData> queryConsDayDosageMonthDataa(DaConsQuery daConsQuery);

    /**
     * 获取企业日用量数据(含同比、环比)
     * @param daConsQuery
     * @return
     */
    List<DaConsDayDosageMonthData> queryConsDayDosageDataa(DaConsQuery daConsQuery);

    /**
     * 获取企业月用量数据(含同比、环比)
     * @param daConsQuery
     * @return
     */
    List<DaConsMonthDosageYearData> queryConsMonthDosageDataa(DaConsQuery daConsQuery);

    /**
     * 获取企业年用量数据(含环比)
     * @param daConsQuery
     * @return
     */
    public List<DaConsYearDosageData> queryConsYearDosageDataa(DaConsQuery daConsQuery);

}
