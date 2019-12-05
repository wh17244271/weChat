package com.suypower.venus.app.kbs.service;

import com.suypower.venus.app.kbs.entity.KbsArticleCategory;

import java.util.List;


public interface IKbsArticleService {

    /**
     * 展示文章分类
     * @return
     */
    List<KbsArticleCategory> queryKbsArticleCategory();

}
