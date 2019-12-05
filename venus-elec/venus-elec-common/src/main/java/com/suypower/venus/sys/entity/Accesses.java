package com.suypower.venus.sys.entity;

public class Accesses {
    private String name;
    private String title;
    private String control;
    private String tip;


    public Accesses() {
    }

    public Accesses(String name, String title, String control, String tip) {
        this.name = name;
        this.title = title;
        this.control = control;
        this.tip = tip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getControl() {
        return control;
    }

    public void setControl(String control) {
        this.control = control;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }
}
