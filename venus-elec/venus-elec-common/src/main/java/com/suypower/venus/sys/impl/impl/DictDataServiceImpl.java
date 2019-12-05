package com.suypower.venus.sys.impl.impl;

import com.suypower.venus.sys.entity.DictData;
import com.suypower.venus.sys.impl.IDictDataService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service( "dictDataService" )
public class DictDataServiceImpl implements IDictDataService {

    @Override
    public List<DictData> findDictList(Long dictId) {
        return null;
    }

    @Override
    public boolean addDictData(DictData dictData) {
        return false;
    }

    @Override
    public boolean delDictData(DictData dictData) {
        return false;
    }

    @Override
    public boolean updateDictData(DictData dictData) {
        return false;
    }
}
