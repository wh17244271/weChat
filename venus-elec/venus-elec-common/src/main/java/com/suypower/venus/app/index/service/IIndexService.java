package com.suypower.venus.app.index.service;

import com.suypower.venus.app.index.entity.IndexLabel;

import java.util.List;


public interface IIndexService {

    /**
     * 查询指标结构
     * @return
     */
    List<IndexLabel> queryIndex();

}
