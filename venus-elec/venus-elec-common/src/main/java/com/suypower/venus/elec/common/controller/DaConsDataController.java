package com.suypower.venus.elec.common.controller;

import com.suypower.venus.elec.common.common.TimeType;
import com.suypower.venus.elec.common.common.exception.VenusResponseException;
import com.suypower.venus.elec.common.entity.*;
import com.suypower.venus.elec.common.query.DaConsMultiRawQuery;
import com.suypower.venus.elec.common.query.DaConsQuery;
import com.suypower.venus.elec.common.query.DaConsSingleRawQuery;
import com.suypower.venus.elec.common.service.IDaConsDataService;
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
@RequestMapping( value = ("/app/da/cons") )
public class DaConsDataController extends BaseController {

    @Autowired
    private IDaConsDataService daConsDataService;

    /**
     * 查询企业【日单条】数据
     *
     * @param daConsSingleRawQuery 企业查询原始对象(单个查询)
     * @return
     */
    @RequestMapping( value = ("/dayData") )
    @ResponseBody

    public VenusResponse<DaConsDayData> dayData(DaConsSingleRawQuery daConsSingleRawQuery) {
        String consNo = consNo(); //获取用户编号
        Assert.isEmpty(daConsSingleRawQuery.getUnitTypeNo(), "单元编号不能为空");
        Assert.isEmpty(daConsSingleRawQuery.getIndBNo(), "指标编号不能为空");
        DaConsQuery parse = daConsSingleRawQuery.parse();
        parse.setConsNo(consNo());
        List<DaConsDayData> daConsDayData = daConsDataService.queryConsDayData(parse);

        return new VenusResponse(VenusResponseHttpCode.OK, CommonUtils.getFirstList(daConsDayData));
    }


    /**
     * 查询企业【日多条】数据(日、周、月、年时间范围查询)
     *
     * @param daConsMultiRawQuery 企业查询原始对象(多个查询)
     * @return
     */
    @RequestMapping( value = ("/dayDataList") )
    @ResponseBody
    public VenusResponse<List<DaConsDayData>> dayDataList(DaConsMultiRawQuery daConsMultiRawQuery) {

        String consNo = consNo(); //获取用户编号

        List<DaConsDayData> daConsDayData = null;
        DaConsQuery parse = daConsMultiRawQuery.parse();
        parse.setConsNo(consNo());
        if (TimeType.Day.getTimeTypeNo().equals(daConsMultiRawQuery.getTimeType())) {
            daConsDayData = daConsDataService.queryConsDayData(parse);
        } else if (TimeType.Month.getTimeTypeNo().equals(daConsMultiRawQuery.getTimeType())) {
            daConsDayData = daConsDataService.queryConsDayDataByMonth(parse);
        } else {
            throw new VenusResponseException("请传递正确的日期类型");
        }

        return new VenusResponse(VenusResponseHttpCode.OK, DataGroupUtils.originalOrgroupByField(daConsDayData,parse.getGroupBys()));

    }

    /**
     * 查询企业【日单条】最值数据
     *
     * @return
     */
    @RequestMapping( value = ("/dayMostData") )
    @ResponseBody
    public VenusResponse<DaConsDayMostData> dayMostData(DaConsSingleRawQuery daConsSingleRawQuery) {
        String consNo = consNo(); //获取用户编号
        Assert.isEmpty(daConsSingleRawQuery.getUnitTypeNo(), "单元编号不能为空");
        Assert.isEmpty(daConsSingleRawQuery.getIndBNo(), "指标编号不能为空");
        DaConsQuery parse = daConsSingleRawQuery.parse();
        parse.setConsNo(consNo());

        List<DaConsDayMostData> daConsDayMostData = daConsDataService.queryConsDayMostData(parse);
        return new VenusResponse(VenusResponseHttpCode.OK, CommonUtils.getFirstList(daConsDayMostData));

    }


