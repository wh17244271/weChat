package com.suypower.venus.sys.entity;

/**
 * 菜单中属性 Meta
 */
public class Meta {
    private String title;
    private String icon;
    private boolean hideInBread;
    private boolean hideInMenu;
    private boolean notCache;
    private String access;
    private String beforeCloseName;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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
}
