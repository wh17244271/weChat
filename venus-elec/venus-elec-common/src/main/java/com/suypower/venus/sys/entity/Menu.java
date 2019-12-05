package com.suypower.venus.sys.entity;

import java.util.List;
import java.util.Map;

public class Menu<T> {
    private String name;
    private String path;
    private String icon;
    private String title;
    private boolean hideInBread;
    private boolean hideInMenu;
    private boolean notCache;
    private String access;
    private String beforeCloseName;
    private Map meta;
    private String component;
    private List<T> children;




    public Menu() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public List<T> getChildren() {
        return children;
    }

    public void setChildren(List<T> children) {
        this.children = children;
    }

    public Map getMeta() {
        return meta;
    }

    public void setMeta(Map meta) {
        this.meta = meta;
    }


    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public String getBeforeCloseName() {
        return beforeCloseName;
    }

    public void setBeforeCloseName(String beforeCloseName) {
        this.beforeCloseName = beforeCloseName;
    }

    public boolean isHideInBread() {
        return hideInBread;
    }

    public void setHideInBread(boolean hideInBread) {
        this.hideInBread = hideInBread;
    }

    public boolean isHideInMenu() {
        return hideInMenu;
    }

    public void setHideInMenu(boolean hideInMenu) {
        this.hideInMenu = hideInMenu;
    }

    public boolean isNotCache() {
        return notCache;
    }

    public void setNotCache(boolean notCache) {
        this.notCache = notCache;
    }
}
