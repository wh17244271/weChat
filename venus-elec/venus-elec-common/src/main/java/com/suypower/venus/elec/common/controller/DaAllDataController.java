package com.suypower.venus.elec.common.controller;

import com.suypower.venus.app.cs.common.RelationTypeConstant;
import com.suypower.venus.app.cs.entity.CsObjectRelation;
import com.suypower.venus.app.cs.service.ICsObjectStrucureService;
import com.suypower.venus.elec.common.common.TimeType;
import com.suypower.venus.elec.common.common.exception.VenusResponseException;
import com.suypower.venus.elec.common.entity.*;
import com.suypower.venus.elec.common.query.DaAllMultiRawQuery;
import com.suypower.venus.elec.common.query.DaAllSingleRawQuery;
import com.suypower.venus.elec.common.query.DaConsQuery;
import com.suypower.venus.elec.common.query.DaMpQuery;
import com.suypower.venus.elec.common.service.IDaConsDataService;
import com.suypower.venus.elec.common.service.IDaMpDataService;
import com.suypower.venus.elec.common.utils.*;
import com.suypower.venus.platform.web.controller.BaseController;
import com.suypower.venus.platform.web.response.VenusResponse;
import com.suypower.venus.platform.web.response.VenusResponseHttpCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping( "/app/da/all" )
public class DaAllDataController extends BaseController {

    @Autowired
    private IDaMpDataService daMpDataService;
    @Autowired
    private IDaConsDataService daConsDataService;
    @Autowired
    private ICsObjectStrucureService csObjectStrucureService;
    /**
     * 查询测点【日单条】数据
     *
     * @return
     */
    @RequestMapping( value = ("/dayData") )
    @ResponseBody
    public VenusResponse<?> dayData(DaAllSingleRawQuery daAllSingleRawQuery) {

        Map<String, List<String>> typeMap = associationTypeJudgment(daAllSingleRawQuery);


        List<Object> result = new ArrayList<>();
        daAllSingleRawQuery.setRelationType(null);
        daAllSingleRawQuery.setRelationId(null);
        if(!StringUtils.isEmpty(typeMap.get(RelationTypeConstant.CONS_TYPE))){
            daAllSingleRawQuery.setRelationType(RelationTypeConstant.CONS_TYPE);
            daAllSingleRawQuery.setRelationId(consNo());
            Assert.isEmpty(daAllSingleRawQuery.getUnitTypeNo(), "单元编号不能为空");
            Assert.isEmpty(daAllSingleRawQuery.getIndBNo(), "指标编号不能为空");
            DaConsQuery parse = daAllSingleRawQuery.parse();
            parse.setConsNo(consNo());
            List<DaConsDayData> daConsDayData = daConsDataService.queryConsDayData(parse);
            result.add(CommonUtils.getFirstList(daConsDayData));

        }
        if(!StringUtils.isEmpty(typeMap.get(RelationTypeConstant.MP_TYPE))){
            Assert.isEmpty(daAllSingleRawQuery.getIndBNo(), "指标编号不能为空");
            daAllSingleRawQuery.setRelationType(RelationTypeConstant.MP_TYPE);
            daAllSingleRawQuery.setRelationIds((typeMap.get(RelationTypeConstant.MP_TYPE).toArray(new String[typeMap.get(RelationTypeConstant.MP_TYPE).size()])));
            DaMpQuery parse = daAllSingleRawQuery.parse();

            List<DaMpDayData> daMpDayData = daMpDataService.queryMpDayData(parse);
            result.add(CommonUtils.getFirstList(daMpDayData));
        }
        return new VenusResponse(VenusResponseHttpCode.OK, result);




    }

