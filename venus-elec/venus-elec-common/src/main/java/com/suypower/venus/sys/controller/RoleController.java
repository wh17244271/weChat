package com.suypower.venus.sys.controller;


import com.suypower.venus.elec.common.utils.Assert;
import com.suypower.venus.elec.common.utils.Types;
import com.suypower.venus.platform.web.controller.BaseController;
import com.suypower.venus.platform.web.response.VenusResponse;
import com.suypower.venus.platform.web.response.VenusResponseHttpCode;
import com.suypower.venus.sys.entity.Role;
import com.suypower.venus.sys.entity.User;
import com.suypower.venus.sys.impl.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/sys/role")
public class RoleController extends BaseController {

    @Autowired
    private IRoleService roleService;

    /**
     * 查找系统平台下的所有角色
     * @param sysId
     * @return
     */
    @RequestMapping( "/findRoleList" )
    @ResponseBody
    public VenusResponse<List<User> > findRoleList(String sysId) {
        Assert.isEmpty(sysId,"平台id不能为空");
        List<Role> roleList = roleService.findRoleList(Types.Long(sysId));
        return new VenusResponse(VenusResponseHttpCode.OK, roleList);
    }





}
