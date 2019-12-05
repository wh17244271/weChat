package com.suypower.venus.elec.common.service;

import com.suypower.venus.elec.common.common.Index;
import com.suypower.venus.elec.common.common.UnitType;
import com.suypower.venus.elec.common.entity.*;

import java.time.LocalDate;
import java.util.List;

/**
 * @author maofukai
 * @date 2019-07-12
 * 单元采集数据
 */
public interface IDaUnitDataService {

    /**
     * 获取单元日数据
     *
     * @param unitId     单元标识
     * @param dates      数据日期(yyyy-MM-dd)
     * @param indexes    指标编码
     * @param pointCount 数据频度
     * @return
     */
    List<DaUnitDayData> queryUnitDayData(String unitId, LocalDate[] dates, Index[] indexes, String pointCount);

    /**
     * 获取单元日最值数据
     *
     * @param unitId  单元标识
     * @param dates   数据日期(yyyy-MM-dd)
     * @param indexes 指标编码
     * @return
     */
    List<DaUnitDayMostData> queryUnitDayMostData(String unitId, LocalDate[] dates, Index[] indexes);


    /**
     * 获取单元日用量数据
     *
     * @param unitId  单元标识
     * @param dates   数据日期(yyyy-MM-dd)
     * @param indexes 指标编码
     * @return
     */
    List<DaUnitDayDosageData> queryUnitDayDosageData(String unitId, LocalDate[] dates, Index[] indexes);


    /**
     * 获取单元月数据
     *
     * @param unitId     单元标识
     * @param dataMonths 数据日期(yyyy-MM)
     * @param indexes    指标编码
     * @return
     */
    List<DaUnitMonthData> queryUnitMonthData(String unitId, String[] dataMonths, Index[] indexes);


    /**
     * 获取单元月用量数据
     *
     * @param unitId  单元标识
     * @param dates   数据日期(yyyy-MM)
     * @param indexes 指标编码
     * @return
     */
    List<DaUnitMonthDosageData> queryUnitMonthDosageData(String unitId, String[] dates, Index[] indexes);

    /**
     * 获取企业单元日数据
     *
     * @param consNo    企业编号
     * @param dates     数据日期(yyyy-MM-dd)
     * @param unitTypes 单元类型编号(单元类型为空查询企业所有类型单元)
     * @param indexes   指标编码
     * @return
     */
    List<DaUnitDayData> queryUnitDayDataByCons(String consNo, LocalDate[] dates, UnitType[] unitTypes, Index[] indexes);

    /**
     * 获取企业单元日最值数据
     *
     * @param consNo    企业编号
     * @param dates     数据日期(yyyy-MM-dd)
     * @param unitTypes 单元类型编号(单元类型为空查询企业所有类型单元)
     * @param indexes   指标编码
     * @return
     */
    List<DaUnitDayMostData> queryUnitDayMostDataByCons(String consNo, LocalDate[] dates, UnitType[] unitTypes, Index[] indexes);


    /**
     * 获取企业单元日用量数据
     *
     * @param consNo     企业编号
     * @param dataMonths 数据日期(YYYY-MM-dd)
     * @param unitTypes  单元类型编号(单元类型为空查询企业所有类型单元)
     * @param indexes    指标编码
     * @return
     */
    List<DaUnitDayDosageData> queryUnitDayDosageDataByCons(String consNo, LocalDate[] dataMonths, UnitType[] unitTypes, Index[] indexes);


    /**
     * 获取企业单元月数据
     *
     * @param consNo     单元标识
     * @param dataMonths 数据日期(yyyy-MM)
     * @param unitTypes  单元类型编号(单元类型为空查询企业所有类型单元)
     * @param indexes    指标编码
     * @return
     */
    List<DaUnitMonthData> queryUnitMonthDataByCons(String consNo, String[] dataMonths, UnitType[] unitTypes, Index[] indexes);


    /**
     * 获取企业单元月用量数据
     *
     * @param consNo     单元标识
     * @param dataMonths 数据日期(yyyy-MM)
     * @param unitTypes  单元类型编号(单元类型为空查询企业所有类型单元)
     * @param indexes    指标编码
     * @return
     */
    List<DaUnitMonthDosageData> queryUnitMonthDosageDataByCons(String consNo, String[] dataMonths, UnitType[] unitTypes, Index[] indexes);

}
