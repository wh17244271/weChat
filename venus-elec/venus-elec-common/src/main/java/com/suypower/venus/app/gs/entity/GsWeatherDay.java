package com.suypower.venus.app.gs.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.suypower.venus.app.gs.common.Weather;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @auther:maofukai
 * @date:2019-07-29 通用服务-天气预报
 */
public class GsWeatherDay {
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
     * 天气日期
     */
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate wtDate;
    /**
     * 天气星期(星期一,星期二,星期三,星期四,星期五,星期六,星期日)
     */
    private String wtWeek;
    /**
     * 天气信息
     */
    private String wtWeather;
    /**
     * 天气信息拼音
     */
    private String wtWeatherPinyin;
    /**
     * 空气质量
     */
    private String wtAir;
    /**
     * 空气质量等级
     */
    private String wtAirLevel;
    /**
     * 空气质量描述
     */
    private String wtAirTips;
    /**
     * 空气湿度
     */
    private String wtHumidity;
    /**
     * 预警类型
     */
    private String wtAlarmType;
    /**
     * 预警级别
     */
    private String wtAlarmLevel;
    /**
     * 预警信息
     */
    private String wtAlarmContent;
    /**
     * 高温/白天温度
     */
    private String wtTem1;
    /**
     * 低温/晚上温度
     */
    private String wtTem2;
    /**
     * 当前温度
     */
    private String wtTem;
    /**
     * 高温/白天温度(无单位)
     */
    private String wtVTem1;
    /**
     * 低温/晚上温度(无单位)
     */
    private String wtVTem2;
    /**
     * 当前温度(无单位)
     */
    private String wtVTem;
    /**
     * 风向
     */
    private String wtWin;
    /**
     * 风速
     */
    private String wtWinSpeed;
    /**
     * 风向(无单位)
     */
    private String wtWinVSpeed;
    /**
     * 数据更新时间
     */
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private LocalDateTime wtUpdateTime;
    /**
     * 生活指数
     */
//    private List<> wtWinVSpeed;
    /**
     * 小时天气信息
     */
    private List<GsWeatherHour> hours;

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

    public LocalDate getWtDate() {
        return wtDate;
    }

    public void setWtDate(LocalDate wtDate) {
        this.wtDate = wtDate;
    }

    public String getWtWeek() {
        return wtWeek;
    }

    public void setWtWeek(String wtWeek) {
        this.wtWeek = wtWeek;
    }

    public String getWtWeather() {
        return wtWeather;
    }

    public void setWtWeather(String wtWeather) {
        this.wtWeather = wtWeather;
    }

    public String getWtWeatherPinyin() {
        return wtWeatherPinyin;
    }

    public void setWtWeatherPinyin(String wtWeatherPinyin) {
        this.wtWeatherPinyin = wtWeatherPinyin;
    }

    @JsonProperty("wtWeatherIcon")
    public String getWtWeatherIcon( ){
        return Weather.getWeatherNo(getWtWeather());
    }

    public String getWtAir() {
        return wtAir;
    }

    public void setWtAir(String wtAir) {
        this.wtAir = wtAir;
    }

    public String getWtAirLevel() {
        return wtAirLevel;
    }

    public void setWtAirLevel(String wtAirLevel) {
        this.wtAirLevel = wtAirLevel;
    }

    public String getWtAirTips() {
        return wtAirTips;
    }

    public void setWtAirTips(String wtAirTips) {
        this.wtAirTips = wtAirTips;
    }

    public String getWtHumidity() {
        return wtHumidity;
    }

    public void setWtHumidity(String wtHumidity) {
        this.wtHumidity = wtHumidity;
    }

    public String getWtAlarmType() {
        return wtAlarmType;
    }

    public void setWtAlarmType(String wtAlarmType) {
        this.wtAlarmType = wtAlarmType;
    }

    public String getWtAlarmLevel() {
        return wtAlarmLevel;
    }

    public void setWtAlarmLevel(String wtAlarmLevel) {
        this.wtAlarmLevel = wtAlarmLevel;
    }

    public String getWtAlarmContent() {
        return wtAlarmContent;
    }

    public void setWtAlarmContent(String wtAlarmContent) {
        this.wtAlarmContent = wtAlarmContent;
    }

    public String getWtTem1() {
        return wtTem1;
    }

    public void setWtTem1(String wtTem1) {
        this.wtTem1 = wtTem1;
    }

    public String getWtTem2() {
        return wtTem2;
    }

    public void setWtTem2(String wtTem2) {
        this.wtTem2 = wtTem2;
    }

    public String getWtTem() {
        return wtTem;
    }

    public void setWtTem(String wtTem) {
        this.wtTem = wtTem;
    }

    public String getWtVTem1() {
        return wtVTem1;
    }

    public void setWtVTem1(String wtVTem1) {
        this.wtVTem1 = wtVTem1;
    }

    public String getWtVTem2() {
        return wtVTem2;
    }

    public void setWtVTem2(String wtVTem2) {
        this.wtVTem2 = wtVTem2;
    }

    public String getWtVTem() {
        return wtVTem;
    }

    public void setWtVTem(String wtVTem) {
        this.wtVTem = wtVTem;
    }

    public String getWtWin() {
        return wtWin;
    }

    public void setWtWin(String wtWin) {
        this.wtWin = wtWin;
    }

    public String getWtWinSpeed() {
        return wtWinSpeed;
    }

    public void setWtWinSpeed(String wtWinSpeed) {
        this.wtWinSpeed = wtWinSpeed;
    }

    public String getWtWinVSpeed() {
        return wtWinVSpeed;
    }

    public void setWtWinVSpeed(String wtWinVSpeed) {
        this.wtWinVSpeed = wtWinVSpeed;
    }

    public LocalDateTime getWtUpdateTime() {
        return wtUpdateTime;
    }

    public void setWtUpdateTime(LocalDateTime wtUpdateTime) {
        this.wtUpdateTime = wtUpdateTime;
    }

    public List<GsWeatherHour> getHours() {
        return hours;
    }

    public void setHours(List<GsWeatherHour> hours) {
        this.hours = hours;
    }
}
