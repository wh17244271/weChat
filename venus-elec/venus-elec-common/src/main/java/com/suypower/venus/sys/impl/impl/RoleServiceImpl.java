package com.suypower.venus.sys.impl.impl;

import com.suypower.venus.sys.dao.RoleDao;
import com.suypower.venus.sys.entity.Role;
import com.suypower.venus.sys.impl.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service( "roleService" )
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> findRoleList(Long sysId) {
        Role role = new Role();
        role.setSysId(sysId);
        List<Role> roleList = roleDao.findRoleList(role);
        return roleList;
    }

    @Override
    public boolean addRole(Role role) {
        return false;
    }

    @Override
    public boolean updateRoleInfoByRoleId(Role role) {
        return false;
    }
}
