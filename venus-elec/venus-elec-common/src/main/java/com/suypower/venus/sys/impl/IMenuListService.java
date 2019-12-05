package com.suypower.venus.sys.impl;

import com.suypower.venus.sys.entity.Menu;

import java.util.List;

public interface IMenuListService {
    /**
     * 查找菜单
     * @return
     */
    List<Menu> findMenuList();

    /**
     * 添加菜单
     * @param menu
     * @return
     */
    boolean addMenu(Menu menu);

    /**
     * 删除菜单
     * @param menuId
     * @return
     */
    boolean delMenu(Long menuId);

    /**
     * 更新菜单
     * @param menu
     * @return
     */
    boolean updateMenu(Menu menu);
}
