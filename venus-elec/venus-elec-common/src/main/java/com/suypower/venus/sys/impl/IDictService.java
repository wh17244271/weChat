package com.suypower.venus.sys.impl;

import com.suypower.venus.sys.entity.Dict;

import java.util.List;

public interface IDictService {

    /**
     * 查找指定系统的所有字典(含共享)
     *
     * @param sysId
     * @return
     */
    List<Dict> findDictList(Long sysId);

    /**
     * 添加字典
     * @return
     */
    boolean addDict(Dict dict);

    /**
     * 删除字典
     * @param dict
     * @return
     */
    boolean delDict(Dict dict);

    /**
     * 更新字典
     * @param dict
     * @return
     */
    boolean updateDict(Dict dict);
}
