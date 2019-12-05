package com.suypower.venus.platform.springboot.configure;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

import javax.servlet.*;
import java.util.EnumSet;

//@Configuration
public class DruidConfiguration implements ServletContextInitializer,EnvironmentAware {

    @Override
    public void setEnvironment(Environment environment) {

    }


    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        ServletRegistration.Dynamic viewServlet = servletContext.addServlet("StatViewServlet",new StatViewServlet());
        viewServlet.addMapping("/druid/*");
        viewServlet.setInitParameter("allow", "127.0.0.1");
        //IP黑名单 (存在共同时，deny优先于allow) : 如果满足deny的话提示:Sorry, you are not permitted to view this page.
        viewServlet.setInitParameter("allow", "192.168.0.109");
        //登录查看信息的账号密码.
        viewServlet.setInitParameter("loginUsername", "admin");
        viewServlet.setInitParameter("loginPassword", "suypower");
        //是否能够重置数据.
        viewServlet.setInitParameter("resetEnable", "false");

        FilterRegistration.Dynamic statFilter = servletContext.addFilter("WebStatFilter", new WebStatFilter
                ());

        EnumSet<DispatcherType> dispatcherTypes = EnumSet
                .allOf(DispatcherType.class);
        dispatcherTypes.add(DispatcherType.REQUEST);
        dispatcherTypes.add(DispatcherType.FORWARD);
        statFilter.addMappingForUrlPatterns(dispatcherTypes, true, "/*");

        statFilter.setInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");

    }
}