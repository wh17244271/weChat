package com.suypower.venus.sys.dao;

import com.suypower.venus.sys.entity.System;

import java.util.List;

public interface SystemDao {

    /**
     *查找系统列表
     * @return
     */
    List<System> findSysList();



}
