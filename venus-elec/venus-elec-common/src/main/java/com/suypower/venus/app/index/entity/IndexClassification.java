package com.suypower.venus.app.index.entity;

import java.util.List;

/**
 * 指标分类
 */
public class IndexClassification {
    private String groupName;
    private String groupNo;
    private List<Index> items;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupNo() {
        return groupNo;
    }

    public void setGroupNo(String groupNo) {
        this.groupNo = groupNo;
    }

    public List<Index> getItems() {
        return items;
    }

    public void setItems(List<Index> items) {
        this.items = items;
    }
}
