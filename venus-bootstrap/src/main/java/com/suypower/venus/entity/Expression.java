package com.suypower.venus.entity;

import com.suypower.venus.utils.StringUtils;

/**
 * 表情库
 */
public class Expression {
    private String expName;
    private String expUrl;

    public Expression() {
    }

    public Expression( String expName, String expUrl) {
        this.expName = StringUtils.uuid();
        this.expUrl = expUrl;
    }


    public String getExpName() {
        return expName;
    }

    public void setExpName(String expName) {
        this.expName = expName;
    }

    public String getExpUrl() {
        return expUrl;
    }

    public void setExpUrl(String expUrl) {
        this.expUrl = expUrl;
    }
}
