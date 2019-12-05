package com.suypower.venus.elec.common.utils;

/**
 * 时间常量
 */
public enum TimeConstant {
    /**
     * 今日
     */
    Today("today","今日"),
    /**
     * 昨日
     */
    Yesterday("yesterday","昨日"),
    /**
     * 今日等同于 Today
     * @see TimeConstant#Today
     */
    TheDate("theDate","今日"),
    /**
     * 指定日(以参考日对比)
     */
    TheMonth("theMonth","今月"),
    /**
     * 指定日(以参考日对比)
     */
    TheYear("theYear","今年"),
    /**
     * 指定日(以参考日对比)
     */
    LastDate("lastDate","昨日"),
    /**
     * 指定日(以参考日对比)
     */
    LastMonth("lastMonth","上月"),
    /**
     * 指定日(以参考日对比)
     */
    LastYear("lastYear","去年"),
    /**
     * 指定日(以参考日对比)
     */
    SelfDate("selfDate","指定日"),
    /**
     * 指定月(以参考月对比)
     */
    SelfMonth("selfMonth","指定月"),
    /**
     * 指定年(以参考年对比)
     */
    SelfYear("selfYear","指定年"),
    /**
     * 指定日前一日(以参考日对比)
     */
    PrevDate("prevDate","指定日前一天"),
    /**
     * 指定日前一月(以参考月对比)
     */
    PrevMonth("prevMonth","指定月前一月"),
    /**
     * 指定日前一年(以参考年对比)
     */
    PrevYear("prevYear","指定年前一年"),

    /**
     * 指定日后一日(以参考日对比)
     */
    NextDate("nextDate","指定日后一天"),
    /**
     * 指定日后一月(以参考月对比)
     */
    NextMonth("nextMonth","指定月后一月"),
    /**
     * 指定日后一年(以参考年对比)
     */
    NextYear("nextYear","指定年后一年");

    private String name;

    private String title;

    TimeConstant(String name,String title){
        this.name  = name;
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public static TimeConstant parse(String name){
        TimeConstant find=null;
        for(TimeConstant timeConstant : values()){
            if(timeConstant.getName().equals(name)){
                find = timeConstant;
                break;
            }
        }
        return find;
    }
}
