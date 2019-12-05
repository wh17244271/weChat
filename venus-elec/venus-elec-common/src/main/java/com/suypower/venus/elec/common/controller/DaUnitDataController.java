package com.suypower.venus.elec.common.controller;

import com.suypower.venus.elec.common.common.Index;
import com.suypower.venus.elec.common.entity.DaUnitDayData;
import com.suypower.venus.elec.common.service.IDaUnitDataService;
import com.suypower.venus.elec.common.utils.Assert;
import com.suypower.venus.elec.common.utils.Times;
import com.suypower.venus.platform.web.controller.BaseController;
import com.suypower.venus.platform.web.response.VenusResponse;
import com.suypower.venus.platform.web.response.VenusResponseHttpCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping( "/app/da/unit" )
public class DaUnitDataController extends BaseController {

    @Autowired
    private IDaUnitDataService daUnitDataService;

    /**
     * 查询单元【日单条】数据
     *
     * @param unitId     单元标志
     * @param dataDate   数据日期
     * @param indBNo     指标编号
     * @param pointCount 数据频度
     * @return
     */
    @RequestMapping( value = ("/dayData") )
    @ResponseBody
    public VenusResponse<DaUnitDayData> dayData(String unitId, String dataDate, String indBNo, String pointCount) {
        Assert.isEmpty(dataDate, "数据日期不能为空");
        Assert.isEmpty(indBNo, "指标编号不能为空");

        LocalDate[] localDates = Times.parseArray(dataDate);
        Index[] indexes = Index.parseOf(indBNo);

        List<DaUnitDayData> daUnitDayData = daUnitDataService.queryUnitDayData(unitId, localDates, indexes, pointCount);
        DaUnitDayData result = null;
        if (daUnitDayData.size() > 0) {
            result = daUnitDayData.get(0);
        }

        return new VenusResponse(VenusResponseHttpCode.OK, result);
    }

    /**
     * 查询单元【日多条】数据
     *
     * @param dataDate      数据日期
     * @param unitId        单元标志
     * @param indBNo        指标编号
     * @param dataDateCycle 数据周期
     * @param pointCount    数据频度
     * @return
     */
    @RequestMapping( value = ("/dayDataList") )
    @ResponseBody
    public VenusResponse<List<DaUnitDayData>> dayDataList(String unitId, String dataDate, String indBNo, String dataDateCycle, String pointCount) {
        String consNo = consNo(); //获取用户编号
        Assert.isEmpty(dataDate, "数据日期不能为空");
        LocalDate[] localDates = Times.parseArray(dataDate);
        Index[] indexes = Index.parseOf(indBNo);

        List<DaUnitDayData> daUnitDayData = daUnitDataService.queryUnitDayData(unitId, localDates, indexes, pointCount);


        return new VenusResponse(VenusResponseHttpCode.OK, daUnitDayData);
    }

}
