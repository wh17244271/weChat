package com.suypower.venus.elec.common.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.suypower.venus.elec.common.common.Index;
import com.suypower.venus.elec.common.common.converter.DataItemSerializer;
import com.suypower.venus.elec.common.common.converter.IndexSerializer;

/**
 * 数据项
 */
@JsonSerialize( using = DataItemSerializer.class )
public class DaDataItem {

    /**
     * 数据指标
     */
    @JsonSerialize( using = IndexSerializer.class )
    private Index index;

    /**
     * 数据
     */
    private Double value;

    public DaDataItem(String index, Double value) {
        this.index = Index.parse(index);
        this.value = value;
    }

    public DaDataItem(Index index, Double value) {
        this.index = index;
        this.value = value;
    }

    public DaDataItem() {
    }

    public Index getIndex() {
        return index;
    }

    public void setIndex(Index index) {
        this.index = index;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @JsonProperty( "indBNo" )
    public String getIndBNo() {
        return index != null ? index.getIndBNo() : null;
    }

    /**
     * 由于Mybatis映射枚举问题、临时解决方案、后期该方案会移除
     *
     * @param indBNo
     */
    @Deprecated
    public void setIndBNo(String indBNo) {
        Index indexes = Index.parse(indBNo);

        this.index = indexes;

    }
}
