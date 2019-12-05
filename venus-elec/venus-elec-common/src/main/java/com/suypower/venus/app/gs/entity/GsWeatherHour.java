package com.suypower.venus.app.gs.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.suypower.venus.app.gs.common.Weather;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @auther:maofukai
 * @date:2019-07-29 通用服务-天气预报小时
 */
public class GsWeatherHour {

    /**
     * 行政区划码
     */
    private String orgNo;
    /**
     * 城市标识
     */
    private String cityId;
    /**
     * 城市名称
     */
    private String cityName;
    /**
     * 城市名称拼音
     */
    private String cityNamePinyin;
    /**
     * 天气日期(yyyy-MM-dd)
     */
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate whDate;
    /**
     * 天气星期(星期一,星期二,星期三,星期四,星期五,星期六,星期日)
     */
    private String whWeek;
    /**
     * 天气小时(hh)
     */
    private String whHour;
    /**
     * 小时天气
     */
    private String whWeather;
    /**
     * 小时天气拼音
     */
    private String whWeatherPinyin;
    /**
     * 小时温度
     */
    private String whTem;
    /**
     * 小时温度(无单位)
     */
    private String whVTem;
    /**
     * 小时风向
     */
    private String whWin;
    /**
     * 小时风速
     */
    private String whWinSpeed;
    /**
     * 小时风速(无单位)
     */
    private String whWinVSpeed;

    /**
     * 数据更新时间
     */
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private LocalDateTime wtUpdateTime;

    public String getOrgNo() {
        return orgNo;
    }

    public void setOrgNo(String orgNo) {
        this.orgNo = orgNo;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityNamePinyin() {
        return cityNamePinyin;
    }

    public void setCityNamePinyin(String cityNamePinyin) {
        this.cityNamePinyin = cityNamePinyin;
    }

    public LocalDate getWhDate() {
        return whDate;
    }

    public void setWhDate(LocalDate whDate) {
        this.whDate = whDate;
    }

    public String getWhWeek() {
        return whWeek;
    }

    public void setWhWeek(String whWeek) {
        this.whWeek = whWeek;
    }

    public String getWhHour() {
        return whHour;
    }

    public void setWhHour(String whHour) {
        this.whHour = whHour;
    }

    public String getWhWeather() {
        return whWeather;
    }

    public void setWhWeather(String whWeather) {
        this.whWeather = whWeather;
    }

    public String getWhWeatherPinyin() {
        return whWeatherPinyin;
    }

    public void setWhWeatherPinyin(String whWeatherPinyin) {
        this.whWeatherPinyin = whWeatherPinyin;
    }

    @JsonProperty("whWeatherIcon")
    public String getWhWeatherIcon( ){
        return  Weather.getWeatherNo(getWhWeather());
    }

    public String getWhTem() {
        return whTem;
    }

    public void setWhTem(String whTem) {
        this.whTem = whTem;
    }

    public String getWhVTem() {
        return whVTem;
    }

    public void setWhVTem(String whVTem) {
        this.whVTem = whVTem;
    }

    public String getWhWin() {
        return whWin;
    }

    public void setWhWin(String whWin) {
        this.whWin = whWin;
    }

    public String getWhWinSpeed() {
        return whWinSpeed;
    }

    public void setWhWinSpeed(String whWinSpeed) {
        this.whWinSpeed = whWinSpeed;
    }

    public String getWhWinVSpeed() {
        return whWinVSpeed;
    }

    public void setWhWinVSpeed(String whWinVSpeed) {
        this.whWinVSpeed = whWinVSpeed;
    }

    public LocalDateTime getWtUpdateTime() {
        return wtUpdateTime;
    }

    public void setWtUpdateTime(LocalDateTime wtUpdateTime) {
        this.wtUpdateTime = wtUpdateTime;
    }
}
