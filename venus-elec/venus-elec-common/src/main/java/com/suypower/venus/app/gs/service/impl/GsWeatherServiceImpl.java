package com.suypower.venus.app.gs.service.impl;

import com.suypower.venus.app.gs.dao.GsWeatherDao;
import com.suypower.venus.app.gs.entity.GsWeatherDay;
import com.suypower.venus.app.gs.entity.GsWeatherHour;
import com.suypower.venus.app.gs.service.IGsWeatherService;
import com.suypower.venus.elec.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service( "gsWeatherService" )
public class GsWeatherServiceImpl implements IGsWeatherService {

    @Autowired
    private GsWeatherDao gsWeatherDao;

    /**
     * 更新气象数据
     * 如果数据库不存在则新增,存在则进行更新
     *
     * @param weatherDay
     * @return
     */
    @Override
    public boolean update(GsWeatherDay weatherDay) {

        boolean result = false;
        if (null != weatherDay) {
            //判断库里有没有这一天
            String cityId = weatherDay.getCityId();
            LocalDate wtDate = weatherDay.getWtDate();
            Integer integer = gsWeatherDao.existDay(cityId, wtDate);
            System.out.println(integer);
            if (integer > 0) {
                result = gsWeatherDao.updateWeatherDay(weatherDay);
            } else {
                result = gsWeatherDao.insertWeatherDay(weatherDay);
            }

            //操作小时
            List<GsWeatherHour> hours = weatherDay.getHours();
            if (!StringUtils.isEmpty(hours)) {
                for (GsWeatherHour weatherHour : hours) {
                    //判断小时是否存在
                    String whHour = weatherHour.getWhHour();
                    Integer num = gsWeatherDao.existDayTime(whHour, cityId, wtDate);
                    if (num > 0) {
                        result = gsWeatherDao.updateWeatherHour(weatherHour);
                    } else {
                        result = gsWeatherDao.insertWeatherHour(weatherHour);
                    }
                }
            }

        }
        return result;
    }

    /**
     * 查询某天气象数据
     *
     * @param orgNo  行政区划码(行政区划码|城市编号 参数必须存在一个)
     * @param cityId 城市编号(行政区划码|城市编号 参数必须存在一个)
     * @param wtDate 气象日期
     * @return
     */
    @Override
    public List<GsWeatherDay> queryOne(String orgNo, String cityId, LocalDate wtDate) {
        List<GsWeatherDay> gsWeatherDays = gsWeatherDao.queryOne(orgNo, cityId, wtDate);
        return gsWeatherDays;
    }

    /**
     * 查询某一段日期内的气象数据
     *
     * @param orgNo       行政区划码(行政区划码|城市编号 参数必须存在一个)
     * @param cityId      城市编号(行政区划码|城市编号 参数必须存在一个)
     * @param startWtDate 气象开始日期(大于等于)
     * @param endWtDate   气象结束日期(小于等于)
     * @return
     */
    @Override
    public List<GsWeatherDay> queryList(String orgNo, String cityId, LocalDate startWtDate, LocalDate endWtDate) {
        List<GsWeatherDay> gsWeatherDays = gsWeatherDao.queryList(orgNo, cityId, startWtDate, endWtDate);
        return gsWeatherDays;
    }
}
