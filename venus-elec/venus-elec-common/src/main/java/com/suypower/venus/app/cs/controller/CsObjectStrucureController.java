package com.suypower.venus.app.cs.controller;

import com.suypower.venus.app.cs.entity.CsObjectInfoStructure;
import com.suypower.venus.app.cs.entity.CsObjectStructure;
import com.suypower.venus.app.cs.service.ICsObjectStrucureService;
import com.suypower.venus.elec.common.utils.Assert;
import com.suypower.venus.elec.common.utils.StringUtils;
import com.suypower.venus.platform.share.entity.Tree;
import com.suypower.venus.platform.web.controller.BaseController;
import com.suypower.venus.platform.web.response.VenusResponse;
import com.suypower.venus.platform.web.response.VenusResponseHttpCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CsObjectStrucureController extends BaseController {

    @Autowired
    private ICsObjectStrucureService csObjectStrucureService;

    /**
     * 查询企业所有监测点-树控件
     * @return
     */
    @RequestMapping( value = ("/app/elec/cs/topologyTree") )
    @ResponseBody
    public VenusResponse<?> topologyTree(CsObjectStructure csObjectStructure ) {
        csObjectStructure.setConsNo(consNo());
        String stClsId = csObjectStructure.getStClsId();
        String stClsNo = csObjectStructure.getStClsNo();
        Assert.isTrue(StringUtils.isEmpty(stClsId)&&StringUtils.isEmpty(stClsNo),"档案结构分类标识或者编号必须传一个");


        List<CsObjectInfoStructure> csObjectInfoStructures = csObjectStrucureService.queryForList(csObjectStructure);
        return new VenusResponse(VenusResponseHttpCode.OK, csObjectInfoStructures);
    }

    /**
     * 查询企业所有监测点-树控件
     * @return
     */
    @RequestMapping( value = ("/app/elec/cs/topologyTree2") )
    @ResponseBody
    public VenusResponse<?> topologyTree2(CsObjectStructure csObjectStructure ) {
        csObjectStructure.setConsNo(consNo());
        String stClsId = csObjectStructure.getStClsId();
        String stClsNo = csObjectStructure.getStClsNo();
        Assert.isTrue(StringUtils.isEmpty(stClsId)&&StringUtils.isEmpty(stClsNo),"档案结构分类标识或者编号必须传一个");
        Tree<CsObjectInfoStructure> csObjectInfoStructureTree = csObjectStrucureService.queryForTree(csObjectStructure);
        return new VenusResponse(VenusResponseHttpCode.OK, csObjectInfoStructureTree);
    }



}
