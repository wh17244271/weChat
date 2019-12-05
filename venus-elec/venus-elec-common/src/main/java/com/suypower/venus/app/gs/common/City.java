package com.suypower.venus.app.gs.common;

import com.suypower.venus.platform.share.entity.IEnum;

/**
 * @auther:maofukai
 * @date:2019-07-09 系统指标定义
 */
public enum City implements IEnum<String> {


    南京("南京", "101190101"),
    西安("西安", "101110101"),
    济南("济南", "101120101"),


    ;


    /**
     * 城市名字
     */
    private String cityName;
    /**
     * 城市id
     */
    private String cityId;


     City(String cityName, String cityId ) {
        this.cityName = cityName;
         this.cityId = cityId;

    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public static City parse(String cityName) {
        City findCity = null;
        try {
            City[] citys = values();
            for (City city : citys) {
                String cityNameNow = city.getCityName();
                if(cityName.equals(cityNameNow)){
                    findCity = city;
                    break;
                }
            }

            return findCity;
        }catch (Exception e){
            throw new RuntimeException("天气种类转化失败:"+e.getMessage());
        }


    }




    @Override
    public String getId() {
        return null;
    }


}
