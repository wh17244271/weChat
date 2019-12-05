package com.suypower.venus.elec.common.service.impl;

import com.suypower.venus.elec.common.dao.DaMpRealtimeDataDao;
import com.suypower.venus.elec.common.entity.DaMpRealtimeData;
import com.suypower.venus.elec.common.service.IDaMpRealtimeDataService;
import com.suypower.venus.elec.common.utils.Times;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service( "daMpRealtimeDataService" )
public class DaMpRealtimeDataServiceImpl implements IDaMpRealtimeDataService {
    private static String POINT_TIME = "1";
    @Autowired
    private DaMpRealtimeDataDao daMpRealtimeDataDao;

    @Override
    public List<DaMpRealtimeData> queryRealtimeData(String consNo, String mpId, String realTimeType) {

        LocalDateTime nowTime = LocalDateTime.now();//2019-07-30 10:06:21
        String now = null;
        if (POINT_TIME.equals(realTimeType)) {
            int minute = nowTime.getMinute();
            int remainder = minute % 5;
            if (remainder == 0) {
                now = nowTime.format(Times.defaultDateTimeFormatter);
            } else {
                now = nowTime.plusMinutes(-remainder).format(Times.defaultDateTimeFormatter);
            }
        } else {
            nowTime= nowTime.withHour(0).withMinute(0).withSecond(0);
            now = nowTime.format(Times.defaultDateTimeFormatter);
        }
        List<DaMpRealtimeData> daMpRealtimeData = daMpRealtimeDataDao.queryRealtimeData(consNo, mpId, now);

        return daMpRealtimeData;
    }




}
