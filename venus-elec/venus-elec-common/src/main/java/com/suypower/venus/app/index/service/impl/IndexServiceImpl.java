package com.suypower.venus.app.index.service.impl;

import com.suypower.venus.app.index.dao.IndexDao;
import com.suypower.venus.app.index.entity.IndexLabel;
import com.suypower.venus.app.index.service.IIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service( "indexService" )
public class IndexServiceImpl implements IIndexService {
    @Autowired
    private IndexDao indexDao;


    @Override
    public List<IndexLabel> queryIndex() {
        List<IndexLabel> indexLabels = indexDao.queryIndex();
        return indexLabels;
    }
}
