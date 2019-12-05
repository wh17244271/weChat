package com.suypower.venus.elec.common.controller;

import com.suypower.venus.elec.common.common.Index;
import com.suypower.venus.elec.common.common.UnitType;
import com.suypower.venus.elec.common.entity.DaUnitMonthDosageData;
import com.suypower.venus.elec.common.service.IDaConsDataService;
import com.suypower.venus.elec.common.service.IDaMpDataService;
import com.suypower.venus.elec.common.service.IDaUnitDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/daOrgData")
public class DaOrgDataController {

    @Autowired
    private IDaConsDataService daConsDataService;
    @Autowired
    private IDaMpDataService daMpDataService;
    @Autowired
    private IDaUnitDataService daUnitDataService;

    @RequestMapping("/queryConsDayData")
    @ResponseBody
    public <T>T queryConsDayData(HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        String consNo = "0108333074";
        UnitType[] unitTypes = UnitType.list(UnitType.USER, UnitType.BUILDING);
        LocalDate[] dates = {LocalDate.of(2019, 03, 01), LocalDate.of(2019, 03, 2)};
        Index[] indexes = {Index.Ia, Index.SPZW, Index.P}; //01010001
        String[] dateMonth = {"2019-3", "2019-4"};
        String mpId = "545725286877028354";
        String unitId = "550312560935587842";

//        List<DaConsDayData> daConsDayData = daConsDataService.queryConsDayData(consNo, dates,unitTypes , indexes);
//        List<DaConsDayMostData> daConsDayMostData = daConsDataService.queryConsDayMostData(consNo, dates, unitTypes, indexes);
//        List<DaConsMonthData> daConsMonthData = daConsDataService.queryConsMonthData(consNo, dateMonth, unitTypes, indexes);
//        List<DaConsDayDosageData> daConsDayDosageData = daConsDataService.queryConsDayDosageData(consNo, dates, unitTypes, indexes);
//        List<DaConsMonthDosageData> daConsMonthDosageData = daConsDataService.queryConsMonthDosageData("0108333074", dateMonth, unitTypes, indexes);




//        List<DaMpDayData> daMpDayData = daMpDataService.queryMpDayData(mpId, dates, indexes);
//        List<DaMpDayData> daMpDayData = daMpDataService.queryMpDayData(mpId, dates, indexes);
//        List<DaMpDayMostData> daMpDayMostData = daMpDataService.queryMpDayMostData(mpId, dates, indexes);
//        List<DaMpDayReadingsData> daMpDayReadingsData = daMpDataService.queryMpDayReadingsData("545725286877028354", dates, indexes);

//        List<DaMpDayDosageData> daMpDayDosageData = daMpDataService.queryMpDayDosageData("545725286877028354", dates, indexes);
//        List<DaMpMonthData> daMpMonthData = daMpDataService.queryMpMonthData(mpId, dateMonth, indexes);
//        List<DaMpMonthReadingsData> daMpMonthReadingsData = daMpDataService.queryMpMonthReadingsData(mpId, dateMonth, indexes);
//        List<DaMpMonthDosageData> daMpMonthDosageData = daMpDataService.queryMpMonthDosageData(mpId, dateMonth, indexes);
//        List<DaMpDayData> daMpDayData = daMpDataService.queryMpDayDataByCons(consNo, dates, indexes);
//        List<DaMpDayMostData> daMpDayMostData = daMpDataService.queryMpDayMostDataByCons(consNo, dates, indexes);

//        List<DaMpDayReadingsData> daMpDayReadingsData = daMpDataService.queryMpDayReadingsDataByCons(consNo, dates, indexes);
//        List<DaMpDayDosageData> daMpDayDosageData = daMpDataService.queryMpDayDosageDataByCons(consNo, dates, indexes);
//        List<DaMpMonthData> daMpMonthData = daMpDataService.queryMpMonthDataByCons(consNo, dateMonth, indexes);
//        List<DaMpMonthReadingsData> daMpMonthReadingsData = daMpDataService.queryMpMonthReadingsDataByCons(consNo, dateMonth, indexes);
//        List<DaMpMonthDosageData> daMpMonthDosageData = daMpDataService.queryMpMonthDosageDataByCons(consNo, dateMonth, indexes);
//        List<DaMpDayData> daMpDayData = daMpDataService.queryMpDayDataByUnit(unitId, dates, indexes);
//        List<DaMpDayReadingsData> daMpDayReadingsData = daMpDataService.queryMpDayReadingsDataByUnit(unitId, dates, indexes);
//        List<DaMpDayMostData> daMpDayMostData = daMpDataService.queryMpDayMostDataByUnit(unitId, dates, indexes);
//        List<DaMpDayDosageData> daMpDayDosageData = daMpDataService.queryMpDayDosageDataByUnit(unitId, dates, indexes);
//        List<DaMpMonthData> daMpMonthData = daMpDataService.queryMpMonthDataByUnit(unitId, dateMonth, indexes);
//        List<DaMpMonthReadingsData> daMpMonthReadingsData = daMpDataService.queryMpMonthReadingsDataByUnit(unitId, dateMonth, indexes);
//        List<DaMpMonthDosageData> daMpMonthDosageData = daMpDataService.queryMpMonthDosageDataByUnit(unitId, dateMonth, indexes);
//        List<DaUnitDayData> daUnitDayData = daUnitDataService.queryUnitDayData(unitId, dates, indexes);
//        List<DaUnitDayMostData> daUnitDayMostData = daUnitDataService.queryUnitDayMostData(unitId, dates, indexes);
//        List<DaUnitDayDosageData> daUnitDayDosageData = daUnitDataService.queryUnitDayDosageData(unitId, dates, indexes);
//        List<DaUnitMonthData> daUnitMonthData = daUnitDataService.queryUnitMonthData(unitId, dateMonth, indexes);
//        List<DaUnitMonthDosageData> daUnitMonthDosageData = daUnitDataService.queryUnitMonthDosageData(unitId, dateMonth, indexes);
//        List<DaUnitDayData> daUnitDayData = daUnitDataService.queryUnitDayDataByCons(consNo, dates, unitTypes, indexes);
//        List<DaUnitDayMostData> daUnitDayMostData = daUnitDataService.queryUnitDayMostDataByCons(consNo, dates, unitTypes, indexes);
//        List<DaUnitDayDosageData> daUnitDayDosageData = daUnitDataService.queryUnitDayDosageDataByCons(consNo, dates, unitTypes, indexes);

//        List<DaUnitMonthData> daUnitMonthData = daUnitDataService.queryUnitMonthDataByCons(consNo, dateMonth, unitTypes, indexes);
        List<DaUnitMonthDosageData> daUnitMonthDosageData = daUnitDataService.queryUnitMonthDosageDataByCons(consNo, dateMonth, unitTypes, indexes);


        return (T)daUnitMonthDosageData;
    }

}
