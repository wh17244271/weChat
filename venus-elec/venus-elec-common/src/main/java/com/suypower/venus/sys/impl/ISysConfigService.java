package com.suypower.venus.sys.impl;

import com.suypower.venus.sys.entity.SysConfig;

import java.util.List;

public interface ISysConfigService {


    /**
     * 查找系统平台下的所有系统配置
     * @param sysId
     * @return
     */
    List<SysConfig> findSysConfigList(Long sysId);

}