    /**
     * 查询企业【日多条】最值数据(日、周、月、年时间范围查询)
     *
     * @return
     */
    @RequestMapping( value = ("/dayMostDataList") )
    @ResponseBody
    public VenusResponse<List<DaConsDayMostData>> dayMostDataList(DaConsMultiRawQuery daConsMultiRawQuery) {
        String consNo = consNo(); //获取用户编号
        DaConsQuery parse = daConsMultiRawQuery.parse();
        parse.setConsNo(consNo());
        String timeType = daConsMultiRawQuery.getTimeType();
        List<DaConsDayMostData> daConsDayMostData = null;
        if (TimeType.Day.getTimeTypeNo().equals(timeType)) {
            daConsDayMostData = daConsDataService.queryConsDayMostData(parse);
        } else if (TimeType.Month.getTimeTypeNo().equals(timeType)) {
            daConsDayMostData = daConsDataService.queryConsDayMostDataByMonth(parse);
        } else {
            throw new VenusResponseException("请传递正确的日期类型");
        }
        return new VenusResponse(VenusResponseHttpCode.OK, DataGroupUtils.originalOrgroupByField(daConsDayMostData,parse.getGroupBys()));

    }


    /**
     * 查询企业【日单条】用量数据
     *
     * @return
     */
    @RequestMapping( value = ("/dayDosageData") )
    @ResponseBody
    public VenusResponse<DaConsDayDosageData> dayDosageData(DaConsSingleRawQuery daConsSingleRawQuery) {
        String consNo = consNo(); //获取用户编号
        Assert.isEmpty(daConsSingleRawQuery.getUnitTypeNo(), "单元编号不能为空");
        Assert.isEmpty(daConsSingleRawQuery.getIndBNo(), "指标编号不能为空");
        DaConsQuery parse = daConsSingleRawQuery.parse();
        parse.setConsNo(consNo());
        List<DaConsDayDosageData> daConsDayDosageData = daConsDataService.queryConsDayDosageData(parse);

        return new VenusResponse(VenusResponseHttpCode.OK, CommonUtils.getFirstList(daConsDayDosageData));
    }


    /**
     * 查询企业【日多条】用量数据(日、周、月、年时间范围查询)
     *
     * @return
     */
    @RequestMapping( value = ("/dayDosageDataList") )
    @ResponseBody
    public VenusResponse<List<DaConsDayDosageData>> dayDosageDataList(DaConsMultiRawQuery daConsMultiRawQuery) {
        String consNo = consNo(); //获取用户编号
        DaConsQuery parse = daConsMultiRawQuery.parse();
        parse.setConsNo(consNo());
        String timeType = daConsMultiRawQuery.getTimeType();

        List<DaConsDayDosageData> daConsDayDosageData = null;
        if (TimeType.Day.getTimeTypeNo().equals(timeType)) {
            daConsDayDosageData = daConsDataService.queryConsDayDosageData(parse);
        } else if (TimeType.Month.getTimeTypeNo().equals(timeType)) {
            daConsDayDosageData = daConsDataService.queryConsDayDosageDataByMonth(parse);
        } else {
            throw new VenusResponseException("请传递正确的日期类型");
        }

        return new VenusResponse(VenusResponseHttpCode.OK, DataGroupUtils.originalOrgroupByField(daConsDayDosageData,parse.getGroupBys()));
    }

    /**
     * 查询企业【月单条】数据
     *
     * @return
     */
    @RequestMapping( value = ("/monthData") )
    @ResponseBody
    public VenusResponse<DaConsMonthData> monthData(DaConsSingleRawQuery daConsSingleRawQuery) {
        String consNo = consNo(); //获取用户编号
        Assert.isEmpty(daConsSingleRawQuery.getUnitTypeNo(), "单元编号不能为空");
        Assert.isEmpty(daConsSingleRawQuery.getIndBNo(), "指标编号不能为空");
        DaConsQuery parse = daConsSingleRawQuery.parse();
        parse.setConsNo(consNo());
        List<DaConsMonthData> daConsMonthData = daConsDataService.queryConsMonthData(parse);

        return new VenusResponse(VenusResponseHttpCode.OK, CommonUtils.getFirstList(daConsMonthData));
    }


