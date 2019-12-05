package com.suypower.venus.elec.monitor.service;

import com.suypower.venus.elec.common.entity.DaMpRealtimeData;
import com.suypower.venus.elec.monitor.entity.Diagram;
import com.suypower.venus.elec.monitor.entity.DiagramDetail;

import java.util.List;

/**
 * @author maofukai
 * @date 2019-07-09
 * 接线图
 */
public interface IDiagramService {

    /**
     * 查询企业接线图
     * @param consNo  企业编号
     * @param pGId    上级接线图
     * @param gLevel  接线图类型(一次测,二次侧)
     * @return
     */
    List<Diagram>  queryDiagramList(String consNo,Long pGId,String gLevel);

    /**
     * 查询企业详细的接线图
     * @param gId
     * @return
     */
    DiagramDetail getDiagramDetail(Long gId);


    /**
     * 获取接线图实时数据
     * @param gId
     * @return
     */
    List<DaMpRealtimeData> readRealtimeDataList(Long gId);
}
