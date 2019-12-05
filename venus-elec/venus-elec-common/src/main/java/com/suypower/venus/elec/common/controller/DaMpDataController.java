package com.suypower.venus.elec.common.controller;

import com.suypower.venus.elec.common.entity.*;
import com.suypower.venus.elec.common.query.DaMpMultiRawQuery;
import com.suypower.venus.elec.common.query.DaMpQuery;
import com.suypower.venus.elec.common.query.DaMpSingleRawQuery;
import com.suypower.venus.elec.common.service.IDaMpDataService;
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
@RequestMapping( "/app/da/mp" )
public class DaMpDataController extends BaseController {

    @Autowired
    private IDaMpDataService daMpDataService;

    /**
     * 查询测点【日单条】数据
     *
     * @return
     */
    @RequestMapping( value = ("/dayData") )
    @ResponseBody
    public VenusResponse<DaMpDayData> dayData(DaMpSingleRawQuery daMpSingleRawQuery) {
        Assert.isEmpty(daMpSingleRawQuery.getMpId(), "测点标志不能为空");
        Assert.isEmpty(daMpSingleRawQuery.getIndBNo(), "指标编号不能为空");
        DaMpQuery daMpQuery = daMpSingleRawQuery.parse();

        List<DaMpDayData> daMpDayData = daMpDataService.queryMpDayData(daMpQuery);
        return new VenusResponse(VenusResponseHttpCode.OK, CommonUtils.getFirstList(daMpDayData));

    }

    /**
     * 查询测点【日多条】数据集合
     *
     * @return
     */
    @RequestMapping( value = ("/dayDataList") )
    @ResponseBody
    public VenusResponse<?> dayDataList(DaMpMultiRawQuery daMpMultiRawQuery) {

        DaMpQuery daMpQuery = daMpMultiRawQuery.parse();
        CommonUtils.dayTimeTypeNotApplicable(daMpQuery);

        List<DaMpDayData> daMpDayData = daMpDataService.queryMpDayData(daMpQuery);

        return new VenusResponse(VenusResponseHttpCode.OK, DataGroupUtils.originalOrgroupByField(daMpDayData,daMpQuery.getGroupBys()));
    }

    /**
     * 查询测点【日单条】最值数据
     *
     * @return
     */
    @RequestMapping( value = ("/dayMostData") )
    @ResponseBody
    public VenusResponse<DaMpDayMostData> dayMostData(DaMpSingleRawQuery daMpSingleRawQuery) {
        Assert.isEmpty(daMpSingleRawQuery.getMpId(), "测点标志不能为空");
        Assert.isEmpty(daMpSingleRawQuery.getIndBNo(), "指标编号不能为空");
        DaMpQuery daMpQuery = daMpSingleRawQuery.parse();
        List<DaMpDayMostData> daMpDayMostData = daMpDataService.queryMpDayMostData(daMpQuery);


        return new VenusResponse(VenusResponseHttpCode.OK, CommonUtils.getFirstList(daMpDayMostData));
    }

    /**
     * 查询测点【日多条】最值数据
     *
     * @return
     */
    @RequestMapping( value = ("/dayMostDataList") )
    @ResponseBody
    public VenusResponse<List<DaMpDayMostData>> dayMostDataList(DaMpMultiRawQuery daMpMultiRawQuery) {
        DaMpQuery daMpQuery = daMpMultiRawQuery.parse();
        CommonUtils.dayTimeTypeNotApplicable(daMpQuery);
        List<DaMpDayMostData> daMpDayMostData = daMpDataService.queryMpDayMostData(daMpQuery);

        return new VenusResponse(VenusResponseHttpCode.OK, DataGroupUtils.originalOrgroupByField(daMpDayMostData,daMpQuery.getGroupBys()));
    }
//

