package com.suypower.venus.sys.impl;

import com.suypower.venus.sys.entity.DictData;

import java.util.List;

public interface IDictDataService {

    /**
     * 查找字典数据
     *
     * @param dictId
     * @return
     */
    List<DictData> findDictList(Long dictId);

    /**
     * 添加字典数据
     * @param dictData
     * @return
     */
    boolean addDictData(DictData dictData);

    /**
     * 删除字典数据
     * @param dictData
     * @return
     */
    boolean delDictData(DictData dictData);

    /**
     * 更新字典数据
     * @param dictData
     * @return
     */
    boolean updateDictData(DictData dictData);
}
