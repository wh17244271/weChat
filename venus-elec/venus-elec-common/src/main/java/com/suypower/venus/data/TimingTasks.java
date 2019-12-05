package com.suypower.venus.data;

import com.suypower.venus.app.gs.service.IGsWeatherService;
import com.suypower.venus.elec.common.utils.StringUtils;
import com.suypower.venus.elec.common.utils.Times;
import com.suypower.venus.elec.common.utils.Types;
import com.suypower.venus.platform.utils.SnowflakeIdWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Component
@Configuration
@EnableScheduling
public class TimingTasks {
    public static final Logger logger = LoggerFactory.getLogger(TimingTasks.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private IGsWeatherService gsWeatherService;



    /**
     * 补数据
     */
    //    @Scheduled( cron = "0/5 * * * * ?" )
    @Scheduled( fixedRate = 1000 * 60 * 5 )
    private void configureTasks() {
        System.err.println("开始定时任务: " + LocalDateTime.now().format(Times.defaultDateTimeFormatter));

        StringBuffer selectSql = new StringBuffer();
        selectSql.append(" SELECT ");
        selectSql.append(" 	DATE_FORMAT( ");
        selectSql.append(" 		MAX(FREEZING_TIME), ");
        selectSql.append(" 		'%Y-%m-%d %H:%i:%s' ");
        selectSql.append(" 	) FREEZING_TIME, ");
//        selectSql.append(" 	DATE_FORMAT( ");
//        selectSql.append(" 		MAX(FREEZING_TIME), ");
//        selectSql.append(" 		'%H:%i:%s' ");
//        selectSql.append(" 	) TIME, ");
        selectSql.append(" 	DATE_FORMAT( ");
        selectSql.append(" 		MAX(FREEZING_TIME), ");
        selectSql.append(" 		'%Y-%m-%d' ");
        selectSql.append(" 	) DATA_DATE, ");
        selectSql.append(" 	MAX(VAL)VAL, ");
        selectSql.append(" 	info.MP_ID, ");
        selectSql.append(" 	info.IND_B_NO ");
        selectSql.append(" FROM ");
        selectSql.append(" 	dc_meta_raw_data_info info ");
        selectSql.append(" where  cons_no = '0099760380' ");
        selectSql.append(" GROUP BY ");
        selectSql.append(" 	MP_ID, ");
        selectSql.append(" 	IND_B_NO ");

        StringBuffer sampleSql = new StringBuffer();
        sampleSql.append("SELECT ");
        sampleSql.append("	info.*,DATE_FORMAT( info.FREEZING_TIME,'%H:%i:%s')TIME ");
        sampleSql.append("FROM ");
        sampleSql.append("	dc_meta_raw_data_info info ");
        sampleSql.append("WHERE ");
        sampleSql.append("	info.CONS_NO = '0099760380' ");
        sampleSql.append("AND info.data_date = ? ");

        List<Map<String, Object>> sampleList = new ArrayList<>();
        List<Map<String, Object>> sampleList0 = jdbcTemplate.queryForList(sampleSql.toString(), "2019-07-29");
        List<Map<String, Object>> sampleList1 = jdbcTemplate.queryForList(sampleSql.toString(), "2019-07-29");
        List<Map<String, Object>> sampleList2 = jdbcTemplate.queryForList(sampleSql.toString(), "2019-07-29");

        List<Map<String, Object>> selectList = jdbcTemplate.queryForList(selectSql.toString());

        StringBuffer updateSql = new StringBuffer();
        updateSql.append(" INSERT INTO dc_meta_raw_data_info ( ");
        updateSql.append(" 	DATA_ID,CONS_NO,DATA_DATE,MP_ID,EQUIP_NO,TIME_NO,PEAK_NO,IND_B_NO,VAL,MULT_PW,DATA_TIME,FREEZING_TIME,IN_TIME,IS_HANDLED ");
        updateSql.append(" ) ");
        updateSql.append(" VALUES ");
        updateSql.append(" 	( ");
        updateSql.append(" 		?, '0099760380' ,STR_TO_DATE(?,'%Y-%m-%d'),?,?,?,?,?,?,?, ");
        updateSql.append("      STR_TO_DATE(?,'%Y-%m-%d %H:%i:%s'),STR_TO_DATE(?,'%Y-%m-%d %H:%i:%s'),STR_TO_DATE(?,'%Y-%m-%d %H:%i:%s'),?");
        updateSql.append(" 	) ");
        for (Map<String, Object> selectMap : selectList) {
            LocalDateTime maxFreezingTime = Types.localDateTime(selectMap.get("FREEZING_TIME"));
            String time = null;
            Double val = Types.Double(selectMap.get("VAL"));
            String mpId = Types.String(selectMap.get("MP_ID"));
            String indBNo = Types.String(selectMap.get("IND_B_NO"));
            List<Object[]> batchArgs = new ArrayList<Object[]>();
            Object[] objs = null;
            //一直补充数据，直到当前时间
            while (Duration.between(maxFreezingTime, LocalDateTime.now().minusMinutes(Constan.STATISTICAL_TIME)).toMillis() > 0) {
                maxFreezingTime = maxFreezingTime.plusMinutes(Constan.STATISTICAL_TIME); //每5分钟补充
                time = maxFreezingTime.format(Times.defaultTimeFormatter); //当前需要补充数据的点时间
                String nextFreezingTime = maxFreezingTime.format(Times.defaultDateTimeFormatter);
                //取值样本数据
                Random random = new Random();
                int randomNum = (random.nextInt(9) + 1) % 3;
                if (randomNum == 0) {
                    sampleList = sampleList0;
                } else if (randomNum == 1) {
                    sampleList = sampleList1;
                } else {
                    sampleList = sampleList2;
                }

                for (Map<String, Object> sampleMap : sampleList) {
                    String mpIdSample = Types.String(sampleMap.get("MP_ID"));
                    String indBNoSample = Types.String(sampleMap.get("IND_B_NO"));
                    String timeSample = Types.String(sampleMap.get("TIME"));
                    if (time.equals(timeSample) && mpId.equals(mpIdSample) && indBNo.equals(indBNoSample)) {
                        String dataDate = maxFreezingTime.format(Times.defaultDateFormatter);
                        String equip_no = Types.String(sampleMap.get("EQUIP_NO"));
                        String time_no = Types.String(sampleMap.get("TIME_NO"));
                        String peak_no = Types.String(sampleMap.get("PEAK_NO"));
                        //4个特殊值采用当前最大值递增
                        Double valSet = null;
                        if (Constan.indBNos.contains(indBNo)) {
                            valSet = val * Constan.GROWTH_NUMBER;
                            val = val * Constan.GROWTH_NUMBER;
                        } else {
                            valSet = Types.Double(sampleMap.get("VAL"));
                        }

                        Double mult_pw = Types.Double(sampleMap.get("MULT_PW"));
                        String is_handled = Types.String(sampleMap.get("IS_HANDLED"));
                        //TODO  样本获取规则未做
                        long uuid = SnowflakeIdWorker.getInstance().nextId();
                        objs = new Object[]{uuid, dataDate, mpId, equip_no, time_no, peak_no, indBNo, valSet, mult_pw,
                                nextFreezingTime, nextFreezingTime, "2013-01-01 12:12:12", is_handled};

                        batchArgs.add(objs);
                        break;
                    }

                }
            }
            if (!StringUtils.isEmpty(batchArgs)) {
                jdbcTemplate.batchUpdate(updateSql.toString(), batchArgs);
                System.err.println("mpId:" + mpId + ",indBNo:" + indBNo + ">>>>>>该批补数据成功");
            }

        }


        System.err.println("结束定时任务: " + LocalDateTime.now().format(Times.defaultDateTimeFormatter));


    }

}
