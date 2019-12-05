package com.suypower.venus.elec.monitor.service.impl;

import com.suypower.venus.elec.common.common.Index;
import com.suypower.venus.elec.common.entity.DaDataItem;
import com.suypower.venus.elec.common.entity.DaMpRealtimeData;
import com.suypower.venus.elec.common.service.IDaMpRealtimeDataService;
import com.suypower.venus.elec.common.utils.Maths;
import com.suypower.venus.elec.monitor.dao.DiagramDao;
import com.suypower.venus.elec.monitor.entity.Diagram;
import com.suypower.venus.elec.monitor.entity.DiagramDetail;
import com.suypower.venus.elec.monitor.service.IDiagramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service( "diagramService" )
public class DiagramServiceImpl implements IDiagramService {

    @Autowired
    private DiagramDao diagramDao;

    @Autowired
    private IDaMpRealtimeDataService daMpRealtimeDataService;

    /**
     * 查询企业接线图
     * @param consNo  企业编号
     * @param pGId    上级接线图
     * @param gLevel  接线图类型(一次测,二次侧)
     * @return
     */
    @Override
    public List<Diagram> queryDiagramList(String consNo, Long pGId, String gLevel) {
        List<Diagram> diagrams = diagramDao.queryDiagramList(consNo, pGId, gLevel);
        return diagrams;
    }

    /**
     * 查询企业详细的接线图
     * @param gId
     * @return
     */
    @Override
    public DiagramDetail getDiagramDetail(Long gId) {
        DiagramDetail diagramDetail = diagramDao.getDiagramDetail(gId);
        return diagramDetail;
    }

    /**
     * 获取接线图实时数据
     * @param gId
     * @return
     */
    @Override
    public List<DaMpRealtimeData> readRealtimeDataList(Long gId) {
        //TODO 随机数产生实时数据
        List<DaMpRealtimeData> daMpRealtimeDataList = new ArrayList<>();
        DaMpRealtimeData daMpRealtimeDataOne = new DaMpRealtimeData();
        daMpRealtimeDataOne.setConsNo("0099760380");
        daMpRealtimeDataOne.setMpId(601417006150893569L);
        daMpRealtimeDataOne.setMpName("1#空压机");
        daMpRealtimeDataOne.setMpNo(1);
        List<DaDataItem> daDataItemList = new ArrayList<>();
        daDataItemList.add(new DaDataItem(Index.Ia, Maths.digits(Math.random() * 100D, 2)));
        daDataItemList.add(new DaDataItem(Index.SPZW, Maths.digits(Math.random() * 100D, 2)));
        daDataItemList.add(new DaDataItem(Index.P, Maths.digits(Math.random() * 100D, 2)));
        daMpRealtimeDataOne.setData(daDataItemList);
        daMpRealtimeDataList.add(daMpRealtimeDataOne);
        //第二个
        DaMpRealtimeData daMpRealtimeDataTwo = new DaMpRealtimeData();
        daMpRealtimeDataTwo.setConsNo("0099760380");
        daMpRealtimeDataTwo.setMpId(601417006113144834L);
        daMpRealtimeDataTwo.setMpName("2#空压机");
        daMpRealtimeDataTwo.setMpNo(1);
        List<DaDataItem> daDataItemListTwo = new ArrayList<>();
        daDataItemListTwo.add(new DaDataItem(Index.Ia, Maths.digits(Math.random() * 100D, 2)));
        daDataItemListTwo.add(new DaDataItem(Index.SPZW, Maths.digits(Math.random() * 100D, 2)));
        daDataItemListTwo.add(new DaDataItem(Index.P, Maths.digits(Math.random() * 100D, 2)));
        daMpRealtimeDataTwo.setData(daDataItemListTwo);
        daMpRealtimeDataList.add(daMpRealtimeDataTwo);

       // List<DaMpRealtimeData> daMpRealtimeData = daMpRealtimeDataService.queryRealtimeData(consNo, mpId, realTimeType);

        return daMpRealtimeDataList;
    }
}
