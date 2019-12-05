package com.suypower.venus.elec.common.dao;


import com.suypower.venus.elec.common.common.Index;
import com.suypower.venus.elec.common.common.UnitType;
import com.suypower.venus.elec.common.entity.DaConsDayMostData;
import com.suypower.venus.elec.common.entity.DaConsMonthData;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;


public interface DaOrgDataDao {

    /**
     * 获取企业日类型数据
     * @param consNo      企业编号
     * @param unitTypes   单元类型编号
     * @param dates       数据日期(YYYY-MM-dd)
     * @param indexes     指标编码
     * @return
     */
    List<LinkedHashMap<String,Object>> queryConsDayData(@Param("consNo") String consNo, @Param("unitTypes") UnitType[] unitTypes,
                                                        @Param("dates") LocalDate[] dates, @Param("indexes") Index[] indexes);

    /**
     *获取企业最值数据
     * @param consNo
     * @param dates
     * @param indexes
     * @return
     */
    List<DaConsDayMostData> queryConsMostData(@Param("consNo") String consNo,
                                              @Param("unitTypes") UnitType[] unitTypes,
                                              @Param("dates") LocalDate[] dates,
                                              @Param("indexes") Index[] indexes);
    /**
     *获取企业月数据
     * @param consNo
     * @param dates
     * @param indexes
     * @return
     */
    List<DaConsMonthData> queryConsMonthData(@Param("consNo") String consNo,
                                             @Param("unitTypes") UnitType[] unitTypes,
                                             @Param("dates") LocalDate[] dates,
                                             @Param("indexes") Index[] indexes);
}

