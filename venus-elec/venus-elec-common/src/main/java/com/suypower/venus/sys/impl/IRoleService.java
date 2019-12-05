package com.suypower.venus.sys.impl;

import com.suypower.venus.sys.entity.Role;

import java.util.List;

public interface IRoleService {

    /**
     * 查找系统平台下的所有角色
     * @param sysId
     * @return
     */
    List<Role> findRoleList(Long sysId);

    /**
     * 新增角色
     * @param role
     * @return
     */
    boolean addRole(Role role);

    /**
     * 更新角色信息通过角色id
     * @param role
     * @return
     */
    boolean updateRoleInfoByRoleId(Role role);



}
