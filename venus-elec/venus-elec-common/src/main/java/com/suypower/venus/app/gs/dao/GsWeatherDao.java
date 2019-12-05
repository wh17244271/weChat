package com.suypower.venus.app.gs.dao;


import com.suypower.venus.app.gs.entity.GsWeatherDay;
import com.suypower.venus.app.gs.entity.GsWeatherHour;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

public interface GsWeatherDao {

    /**
     * 更新气象数据(天)
     * 如果数据库不存在则新增,存在则进行更新
     *
     * @param gsWeatherDay
     * @return
     */
    boolean updateWeatherDay(GsWeatherDay gsWeatherDay);

    /**
     * 更新气象数据(小时)
     * 如果数据库不存在则新增,存在则进行更新
     *
     * @param gsWeatherHour
     * @return
     */
    boolean updateWeatherHour(GsWeatherHour gsWeatherHour);

    /**
     * 新增气象数据(天)
     * 如果数据库不存在则新增,存在则进行更新
     *
     * @param gsWeatherDay
     * @return
     */
    boolean insertWeatherDay(GsWeatherDay gsWeatherDay);

    /**
     * 新增气象数据(小时)
     * 如果数据库不存在则新增,存在则进行更新
     *
     * @param gsWeatherHour
     * @return
     */
    boolean insertWeatherHour(GsWeatherHour gsWeatherHour);
    /**
     * 判断该城市这天是否存在
     * @param cityId
     * @param wtDate
     * @return
     */
    Integer existDay( @Param( "cityId" ) String cityId, @Param( "wtDate" ) LocalDate wtDate);

    /**
     * 判断该城市这天这个时间点是否存在
     * @param whHour
     * @param cityId
     * @param whDate
     * @return
     */
    Integer existDayTime(@Param( "whHour" ) String whHour, @Param( "cityId" ) String cityId, @Param( "whDate" ) LocalDate whDate);


    /**
     * 查询某天气象数据
     *
     * @param orgNo  行政区划码(行政区划码|城市编号 参数必须存在一个)
     * @param cityId 城市编号(行政区划码|城市编号 参数必须存在一个)
     * @param wtDate 气象日期
     * @return
     */
    List<GsWeatherDay> queryOne(@Param( "orgNo" ) String orgNo, @Param( "cityId" ) String cityId, @Param( "wtDate" ) LocalDate wtDate);


    /**
     * 查询某一段日期内的气象数据
     *
     * @param orgNo       行政区划码(行政区划码|城市编号 参数必须存在一个)
     * @param cityId      城市编号(行政区划码|城市编号 参数必须存在一个)
     * @param startWtDate 气象开始日期(大于等于)
     * @param endWtDate   气象结束日期(小于等于)
     * @return
     */
    List<GsWeatherDay> queryList(@Param( "orgNo" ) String orgNo, @Param( "cityId" ) String cityId,
                                 @Param( "startWtDate" ) LocalDate startWtDate, @Param( "endWtDate" ) LocalDate endWtDate);


}

