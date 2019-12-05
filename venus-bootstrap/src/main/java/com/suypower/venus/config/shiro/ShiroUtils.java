package com.suypower.venus.config.shiro;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class ShiroUtils {
    public static Logger logger = LoggerFactory.getLogger(ShiroUtils.class);

    public static ShiroBean xmlShiroBean() {
        ShiroBean shiroBean = new ShiroBean();
        InputStream inputStream = null;
        try {
            //1.创建Reader对象
            SAXReader reader = new SAXReader();
            //2.加载xml
            ClassPathResource classPathResource = new ClassPathResource("shiro-config.xml");


            inputStream = classPathResource.getInputStream();
            Document document = null;
            document = reader.read(inputStream);
            //3.获取根节点
            Element rootElement = document.getRootElement();
            Iterator iterator = rootElement.elementIterator();

            Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
            while (iterator.hasNext()) {
                Element stu = (Element) iterator.next();

                String name = stu.getName();
                String textTrim = stu.getTextTrim();
                if ("anon".equals(name) || "authc".equals(name)) {
                    Iterator iterator1 = stu.elementIterator();
                    while (iterator1.hasNext()) {
                        Element stuChild = (Element) iterator1.next();
                        String url = stuChild.getTextTrim();
                        filterChainDefinitionMap.put(url, name);
                        shiroBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
                    }
                } else if ("loginUrl".equals(name)) {
                    shiroBean.setLoginUrl(textTrim);
                } else if ("unauthorizedUrl".equals(name)) {
                    shiroBean.setUnauthorizedUrl(textTrim);
                }

            }

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return shiroBean;
    }
}
