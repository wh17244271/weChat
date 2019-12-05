package com.suypower.venus.elec.common.dao;


import com.suypower.venus.elec.common.entity.DaMpRealtimeData;

import java.util.List;

public interface DaMpRealtimeDataDao {

    /**
     * 查询实时数据
     * @return
     */
    List<DaMpRealtimeData> queryRealtimeData(String consNo, String mpId, String now);

}

