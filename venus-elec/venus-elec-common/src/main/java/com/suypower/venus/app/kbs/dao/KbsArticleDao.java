package com.suypower.venus.app.kbs.dao;


import com.suypower.venus.app.kbs.entity.KbsArticleCategory;

import java.util.List;

public interface KbsArticleDao {

    /**
     * 展示文章分类
     * @param categoryId 分类id
     * @return
     */
    List<KbsArticleCategory> queryKbsArticleCategory(String categoryId);

}

