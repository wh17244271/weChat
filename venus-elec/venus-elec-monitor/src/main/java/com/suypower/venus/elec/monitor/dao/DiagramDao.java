package com.suypower.venus.elec.monitor.dao;


import com.suypower.venus.elec.monitor.entity.Diagram;
import com.suypower.venus.elec.monitor.entity.DiagramDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DiagramDao {

    /**
     * 查询企业接线图
     * @param consNo  企业编号
     * @param pGId    上级接线图
     * @param gLevel  接线图类型(一次测,二次侧)
     * @return
     */
    List<Diagram> queryDiagramList(@Param("consNo") String consNo,
                                   @Param("pGId") Long pGId,
                                   @Param("gLevel") String gLevel);

    /**
     * 查询企业详细的接线图
     * @param gId
     * @return
     */
    DiagramDetail getDiagramDetail(@Param("gId")Long gId);

}