    /**
     * 查询测点【日多条】数据集合
     *
     * @return
     */
    @RequestMapping( value = ("/dayDataList") )
    @ResponseBody
    public VenusResponse<?> dayDataList(DaAllMultiRawQuery daAllMultiRawQuery) {

        Map<String, List<String>> typeMap = associationTypeJudgment(daAllMultiRawQuery);

        List<Object> result = new ArrayList<>();
        daAllMultiRawQuery.setRelationType(null);
        daAllMultiRawQuery.setRelationId(null);
        if(!StringUtils.isEmpty(typeMap.get(RelationTypeConstant.CONS_TYPE))){
            daAllMultiRawQuery.setRelationType(RelationTypeConstant.CONS_TYPE);
            daAllMultiRawQuery.setRelationId(consNo());

            List<DaConsDayData> daConsDayData = null;
            DaConsQuery parse = daAllMultiRawQuery.parse();
            parse.setConsNo(consNo());
            if (TimeType.Day.getTimeTypeNo().equals(daAllMultiRawQuery.getTimeType())) {
                daConsDayData = daConsDataService.queryConsDayData(parse);
            } else if (TimeType.Month.getTimeTypeNo().equals(daAllMultiRawQuery.getTimeType())) {
                daConsDayData = daConsDataService.queryConsDayDataByMonth(parse);
            } else {
                throw new VenusResponseException("请传递正确的日期类型");
            }
            result.add(DataGroupUtils.originalOrgroupByField(daConsDayData,parse.getGroupBys()));
        }

        if(!StringUtils.isEmpty(typeMap.get(RelationTypeConstant.MP_TYPE))){
            daAllMultiRawQuery.setRelationType(RelationTypeConstant.MP_TYPE);
            daAllMultiRawQuery.setRelationIds((typeMap.get(RelationTypeConstant.MP_TYPE).toArray(new String[typeMap.get(RelationTypeConstant.MP_TYPE).size()])));
            DaMpQuery parse = daAllMultiRawQuery.parse();
            CommonUtils.dayTimeTypeNotApplicable(parse);

            List<DaMpDayData> daMpDayData = daMpDataService.queryMpDayData(parse);
            result.add(DataGroupUtils.originalOrgroupByField(daMpDayData,parse.getGroupBys()));
        }
        return new VenusResponse(VenusResponseHttpCode.OK, result);


    }



    /**
     * 查询测点【日单条】最值数据
     *
     * @return
     */
    @RequestMapping( value = ("/dayMostData") )
    @ResponseBody
    public VenusResponse<?> dayMostData(DaAllSingleRawQuery daAllSingleRawQuery) {
        Map<String, List<String>> typeMap = associationTypeJudgment(daAllSingleRawQuery);

        List<Object> result = new ArrayList<>();
        daAllSingleRawQuery.setRelationType(null);
        daAllSingleRawQuery.setRelationId(null);
        if(!StringUtils.isEmpty(typeMap.get(RelationTypeConstant.CONS_TYPE))){
            daAllSingleRawQuery.setRelationType(RelationTypeConstant.CONS_TYPE);
            daAllSingleRawQuery.setRelationId(consNo());

            Assert.isEmpty(daAllSingleRawQuery.getUnitTypeNo(), "单元编号不能为空");
            Assert.isEmpty(daAllSingleRawQuery.getIndBNo(), "指标编号不能为空");
            DaConsQuery parse = daAllSingleRawQuery.parse();
            parse.setConsNo(consNo());

            List<DaConsDayMostData> daConsDayMostData = daConsDataService.queryConsDayMostData(parse);
            result.add(CommonUtils.getFirstList(daConsDayMostData));
        }

        if(!StringUtils.isEmpty(typeMap.get(RelationTypeConstant.MP_TYPE))){
            daAllSingleRawQuery.setRelationType(RelationTypeConstant.MP_TYPE);
            daAllSingleRawQuery.setRelationIds((typeMap.get(RelationTypeConstant.MP_TYPE).toArray(new String[typeMap.get(RelationTypeConstant.MP_TYPE).size()])));
            Assert.isEmpty(daAllSingleRawQuery.getIndBNo(), "指标编号不能为空");
            DaMpQuery parse = daAllSingleRawQuery.parse();
            List<DaMpDayMostData> daMpDayMostData = daMpDataService.queryMpDayMostData(parse);
            result.add(CommonUtils.getFirstList(daMpDayMostData));
        }

        return new VenusResponse(VenusResponseHttpCode.OK, result);
    }

