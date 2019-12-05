package com.suypower.venus.elec.common.dao;


import com.suypower.venus.elec.common.common.Index;
import com.suypower.venus.elec.common.entity.DaConsDayDosageData;
import com.suypower.venus.elec.common.entity.DaConsDayMostData;
import com.suypower.venus.elec.common.entity.DaConsMonthData;
import com.suypower.venus.elec.common.entity.DaConsMonthDosageData;
import com.suypower.venus.elec.common.query.DaConsQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;


public interface DaConsDataDao {

    /**
     * 获取企业日类型数据
     *
     * @param tableIndxesMap 指标编码
     * @return
     */
    List<Map<String, Object>> queryConsDayData(@Param( "daConsQuery" )DaConsQuery daConsQuery,
                                               @Param( "tableIndxesMap" ) Map<String, Set<Index>> tableIndxesMap);

    /**
     * 获取企业最值数据
     *
     * @param tableIndxesMap
     * @return
     */
    List<DaConsDayMostData> queryConsMostData(@Param( "daConsQuery" )DaConsQuery daConsQuery,
                                              @Param( "tableIndxesMap" ) Map<String, Set<Index>> tableIndxesMap);

    /**
     * 获取企业月数据
     *
     * @return
     */
    List<DaConsMonthData> queryConsMonthData(DaConsQuery daConsQuery);

    /**
     * 获取企业日用量数据
     *
     * @return
     */
    List<DaConsDayDosageData> queryConsDayDosageData(DaConsQuery daConsQuery);


    /**
     * 按年获取企业月用量数据
     *
     * @return
     */
    List<DaConsMonthDosageData> queryConsMonthDosageData(DaConsQuery daConsQuery);

    /**
     * 获取企业年用量数据
     *
     * @return
     */
    List<DaConsMonthDosageData> queryConsYearDosageData(DaConsQuery daConsQuery);

}

