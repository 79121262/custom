package com.tc.spring.custom;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

import com.tc.spring.custom.annotation.AnnotationDrivenDefinitionParser;
import com.tc.spring.custom.handler.UserBeanDefinitionParser;  
public class MyNamespaceHandler extends NamespaceHandlerSupport {  
    public void init() {  
        registerBeanDefinitionParser("user", new UserBeanDefinitionParser());  
        registerBeanDefinitionParser("annotation-driven", new AnnotationDrivenDefinitionParser());
    }  
}  