package com.suypower.venus.elec.common.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class CalendarInfo {
    /**
     * 天(yyyy-MM-dd)
     */
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate date;
    /**
     * 月(yyyy)
     */
    private String month;
    /**
     * 年(yyyy)
     */
    private String year;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