    /**
     * 查询测点【日多条】最值数据
     *
     * @return
     */
    @RequestMapping( value = ("/dayMostDataList") )
    @ResponseBody
    public VenusResponse<?> dayMostDataList(DaAllMultiRawQuery daAllMultiRawQuery) {
        Map<String, List<String>> typeMap = associationTypeJudgment(daAllMultiRawQuery);

        List<Object> result = new ArrayList<>();
        daAllMultiRawQuery.setRelationType(null);
        daAllMultiRawQuery.setRelationId(null);
        if(!StringUtils.isEmpty(typeMap.get(RelationTypeConstant.CONS_TYPE))){
            daAllMultiRawQuery.setRelationType(RelationTypeConstant.CONS_TYPE);
            daAllMultiRawQuery.setRelationId(consNo());

            DaConsQuery parse = daAllMultiRawQuery.parse();
            parse.setConsNo(consNo());
            String timeType = daAllMultiRawQuery.getTimeType();
            List<DaConsDayMostData> daConsDayMostData = null;
            if (TimeType.Day.getTimeTypeNo().equals(timeType)) {
                daConsDayMostData = daConsDataService.queryConsDayMostData(parse);
            } else if (TimeType.Month.getTimeTypeNo().equals(timeType)) {
                daConsDayMostData = daConsDataService.queryConsDayMostDataByMonth(parse);
            } else {
                throw new VenusResponseException("请传递正确的日期类型");
            }
            result.add(DataGroupUtils.originalOrgroupByField(daConsDayMostData,parse.getGroupBys()));
        }

        if(!StringUtils.isEmpty(typeMap.get(RelationTypeConstant.MP_TYPE))){
            daAllMultiRawQuery.setRelationType(RelationTypeConstant.MP_TYPE);
            daAllMultiRawQuery.setRelationIds((typeMap.get(RelationTypeConstant.MP_TYPE).toArray(new String[typeMap.get(RelationTypeConstant.MP_TYPE).size()])));
            DaMpQuery parse = daAllMultiRawQuery.parse();
            CommonUtils.dayTimeTypeNotApplicable(parse);
            List<DaMpDayMostData> daMpDayMostData = daMpDataService.queryMpDayMostData(parse);
            result.add(DataGroupUtils.originalOrgroupByField(daMpDayMostData,parse.getGroupBys()));
        }
        return new VenusResponse(VenusResponseHttpCode.OK, result);


    }
//

    /**
     * 查询测点【日单条】用量数据
     *
     * @return
     */
    @RequestMapping( value = ("/dayDosageData") )
    @ResponseBody
    public VenusResponse<?> dayDosageData(DaAllSingleRawQuery daAllSingleRawQuery) {
        Map<String, List<String>> typeMap = associationTypeJudgment(daAllSingleRawQuery);

        List<Object> result = new ArrayList<>();
        daAllSingleRawQuery.setRelationType(null);
        daAllSingleRawQuery.setRelationId(null);
        if(!StringUtils.isEmpty(typeMap.get(RelationTypeConstant.CONS_TYPE))){
            daAllSingleRawQuery.setRelationType(RelationTypeConstant.CONS_TYPE);
            daAllSingleRawQuery.setRelationId(consNo());
            Assert.isEmpty(daAllSingleRawQuery.getUnitTypeNo(), "单元编号不能为空");
            Assert.isEmpty(daAllSingleRawQuery.getIndBNo(), "指标编号不能为空");
            DaConsQuery parse = daAllSingleRawQuery.parse();
            parse.setConsNo(consNo());
            List<DaConsDayDosageData> daConsDayDosageData = daConsDataService.queryConsDayDosageData(parse);

            result.add(CommonUtils.getFirstList(daConsDayDosageData));
        }

        if(!StringUtils.isEmpty(typeMap.get(RelationTypeConstant.MP_TYPE))){
            daAllSingleRawQuery.setRelationType(RelationTypeConstant.MP_TYPE);
            daAllSingleRawQuery.setRelationIds((typeMap.get(RelationTypeConstant.MP_TYPE).toArray(new String[typeMap.get(RelationTypeConstant.MP_TYPE).size()])));
            Assert.isEmpty(daAllSingleRawQuery.getIndBNo(), "指标编号不能为空");
            DaMpQuery parse = daAllSingleRawQuery.parse();

            List<DaMpDayDosageData> daMpDayDosageData = daMpDataService.queryMpDayDosageData(parse);

            result.add(CommonUtils.getFirstList(daMpDayDosageData));
        }
        return new VenusResponse(VenusResponseHttpCode.OK, result);


    }
//

