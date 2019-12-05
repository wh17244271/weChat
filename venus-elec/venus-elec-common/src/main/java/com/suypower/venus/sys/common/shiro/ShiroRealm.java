package com.suypower.venus.sys.common.shiro;

import com.suypower.venus.sys.entity.User;
import com.suypower.venus.sys.impl.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class ShiroRealm extends AuthorizingRealm {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private ShiroConfig shiroConfig;

    @Autowired
    private IUserService userService;

    @Autowired
    private RetryLimitHashedCredentialsMatcher retryLimitHashedCredentialsMatcher;

    public AuthorizationInfo getAuthorizationInfo(){
        return doGetAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
    }


    /**
     * 这里做权限控制
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("##################执行Shiro权限认证##################");
       /* UUser user = (UUser) principalCollection.getPrimaryPrincipal();
        if (user != null) {
            //权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            //用户的角色集合
            info.addRoles(user.getRoleStrlist());
            //用户的权限集合
            info.addStringPermissions(user.getPerminsStrlist());

            return info;
        }*/

        // 返回null的话，就会导致任何用户访问被拦截的请求时，都会自动跳转到unauthorizedUrl指定的地址

        User user = (User) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRole("超级管理员");
        info.addStringPermission("添加用户");
        return info;
    }

    /**
     * 这里做登录控制
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        boolean b = retryLimitHashedCredentialsMatcher.doCredentialsMatch(authenticationToken,);


        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        logger.info("验证当前Subject时获取到token为：" + token.toString());
        //查出是否有此用户
        String username = token.getUsername();
        User hasUser = userService.findByUserName(username);

        if (hasUser != null) {
            // 若存在，将此用户存放到登录认证info中，无需自己做密码对比，Shiro会为我们进行密码对比校验
//            List<URole> rlist = uRoleDao.findRoleByUid(hasUser.getId());//获取用户角色
//            List<UPermission> plist = uPermissionDao.findPermissionByUid(hasUser.getId());//获取用户权限
//            List<String> roleStrlist=new ArrayList<String>();////用户的角色集合
//            List<String> perminsStrlist=new ArrayList<String>();//用户的权限集合
//            for (URole role : rlist) {
//                roleStrlist.add(role.getName());
//            }
//            for (UPermission uPermission : plist) {
//                perminsStrlist.add(uPermission.getName());
//            }
//            hasUser.setRoleStrlist(roleStrlist);
//            hasUser.setPerminsStrlist(perminsStrlist);
            // 若存在，将此用户存放到登录认证info中，无需自己做密码对比，Shiro会为我们进行密码对比校验

            return new SimpleAuthenticationInfo(hasUser, hasUser.getUserPassword(), getName());
        }else{
            throw new UnknownAccountException("用户名不存在");
        }


    }






}
