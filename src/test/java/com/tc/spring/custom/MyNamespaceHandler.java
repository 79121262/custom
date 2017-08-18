package com.tc.spring.custom;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

import com.tc.spring.custom.handler.UserBeanDefinitionParser;  
public class MyNamespaceHandler extends NamespaceHandlerSupport {  
    public void init() {  
        registerBeanDefinitionParser("user", new UserBeanDefinitionParser());  
    }  
}  