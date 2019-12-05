package com.suypower.venus.sys.impl.impl;

import com.suypower.venus.sys.entity.Dict;
import com.suypower.venus.sys.impl.IDictService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service( "dictService" )
public class DictServiceImpl implements IDictService {


    @Override
    public List<Dict> findDictList(Long sysId) {
        return null;
    }

    @Override
    public boolean addDict(Dict dict) {
        return false;
    }

    @Override
    public boolean delDict(Dict dict) {
        return false;
    }

    @Override
    public boolean updateDict(Dict dict) {
        return false;
    }
}
