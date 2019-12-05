package com.suypower.venus.sys.impl.impl;

import com.suypower.venus.sys.dao.UserDao;
import com.suypower.venus.sys.entity.Role;
import com.suypower.venus.sys.entity.User;
import com.suypower.venus.sys.impl.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<Role> findRoleByUser(User user) {
        return null;
    }

    @Override
    public boolean addRolesToUser(Long userId, Long[] roleIds) {
        return false;
    }

    @Override
    public boolean delRolesToUser(Long userId, Long[] roleIds) {
        return false;
    }

    @Override
    public boolean updateUserStatusByUserids(User user) {
        Integer result = userDao.updateUserStatusByUserids(user);
        if(result !=null && result >0){
            return true;
        }else{
            return false;
        }

    }

    @Override
    public boolean addUser(User user) {
        boolean result = userDao.addUser(user);
        return result;
    }

    @Override
    @Transactional
    public boolean updateUserInfoByUserId(User user) {
        boolean result = userDao.updateUserInfoByUserId(user);
        return result;
    }

    @Override
    public List<User> findUserList(User user) {
        List<User> userList = userDao.findUserList(user);
        return userList;
    }

    /**
     * 通过用户名查找用户
     * @param username
     * @return
     */
    @Override
    public User findByUserName(String username) {
        User user = userDao.findByUserName(username);
        return user;
    }
    /**
     * 通过用户名更新用户状态
     * @param status (用户状态)
     *  @param errorCount (错误次数)
     *   @param username (用户名)
     */
    @Override
    public void updateUserStatus(String status, int errorCount, LocalDateTime errorTime, String username) {
        userDao.updateUserStatus(status, errorCount,errorTime, username);
    }


}
