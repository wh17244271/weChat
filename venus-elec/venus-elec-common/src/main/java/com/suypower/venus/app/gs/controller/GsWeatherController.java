package com.suypower.venus.app.gs.controller;

import com.suypower.venus.app.gs.entity.GsWeatherDay;
import com.suypower.venus.app.gs.service.IGsWeatherService;
import com.suypower.venus.elec.common.utils.CommonUtils;
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
@RequestMapping("/app/gs/weather")
public class GsWeatherController extends BaseController {
static String cityId = "101190101";
    @Autowired
    private IGsWeatherService gsWeatherService;

    /**
     * 获取当天气象数据(自动获取用户对应的城市或行政区划码)查询对应的气象数据
     * @return
     */
    @RequestMapping( value = ("/today") )
    @ResponseBody
    public VenusResponse<?> today() {


        List<GsWeatherDay> gsWeatherDays = gsWeatherService.queryOne("", cityId, LocalDate.now());
        return new VenusResponse(VenusResponseHttpCode.OK, CommonUtils.getFirstList(gsWeatherDays));
    }

    @RequestMapping( value = ("/week") )
    @ResponseBody
    public VenusResponse<?> week() {
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(6);

        List<GsWeatherDay> gsWeatherDays = gsWeatherService.queryList("", cityId, startDate, endDate);
        return new VenusResponse(VenusResponseHttpCode.OK, gsWeatherDays);
    }


    @RequestMapping( value = ("/update") )
    @ResponseBody
    public VenusResponse<?> update() {
        boolean update = gsWeatherService.update(null);
        return new VenusResponse(VenusResponseHttpCode.OK, update);
    }





}
