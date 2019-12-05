package com.suypower.venus.sys.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.suypower.venus.elec.common.common.converter.LongToStringSerializer;

import java.util.List;

/**
 * 字典
 */
public class Dict {
    /**
     * 字典标志
     */
    @JsonSerialize(using= LongToStringSerializer.class )
    private Long dictId;
    /**
     * 系统平台标志
     */
    @JsonSerialize(using= LongToStringSerializer.class )
    private Long sysId;
    /**
     * 字典编码
     */
    private String dictCode;

    /**
     * 字典名称
     */
    private String dictName;
    /**
     * 字典父标志
     */
    @JsonSerialize(using= LongToStringSerializer.class )
    private Long dictPid;

    /**
     * 字典权重
     */
    private String dictWeight;
    /**
     * 字典状态
     */
    private String dictStatus;
    /**
     * 是否共享
     */
    private String dictSharing;
    /**
     * 字典备注
     */
    private String dictRemark;
    /**
     * 子类
     */
    private List<Dict> children;
    /**
     * 具体字典数据
     */
    private List<DictData> dictData;

    public Long getDictId() {
        return dictId;
    }

    public void setDictId(Long dictId) {
        this.dictId = dictId;
    }

    public Long getSysId() {
        return sysId;
    }

    public void setSysId(Long sysId) {
        this.sysId = sysId;
    }

    public String getDictCode() {
        return dictCode;
    }

    public void setDictCode(String dictCode) {
        this.dictCode = dictCode;
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    public Long getDictPid() {
        return dictPid;
    }

    public void setDictPid(Long dictPid) {
        this.dictPid = dictPid;
    }

    public String getDictWeight() {
        return dictWeight;
    }

    public void setDictWeight(String dictWeight) {
        this.dictWeight = dictWeight;
    }

    public String getDictStatus() {
        return dictStatus;
    }

    public void setDictStatus(String dictStatus) {
        this.dictStatus = dictStatus;
    }

    public String getDictSharing() {
        return dictSharing;
    }

    public void setDictSharing(String dictSharing) {
        this.dictSharing = dictSharing;
    }

    public String getDictRemark() {
        return dictRemark;
    }

    public void setDictRemark(String dictRemark) {
        this.dictRemark = dictRemark;
    }

    public List<Dict> getChildren() {
        return children;
    }

    public void setChildren(List<Dict> children) {
        this.children = children;
    }

    public List<DictData> getDictData() {
        return dictData;
    }

    public void setDictData(List<DictData> dictData) {
        this.dictData = dictData;
    }
}
