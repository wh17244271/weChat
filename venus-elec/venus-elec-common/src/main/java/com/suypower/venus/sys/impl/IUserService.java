package com.suypower.venus.sys.impl;

import com.suypower.venus.sys.entity.Role;
import com.suypower.venus.sys.entity.User;

import java.time.LocalDateTime;
import java.util.List;

public interface IUserService {

    /**
     * 查找用户所拥有的角色
     * @param user
     * @return
     */
    List<Role> findRoleByUser(User user);

    /**
     * 给用户批量添加角色
     * @param userId
     * @param roleIds
     * @return
     */
    boolean addRolesToUser(Long userId,Long[] roleIds);

    /**
     *  给用户批量删除角色
     * @param userId
     * @param roleIds
     * @return
     */
    boolean delRolesToUser(Long userId,Long[] roleIds);

    /**
     * 通过用户id更改用户状态
     * @param user
     * @return
     */
    boolean updateUserStatusByUserids(User user);

    /**
     * 新增用户
     * @param user
     * @return
     */
    boolean addUser(User user);

    /**
     * 更新用户信息通过用户id
     * @param user
     * @return
     */
    boolean updateUserInfoByUserId(User user);
    /**
     * 通过多个条件查找用户信息
     * @param user
     * @return
     */
    List<User> findUserList(User user);


    /**
     * 通过用户名查找用户
     * @param username
     * @return
     */
    User findByUserName(String username);

    /**
     * 通过用户名更新用户状态(登陆时用到)
     * @param status (用户状态)
     *  @param errorCount (错误次数)
     *   @param username (用户名)
     */
    void updateUserStatus(String status , int errorCount, LocalDateTime errorTime, String username);


}
