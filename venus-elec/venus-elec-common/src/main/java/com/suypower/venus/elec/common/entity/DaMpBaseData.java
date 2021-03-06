package com.suypower.venus.elec.common.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.suypower.venus.elec.common.common.Index;
import com.suypower.venus.elec.common.common.converter.IndexSerializer;

/**
 * @author maofukai
 * @date 2019-07-12
 * 测点基本采集数据
 */
public class DaMpBaseData extends DaMpBaseInfo{

    /**
     * 基础指标编号
     */
    @JsonSerialize( using = IndexSerializer.class )
    private Index index;

    public Index getIndex() {
        return index;
    }

    public void setIndex(Index index) {
        this.index = index;
    }

    @JsonProperty( "indBNo" )
    public String getIndBNo() {
        return index != null ? index.getIndBNo() : null;
    }

    /**
     * 由于Mybatis映射枚举问题、临时解决方案、后期该方案会移除
     * 代码中不要使用该方法!!!
     * @param indBNo
     */
    @Deprecated
    public void setIndBNo(String indBNo) {
        Index index = Index.parse(indBNo);
        this.index = index;
    }
}
