package com.suypower.venus.app.index.entity;

import java.util.List;

/**
 * 标签结构
 */
public class IndexLabel {
    private String title;
    private String value;
    private String labelName;
    private String valueName;
    private boolean multiple;
    private String dataType;
    private List<IndexClassification> data;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }

    public boolean isMultiple() {
        return multiple;
    }

    public void setMultiple(boolean multiple) {
        this.multiple = multiple;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public List<IndexClassification> getData() {
        return data;
    }

    public void setData(List<IndexClassification> data) {
        this.data = data;
    }
}

