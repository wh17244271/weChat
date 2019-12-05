package com.suypower.venus.elec.common.dao;


import com.suypower.venus.elec.common.common.Index;
import com.suypower.venus.elec.common.entity.*;
import com.suypower.venus.elec.common.query.DaMpQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;


public interface DaMpDataDao {


    /**
     * 获取单个测点日数据/
     * 获取企业全部测点日数据
     * 获取单元全部测点日数据
     *
     * @param daMpQuery     获取单个测点日数据
     * @param tableIndxesMap
     * @return
     */
    List<Map<String, Object>> queryMpDayData(@Param( "daMpQuery" ) DaMpQuery daMpQuery,
                                             @Param( "tableIndxesMap" ) Map<String, Set<Index>> tableIndxesMap);

    /**
     * 获取单个测点日最值数据
     * 取企业全部测点日最值数据
     * 获取单元全部测点日最值数据
     *
     * @param daMpQuery     参数实体对象
     * @param tableIndxesMap
     * @return
     */
    List<DaMpDayMostData> queryMpDayMostData(@Param( "daMpQuery" ) DaMpQuery daMpQuery,
                                             @Param( "tableIndxesMap" ) Map<String, Set<Index>> tableIndxesMap);

    /**
     * 获取单个测点日抄表示数数据
     * 获取企业全部测点日抄表示数数据
     * 获取单元全部测点日抄表示数数据
     *
     * @param daMpQuery 参数实体对象
     * @return
     */
    List<DaMpDayReadingsData> queryMpDayReadingsData(DaMpQuery daMpQuery);


    /**
     * 获取单个测点日用量数据
     * 获取企业全部测点日用量数据
     * 获取单元全部测点日用量数据
     *
     * @param daMpQuery 测点标识
     * @return
     */

    List<DaMpDayDosageData> queryMpDayDosageData(DaMpQuery daMpQuery);

    /**
     * 获取单个测点月数据
     * 获取企业全部测点月数据
     * 获取单元全部测点月数据
     *
     * @param daMpQuery 测点标识
     * @return
     */
    List<DaMpMonthData> queryMpMonthData(DaMpQuery daMpQuery);

    /**
     * 获取单个测点月抄表示数数据
     * 取企业全部测点月抄表示数数据
     * 获取单元全部测点月抄表示数数据
     *
     * @param daMpQuery 测点标识
     * @return
     */
    List<DaMpMonthReadingsData> queryMpMonthReadingsData(DaMpQuery daMpQuery);

    /**
     * 获取单个测点月用量数据
     * 获取企业全部测点月用量数据
     * 获取单元全部测点月用量数据
     *
     * @param daMpQuery 测点标识
     * @return
     */
    List<DaMpMonthDosageData> queryMpMonthDosageData(DaMpQuery daMpQuery);
}

