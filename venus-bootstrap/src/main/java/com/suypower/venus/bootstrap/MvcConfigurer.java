package com.suypower.venus.bootstrap;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class MvcConfigurer extends WebMvcConfigurationSupport {


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }

//    @Override
//    protected void addViewControllers(ViewControllerRegistry registry) {
//
////若无业务逻辑处理，直接请求页面可以再次设置请求资源
//        registry.addViewController("/").setViewName("forward:dist/index.html");
//        super.addViewControllers(registry);
//    }

   /* @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        super.configurePathMatch(configurer);
        configurer.setUseSuffixPatternMatch(false);
    }*/
}