    /**
     * 查询测点【日多条】用量数据
     *
     * @return
     */
    @RequestMapping( value = ("/dayDosageDataList") )
    @ResponseBody
    public VenusResponse<?> dayDosageDataList(DaAllMultiRawQuery daAllMultiRawQuery) {

        Map<String, List<String>> typeMap = associationTypeJudgment(daAllMultiRawQuery);

        List<Object> result = new ArrayList<>();
        daAllMultiRawQuery.setRelationType(null);
        daAllMultiRawQuery.setRelationId(null);
        if(!StringUtils.isEmpty(typeMap.get(RelationTypeConstant.CONS_TYPE))){
            daAllMultiRawQuery.setRelationType(RelationTypeConstant.CONS_TYPE);
            daAllMultiRawQuery.setRelationId(consNo());
            DaConsQuery parse = daAllMultiRawQuery.parse();
            parse.setConsNo(consNo());
            String timeType = daAllMultiRawQuery.getTimeType();

            List<DaConsDayDosageData> daConsDayDosageData = null;
            if (TimeType.Day.getTimeTypeNo().equals(timeType)) {
                daConsDayDosageData = daConsDataService.queryConsDayDosageData(parse);
            } else if (TimeType.Month.getTimeTypeNo().equals(timeType)) {
                daConsDayDosageData = daConsDataService.queryConsDayDosageDataByMonth(parse);
            } else {
                throw new VenusResponseException("请传递正确的日期类型");
            }
            result.add(DataGroupUtils.originalOrgroupByField(daConsDayDosageData,parse.getGroupBys()));
        }

        if(!StringUtils.isEmpty(typeMap.get(RelationTypeConstant.MP_TYPE))){
            daAllMultiRawQuery.setRelationType(RelationTypeConstant.MP_TYPE);
            daAllMultiRawQuery.setRelationIds((typeMap.get(RelationTypeConstant.MP_TYPE).toArray(new String[typeMap.get(RelationTypeConstant.MP_TYPE).size()])));

            DaMpQuery parse = daAllMultiRawQuery.parse();
            CommonUtils.dayTimeTypeNotApplicable(parse);
            List<DaMpDayDosageData> daMpDayDosageData = daMpDataService.queryMpDayDosageData(parse);
            result.add(DataGroupUtils.originalOrgroupByField(daMpDayDosageData,parse.getGroupBys()));
        }
        return new VenusResponse(VenusResponseHttpCode.OK, result);


    }
//
    /**
     * 查询测点【日单条】抄表示数
     * @return
     */
    @RequestMapping( value = ("/dayReadingsData") )
    @ResponseBody
    public VenusResponse<?> dayReadingsData(DaAllSingleRawQuery daAllSingleRawQuery) {
        Map<String, List<String>> typeMap = associationTypeJudgment(daAllSingleRawQuery);

        List<Object> result = new ArrayList<>();
        daAllSingleRawQuery.setRelationType(null);
        daAllSingleRawQuery.setRelationId(null);
//        if(!StringUtils.isEmpty(typeMap.get(RelationTypeConstant.CONS_TYPE))){
//            throw new VenusResponseException("关联类型不存在");
//        }

        if(!StringUtils.isEmpty(typeMap.get(RelationTypeConstant.MP_TYPE))){
            daAllSingleRawQuery.setRelationType(RelationTypeConstant.MP_TYPE);
            daAllSingleRawQuery.setRelationIds((typeMap.get(RelationTypeConstant.MP_TYPE).toArray(new String[typeMap.get(RelationTypeConstant.MP_TYPE).size()])));
            Assert.isEmpty(daAllSingleRawQuery.getIndBNo(), "指标编号不能为空");
            DaMpQuery parse = daAllSingleRawQuery.parse();
            List<DaMpDayReadingsData> daMpDayReadingsData = daMpDataService.queryMpDayReadingsData(parse);

            result.add(CommonUtils.getFirstList(daMpDayReadingsData));
        }
        return new VenusResponse(VenusResponseHttpCode.OK, result);


    }

