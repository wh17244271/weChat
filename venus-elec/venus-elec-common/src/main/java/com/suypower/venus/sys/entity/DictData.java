package com.suypower.venus.sys.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.suypower.venus.elec.common.common.converter.LongToStringSerializer;

/**
 * 字典数据
 */
public class DictData {
    /**
     * 字典数据标志
     */
    @JsonSerialize(using= LongToStringSerializer.class )
    private Long dict_data_id;
    /**
     * 字典标志
     */
    @JsonSerialize(using= LongToStringSerializer.class )
    private Long dict_id;
    /**
     * 字典数据编码
     */
    private String dict_data_code;

    /**
     * 字典数据索引
     */
    private String dict_data_key;

    /**
     * 字典数据值
     */
    private String dict_data_value;
    /**
     * 字典数据状态
     */
    private String dict_data_status;
    /**
     * 字典数据备注
     */
    private String dict_data_remark;

    public Long getDict_data_id() {
        return dict_data_id;
    }

    public void setDict_data_id(Long dict_data_id) {
        this.dict_data_id = dict_data_id;
    }

    public Long getDict_id() {
        return dict_id;
    }

    public void setDict_id(Long dict_id) {
        this.dict_id = dict_id;
    }

    public String getDict_data_code() {
        return dict_data_code;
    }

    public void setDict_data_code(String dict_data_code) {
        this.dict_data_code = dict_data_code;
    }

    public String getDict_data_key() {
        return dict_data_key;
    }

    public void setDict_data_key(String dict_data_key) {
        this.dict_data_key = dict_data_key;
    }

    public String getDict_data_value() {
        return dict_data_value;
    }

    public void setDict_data_value(String dict_data_value) {
        this.dict_data_value = dict_data_value;
    }

    public String getDict_data_status() {
        return dict_data_status;
    }

    public void setDict_data_status(String dict_data_status) {
        this.dict_data_status = dict_data_status;
    }

    public String getDict_data_remark() {
        return dict_data_remark;
    }

    public void setDict_data_remark(String dict_data_remark) {
        this.dict_data_remark = dict_data_remark;
    }
}