    /**
     * 查询企业【月多条】数据(月、年时间范围查询)
     *
     * @return
     */
    @RequestMapping( value = ("/monthDataList") )
    @ResponseBody
    public VenusResponse<List<DaConsMonthData>> monthDataList(DaConsMultiRawQuery daConsMultiRawQuery) {
        String consNo = consNo(); //获取用户编号
        DaConsQuery parse = daConsMultiRawQuery.parse();
        parse.setConsNo(consNo());
        String timeType = daConsMultiRawQuery.getTimeType();
        List<DaConsMonthData> daConsMonthData = null;
        if (TimeType.Month.getTimeTypeNo().equals(timeType)) {
            daConsMonthData = daConsDataService.queryConsMonthData(parse);
        } else if (TimeType.Year.getTimeTypeNo().equals(timeType)) {
            daConsMonthData = daConsDataService.queryConsMonthDataByYear(parse);
        } else {
            throw new VenusResponseException("请传递正确的日期类型");
        }

        return new VenusResponse(VenusResponseHttpCode.OK, DataGroupUtils.originalOrgroupByField(daConsMonthData,parse.getGroupBys()));
    }

    /**
     * 查询企业【月单条】用量数据
     * @return
     */
    @RequestMapping( value = ("/monthDosageData") )
    @ResponseBody
    public VenusResponse<DaConsMonthDosageData> monthDosageData(DaConsSingleRawQuery daConsSingleRawQuery) {
        String consNo = consNo(); //获取用户编号
        Assert.isEmpty(daConsSingleRawQuery.getUnitTypeNo(), "单元编号不能为空");
        Assert.isEmpty(daConsSingleRawQuery.getIndBNo(), "指标编号不能为空");
        DaConsQuery parse = daConsSingleRawQuery.parse();
        parse.setConsNo(consNo());
        List<DaConsMonthDosageData> daConsMonthDosageData = daConsDataService.queryConsMonthDosageData(parse);

        return new VenusResponse(VenusResponseHttpCode.OK, CommonUtils.getFirstList(daConsMonthDosageData));
    }


    /**
     * 查询企业【月多条】用量数据(月、年时间范围查询)
     *
     * @return
     */
    @RequestMapping( value = ("/monthDosageDataList") )
    @ResponseBody
    public VenusResponse<List<DaConsMonthDosageData>> monthDosageDataList(DaConsMultiRawQuery daConsMultiRawQuery) {
        String consNo = consNo(); //获取用户编号
        DaConsQuery parse = daConsMultiRawQuery.parse();
        parse.setConsNo(consNo());
        String timeType = daConsMultiRawQuery.getTimeType();

        List<DaConsMonthDosageData> daConsMonthDosageData = null;
        if (TimeType.Month.getTimeTypeNo().equals(timeType)) {
            daConsMonthDosageData = daConsDataService.queryConsMonthDosageData(parse);
        } else if (TimeType.Year.getTimeTypeNo().equals(timeType)) {
            daConsMonthDosageData = daConsDataService.queryConsMonthDosageDataByYear(parse);
        } else {
            throw new VenusResponseException("请传递正确的日期类型");
        }

        return new VenusResponse(VenusResponseHttpCode.OK, DataGroupUtils.originalOrgroupByField(daConsMonthDosageData,parse.getGroupBys()));
    }


    /**
     * 获取统计企业用量数据(当日、当月、当年、上日、上月、上年)
     *
     * @return
     */
    @RequestMapping( value = ("/totalDosageData") )
    @ResponseBody
    public VenusResponse<DaConsTotalDosageData> totalDosageData(DaConsSingleRawQuery daConsSingleRawQuery) {
        Assert.isEmpty(daConsSingleRawQuery.getUnitTypeNo(), "单元编号不能为空");
        Assert.isEmpty(daConsSingleRawQuery.getIndBNo(), "指标编号不能为空");
        DaConsQuery parse = daConsSingleRawQuery.parse();
        parse.setConsNo(consNo());

        DaConsTotalDosageData daConsTotalDosageData = daConsDataService.queryConsTotalDosageData(parse);
        return new VenusResponse(VenusResponseHttpCode.OK, daConsTotalDosageData);
    }


}
