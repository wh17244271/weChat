package com.suypower.venus.sys.impl.impl;

import com.suypower.venus.sys.dao.SystemDao;
import com.suypower.venus.sys.entity.System;
import com.suypower.venus.sys.impl.ISystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service( "systemService" )
public class SystemServiceImpl implements ISystemService {

    @Autowired
    private SystemDao systemDao;
    @Override
    public List<System> findSysList() {

        List<System> sysList = systemDao.findSysList();
        return sysList;
    }

    @Override
    public boolean addMenusToSys(Long[] menuIds) {
        return false;
    }

    @Override
    public boolean delMenusToSys(Long[] menuIds) {
        return false;
    }
}