    /**
     * 查询测点【日单条】用量数据
     *
     * @return
     */
    @RequestMapping( value = ("/dayDosageData") )
    @ResponseBody
    public VenusResponse<DaMpDayDosageData> dayDosageData(DaMpSingleRawQuery daMpSingleRawQuery) {
        Assert.isEmpty(daMpSingleRawQuery.getMpId(), "测点标志不能为空");
        Assert.isEmpty(daMpSingleRawQuery.getIndBNo(), "指标编号不能为空");
        DaMpQuery daMpQuery = daMpSingleRawQuery.parse();

        List<DaMpDayDosageData> daMpDayDosageData = daMpDataService.queryMpDayDosageData(daMpQuery);

        return new VenusResponse(VenusResponseHttpCode.OK, CommonUtils.getFirstList(daMpDayDosageData));
    }
//

    /**
     * 查询测点【日多条】用量数据
     *
     * @return
     */
    @RequestMapping( value = ("/dayDosageDataList") )
    @ResponseBody
    public VenusResponse<List<DaMpDayDosageData>> dayDosageDataList(DaMpMultiRawQuery daMpMultiRawQuery) {
        DaMpQuery daMpQuery = daMpMultiRawQuery.parse();
        CommonUtils.dayTimeTypeNotApplicable(daMpQuery);
        List<DaMpDayDosageData> daMpDayDosageData = daMpDataService.queryMpDayDosageData(daMpQuery);

        return new VenusResponse(VenusResponseHttpCode.OK, DataGroupUtils.originalOrgroupByField(daMpDayDosageData,daMpQuery.getGroupBys()));
    }
//
    /**
     * 查询测点【日单条】抄表示数
     * @return
     */
    @RequestMapping( value = ("/dayReadingsData") )
    @ResponseBody
    public VenusResponse<DaMpDayReadingsData> dayReadingsData(DaMpSingleRawQuery daMpSingleRawQuery) {
        Assert.isEmpty(daMpSingleRawQuery.getMpId(), "测点标志不能为空");
        Assert.isEmpty(daMpSingleRawQuery.getIndBNo(), "指标编号不能为空");
        DaMpQuery daMpQuery = daMpSingleRawQuery.parse();
        List<DaMpDayReadingsData> daMpDayReadingsData = daMpDataService.queryMpDayReadingsData(daMpQuery);

        return new VenusResponse(VenusResponseHttpCode.OK, CommonUtils.getFirstList(daMpDayReadingsData));
    }

    /**
     * 查询测点【日多条】抄表示数
     * @return
     */
    @RequestMapping( value = ("/dayReadingsDataList") )
    @ResponseBody
    public VenusResponse<List<DaMpDayReadingsData> > dayReadingsDataList(DaMpMultiRawQuery daMpMultiRawQuery) {
        DaMpQuery daMpQuery = daMpMultiRawQuery.parse();
        CommonUtils.dayTimeTypeNotApplicable(daMpQuery);
        List<DaMpDayReadingsData> daMpDayReadingsData = daMpDataService.queryMpDayReadingsData(daMpQuery);

        return new VenusResponse(VenusResponseHttpCode.OK, DataGroupUtils.originalOrgroupByField(daMpDayReadingsData,daMpQuery.getGroupBys()));
    }

    /**
     *查询测点【月单条】数据
     *
     * @return
     */
    @RequestMapping( value = ("/monthData") )
    @ResponseBody
    public VenusResponse<DaMpMonthData> monthData(DaMpSingleRawQuery daMpSingleRawQuery) {
        Assert.isEmpty(daMpSingleRawQuery.getMpId(), "测点标志不能为空");
        Assert.isEmpty(daMpSingleRawQuery.getIndBNo(), "指标编号不能为空");
        DaMpQuery daMpQuery = daMpSingleRawQuery.parse();

        List<DaMpMonthData> daMpMonthData = daMpDataService.queryMpMonthData(daMpQuery);

        return new VenusResponse(VenusResponseHttpCode.OK, CommonUtils.getFirstList(daMpMonthData));
    }
    /**
     * 查询测点【月多条】数据
     * @return
     */
    @RequestMapping( value = ("/monthDataList") )
    @ResponseBody
    public VenusResponse<List<DaMpMonthData> > monthDataList(DaMpMultiRawQuery daMpMultiRawQuery) {
        DaMpQuery daMpQuery = daMpMultiRawQuery.parse();
        CommonUtils.monthTimeTypeNotApplicable(daMpQuery);
        List<DaMpMonthData> daMpMonthData = daMpDataService.queryMpMonthData(daMpQuery);

        return new VenusResponse(VenusResponseHttpCode.OK, DataGroupUtils.originalOrgroupByField(daMpMonthData,daMpQuery.getGroupBys()));
    }

