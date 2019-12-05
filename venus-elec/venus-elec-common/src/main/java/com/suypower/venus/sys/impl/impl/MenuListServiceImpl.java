package com.suypower.venus.sys.impl.impl;

import com.suypower.venus.elec.common.utils.StringUtils;
import com.suypower.venus.sys.dao.MenuListDao;
import com.suypower.venus.sys.entity.Menu;
import com.suypower.venus.sys.impl.IMenuListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("menuListService")
public class MenuListServiceImpl implements IMenuListService {

    @Autowired
    private MenuListDao menuListDao;
    @Override
    public List<Menu> findMenuList() {
        List<Menu> menuList = menuListDao.findMenuList();

        return  addMeta(menuList);
    }

    @Override
    public boolean addMenu(Menu menu) {
        return false;
    }

    @Override
    public boolean delMenu(Long menuId) {
        return false;
    }

    @Override
    public boolean updateMenu(Menu menu) {
        return false;
    }

    /**
     * 递归补充meta
     * @param list
     * @return
     */
    private static List<Menu> addMeta(List<Menu> list){
        if(!StringUtils.isEmpty(list)){
            for(Menu menu:list){
                Map<String,Object> meta = new HashMap<>();
                meta.put("icon",menu.getIcon());
                meta.put("title",menu.getTitle());
                meta.put("hideInBread",menu.isHideInBread());
                meta.put("hideInMenu",menu.isHideInMenu());
                meta.put("notCache",menu.isNotCache());
                meta.put("access",menu.getAccess());
                meta.put("beforeCloseName",menu.getBeforeCloseName());
                menu.setMeta(meta);
                addMeta(menu.getChildren());

            }
        }
        return list;
    }


}
