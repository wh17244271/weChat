package com.suypower.venus.sys.impl.impl;

import com.suypower.venus.sys.entity.UserConfig;
import com.suypower.venus.sys.impl.IUserConfigService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service( "userConfigService" )
public class UserConfigServiceImpl implements IUserConfigService {


    @Override
    public List<UserConfig> findUserConfigList(Long sysId) {
        return null;
    }
}
