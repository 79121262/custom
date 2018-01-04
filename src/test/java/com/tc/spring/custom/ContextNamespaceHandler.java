package com.tc.spring.custom;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

import com.tc.spring.custom.property.TcPropertyPlaceholderBeanDefinitionParser;  
public class ContextNamespaceHandler extends NamespaceHandlerSupport {  
    public void init() {  
    	 registerBeanDefinitionParser("property-placeholder", new TcPropertyPlaceholderBeanDefinitionParser());  
    }  
}  