    /**
     * 查询测点【日多条】抄表示数
     * @return
     */
    @RequestMapping( value = ("/dayReadingsDataList") )
    @ResponseBody
    public VenusResponse<?> dayReadingsDataList(DaAllMultiRawQuery daAllMultiRawQuery) {



        Map<String, List<String>> typeMap = associationTypeJudgment(daAllMultiRawQuery);

        List<Object> result = new ArrayList<>();
        daAllMultiRawQuery.setRelationType(null);
        daAllMultiRawQuery.setRelationId(null);
//        if(!StringUtils.isEmpty(typeMap.get(RelationTypeConstant.CONS_TYPE))){
//            throw new VenusResponseException("关联类型不存在");
//        }

        if(!StringUtils.isEmpty(typeMap.get(RelationTypeConstant.MP_TYPE))){
            daAllMultiRawQuery.setRelationType(RelationTypeConstant.MP_TYPE);
            daAllMultiRawQuery.setRelationIds((typeMap.get(RelationTypeConstant.MP_TYPE).toArray(new String[typeMap.get(RelationTypeConstant.MP_TYPE).size()])));
            DaMpQuery parse = daAllMultiRawQuery.parse();
            CommonUtils.dayTimeTypeNotApplicable(parse);
            List<DaMpDayReadingsData> daMpDayReadingsData = daMpDataService.queryMpDayReadingsData(parse);

            result.add(DataGroupUtils.originalOrgroupByField(daMpDayReadingsData,parse.getGroupBys()));
        }
        return new VenusResponse(VenusResponseHttpCode.OK, result);




    }

    /**
     *查询测点【月单条】数据
     *
     * @return
     */
    @RequestMapping( value = ("/monthData") )
    @ResponseBody
    public VenusResponse<?> monthData(DaAllSingleRawQuery daAllSingleRawQuery) {
        Map<String, List<String>> typeMap = associationTypeJudgment(daAllSingleRawQuery);

        List<Object> result = new ArrayList<>();
        daAllSingleRawQuery.setRelationType(null);
        daAllSingleRawQuery.setRelationId(null);
        if(!StringUtils.isEmpty(typeMap.get(RelationTypeConstant.CONS_TYPE))){
            daAllSingleRawQuery.setRelationType(RelationTypeConstant.CONS_TYPE);
            daAllSingleRawQuery.setRelationId(consNo());

            Assert.isEmpty(daAllSingleRawQuery.getUnitTypeNo(), "单元编号不能为空");
            Assert.isEmpty(daAllSingleRawQuery.getIndBNo(), "指标编号不能为空");
            DaConsQuery parse = daAllSingleRawQuery.parse();
            parse.setConsNo(consNo());
            List<DaConsMonthData> daConsMonthData = daConsDataService.queryConsMonthData(parse);
            result.add(CommonUtils.getFirstList(daConsMonthData));
        }

        if(!StringUtils.isEmpty(typeMap.get(RelationTypeConstant.MP_TYPE))){
            daAllSingleRawQuery.setRelationType(RelationTypeConstant.MP_TYPE);
            daAllSingleRawQuery.setRelationIds((typeMap.get(RelationTypeConstant.MP_TYPE).toArray(new String[typeMap.get(RelationTypeConstant.MP_TYPE).size()])));
            Assert.isEmpty(daAllSingleRawQuery.getIndBNo(), "指标编号不能为空");
            DaMpQuery parse = daAllSingleRawQuery.parse();

            List<DaMpMonthData> daMpMonthData = daMpDataService.queryMpMonthData(parse);

            result.add(CommonUtils.getFirstList(daMpMonthData));
        }
        return new VenusResponse(VenusResponseHttpCode.OK, result);

    }
    /**
     * 查询测点【月多条】数据
     * @return
     */
    @RequestMapping( value = ("/monthDataList") )
    @ResponseBody
    public VenusResponse<? > monthDataList(DaAllMultiRawQuery daAllMultiRawQuery) {

        Map<String, List<String>> typeMap = associationTypeJudgment(daAllMultiRawQuery);

        List<Object> result = new ArrayList<>();
        daAllMultiRawQuery.setRelationType(null);
        daAllMultiRawQuery.setRelationId(null);
        if(!StringUtils.isEmpty(typeMap.get(RelationTypeConstant.CONS_TYPE))){
            daAllMultiRawQuery.setRelationType(RelationTypeConstant.CONS_TYPE);
            daAllMultiRawQuery.setRelationId(consNo());
            DaConsQuery parse = daAllMultiRawQuery.parse();
            parse.setConsNo(consNo());
            String timeType = daAllMultiRawQuery.getTimeType();
            List<DaConsMonthData> daConsMonthData = null;
            if (TimeType.Month.getTimeTypeNo().equals(timeType)) {
                daConsMonthData = daConsDataService.queryConsMonthData(parse);
            } else if (TimeType.Year.getTimeTypeNo().equals(timeType)) {
                daConsMonthData = daConsDataService.queryConsMonthDataByYear(parse);
            } else {
                throw new VenusResponseException("请传递正确的日期类型");
            }
            result.add(DataGroupUtils.originalOrgroupByField(daConsMonthData,parse.getGroupBys()));
        }

        if(!StringUtils.isEmpty(typeMap.get(RelationTypeConstant.MP_TYPE))){
            daAllMultiRawQuery.setRelationType(RelationTypeConstant.MP_TYPE);
            daAllMultiRawQuery.setRelationIds((typeMap.get(RelationTypeConstant.MP_TYPE).toArray(new String[typeMap.get(RelationTypeConstant.MP_TYPE).size()])));
            DaMpQuery parse = daAllMultiRawQuery.parse();
            CommonUtils.monthTimeTypeNotApplicable(parse);
            List<DaMpMonthData> daMpMonthData = daMpDataService.queryMpMonthData(parse);


            result.add(DataGroupUtils.originalOrgroupByField(daMpMonthData,parse.getGroupBys()));
        }
        return new VenusResponse(VenusResponseHttpCode.OK, result);


    }

