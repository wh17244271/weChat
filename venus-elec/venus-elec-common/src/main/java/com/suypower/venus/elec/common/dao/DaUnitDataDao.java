package com.suypower.venus.elec.common.dao;


import com.suypower.venus.elec.common.common.Index;
import com.suypower.venus.elec.common.common.UnitType;
import com.suypower.venus.elec.common.entity.*;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;


public interface DaUnitDataDao {

    /**
     * 获取单元日数据
     * 获取企业单元日数据
     *
     * @param unitId     单元标识
     * @param consNo     用户标志
     * @param unitTypes  单元类型编号(单元类型为空查询企业所有类型单元)
     * @param dates      数据日期(yyyy-MM-dd)
     * @param indexes    指标编码
     * @return
     */
    List<Map<String, Object>> queryUnitDayData(@Param("unitId") String unitId,@Param("consNo") String consNo, @Param("unitTypes") UnitType[] unitTypes,
                                               @Param("dates") LocalDate[] dates, @Param("indexes") Index[] indexes);

    /**
     * 获取单元日最值数据
     * 获取企业单元日最值数据
     * @param unitId     单元标识
     * @param consNo     用户标志
     * @param unitTypes  单元类型编号(单元类型为空查询企业所有类型单元)
     * @param dates      数据日期(yyyy-MM-dd)
     * @param indexes    指标编码
     * @return
     */
    List<DaUnitDayMostData> queryUnitDayMostData(@Param("unitId") String unitId, @Param("consNo") String consNo, @Param("unitTypes") UnitType[] unitTypes,
                                                 @Param("dates") LocalDate[] dates, @Param("indexes") Index[] indexes);
    /**
     * 获取单元日用量数据
     * 获取企业单元日用量数据
     * @param unitId     单元标识
     * @param consNo     用户标志
     * @param unitTypes  单元类型编号(单元类型为空查询企业所有类型单元)
     * @param dates      数据日期(yyyy-MM-dd)
     * @param indexes    指标编码
     * @return
     */
    List<DaUnitDayDosageData> queryUnitDayDosageData(@Param("unitId") String unitId, @Param("consNo") String consNo, @Param("unitTypes") UnitType[] unitTypes,
                                                     @Param("dates") LocalDate[] dates, @Param("indexes") Index[] indexes);

    /**
     * 获取单元月数据
     * 获取企业单元月数据
     * @param unitId     单元标识
     * @param consNo     用户标志
     * @param unitTypes  单元类型编号(单元类型为空查询企业所有类型单元)
     * @param dates      数据日期(yyyy-MM)
     * @param indexes    指标编码
     * @return
     */
    List<DaUnitMonthData> queryUnitMonthData(@Param("unitId") String unitId, @Param("consNo") String consNo, @Param("unitTypes") UnitType[] unitTypes,
                                             @Param("dates") String[] dates, @Param("indexes") Index[] indexes);
    /**
     * 获取单元月用量数据
     * 获取企业单元月用量数据
     * @param unitId     单元标识
     * @param consNo     用户标志
     * @param unitTypes  单元类型编号(单元类型为空查询企业所有类型单元)
     * @param dates      数据日期(yyyy-MM)
     * @param indexes    指标编码
     * @return
     */
    List<DaUnitMonthDosageData> queryUnitMonthDosageData(@Param("unitId") String unitId, @Param("consNo") String consNo, @Param("unitTypes") UnitType[] unitTypes,
                                             @Param("dates") String[] dates, @Param("indexes") Index[] indexes);

}

