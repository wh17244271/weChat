
/**
 * ==============================
 *    综合服务-气象接口
 * ==============================
 * [更改信息]
 *
 */

/**
 *  获取当天气象数据(自动获取用户对应的城市或行政区划码)查询对应的气象数据
 * 【请求URL】/app/gs/weather/today
 * 【参数方式】GET|POST
 * 【请求参数】
 */
(function(){
    let ajaxReponseData =
        {
            orgNo: "3201",
            cityId: "101190101",
            cityName: "南京",
            cityNamePinyin: "nanjing",
            wtDate: "2019-08-15",
            wtWeek: "星期四",
            wtWeather: "多云转晴",   //天气信息
            wtWeatherPinyin: "yun", //天气信息拼音
            wtWeatherIcon  : "yun", //天气信息图片
            wtAir: "47",   //空气质量等级
            wtAirLevel: "优", //wtAirLevel
            wtAirTips: "空气很好，可以外出活动，呼吸新鲜空气，拥抱大自然！",//空气质量描述
            wtHumidity: 65, //空气湿度
            wtAlarmType: "", //预警类型
            wtAlarmLevel: "",//预警级别
            wtAlarmContent: "",//预警信息
            wtTem1: "37℃", //高温/白天温度
            wtTem2: "24℃", //低温/晚上温度
            wtTem: "27℃", //当前温度
            wtVTem1: "37", //高温/白天温度(无单位)
            wtVTem2: "24", //低温/晚上温度(无单位)
            wtVTem: "27", //当前温度(无单位)
            wtWin: "西北风", //风向
            wtWinSpeed: "<3级", //风速
            wtWinVSpeed: "3",   //风速(无单位)
            wtUpdateTime: "2019-08-15 12:10:20",//数据更新时间
            hours:
                [
                    {
                        whHour: "12:00", //天气小时
                        whWeather: "晴",   //小时天气
                        whWeatherPinyin: "qing", //小时天气拼音
                        whWeatherIcon  : "qing", //小时天气图片
                        whTem: "27℃", //当前温度
                        whVTem: "27",  //当前温度(无单位)
                        whWin: "西北风", //风向
                        whWinSpeed: "<3级", //风速
                        whWinVSpeed: "3",   //风速(无单位)
                        whUpdateTime: "2019-08-15 12:10:20",//数据更新时间
                    },
                    {
                        whHour: "13:00", //天气小时
                        whWeather: "晴",   //小时天气
                        whWeatherPinyin: "qing", //小时天气拼音
                        whWeatherIcon  : "qing", //小时天气图片
                        whTem: "27℃", //当前温度
                        whVTem: "27",  //当前温度(无单位)
                        whWin: "西北风", //风向
                        whWinSpeed: "<3级", //风速
                        whWinVSpeed: "3",   //风速(无单位)
                        whUpdateTime: "2019-08-15 12:10:20",//数据更新时间
                    }
                ]
        }
})();

/**
 * 1 获取最近一个星期内的(共7天包含今天)气象数据(自动获取用户对应的城市或行政区划码)查询对应的气象数据
 * 【请求URL】/app/gs/weather/week
 * 【参数方式】GET|POST
 * 【请求参数】
 */