    /**
     *查询测点【月单条】用量数据
     * @return
     */
    @RequestMapping( value = ("/monthDosageData") )
    @ResponseBody
    public VenusResponse<DaMpMonthDosageData> monthDosageData(DaMpSingleRawQuery daMpSingleRawQuery) {
        Assert.isEmpty(daMpSingleRawQuery.getMpId(), "测点标志不能为空");
        Assert.isEmpty(daMpSingleRawQuery.getIndBNo(), "指标编号不能为空");
        DaMpQuery daMpQuery = daMpSingleRawQuery.parse();
        List<DaMpMonthDosageData> daMpMonthDosageData = daMpDataService.queryMpMonthDosageData(daMpQuery);

        return new VenusResponse(VenusResponseHttpCode.OK, CommonUtils.getFirstList(daMpMonthDosageData));
    }

    /**
     * 查询测点【月多条】用量数据
     * @return
     */
    @RequestMapping( value = ("/monthDosageDataList") )
    @ResponseBody
    public VenusResponse<List<DaMpMonthDosageData> > monthDosageDataList(DaMpMultiRawQuery daMpMultiRawQuery) {
        DaMpQuery daMpQuery = daMpMultiRawQuery.parse();
        CommonUtils.monthTimeTypeNotApplicable(daMpQuery);
        List<DaMpMonthDosageData> daMpMonthDosageData = daMpDataService.queryMpMonthDosageData(daMpQuery);

        return new VenusResponse(VenusResponseHttpCode.OK, DataGroupUtils.originalOrgroupByField(daMpMonthDosageData,daMpQuery.getGroupBys()));
    }

    /**
     *查询测点【月单条】抄表示数
     * @return
     */
    @RequestMapping( value = ("/monthReadings") )
    @ResponseBody
    public VenusResponse<DaMpMonthReadingsData> monthReadings(DaMpSingleRawQuery daMpSingleRawQuery) {
        Assert.isEmpty(daMpSingleRawQuery.getMpId(), "测点标志不能为空");
        Assert.isEmpty(daMpSingleRawQuery.getIndBNo(), "指标编号不能为空");
        DaMpQuery daMpQuery = daMpSingleRawQuery.parse();
        List<DaMpMonthReadingsData> daMpMonthReadingsData = daMpDataService.queryMpMonthReadingsData(daMpQuery);
        return new VenusResponse(VenusResponseHttpCode.OK, CommonUtils.getFirstList(daMpMonthReadingsData));
    }

    /**
     * 查询测点【月多条】抄表示数
     * @return
     */
    @RequestMapping( value = ("/monthReadingsList") )
    @ResponseBody
    public VenusResponse<List<DaMpMonthReadingsData> > monthReadingsList(DaMpMultiRawQuery daMpMultiRawQuery) {
        DaMpQuery daMpQuery = daMpMultiRawQuery.parse();
        CommonUtils.monthTimeTypeNotApplicable(daMpQuery);
        List<DaMpMonthReadingsData> daMpMonthReadingsData = daMpDataService.queryMpMonthReadingsData(daMpQuery);

        return new VenusResponse(VenusResponseHttpCode.OK, DataGroupUtils.originalOrgroupByField(daMpMonthReadingsData,daMpQuery.getGroupBys()));
    }

}
