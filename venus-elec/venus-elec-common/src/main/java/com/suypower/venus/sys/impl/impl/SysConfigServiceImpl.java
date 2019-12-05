package com.suypower.venus.sys.impl.impl;

import com.suypower.venus.sys.entity.SysConfig;
import com.suypower.venus.sys.impl.ISysConfigService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service( "sysConfigService" )
public class SysConfigServiceImpl implements ISysConfigService {


    @Override
    public List<SysConfig> findSysConfigList(Long sysId) {
        return null;
    }
}
