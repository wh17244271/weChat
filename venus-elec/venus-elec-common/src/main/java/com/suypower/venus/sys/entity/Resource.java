package com.suypower.venus.sys.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.suypower.venus.elec.common.common.converter.LongToStringSerializer;

/**
 * 资源
 */
public class Resource {
    /**
     *系统id
     */
    @JsonSerialize(using= LongToStringSerializer.class )
    private Long rsour_id;
    /**
     *关联资源标志
     */
    @JsonSerialize(using= LongToStringSerializer.class )
    private Long rel_id;
    /**
     * 系统资源类型编号
     */
    private String rsour_type_no;

    /**
     * 系统资源类型名称
     */
    private String rsour_type_name;

    /**
     * 系统资源所属表
     */
    private String rsour_table;

    public Long getRsour_id() {
        return rsour_id;
    }

    public void setRsour_id(Long rsour_id) {
        this.rsour_id = rsour_id;
    }

    public Long getRel_id() {
        return rel_id;
    }

    public void setRel_id(Long rel_id) {
        this.rel_id = rel_id;
    }

    public String getRsour_type_no() {
        return rsour_type_no;
    }

    public void setRsour_type_no(String rsour_type_no) {
        this.rsour_type_no = rsour_type_no;
    }

    public String getRsour_type_name() {
        return rsour_type_name;
    }

    public void setRsour_type_name(String rsour_type_name) {
        this.rsour_type_name = rsour_type_name;
    }

    public String getRsour_table() {
        return rsour_table;
    }

    public void setRsour_table(String rsour_table) {
        this.rsour_table = rsour_table;
    }
}
