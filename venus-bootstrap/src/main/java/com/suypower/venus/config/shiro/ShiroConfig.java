package com.suypower.venus.config.shiro;

import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.session.mgt.eis.MemorySessionDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    /**
     * ShiroFilterFactoryBean 处理拦截资源文件问题。
     * 注意：单独一个ShiroFilterFactoryBean配置是或报错的，以为在
     * 初始化ShiroFilterFactoryBean的时候需要注入：SecurityManager
     * Filter Chain定义说明 1、一个URL可以配置多个Filter，使用逗号分隔 2、当设置多个过滤器时，全部验证通过，才视为通过
     * 3、部分过滤器可指定参数，如perms，roles
     */
    @Value( "${shiro.sessionTime}" )
    private Long sessionTime;

    @Bean
    public ShiroFilterFactoryBean shirFilter(org.apache.shiro.mgt.SecurityManager securityManager) {

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        shiroFilterFactoryBean.setSecurityManager(securityManager);

        ShiroBean shiroBean = ShiroUtils.xmlShiroBean();

        Map<String, Filter> filters = new HashMap<String, Filter>();
        shiroFilterFactoryBean.setFilters(filters);
        shiroFilterFactoryBean.setUnauthorizedUrl(shiroBean.getUnauthorizedUrl());
        shiroFilterFactoryBean.setLoginUrl( shiroBean.getLoginUrl());
        Map<String, String> filterChainDefinitionMap = shiroBean.getFilterChainDefinitionMap();
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean( name = "securityManager" )
    public DefaultWebSecurityManager getDefaultWebSecurityManager(ShiroRealm shiroRealm) {
        DefaultWebSecurityManager dwsm = new DefaultWebSecurityManager();
        dwsm.setRealm(shiroRealm);
        //  <!-- 用户授权/认证信息Cache, 采用EhCache 缓存 -->
        dwsm.setCacheManager(getEhCacheManager());
        dwsm.setSessionManager(getDefaultWebSessionManager());
        return dwsm;
    }

    /**
     * 身份认证realm;
     * (这个需要自己写，账号密码校验；权限等)
     *
     * @return
     */
    @Bean
    public ShiroRealm shiroRealm() {
        ShiroRealm myShiroRealm = new ShiroRealm();
        return myShiroRealm;
    }

    @Bean
    public EhCacheManager getEhCacheManager() {
        EhCacheManager em = new EhCacheManager();
        em.setCacheManagerConfigFile("classpath:ehcache-shiro.xml");
        return em;
    }



    /**
     * 配置org.apache.shiro.web.session.mgt.DefaultWebSessionManager
     *
     * @return
     */
    @Bean( name = "sessionManager" )
    public DefaultWebSessionManager getDefaultWebSessionManager() {
        DefaultWebSessionManager defaultWebSessionManager = new DefaultWebSessionManager();
        defaultWebSessionManager.setSessionDAO(getMemorySessionDAO());
        defaultWebSessionManager.setSessionIdCookie(getSimpleCookie());
        defaultWebSessionManager.setCacheManager(getEhCacheManager());

        // 全局会话超时时间（单位毫秒 1:1000），默认30分钟
        defaultWebSessionManager.setGlobalSessionTimeout(sessionTime*60* 1000);
        // 是否开启删除无效的session对象，默认为true
        defaultWebSessionManager.setDeleteInvalidSessions(true);
        // 是否开启定时调度器进行检测过期session，默认为true
        defaultWebSessionManager.setSessionValidationSchedulerEnabled(true);
        defaultWebSessionManager.setSessionIdCookieEnabled(true);
        //取消url 后面的 JSESSIONID
        defaultWebSessionManager.setSessionIdUrlRewritingEnabled(false);

        return defaultWebSessionManager;
    }

    /**
     * 配置org.apache.shiro.session.mgt.eis.MemorySessionDAO
     *
     * @return
     */
    @Bean
    public MemorySessionDAO getMemorySessionDAO() {
        MemorySessionDAO memorySessionDAO = new MemorySessionDAO();
        memorySessionDAO.setSessionIdGenerator(javaUuidSessionIdGenerator());
        return memorySessionDAO;
    }

    @Bean
    public JavaUuidSessionIdGenerator javaUuidSessionIdGenerator() {
        return new JavaUuidSessionIdGenerator();
    }

    /**
     * session自定义cookie名
     *
     * @return
     */
    @Bean
    public SimpleCookie getSimpleCookie() {
        SimpleCookie simpleCookie = new SimpleCookie("security.session.id");

        //setcookie的httponly属性如果设为true的话，会增加对xss防护的安全系数。它有以下特点：

        //设为true后，只能通过http访问，javascript无法访问
        //防止xss读取cookie
        simpleCookie.setHttpOnly(true);
        simpleCookie.setPath("/");

        // maxAge=-1 表示浏览器关闭时失效此Cookie
        simpleCookie.setMaxAge(-1);

        return simpleCookie;
    }


    // 开启Controller中的shiro注解
    @Bean
    public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator daap = new DefaultAdvisorAutoProxyCreator();
        daap.setProxyTargetClass(true);
        return daap;
    }

    /**
     * 开启shrio注解支持
     *
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor(ShiroRealm shiroRealm) {
        AuthorizationAttributeSourceAdvisor aasa = new AuthorizationAttributeSourceAdvisor();
        aasa.setSecurityManager(getDefaultWebSecurityManager(shiroRealm));
        return aasa;
    }

    /**
     * shiro 的生命周期配置
     * @return
     */
    @Bean
    public static LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

}