    /**
     *查询测点【月单条】用量数据
     * @return
     */
    @RequestMapping( value = ("/monthDosageData") )
    @ResponseBody
    public VenusResponse<?> monthDosageData(DaAllSingleRawQuery daAllSingleRawQuery) {
        Map<String, List<String>> typeMap = associationTypeJudgment(daAllSingleRawQuery);

        List<Object> result = new ArrayList<>();
        daAllSingleRawQuery.setRelationType(null);
        daAllSingleRawQuery.setRelationId(null);
        if(!StringUtils.isEmpty(typeMap.get(RelationTypeConstant.CONS_TYPE))){
            daAllSingleRawQuery.setRelationType(RelationTypeConstant.CONS_TYPE);
            daAllSingleRawQuery.setRelationId(consNo());

            Assert.isEmpty(daAllSingleRawQuery.getUnitTypeNo(), "单元编号不能为空");
            Assert.isEmpty(daAllSingleRawQuery.getIndBNo(), "指标编号不能为空");
            DaConsQuery parse = daAllSingleRawQuery.parse();
            parse.setConsNo(consNo());
            List<DaConsMonthDosageData> daConsMonthDosageData = daConsDataService.queryConsMonthDosageData(parse);
            result.add(CommonUtils.getFirstList(daConsMonthDosageData));
        }

        if(!StringUtils.isEmpty(typeMap.get(RelationTypeConstant.MP_TYPE))){
            daAllSingleRawQuery.setRelationType(RelationTypeConstant.MP_TYPE);
            daAllSingleRawQuery.setRelationIds((typeMap.get(RelationTypeConstant.MP_TYPE).toArray(new String[typeMap.get(RelationTypeConstant.MP_TYPE).size()])));

            Assert.isEmpty(daAllSingleRawQuery.getIndBNo(), "指标编号不能为空");
            DaMpQuery parse = daAllSingleRawQuery.parse();
            List<DaMpMonthDosageData> daMpMonthDosageData = daMpDataService.queryMpMonthDosageData(parse);

            result.add(CommonUtils.getFirstList(daMpMonthDosageData));
        }
        return new VenusResponse(VenusResponseHttpCode.OK, result);


    }

