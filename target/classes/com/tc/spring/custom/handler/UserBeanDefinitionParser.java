package com.tc.spring.custom.handler;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractBeanDefinitionParser;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

import com.tc.spring.custom.entity.User;  
  
public class UserBeanDefinitionParser extends AbstractBeanDefinitionParser implements BeanDefinitionParser {  
	@Override
	protected AbstractBeanDefinition parseInternal(Element rootElmt, ParserContext parserContext) {
		BeanDefinitionBuilder bean = BeanDefinitionBuilder.genericBeanDefinition(User.class);
		
		String userName = rootElmt.getAttribute("userName");  
        String email = rootElmt.getAttribute("email");  
  
        if (StringUtils.hasText(userName)) {  
        	bean.addPropertyValue("userName", userName);  
        }  
        if (StringUtils.hasText(email)) {  
        	bean.addPropertyValue("email", email);  
        }  
		parserContext.getRegistry().registerBeanDefinition("user", bean.getBeanDefinition());
	
		return null;
	} 
	
	@Override
	protected boolean shouldGenerateId() {
		return true;
	}
}  