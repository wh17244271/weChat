package com.suypower.venus.app.gs.service;

import com.suypower.venus.app.gs.entity.GsWeatherDay;

import java.time.LocalDate;
import java.util.List;

/**
 * @auther:maofukai
 * @date:2019-08-15 综合服务-天气预报
 */
public interface IGsWeatherService {

    /**
     * 更新气象数据
     * 如果数据库不存在则新增,存在则进行更新
     * @param gsWeatherDay
     * @return
     */
    boolean update(GsWeatherDay gsWeatherDay);


    /**
     * 查询某天气象数据
     * @param orgNo   行政区划码(行政区划码|城市编号 参数必须存在一个)
     * @param cityId  城市编号(行政区划码|城市编号 参数必须存在一个)
     * @param wtDate  气象日期
     * @return
     */
    List<GsWeatherDay> queryOne(String orgNo, String cityId, LocalDate wtDate);


    /**
     * 查询某一段日期内的气象数据
     * @param orgNo   行政区划码(行政区划码|城市编号 参数必须存在一个)
     * @param cityId  城市编号(行政区划码|城市编号 参数必须存在一个)
     * @param startWtDate 气象开始日期(大于等于)
     * @param endWtDate   气象结束日期(小于等于)
     * @return
     */
    List<GsWeatherDay> queryList(String orgNo, String cityId, LocalDate startWtDate,LocalDate endWtDate);
}
