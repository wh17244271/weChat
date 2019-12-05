package com.suypower.venus.sys.controller;


import com.suypower.venus.platform.web.controller.BaseController;
import com.suypower.venus.platform.web.response.VenusResponse;
import com.suypower.venus.platform.web.response.VenusResponseHttpCode;
import com.suypower.venus.sys.entity.System;
import com.suypower.venus.sys.entity.User;
import com.suypower.venus.sys.impl.ISystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/sys/system")
public class SystemController extends BaseController {

    @Autowired
    private ISystemService systemService;

    /**
     * 查找系统列表
     * @return
     */
    @RequestMapping( "/findSysList" )
    @ResponseBody
    public VenusResponse<List<User> > findRoleList() {
        List<System> result = systemService.findSysList();
        return new VenusResponse(VenusResponseHttpCode.OK, result);
    }





}
