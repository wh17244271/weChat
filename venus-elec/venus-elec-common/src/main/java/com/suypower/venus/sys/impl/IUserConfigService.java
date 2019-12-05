package com.suypower.venus.sys.impl;

import com.suypower.venus.sys.entity.UserConfig;

import java.util.List;

public interface IUserConfigService {

    /**
     * 查找系统平台下的所有用户配置
     * @param sysId
     * @return
     */
    List<UserConfig> findUserConfigList(Long sysId);



}
