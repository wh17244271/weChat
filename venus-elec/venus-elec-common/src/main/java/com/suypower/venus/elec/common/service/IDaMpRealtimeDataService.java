package com.suypower.venus.elec.common.service;

import com.suypower.venus.elec.common.entity.DaMpRealtimeData;

import java.util.List;

/**
 * @author maofukai
 * @date 2019-07-12
 * 测点实时数据接口
 */
public interface IDaMpRealtimeDataService {


    /**
     * 查询实时数据
     * @return
     */
    List<DaMpRealtimeData> queryRealtimeData(String consNo,String mpId,String realTimeType);
}

