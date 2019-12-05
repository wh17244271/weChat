package com.suypower.venus.app.gs.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.suypower.venus.app.gs.entity.GsWeatherDay;
import com.suypower.venus.app.gs.entity.GsWeatherHour;
import com.suypower.venus.app.url.UrlConstant;
import com.suypower.venus.elec.common.utils.*;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 获取某个 城市的天气状况数据，数据格式是Json
 */
public class WeatherUtils {
    /**
     * 通过城市名称获取该城市的天气信息
     *
     * @return
     */

    public static String GetWeatherData(String cityid) {
        StringBuilder sb = new StringBuilder();
        ;
        try {
            String weatherUrl = UrlConstant.weatherUrl + cityid;
            URL url = new URL(weatherUrl);
            URLConnection conn = url.openConnection();
            InputStream is = conn.getInputStream();
            InputStreamReader isr = new InputStreamReader(is, "utf-8"); // 设置读取流的编码格式，自定义编码
            BufferedReader reader = new BufferedReader(isr);
            String line = null;
            while ((line = reader.readLine()) != null)
                sb.append(line + " ");
            reader.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();

    }


    /**
     * 将JSON格式数据进行解析 ，返回一个weather对象
     *
     * @return
     */
    public static List<GsWeatherDay> getWeather(String cityId) {
        String weatherInfobyJson = GetWeatherData(cityId);
        JSONObject dataOfJson = JSONObject.parseObject(weatherInfobyJson);
        if (dataOfJson == null || dataOfJson.size() == 0)
            return null;

        String errcode = dataOfJson.getString("errcode");
        if(!StringUtils.isEmpty(errcode))Assert.isFalse(false, dataOfJson.getString("errmsg"));
        List<GsWeatherDay> entityList = new ArrayList<>();


        //从json数据中提取数据
        String cityid = dataOfJson.getString("cityid");
        //接口返回的城市ID和需要查询的城市id不匹配
        Assert.isFalse(cityId.equals(cityid), "拉取城市数据失败");
        String city = dataOfJson.getString("city");
        String cityEn = dataOfJson.getString("cityEn");
        String country = dataOfJson.getString("country");
        String countryEn = dataOfJson.getString("countryEn");
        String data = dataOfJson.getString("data");
        String update_time = dataOfJson.getString("update_time");
        JSONArray jsonArray = JSONObject.parseArray(data);


        for (int i = 0; i < jsonArray.size(); i++) {

            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String day = (String) jsonObject.get("day");
            String date = (String) jsonObject.get("date");
            String week = (String) jsonObject.get("week");
            String wea = (String) jsonObject.get("wea");
            String wea_img = (String) jsonObject.get("wea_img");
            String air = Types.String(jsonObject.get("air"));
            String humidity = Types.String(jsonObject.get("humidity"));
            String air_level = (String) jsonObject.get("air_level");
            String air_tips = (String) jsonObject.get("air_tips");
            String tem1 = (String) jsonObject.get("tem1");
            String tem2 = (String) jsonObject.get("tem2");
            String tem = (String) jsonObject.get("tem");
            String win_speed = (String) jsonObject.get("win_speed");
            //警告
            JSONObject alarm = jsonObject.getJSONObject("alarm");
            String alarm_type = "";
            String alarm_level = "";
            String alarm_content = "";
            if (alarm != null) {
                alarm_type = alarm.getString("alarm_type");
                alarm_level = alarm.getString("alarm_level");
                alarm_content = alarm.getString("alarm_content");
            }

            //分向
            JSONArray wins = jsonObject.getJSONArray("win");
            String win = "";
            if (wins != null && wins.size() > 0) {
                win = (String) wins.get(0);
            }


            //取小时
            List<GsWeatherHour> hours = new ArrayList<>();
            JSONArray hoursJson = jsonObject.getJSONArray("hours");
            for (int j = 0; j < hoursJson.size(); j++) {
                JSONObject hour = hoursJson.getJSONObject(j);
                String day_wh = (String) hour.get("day");
                String wea_wh = (String) hour.get("wea");
                String tem_wh = (String) hour.get("tem");
                String win_wh = (String) hour.get("win");

                String win_speed_wh = (String) jsonObject.get("win_speed");
                GsWeatherHour gsWeatherHour = new GsWeatherHour();
                gsWeatherHour.setCityId(cityid);
                gsWeatherHour.setCityName(city);
                gsWeatherHour.setCityNamePinyin(cityEn);
                gsWeatherHour.setWhDate(LocalDate.parse(date, Times.defaultDateFormatter));
                gsWeatherHour.setWhWeek(week);
                gsWeatherHour.setWhHour(day_wh.substring(day_wh.indexOf("日")+1,day_wh.indexOf("日")+3));
                gsWeatherHour.setWhWeather(wea_wh);
                gsWeatherHour.setWhWeatherPinyin(PingYinUtils.getPingYin(wea_wh));
                gsWeatherHour.setWhTem(tem_wh);
                gsWeatherHour.setWhVTem(tem_wh.replace("℃", ""));
                gsWeatherHour.setWhWin(win_wh);
                gsWeatherHour.setWhWinSpeed(win_speed_wh);
                gsWeatherHour.setWhWinVSpeed(StringUtils.replaceWin(win_speed_wh));
                hours.add(gsWeatherHour);
            }

            GsWeatherDay gsWeatherDay = new GsWeatherDay();
            gsWeatherDay.setCityId(cityid);
            gsWeatherDay.setCityName(city);
            gsWeatherDay.setCityNamePinyin(cityEn);
            gsWeatherDay.setWtDate(LocalDate.parse(date, Times.defaultDateFormatter));
            gsWeatherDay.setWtWeek(week);
            gsWeatherDay.setWtWeather(wea);
            gsWeatherDay.setWtWeatherPinyin(PingYinUtils.getPingYin(wea));
            gsWeatherDay.setWtAir(air);
            gsWeatherDay.setWtAirLevel(air_level);
            gsWeatherDay.setWtAirTips(air_tips);
            gsWeatherDay.setWtHumidity(humidity);
            gsWeatherDay.setWtAlarmContent(alarm_content);
            gsWeatherDay.setWtAlarmLevel(alarm_level);
            gsWeatherDay.setWtAlarmType(alarm_type);
            gsWeatherDay.setWtTem(tem);
            gsWeatherDay.setWtTem1(tem1);
            gsWeatherDay.setWtTem2(tem2);
            gsWeatherDay.setWtVTem(tem.replace("℃", ""));
            gsWeatherDay.setWtVTem1(tem1.replace("℃", ""));
            gsWeatherDay.setWtVTem2(tem2.replace("℃", ""));
            gsWeatherDay.setWtWin(win);
            gsWeatherDay.setWtWinSpeed(win_speed);
            gsWeatherDay.setWtWinVSpeed(StringUtils.replaceWin(win_speed));
            gsWeatherDay.setWtUpdateTime(LocalDateTime.parse(update_time, Times.defaultDateTimeFormatter));

            gsWeatherDay.setHours(hours);
            entityList.add(gsWeatherDay);
        }

        return entityList;
    }

    public static void main(String[] args) {
        WeatherUtils.getWeather("101110101");
    }
}