package com.suypower.venus.app.index.dao;


import com.suypower.venus.app.index.entity.IndexLabel;

import java.util.List;

public interface IndexDao {


    /**
     * 查询指标结构
     * @return
     */
    List<IndexLabel> queryIndex();

}

