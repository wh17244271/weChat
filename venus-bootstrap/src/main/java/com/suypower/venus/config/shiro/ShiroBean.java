package com.suypower.venus.config.shiro;

import java.util.Map;

public class ShiroBean {
    private Map<String, String> filterChainDefinitionMap;
    private String loginUrl;
    private String unauthorizedUrl;

    public Map<String, String> getFilterChainDefinitionMap() {
        return filterChainDefinitionMap;
    }

    public void setFilterChainDefinitionMap(Map<String, String> filterChainDefinitionMap) {
        this.filterChainDefinitionMap = filterChainDefinitionMap;
    }

    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

    public String getUnauthorizedUrl() {
        return unauthorizedUrl;
    }

    public void setUnauthorizedUrl(String unauthorizedUrl) {
        this.unauthorizedUrl = unauthorizedUrl;
    }

    @Override
    public String toString() {
        return "ShiroBean{" +
                "filterChainDefinitionMap=" + filterChainDefinitionMap +
                ", loginUrl='" + loginUrl + '\'' +
                ", unauthorizedUrl='" + unauthorizedUrl + '\'' +
                '}';
    }
}
