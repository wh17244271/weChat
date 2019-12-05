package com.suypower.venus.app.cs.service.impl;

import com.suypower.venus.app.cs.dao.CsObjectStrucureDao;
import com.suypower.venus.app.cs.entity.CsObjectInfoStructure;
import com.suypower.venus.app.cs.entity.CsObjectRelation;
import com.suypower.venus.app.cs.entity.CsObjectStructure;
import com.suypower.venus.app.cs.service.ICsObjectStrucureService;
import com.suypower.venus.platform.share.entity.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service( "csObjectStrucureService" )
public class CsObjectStrucureServiceImpl implements ICsObjectStrucureService {

    @Autowired
    private CsObjectStrucureDao csObjectStrucureDao;


    @Override
    public List<CsObjectInfoStructure> queryForList(CsObjectStructure csObjectStructure) {
        List<CsObjectInfoStructure> csObjectInfoStructures = csObjectStrucureDao.queryForList(csObjectStructure);
//        for(CsObjectInfoStructure re:csObjectInfoStructures){
//            re.setChecked(true);
//        }
        return csObjectInfoStructures;
    }

    @Override
    public Tree<CsObjectInfoStructure> queryForTree(CsObjectStructure csObjectStructure) {
        List<CsObjectInfoStructure> csObjectInfoStructures = this.queryForList(csObjectStructure);

        Tree<CsObjectInfoStructure> csObjectInfoStructureTree = new Tree<>(csObjectInfoStructures);
        return csObjectInfoStructureTree;
    }

    @Override
    public List<CsObjectRelation> getRelationIdByArcId(String[] arcIds) {
        List<CsObjectRelation> relationIdByArcId = csObjectStrucureDao.getRelationIdByArcId(arcIds);
        return relationIdByArcId;
    }
}
