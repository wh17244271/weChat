package com.suypower.venus.elec.common.service;

import com.suypower.venus.elec.common.common.Index;
import com.suypower.venus.elec.common.common.UnitType;
import com.suypower.venus.elec.common.entity.*;

import java.time.LocalDate;
import java.util.List;

/**
 * @author maofukai
 * @date   2019-07-12
 * 供电单位(供电区域)采集数据
 */
public interface IDaOrgDataService {

    /**
     * 获取供电单位(供电区域)日数据
     * @param orgNo       企业编号
     * @param dataDates   数据日期(yyyy-MM-dd)
     * @param unitTypes   单元类型编号
     * @param indexes     指标编码
     * @return
     */
    List<DaOrgDayData> queryOrgDayData(String orgNo, LocalDate[] dataDates, UnitType[] unitTypes, Index[] indexes);

    /**
     * 获取供电单位(供电区域)日最值数据
     * @param orgNo       企业编号
     * @param dataDates   数据日期(yyyy-MM-dd)
     * @param unitTypes   单元类型编号
     * @param indexes     指标编码
     * @return
     */
    List<DaOrgDayMostData> queryOrgDayMostData(String orgNo, LocalDate[] dataDates, UnitType[] unitTypes, Index[] indexes);

    /**
     * 获取供电单位(供电区域)日用量数据
     * @param orgNo       企业编号
     * @param dataDates   数据日期(yyyy-MM-dd)
     * @param unitTypes   单元类型编号
     * @param indexes     指标编码
     * @return
     */
    List<DaOrgDayDosageData> queryOrgDayDosageData(String orgNo, LocalDate[] dataDates, UnitType[] unitTypes, Index[] indexes);

    /**
     * 获取供电单位(供电区域)月数据
     * @param orgNo       企业编号
     * @param dataMonths  数据日期(yyyy-MM)
     * @param unitTypes   单元类型编号
     * @param indexes     指标编码
     * @return
     */
    List<DaOrgMonthData> queryOrgMonthData(String orgNo, String[] dataMonths, UnitType[] unitTypes, Index[] indexes);

    /**
     * 获取供电单位(供电区域)月用量数据
     * @param orgNo       企业编号
     * @param dataDates   数据日期(yyyy-MM)
     * @param unitTypes   单元类型编号
     * @param indexes     指标编码
     * @return
     */
    List<DaOrgMonthDosageData> queryOrgMonthDosageData(String orgNo, String[] dataDates, UnitType[] unitTypes, Index[] indexes);




}
