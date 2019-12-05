package com.suypower.venus.elec.common.controller;

import com.suypower.venus.elec.common.entity.DaConsDayDosageMonthData;
import com.suypower.venus.elec.common.entity.DaConsMonthDosageYearData;
import com.suypower.venus.elec.common.entity.DaConsYearDosageData;
import com.suypower.venus.elec.common.entity.DaMpDayData;
import com.suypower.venus.elec.common.query.DaConsMultiRawQuery;
import com.suypower.venus.elec.common.query.DaConsQuery;
import com.suypower.venus.elec.common.query.DaConsSingleRawQuery;
import com.suypower.venus.elec.common.service.impl.DaConsAdvDataServiceImpl;
import com.suypower.venus.elec.common.utils.Assert;
import com.suypower.venus.elec.common.utils.CommonUtils;
import com.suypower.venus.elec.common.utils.DataGroupUtils;
import com.suypower.venus.platform.web.controller.BaseController;
import com.suypower.venus.platform.web.response.VenusResponse;
import com.suypower.venus.platform.web.response.VenusResponseHttpCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping( "/app/da/cons/adv" )
public class DaConsAdvDataController extends BaseController {

    @Autowired
    private DaConsAdvDataServiceImpl daConsAdvDataService;

    /**
     * 查询企业【日单条】用量数据(含同比、环比)
     *
     * @return
     */
    @RequestMapping( value = ("/dayDosageData") )
    @ResponseBody
    public VenusResponse<DaMpDayData> dayDosageData(DaConsSingleRawQuery daConsSingleRawQuery ) {
        Assert.isEmpty(daConsSingleRawQuery.getUnitTypeNo(), "测点标志不能为空");
        Assert.isEmpty(daConsSingleRawQuery.getIndBNo(), "指标编号不能为空");
        DaConsQuery parse = daConsSingleRawQuery.parse();
        parse.setConsNo(consNo());
        List<DaConsDayDosageMonthData> resultDataList = daConsAdvDataService.queryConsDayDosageDataa(parse);
        return new VenusResponse(VenusResponseHttpCode.OK, CommonUtils.getFirstList(resultDataList));

    }

    /**
     * 查询企业【日单条】用量数据(含同比、环比)
     *
     * @return
     */
    @RequestMapping( value = ("/monthDosageData") )
    @ResponseBody
    public VenusResponse<DaMpDayData> monthDosageData(DaConsSingleRawQuery daConsSingleRawQuery ) {
        Assert.isEmpty(daConsSingleRawQuery.getUnitTypeNo(), "测点标志不能为空");
        Assert.isEmpty(daConsSingleRawQuery.getIndBNo(), "指标编号不能为空");
        DaConsQuery parse = daConsSingleRawQuery.parse();
        parse.setConsNo(consNo());
        List<DaConsMonthDosageYearData> daConsMonthDosageYearData = daConsAdvDataService.queryConsMonthDosageDataa(parse);
        return new VenusResponse(VenusResponseHttpCode.OK, CommonUtils.getFirstList(daConsMonthDosageYearData));

    }
    @RequestMapping( value = ("/dayDosageDataList") )
    @ResponseBody
    public VenusResponse<DaMpDayData> dayDosageDataList(DaConsMultiRawQuery daConsMultiRawQuery ) {
        DaConsQuery parse = daConsMultiRawQuery.parse();
        parse.setConsNo(consNo());
        List<DaConsDayDosageMonthData> resultDataList = daConsAdvDataService.queryConsDayDosageDataa(parse);
        return new VenusResponse(VenusResponseHttpCode.OK, DataGroupUtils.originalOrgroupByField(resultDataList,parse.getGroupBys()));

    }

    /**
     * 查询企业【日单条】用量数据(含同比、环比、月份每天用量数据集合)
     * @param daConsSingleRawQuery
     * @return
     */
    @RequestMapping( value = ("/dayDosageMonthData") )
    @ResponseBody
    public VenusResponse<DaMpDayData> dayDosageMonthData(DaConsSingleRawQuery daConsSingleRawQuery ) {
        Assert.isEmpty(daConsSingleRawQuery.getUnitTypeNo(), "测点标志不能为空");
        Assert.isEmpty(daConsSingleRawQuery.getIndBNo(), "指标编号不能为空");
        DaConsQuery parse = daConsSingleRawQuery.parse();
        parse.setConsNo(consNo());
        List<DaConsDayDosageMonthData> resultDataList = daConsAdvDataService.queryConsDayDosageMonthDataa(parse);
        return new VenusResponse(VenusResponseHttpCode.OK, CommonUtils.getFirstList(resultDataList));

    }
    /**
     * 查询企业【日单条】用量数据(含同比、环比、月份每天用量数据集合)
     * @param daConsSingleRawQuery
     * @return
     */
    @RequestMapping( value = ("/dayDosageYearData") )
    @ResponseBody
    public VenusResponse<DaConsYearDosageData> dayDosageYearData(DaConsSingleRawQuery daConsSingleRawQuery ) {
        Assert.isEmpty(daConsSingleRawQuery.getUnitTypeNo(), "测点标志不能为空");
        Assert.isEmpty(daConsSingleRawQuery.getIndBNo(), "指标编号不能为空");
        DaConsQuery parse = daConsSingleRawQuery.parse();
        parse.setConsNo(consNo());
        List<DaConsYearDosageData> daConsYearDosageData = daConsAdvDataService.queryConsYearDosageDataa(parse);
        return new VenusResponse(VenusResponseHttpCode.OK, CommonUtils.getFirstList(daConsYearDosageData));

    }


    /**
     * 查询企业【日多条】用量数据(含同比、环比、月份每天用量数据集合)
     * @param daConsMultiRawQuery
     * @return
     */
    @RequestMapping( value = ("/dayDosageMonthDataList") )
    @ResponseBody
    public VenusResponse<DaMpDayData> dayDosageMonthDataList(DaConsMultiRawQuery daConsMultiRawQuery ) {
        DaConsQuery parse = daConsMultiRawQuery.parse();
        parse.setConsNo(consNo());
        List<DaConsDayDosageMonthData> resultDataList = daConsAdvDataService.queryConsDayDosageMonthDataa(parse);
        return new VenusResponse(VenusResponseHttpCode.OK, DataGroupUtils.originalOrgroupByField(resultDataList,parse.getGroupBys()));

    }

}
