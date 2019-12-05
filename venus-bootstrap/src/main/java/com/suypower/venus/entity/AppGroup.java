package com.suypower.venus.entity;

import com.suypower.venus.utils.StringUtils;

import java.util.List;

public class AppGroup {
    private String groupId;
    private String groupName;
    private String groupTitle;
    private List<App> apps;

    public AppGroup() {
    }

    public AppGroup(String groupName, String groupTitle, List<App> apps) {
        this.groupId = StringUtils.uuid();
        this.groupName = groupName;
        this.groupTitle = groupTitle;
        this.apps = apps;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupTitle() {
        return groupTitle;
    }

    public void setGroupTitle(String groupTitle) {
        this.groupTitle = groupTitle;
    }

    public List<App> getApps() {
        return apps;
    }

    public void setApps(List<App> apps) {
        this.apps = apps;
    }
}
