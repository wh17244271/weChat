package com.suypower.venus.app.task.gs;

import com.suypower.venus.app.gs.common.City;
import com.suypower.venus.app.gs.entity.GsWeatherDay;
import com.suypower.venus.app.gs.service.IGsWeatherService;
import com.suypower.venus.app.gs.utils.WeatherUtils;
import com.suypower.venus.elec.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Configuration
@EnableScheduling
public class WeatherTask {
    public static final Logger logger = LoggerFactory.getLogger(WeatherTask.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private IGsWeatherService gsWeatherService;

    /**
     * 拉取天气
     */
//    @Scheduled( fixedRate = 1000 * 60 *60*3 )
     @Scheduled( cron = "0 0/10 * * * ?" )
//    @Scheduled( cron = "0 0/1 * * * ?")
    public void weatherTasks() {
        logger.info("【{}】状态:{}", StringUtils.fixed("定时任务天气", 24), "开始");
        long startTime = System.currentTimeMillis();
        try {
            City[] citys = City.values();
            for (City city : citys) {
                List<GsWeatherDay> weatherList = WeatherUtils.getWeather(city.getCityId());
                for(GsWeatherDay weatherDay :weatherList){
                    boolean update = gsWeatherService.update(weatherDay);
                }
            }

            logger.info("【{}】状态:{},用时:{}",StringUtils.fixed("定时任务", 24), "结束",(System.currentTimeMillis()-startTime)/1000+"s");
        }catch (Exception e){
            logger.error("【{}】异常:{}",StringUtils.fixed("定时任务跑天气出现异常", 24),e.getMessage());
        }
    }

//    @Bean
    public void initWeather() {
        weatherTasks();
    }
}
