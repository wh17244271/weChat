package com.suypower.venus.app.gs.common;

import com.suypower.venus.elec.common.utils.PingYinUtils;
import com.suypower.venus.elec.common.utils.StringUtils;
import com.suypower.venus.platform.share.entity.IEnum;

/**
 * @auther:maofukai
 * @date:2019-07-09 系统指标定义
 */
public enum Weather implements IEnum<String> {

    晴("晴", PingYinUtils.getPingYin("晴"),"00"),
    多云("多云",PingYinUtils.getPingYin("多云"), "01"),
    阴("阴",PingYinUtils.getPingYin("阴"), "02"),
    阵雨("阵雨",PingYinUtils.getPingYin("阵雨"), "03"),
    雷阵雨("雷阵雨",PingYinUtils.getPingYin("雷阵雨"), "04"),
    雷阵雨伴有冰雹("雷阵雨伴有冰雹",PingYinUtils.getPingYin("雷阵雨伴有冰雹"), "05"),
    雨夹雪("雨夹雪",PingYinUtils.getPingYin("雨夹雪"), "06"),
    小雨("小雨",PingYinUtils.getPingYin("小雨"), "07"),
    中雨("中雨",PingYinUtils.getPingYin("中雨"), "08"),
    大雨("大雨",PingYinUtils.getPingYin("大雨"), "09"),
    暴雨("暴雨",PingYinUtils.getPingYin("暴雨"), "10"),
    大暴雨("大暴雨",PingYinUtils.getPingYin("大暴雨"), "11"),
    特大暴雨("特大暴雨",PingYinUtils.getPingYin("特大暴雨"), "12"),
    阵雪("阵雪",PingYinUtils.getPingYin("阵雪"), "13"),
    小雪("小雪",PingYinUtils.getPingYin("小雪"), "14"),
    中雪("中雪",PingYinUtils.getPingYin("中雪"), "15"),
    大雪("大雪",PingYinUtils.getPingYin("大雪"), "16"),
    暴雪("暴雪",PingYinUtils.getPingYin("暴雪"), "17"),
    雾("雾",PingYinUtils.getPingYin("雾"), "18"),
    冻雨("冻雨",PingYinUtils.getPingYin("冻雨"), "19"),
    沙尘暴("沙尘暴",PingYinUtils.getPingYin("沙尘暴"), "20"),
    小雨转中雨("小雨转中雨",PingYinUtils.getPingYin("小雨转中雨"), "21"),
    中雨转大雨("中雨转大雨",PingYinUtils.getPingYin("中雨转大雨"), "22"),
    大雨转暴雨("大雨转暴雨",PingYinUtils.getPingYin("大雨转暴雨"), "23"),
    暴雨转大暴雨("暴雨转大暴雨",PingYinUtils.getPingYin("暴雨转大暴雨"), "24"),
    大暴雨转特大暴雨("大暴雨转特大暴雨",PingYinUtils.getPingYin("大暴雨转特大暴雨"), "25"),
    小雪转中雪("小雪转中雪",PingYinUtils.getPingYin("小雪转中雪"), "26"),
    中雪转大雪("中雪转大雪",PingYinUtils.getPingYin("中雪转大雪"), "27"),
    大雪转暴雪("大雪转暴雪",PingYinUtils.getPingYin("大雪转暴雪"), "28"),
    浮尘("浮尘",PingYinUtils.getPingYin("浮尘"), "29"),
    扬沙("扬沙",PingYinUtils.getPingYin("扬沙"), "30"),
    强沙尘暴("强沙尘暴",PingYinUtils.getPingYin("强沙尘暴"), "31"),
    霾("霾",PingYinUtils.getPingYin("霾"), "53")

    ;


    /**
     * 天气名字
     */
    private String weatherName;
    /**
     * 天气拼音
     */
    private String pingYin;

    /**
     * 天气序号
     */
    private String weatherNo;


     Weather(String weatherName, String pingYin, String weatherNo) {
        this.weatherName = weatherName;
         this.pingYin = pingYin;
        this.weatherNo = weatherNo;

    }

    public String getWeatherName() {
        return weatherName;
    }

    public void setWeatherName(String weatherName) {
        this.weatherName = weatherName;
    }

    public String getPingYin() {
        return pingYin;
    }

    public void setPingYin(String pingYin) {
        this.pingYin = pingYin;
    }

    public String getWeatherNo() {
        return weatherNo;
    }

    public void setWeatherNo(String weatherNo) {
        this.weatherNo = weatherNo;
    }

    /**
     * 通过天气名字转化天气枚举
     * @param weatherName
     * @return
     */
    public static Weather parse(String weatherName) {
        try {
            if(StringUtils.isEmpty(weatherName))
                return null;
            Weather find = null;
            Weather[] weather = values();
            for (Weather index : weather) {
                String weaName = index.getWeatherName();


                //低级别
                if(weatherName.contains("转") ){
                    int indexOf = weatherName.indexOf("转");
                    String newName = weatherName.substring(indexOf+1);
                    if(newName.equals(weaName)){
                        find = index;
                    }
                }
                //最高级别
                if (weaName.equals(weatherName)) {
                    find = index;
                    break;
                }
            }
            if(null == find){
                for (Weather index : weather) {
                    String weaName = index.getWeatherName();

                    //最高级别
                    if (weatherName.contains(weaName)) {
                        find = index;
                        break;
                    }
                }
                if(null==find){
                    find = parse("晴");
                }
            }
            return find;
        }catch (Exception e){
            throw new RuntimeException("天气种类转化失败:"+e.getMessage());
        }


    }

    /**
     * 通过天气名字获取天气编码
     * @param weatherName
     * @return
     */
    public static String getWeatherNo(String weatherName) {
        Weather parse = parse(weatherName);
        String weatherNo = "";
        if (parse != null) {
            weatherNo = parse.getWeatherNo();
        }
        return weatherNo;
    }


    @Override
    public String getId() {
        return null;
    }

    public static void main(String[] args) {
        Weather b = Weather.parse("小雨转中雨");
        String pingYin = b.getPingYin();
        System.out.println( pingYin);
    }
}
