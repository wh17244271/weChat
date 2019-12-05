package com.suypower.venus.platform.springboot.configure;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.util.Assert;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

//@Configuration
public class DefaultEnvironmentWare implements ServletContextInitializer,EnvironmentAware {

    static Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        DefaultEnvironmentWare.environment = environment;
        String[] profiles   = environment.getActiveProfiles();
        Profile profile = null;
        for(String s : profiles){
             profile = Profile.parse(s);
        }
        Assert.notNull(profile,"ELT运行环境不正确！");
    }

    public static Environment getEnvironment(){
        return environment;
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

    }
}