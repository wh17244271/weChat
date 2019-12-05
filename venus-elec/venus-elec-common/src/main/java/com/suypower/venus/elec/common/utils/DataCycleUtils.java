package com.suypower.venus.elec.common.utils;

import com.suypower.venus.elec.common.common.Constant;
import com.suypower.venus.elec.common.common.exception.VenusResponseException;

import java.time.LocalDate;
import java.util.Arrays;

/**
 * 数据周期处理类
 */
public class DataCycleUtils {




    /**
     * 同比、环比之后返回日期
     * @param dataDateCycle 比较类型
     * @param localDates    时间格式 yyyy-MM-dd
     * @return
     */
    public static LocalDate[]  localDate(String dataDateCycle, LocalDate[] localDates){
        if(StringUtils.isEmpty(localDates) ||StringUtils.isEmpty(dataDateCycle))return localDates;
        LocalDate[] newLocalDates = Arrays.copyOf(localDates, localDates.length * 2);

        //同比
        if(Constant.YEAR_ON_YEAR.equals(dataDateCycle)){
            int i=0;
            for (LocalDate localDate:localDates){
                newLocalDates[i+localDates.length] = localDate.plusYears(-1);
                i++;
            }
        }
        else if(Constant.CHAIN_RATIO.equals(dataDateCycle)){
            int i=0;
            for (LocalDate localDate:localDates){
                newLocalDates[i+localDates.length]= localDate.plusDays(-1);
                i++;
            }
        }else{
            throw new VenusResponseException("请输入正确的数据周期");
        }
        return newLocalDates;
    }


    /**
     * 同比、环比之后返回日期
     * @param dataDateCycle 比较类型
     * @param monthes    时间格式 yyyy-MM
     * @return
     */
    public static String[]  localMonth(String dataDateCycle, String[] monthes){
        if(StringUtils.isEmpty(monthes)||StringUtils.isEmpty(dataDateCycle))return monthes;
        String[] newMonthes = Arrays.copyOf(monthes, monthes.length * 2);
        String month="";
        //同比
        if(Constant.YEAR_ON_YEAR.equals(dataDateCycle)){
            try {
                for (int i = 0; i < monthes.length; i++) {
                    month= monthes[i];
                    month = new StringBuffer(month).append("-01").toString();
                    LocalDate parse = LocalDate.parse(month, Times.defaultDateFormatter).plusYears(-1);
                    newMonthes[i+monthes.length] =parse.toString().substring(0, 7);
                }
            } catch (Exception e) {
                throw new VenusResponseException("请输入正确的时间格式");
            }
        }
        else if(Constant.CHAIN_RATIO.equals(dataDateCycle)){
            try {
                for (int i = 0; i < monthes.length; i++) {
                    month= monthes[i];
                    month = new StringBuffer(month).append("-01").toString();
                    LocalDate parse = LocalDate.parse(month, Times.defaultDateFormatter).plusMonths(-1);
                    newMonthes[i+monthes.length] =parse.toString().substring(0, 7);
                }
            } catch (Exception e) {
                throw new VenusResponseException("请输入正确的时间格式");
            }
        }else{
            throw new VenusResponseException("请输入正确的数据周期");
        }
        return newMonthes;
    }

    public static String[]  localYear(String dataDateCycle, String[] years){
        if(StringUtils.isEmpty(years)||StringUtils.isEmpty(dataDateCycle))return years;
        String[] newYears = Arrays.copyOf(years, years.length * 2);
        String year="";
        if(Constant.CHAIN_RATIO.equals(dataDateCycle)){
            try {
                for (int i = 0; i < years.length; i++) {
                    year= years[i];
                    year = new StringBuffer(year).append("-01-01").toString();
                    LocalDate parse = LocalDate.parse(year, Times.defaultDateFormatter).plusYears(-1);
                    newYears[i+years.length] =parse.toString().substring(0, 4);
                }
            } catch (Exception e) {
                throw new VenusResponseException("请输入正确的时间格式");
            }
        }else{
            throw new VenusResponseException("年份查询没有同比，请输入正确的数据周期");
        }
        return newYears;
    }


}
