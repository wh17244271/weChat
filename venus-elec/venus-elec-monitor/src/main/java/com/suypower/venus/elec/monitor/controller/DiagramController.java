package com.suypower.venus.elec.monitor.controller;

import com.suypower.venus.elec.common.entity.DaMpRealtimeData;
import com.suypower.venus.elec.common.utils.Assert;
import com.suypower.venus.elec.common.utils.Types;
import com.suypower.venus.elec.monitor.entity.Diagram;
import com.suypower.venus.elec.monitor.entity.DiagramDetail;
import com.suypower.venus.elec.monitor.service.IDiagramService;
import com.suypower.venus.platform.web.controller.BaseController;
import com.suypower.venus.platform.web.response.VenusResponse;
import com.suypower.venus.platform.web.response.VenusResponseHttpCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping( value = ("/app/elec/monitor/diagram") )
public class DiagramController extends BaseController {

    @Autowired
    private IDiagramService diagramService;

    /**
     * 查询企业一次接线图信息
     *
     * @param pGId  上一级一次图标识
     * @param depth 查询深度级别
     * @return
     */
    @RequestMapping( value = ("/list") )
    @ResponseBody
    public VenusResponse<List<Diagram>> list(String pGId, String depth) {
        String consNo = consNo();
//        Long pGId = -1L;

        List<Diagram> diagrams = diagramService.queryDiagramList(consNo, Types.Long(pGId), depth);
        return new VenusResponse(VenusResponseHttpCode.OK, diagrams);
    }

    /**
     * 查询企业一次接线图单个详细数据
     *
     * @param gId 一次图标识
     * @return
     */
    @RequestMapping( value = ("/detail") )
    @ResponseBody
    public VenusResponse<DiagramDetail> detail(String gId) {
        Assert.isEmpty(gId, "一次图标识不能为空");
//        Long gId = 601465789031120896L;

        DiagramDetail diagramDetail = diagramService.getDiagramDetail(Types.Long(gId));
        return new VenusResponse(VenusResponseHttpCode.OK, diagramDetail);
    }

    /**
     * 查询企业一次接线图实时数据
     *
     * @param gId 一次图标识
     * @return
     */
    @RequestMapping( value = ("/data") )
    @ResponseBody
    public VenusResponse data(String gId) {
        Assert.isEmpty(gId, "一次图标识不能为空");
//        Long gId = 601465789031120896L;

        List<DaMpRealtimeData> daMpRealtimeData = diagramService.readRealtimeDataList(Types.Long(gId));
        return new VenusResponse(VenusResponseHttpCode.OK, daMpRealtimeData);
    }


}
