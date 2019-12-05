package com.suypower.venus.sys.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.suypower.venus.elec.common.common.converter.LongToStringSerializer;

public class Role {
    /**
     * 角色标志
     */
    @JsonSerialize(using= LongToStringSerializer.class )
    private Long roleId;
    /**
     * 系统平台标志
     */
    @JsonSerialize(using= LongToStringSerializer.class )
    private Long sysId;
    /**
     * 角色编码
     */
    private String roleNo;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色等级
     */
    private String roleLeavl;
    /**
     * 角色描述
     */
    private String roleDesc;
    /**
     * 角色备注
     */
    private String roleRemark;
    /**
     * 角色状态
     */
    private String roleStatus;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getSysId() {
        return sysId;
    }

    public void setSysId(Long sysId) {
        this.sysId = sysId;
    }

    public String getRoleNo() {
        return roleNo;
    }

    public void setRoleNo(String roleNo) {
        this.roleNo = roleNo;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleLeavl() {
        return roleLeavl;
    }

    public void setRoleLeavl(String roleLeavl) {
        this.roleLeavl = roleLeavl;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public String getRoleRemark() {
        return roleRemark;
    }

    public void setRoleRemark(String roleRemark) {
        this.roleRemark = roleRemark;
    }

    public String getRoleStatus() {
        return roleStatus;
    }

    public void setRoleStatus(String roleStatus) {
        this.roleStatus = roleStatus;
    }
}
