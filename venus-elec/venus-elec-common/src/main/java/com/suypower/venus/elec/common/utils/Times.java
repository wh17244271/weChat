package com.suypower.venus.elec.common.utils;

import com.suypower.venus.elec.common.common.TimeType;
import com.suypower.venus.elec.common.common.exception.VenusResponseException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Times {

    public static DateTimeFormatter defaultYearFormatter = DateTimeFormatter.ofPattern("yyyy");

    public static DateTimeFormatter defaultMonthFormatter = DateTimeFormatter.ofPattern("yyyy-MM");

    public static DateTimeFormatter defaultDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static DateTimeFormatter defaultDayOfMonthFormatter = DateTimeFormatter.ofPattern("dd");

    public static DateTimeFormatter defaultDateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static DateTimeFormatter defaultTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static DateTimeFormatter blankMonthFormatter = DateTimeFormatter.ofPattern("yyyyMM");

    public static DateTimeFormatter blankDateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");

    public static DateTimeFormatter blankDateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");


    private static String beforeFormat(String dateStr) {
        if (dateStr.indexOf("/") != -1) {
            dateStr = dateStr.replace("/", "");
        } else if (dateStr.indexOf("-") != -1) {
            dateStr = dateStr.replace("-", "");
        }
        dateStr = dateStr.replaceAll(":", "").replace(" ", "");
        return dateStr;
    }



    /**
     * 添加当前日期的月环比和年同比
     *
     * @param localDates (yyyy-MM-dd)
     * @return
     */
    public static LocalDate[] parseYearOnYearOrRatio(LocalDate[] localDates) {
        if (StringUtils.isEmpty(localDates)) return localDates;
//        LocalDate[] newLocalDates = Arrays.copyOf(localDates, localDates.length * 3);
        LocalDate[] newLocalDates = new LocalDate[localDates.length * 2];
        int i = 0;
        for (LocalDate localDate : localDates) {
            newLocalDates[i] = localDate.minusMonths(1);//月环比
            newLocalDates[i + localDates.length] = localDate.minusYears(1);  //年同比

            i++;
        }

        return newLocalDates;
    }

    /**
     * 添加当前日期的月环比和年同比
     * @param monthes
     * @return
     */
    public static String[] parseYearOnYearOrRatio(String[] monthes) {
        if (StringUtils.isEmpty(monthes)) return monthes;
        Assert.isFalse(checkFormatIsTrue(monthes, TimeType.Month.getTimeTypeNo()),"判断时间时出错");
//        if (!checkFormatIsTrue(monthes, TimeType.Month.getTimeTypeNo())) throw new VenusResponseException("判断时间时出错");

//        String[] newMonthes = Arrays.copyOf(monthes, monthes.length * 3);
        String[] newMonthes = new String[ monthes.length * 2];
        String month = "";
        try {
            for (int i = 0; i < monthes.length; i++) {
                month = monthes[i];
                month = new StringBuffer(month).append("-01").toString();
                LocalDate localDate = LocalDate.parse(month, Times.defaultDateFormatter);
                newMonthes[i ] = Times.parse(localDate, TimeConstant.PrevMonth);
                newMonthes[i + monthes.length ] = Times.parse(localDate.minusYears(1), TimeConstant.SelfMonth);
            }
        } catch (Exception e) {
            throw new VenusResponseException("请输入正确的时间格式");
        }
        return newMonthes;
    }

    /**
     * 添加当前年的环比
     * @param years
     * @return
     */
    public static String[] parseYearRatio(String[] years) {
        if (StringUtils.isEmpty(years)) return years;
        Assert.isFalse(checkFormatIsTrue(years, TimeType.Year.getTimeTypeNo()),"判断时间时出错");
        String[] newMonthes = new String[ years.length];
        String year = "";
        try {
            for (int i = 0; i < years.length; i++) {
                year = years[i];
                year = new StringBuffer(year).append("-01-01").toString();
                LocalDate localDate = LocalDate.parse(year, Times.defaultDateFormatter);
                newMonthes[i] = Times.parse(localDate.minusYears(1), TimeConstant.SelfYear);
            }
        } catch (Exception e) {
            throw new VenusResponseException("请输入正确的时间格式");
        }
        return newMonthes;
    }



    /**
     * 解析时间
     *
     * @param dateStr
     * @return
     */
    public static LocalDate parseDate(String dateStr) {
        LocalDate date;
        dateStr = beforeFormat(dateStr);
        if (dateStr.length() == 8) {
            date = LocalDate.parse(dateStr, blankDateFormatter);
        } else {
            throw new VenusResponseException("请输入正确的时间格式");
        }
        return date;
    }

    /**
     * 解析时间
     *
     * @param
     * @return
     */
    public static String format(LocalDate date, DateTimeFormatter formatter) {
        return date.format(formatter);
    }


    public static LocalDateTime parseDateTime(String dateTimeStr) {
        LocalDateTime dateTime;
        dateTimeStr = beforeFormat(dateTimeStr);
        if (dateTimeStr.length() == 14) {
            dateTime = LocalDateTime.parse(dateTimeStr, blankDateTimeFormatter);
        } else {
            throw new VenusResponseException("请输入正确的时间格式");
        }
        return dateTime;
    }


    public static <T> T[] parseArray(String any) {
        if (StringUtils.isEmpty(any)) return null;
        String[] times = any.trim().split(",");
        List<Object> newTimes = new ArrayList();
        for (String s : times) {
            T time = parse(s, null);
            newTimes.add(time);
        }
        T[] ts;
        if (newTimes.size() > 0) {
            if (newTimes.get(0) instanceof LocalDate) {
                ts = (T[]) newTimes.toArray(new LocalDate[0]);
            } else {
                ts = (T[]) newTimes.toArray(new String[0]);
            }
            return ts;
        } else {
            throw new VenusResponseException("请输入正确的时间格式");
        }
    }

    public static <T> T parse(String any) {
        return parse(any, null);
    }


    /**
     * 解析日期
     *
     * @param any      参考日期
     * @param constant 日期常量
     * @param <T>      LocalDate | String(yyyy、yyyy-MM)
     * @return
     */
    public static <T> T parse(String any, TimeConstant constant) {
        Assert.isEmpty(any,"时间为空");
        any = beforeFormat(any);
        TimeConstant selfTimeConstant = TimeConstant.parse(any);
        T time;
        LocalDate date = null;
        //传入的是日期常量
        if (selfTimeConstant != null) {
            time = parse(LocalDate.now(), selfTimeConstant);
            if (constant == null) {
                return time;
            } else {
                if (time instanceof LocalDate) {
                    date = (LocalDate) time;
                } else if (time instanceof String) {
                    String timeStr = beforeFormat(String.valueOf(time));
                    if (timeStr.length() == 4) {
                        date = LocalDate.now();
                        date = date.withYear(Integer.parseInt(timeStr));
                    }
                    //年月(yyyy-MM)
                    else if (timeStr.length() == 6) {
                        date = LocalDate.parse(timeStr + "01", blankDateFormatter);
                        //修复天数
                        int dayOfMonth = LocalDate.now().getDayOfMonth();
                        if (dayOfMonth > date.getMonth().length(date.isLeapYear())) {
                            dayOfMonth = date.getMonth().length(date.isLeapYear());
                        }
                        date = date.withDayOfMonth(dayOfMonth);
                    }
                    //年月日(yyyy-MM-dd)
                    else if (timeStr.length() == 8) {
                        date = LocalDate.parse(timeStr, blankDateFormatter);
                    }
                }
            }
        } else {
            if (any.length() == 4) {
                date = LocalDate.now();
                date = date.withYear(Integer.parseInt(any));
                if (selfTimeConstant == null) {
                    return (T) format(date, defaultYearFormatter);
                }
            }
            //年月(yyyy-MM)
            else if (any.length() == 6) {
                date = LocalDate.parse(any + "01", blankDateFormatter);
                //修复天数
                int dayOfMonth = LocalDate.now().getDayOfMonth();
                if (dayOfMonth > date.getMonth().length(date.isLeapYear())) {
                    dayOfMonth = date.getMonth().length(date.isLeapYear());
                }
                date = date.withDayOfMonth(dayOfMonth);
                if (selfTimeConstant == null) {
                    return (T) format(date, defaultMonthFormatter);
                }
            }
            //年月日(yyyy-MM-dd)
            else if (any.length() == 8) {
                date = LocalDate.parse(any, blankDateFormatter);
                if (selfTimeConstant == null) {
                    return (T) date;
                }
            }
        }
        Assert.isNull(date,"请输入正确的时间格式");
        return parse(date, constant);
    }


    /**
     * 解析日期
     *
     * @param date     参考日期
     * @param constant 日期常量
     * @param <T>      LocalDate | String(yyyy、yyyy-MM)
     * @return
     */
    public static <T> T parse(LocalDate date, TimeConstant constant) {
        Object newDate = null;
        switch (constant) {
            case Today:
                newDate = LocalDate.now();
                break;
            case Yesterday:
                newDate = LocalDate.now().minusDays(1);
                break;
            case TheDate:
                newDate = LocalDate.now();
                break;
            case TheMonth:
                newDate = format(LocalDate.now(), defaultMonthFormatter);
                break;
            case TheYear:
                newDate = format(LocalDate.now(), defaultYearFormatter);
                break;
            case LastDate:
                newDate = LocalDate.now().minusDays(1);
                break;
            case LastMonth:
                newDate = format(LocalDate.now().minusMonths(1), defaultMonthFormatter);
                break;
            case LastYear:
                newDate = format(LocalDate.now().minusYears(1), defaultYearFormatter);
                break;
            case SelfDate:
                newDate = date;
                break;
            case SelfMonth:
                newDate = format(date, defaultMonthFormatter);
                break;
            case SelfYear:
                newDate = format(date, defaultYearFormatter);
                break;
            case PrevDate:
                newDate = date.minusDays(1);
                break;
            case PrevMonth:
                newDate = format(date.minusMonths(1), defaultMonthFormatter);
                break;
            case PrevYear:
                newDate = format(date.minusYears(1), defaultYearFormatter);
                break;
            case NextDate:
                newDate = date.plusDays(1);
                break;
            case NextMonth:
                newDate = format(date.plusMonths(1), defaultMonthFormatter);
                break;
            case NextYear:
                newDate = format(date.plusYears(1), defaultYearFormatter);
                break;
        }
        return newDate != null ? (T) newDate : null;
    }

    /**
     * 检测时间格式是否和时间类型一致
     *
     * @param times
     * @param timeType
     * @return
     */
    public static boolean checkFormatIsTrue(String[] times, String timeType) {
        try {
            for (String time : times) {
                time = beforeFormat(time);
                if (TimeType.Month.getTimeTypeNo().equals(timeType)) {
                    return time.length() == 6;
                } else if (TimeType.Year.getTimeTypeNo().equals(timeType)) {
                    return time.length() == 4;
                } else {
                    return false;
                }
            }

            return false;
        } catch (Exception e) {
            throw new VenusResponseException("判断时间时出错");
        }

    }
}

