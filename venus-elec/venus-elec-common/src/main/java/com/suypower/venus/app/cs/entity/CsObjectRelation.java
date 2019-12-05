package com.suypower.venus.app.cs.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.suypower.venus.elec.common.common.converter.LongToStringSerializer;
import com.suypower.venus.platform.share.entity.Node;

/**
 * @auther:maofukai
 * @date:2019-08-13 档案关联
 */
public class CsObjectRelation {

    /**
     * 档案标识
     */
    @JsonSerialize(using = LongToStringSerializer.class)
    private Long arcId;

    /**
     * 关联类型
     */
    private String relationType;

    /**
     * 关联标识
     */
    private Long relationId;

    /**
     * 关联状态
     */
    private String relationStatus;

    public Long getArcId() {
        return arcId;
    }

    public void setArcId(Long arcId) {
        this.arcId = arcId;
    }

    public String getRelationType() {
        return relationType;
    }

    public void setRelationType(String relationType) {
        this.relationType = relationType;
    }

    public Long getRelationId() {
        return relationId;
    }

    public void setRelationId(Long relationId) {
        this.relationId = relationId;
    }

    public String getRelationStatus() {
        return relationStatus;
    }

    public void setRelationStatus(String relationStatus) {
        this.relationStatus = relationStatus;
    }
}
