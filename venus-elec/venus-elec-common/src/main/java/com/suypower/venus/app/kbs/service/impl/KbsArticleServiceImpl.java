package com.suypower.venus.app.kbs.service.impl;

import com.suypower.venus.app.kbs.dao.KbsArticleDao;
import com.suypower.venus.app.kbs.entity.KbsArticleCategory;
import com.suypower.venus.app.kbs.service.IKbsArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service( "kbsArticleService" )
public class KbsArticleServiceImpl implements IKbsArticleService {
    @Autowired
    private KbsArticleDao kbsArticleDao;


    @Override
    public List<KbsArticleCategory> queryKbsArticleCategory() {
        List<KbsArticleCategory> kbsArticleCategories = kbsArticleDao.queryKbsArticleCategory("-1");
        return kbsArticleCategories;
    }
}
