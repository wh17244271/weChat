package com.suypower.venus.sys.impl;

import com.suypower.venus.sys.entity.System;

import java.util.List;

public interface ISystemService {
    /**
     *查找系统列表
     * @return
     */
    List<System> findSysList();

    /**
     * 给系统分配菜单
     * @param menuIds
     * @return
     */
    boolean addMenusToSys(Long[] menuIds);

    /**
     * 删除系统菜单
     * @param menuIds
     * @return
     */
    boolean delMenusToSys(Long[] menuIds);

}
