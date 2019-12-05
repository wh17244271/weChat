package com.suypower.venus.sys.dao;

import com.suypower.venus.sys.entity.User;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface UserDao {

    /**
     * 通过用户id更改用户状态
     * @param user
     * @return
     */
    Integer updateUserStatusByUserids(User user);

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
     *
     * @param username
     * @return
     */
    User findByUserName(String username);

    /**
     * 通过用户名更新用户状态
     *
     * @param status     (用户状态)
     * @param errorCount (错误次数)
     * @param errorTime  (错误时间)
     * @param username   (用户名)
     */
    void updateUserStatus(@Param( "status" ) String status,
                          @Param( "errorCount" ) int errorCount,
                          @Param( "errorTime" ) LocalDateTime errorTime,
                          @Param( "username" ) String username);

}
