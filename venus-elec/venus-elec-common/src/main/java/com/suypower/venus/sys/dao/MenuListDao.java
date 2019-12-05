package com.suypower.venus.sys.dao;

import com.suypower.venus.sys.entity.Menu;

import java.util.List;

public interface MenuListDao {
    /**
     * 查找菜单
     * @return
     */
    List<Menu> findMenuList();

}
