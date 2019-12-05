package com.suypower.venus.entity;

import com.suypower.venus.controller.WarehousingController;

import java.util.List;

public class Warehousing {

    private String id;

    private String area;

    private String location;

    private String product;

    private String output;

    private String status;

    private List<OperationLog> logs;

    public Warehousing(String id,String area, String location, String product, String output, String status) {
        this.id =id;
        this.area = area;
        this.location = location;
        this.product = product;
        this.output = output;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<OperationLog> getLogs() {
        return logs;
    }

    public void setLogs(List<OperationLog> logs) {
        this.logs = logs;
    }

    /**
     * 通过id查找Warehousing
     * @param id
     * @return
     */
    public static Warehousing getWarehousing(String id){
        Warehousing find = null;
        List<Warehousing> warehousings = WarehousingController.warehousings;
        for(Warehousing warehousing:warehousings){
           if( warehousing.getId().equals(id)){
               return warehousing;
           }
        }
        return null;
    }
}