(function(){
    let ajaxReponseData =
        [
          {
            orgNo: "3201",
            cityId: "101190101",
            cityName: "南京",
            cityNamePinyin: "nanjing",
            wtDate: "2019-08-15",
            wtWeek: "星期四",
            wtWeather: "多云转晴",   //天气信息
            wtWeatherPinyin: "yun", //天气信息拼音
            wtWeatherIcon  : "yun", //天气信息图片
            wtAir: "47",   //空气质量等级
            wtAirLevel: "优", //wtAirLevel
            wtAirTips: "空气很好，可以外出活动，呼吸新鲜空气，拥抱大自然！",//空气质量描述
            wtHumidity: 65, //空气湿度
            wtAlarmType: "", //预警类型
            wtAlarmLevel: "",//预警级别
            wtAlarmContent: "",//预警信息
            wtTem1: "37℃", //高温/白天温度
            wtTem2: "24℃", //低温/晚上温度
            wtTem: "27℃", //当前温度
            wtVTem1: "37", //高温/白天温度(无单位)
            wtVTem2: "24", //低温/晚上温度(无单位)
            wtVTem: "27", //当前温度(无单位)
            wtWin: "西北风", //风向
            wtWinSpeed: "<3级", //风速
            wtWinVSpeed: "3",   //风速(无单位)
            wtUpdateTime: "2019-08-15 12:10:20",//数据更新时间
            hours:
                [
                    {
                        whHour: "12:00", //天气小时
                        whWeather: "晴",   //小时天气
                        whWeatherPinyin: "qing", //小时天气拼音
                        whWeatherIcon  : "qing", //小时天气图片
                        whTem: "27℃", //当前温度
                        whVTem: "27",  //当前温度(无单位)
                        whWin: "西北风", //风向
                        whWinSpeed: "<3级", //风速
                        whWinVSpeed: "3",   //风速(无单位)
                        whUpdateTime: "2019-08-15 12:10:20",//数据更新时间
                    },
                    {
                        whHour: "13:00", //天气小时
                        whWeather: "晴",   //小时天气
                        whWeatherPinyin: "qing", //小时天气拼音
                        whWeatherIcon  : "qing", //小时天气图片
                        whTem: "27℃", //当前温度
                        whVTem: "27",  //当前温度(无单位)
                        whWin: "西北风", //风向
                        whWinSpeed: "<3级", //风速
                        whWinVSpeed: "3",   //风速(无单位)
                        whUpdateTime: "2019-08-15 12:10:20",//数据更新时间
                    }
                ]
          },
            {
                orgNo: "3201",
                cityId: "101190101",
                cityName: "南京",
                cityNamePinyin: "nanjing",
                wtDate: "2019-08-16",
                wtWeek: "星期四",
                wtWeather: "多云转晴",   //天气信息
                wtWeatherPinyin: "yun", //天气信息拼音
                wtWeatherIcon  : "yun", //天气信息图片
                wtAir: "47",   //空气质量等级
                wtAirLevel: "优", //wtAirLevel
                wtAirTips: "空气很好，可以外出活动，呼吸新鲜空气，拥抱大自然！",//空气质量描述
                wtHumidity: 65, //空气湿度
                wtAlarmType: "", //预警类型
                wtAlarmLevel: "",//预警级别
                wtAlarmContent: "",//预警信息
                wtTem1: "37℃", //高温/白天温度
                wtTem2: "24℃", //低温/晚上温度
                wtTem: "27℃", //当前温度
                wtVTem1: "37", //高温/白天温度(无单位)
                wtVTem2: "24", //低温/晚上温度(无单位)
                wtVTem: "27", //当前温度(无单位)
                wtWin: "西北风", //风向
                wtWinSpeed: "<3级", //风速
                wtWinVSpeed: "3",   //风速(无单位)
                wtUpdateTime: "2019-08-15 12:10:20",//数据更新时间
                hours:
                    [
                        {
                            whHour: "12:00", //天气小时
                            whWeather: "晴",   //小时天气
                            whWeatherPinyin: "qing", //小时天气拼音
                            whWeatherIcon  : "qing", //小时天气图片
                            whTem: "27℃", //当前温度
                            whVTem: "27",  //当前温度(无单位)
                            whWin: "西北风", //风向
                            whWinSpeed: "<3级", //风速
                            whWinVSpeed: "3",   //风速(无单位)
                            whUpdateTime: "2019-08-15 12:10:20",//数据更新时间
                        },
                        {
                            whHour: "13:00", //天气小时
                            whWeather: "晴",   //小时天气
                            whWeatherPinyin: "qing", //小时天气拼音
                            whWeatherIcon  : "qing", //小时天气图片
                            whTem: "27℃", //当前温度
                            whVTem: "27",  //当前温度(无单位)
                            whWin: "西北风", //风向
                            whWinSpeed: "<3级", //风速
                            whWinVSpeed: "3",   //风速(无单位)
                            whUpdateTime: "2019-08-15 12:10:20",//数据更新时间
                        }
                    ]
            }
        ]
})();