    /**
     * 查询测点【月多条】用量数据
     * @return
     */
    @RequestMapping( value = ("/monthDosageDataList") )
    @ResponseBody
    public VenusResponse<?> monthDosageDataList(DaAllMultiRawQuery daAllMultiRawQuery) {

        Map<String, List<String>> typeMap = associationTypeJudgment(daAllMultiRawQuery);

        List<Object> result = new ArrayList<>();
        daAllMultiRawQuery.setRelationType(null);
        daAllMultiRawQuery.setRelationId(null);
        if(!StringUtils.isEmpty(typeMap.get(RelationTypeConstant.CONS_TYPE))){
            daAllMultiRawQuery.setRelationType(RelationTypeConstant.CONS_TYPE);
            daAllMultiRawQuery.setRelationId(consNo());
            DaConsQuery parse = daAllMultiRawQuery.parse();
            parse.setConsNo(consNo());
            String timeType = daAllMultiRawQuery.getTimeType();

            List<DaConsMonthDosageData> daConsMonthDosageData = null;
            if (TimeType.Month.getTimeTypeNo().equals(timeType)) {
                daConsMonthDosageData = daConsDataService.queryConsMonthDosageData(parse);
            } else if (TimeType.Year.getTimeTypeNo().equals(timeType)) {
                daConsMonthDosageData = daConsDataService.queryConsMonthDosageDataByYear(parse);
            } else {
                throw new VenusResponseException("请传递正确的日期类型");
            }
            result.add(DataGroupUtils.originalOrgroupByField(daConsMonthDosageData,parse.getGroupBys()));
        }

        if(!StringUtils.isEmpty(typeMap.get(RelationTypeConstant.MP_TYPE))){
            daAllMultiRawQuery.setRelationType(RelationTypeConstant.MP_TYPE);
            daAllMultiRawQuery.setRelationIds((typeMap.get(RelationTypeConstant.MP_TYPE).toArray(new String[typeMap.get(RelationTypeConstant.MP_TYPE).size()])));

            DaMpQuery parse = daAllMultiRawQuery.parse();
            CommonUtils.monthTimeTypeNotApplicable(parse);
            List<DaMpMonthDosageData> daMpMonthDosageData = daMpDataService.queryMpMonthDosageData(parse);

            result.add(DataGroupUtils.originalOrgroupByField(daMpMonthDosageData,parse.getGroupBys()));
        }
        return new VenusResponse(VenusResponseHttpCode.OK, result);

    }

    /**
     *查询测点【月单条】抄表示数
     * @return
     */
    @RequestMapping( value = ("/monthReadings") )
    @ResponseBody
    public VenusResponse<?> monthReadings(DaAllSingleRawQuery daAllSingleRawQuery) {
        Map<String, List<String>> typeMap = associationTypeJudgment(daAllSingleRawQuery);

        List<Object> result = new ArrayList<>();
        daAllSingleRawQuery.setRelationType(null);
        daAllSingleRawQuery.setRelationId(null);
//        if(!StringUtils.isEmpty(typeMap.get(RelationTypeConstant.CONS_TYPE))){
//            throw new VenusResponseException("关联类型不存在");
//        }

        if(!StringUtils.isEmpty(typeMap.get(RelationTypeConstant.MP_TYPE))){
            daAllSingleRawQuery.setRelationType(RelationTypeConstant.MP_TYPE);
            daAllSingleRawQuery.setRelationIds((typeMap.get(RelationTypeConstant.MP_TYPE).toArray(new String[typeMap.get(RelationTypeConstant.MP_TYPE).size()])));

            Assert.isEmpty(daAllSingleRawQuery.getIndBNo(), "指标编号不能为空");
            DaMpQuery parse = daAllSingleRawQuery.parse();
            List<DaMpMonthReadingsData> daMpMonthReadingsData = daMpDataService.queryMpMonthReadingsData(parse);
            result.add(CommonUtils.getFirstList(daMpMonthReadingsData));
        }
        return new VenusResponse(VenusResponseHttpCode.OK, result);


    }

