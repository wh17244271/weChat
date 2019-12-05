package com.suypower.venus.app.cs.service;


import com.suypower.venus.app.cs.entity.CsObjectInfoStructure;
import com.suypower.venus.app.cs.entity.CsObjectRelation;
import com.suypower.venus.app.cs.entity.CsObjectStructure;
import com.suypower.venus.platform.share.entity.Tree;

import java.util.List;


/**
 * @auther:maofukai
 * @date:2019-07-29 档案结构
 */
public interface ICsObjectStrucureService {

    /**
     * 将档案结构生成树
     * consNo   用户编号,不能为空
     * stClsId  档案结构分类标识 与 stClsNo 满足一个不为空即可
     * stClsNo  档案结构分类编号 与 stClsId 满足一个不为空即可
     * arcPid   显示该节点下(包含自己)所有数据
     * @param csObjectStructure
     * @return
     */
    List<CsObjectInfoStructure> queryForList(CsObjectStructure csObjectStructure);

    /**
     * 将档案结构生成树
     * consNo   用户编号,不能为空
     * stClsId  档案结构分类标识 与 stClsNo 满足一个不为空即可
     * stClsNo  档案结构分类编号 与 stClsId 满足一个不为空即可
     * arcPid   显示该节点下(包含自己)所有数据
     * @param csObjectStructure
     * @return
     */
   Tree<CsObjectInfoStructure> queryForTree(CsObjectStructure csObjectStructure);

    /**
     * 通过arcId查询关联关系
     * @param arcIds
     * @return
     */
    List<CsObjectRelation> getRelationIdByArcId(String[] arcIds);
}
