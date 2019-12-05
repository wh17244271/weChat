package com.suypower.venus.elec.monitor.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DiagramDetail extends Diagram {

    /**
     * 接线图数据
     * 对应数据库字段SVG
     */
    private String gData;

    public String getGData() {
        return gData;
    }

    public void setGData(String gData) {
        this.gData = gData;
    }

    //尚未定义的结构
    private List<Map>  elements = new ArrayList<>();
}