    /**
     * 查询测点【月多条】抄表示数
     * @return
     */
    @RequestMapping( value = ("/monthReadingsList") )
    @ResponseBody
    public VenusResponse<? > monthReadingsList(DaAllMultiRawQuery daAllMultiRawQuery ) {

        Map<String, List<String>> typeMap = associationTypeJudgment(daAllMultiRawQuery);

        List<Object> result = new ArrayList<>();
        daAllMultiRawQuery.setRelationType(null);
        daAllMultiRawQuery.setRelationId(null);
//        if(!StringUtils.isEmpty(typeMap.get(RelationTypeConstant.CONS_TYPE))){
//            throw new VenusResponseException("关联类型不存在");
//        }

        if(!StringUtils.isEmpty(typeMap.get(RelationTypeConstant.MP_TYPE))){
            daAllMultiRawQuery.setRelationType(RelationTypeConstant.MP_TYPE);
            daAllMultiRawQuery.setRelationIds((typeMap.get(RelationTypeConstant.MP_TYPE).toArray(new String[typeMap.get(RelationTypeConstant.MP_TYPE).size()])));

            DaMpQuery parse = daAllMultiRawQuery.parse();
            CommonUtils.monthTimeTypeNotApplicable(parse);
            List<DaMpMonthReadingsData> daMpMonthReadingsData = daMpDataService.queryMpMonthReadingsData(parse);

            result.add(DataGroupUtils.originalOrgroupByField(daMpMonthReadingsData,parse.getGroupBys()));
        }
        return new VenusResponse(VenusResponseHttpCode.OK, result);



    }

    /**
     * 关联类型判断 多条查询
     * @param daAllMultiRawQuery
     * @return
     */
    private  Map<String,List<String>> associationTypeJudgment(DaAllMultiRawQuery daAllMultiRawQuery) {
        Assert.isEmpty(daAllMultiRawQuery.getArcIds() ,"档案Id不能为空");
        List<CsObjectRelation> relations = csObjectStrucureService.getRelationIdByArcId(StringUtils.parseArray(daAllMultiRawQuery.getArcIds()));

        Map<String,List<String>> typeMap = new HashMap<>();
        List<String> mpList = new ArrayList<>();
        List<String> consList = new ArrayList<>();
        if(StringUtils.isEmpty(relations)){
            typeMap.put(RelationTypeConstant.CONS_TYPE,consList);
            typeMap.put(RelationTypeConstant.MP_TYPE,mpList);
            return typeMap;
        }

        for(CsObjectRelation relation:relations){
            String type = relation.getRelationType();
            Long id = relation.getRelationId();
            if(RelationTypeConstant.MP_TYPE.equals(type)){
                mpList.add(Types.String(id));
            }else if(RelationTypeConstant.CONS_TYPE.equals(type)){
                consList.add(Types.String(id));
            }
        }
        typeMap.put(RelationTypeConstant.CONS_TYPE,consList);
        typeMap.put(RelationTypeConstant.MP_TYPE,mpList);
        return typeMap;
    }

    /**
     * 关联类型判断 单条查询
     * @param daAllSingleRawQuery
     * @return
     */
    private Map<String,List<String>> associationTypeJudgment(DaAllSingleRawQuery daAllSingleRawQuery) {
        Assert.isEmpty(daAllSingleRawQuery.getArcIds() ,"档案Id不能为空");
        List<CsObjectRelation> relations = csObjectStrucureService.getRelationIdByArcId(StringUtils.parseArray(daAllSingleRawQuery.getArcIds()));
        Map<String,List<String>> typeMap = new HashMap<>();
        List<String> mpList = new ArrayList<>();
        List<String> consList = new ArrayList<>();
        if(StringUtils.isEmpty(relations)){
            typeMap.put(RelationTypeConstant.CONS_TYPE,consList);
            typeMap.put(RelationTypeConstant.MP_TYPE,mpList);
            return typeMap;
        }


        for(CsObjectRelation relation:relations){
            String type = relation.getRelationType();
            Long id = relation.getRelationId();
            if(RelationTypeConstant.MP_TYPE.equals(type)){
                mpList.add(Types.String(id));
            }else if(RelationTypeConstant.CONS_TYPE.equals(type)){
                consList.add(Types.String(id));
            }
        }
        typeMap.put(RelationTypeConstant.CONS_TYPE,consList);
        typeMap.put(RelationTypeConstant.MP_TYPE,mpList);
        return typeMap;
    }


}
