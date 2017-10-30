package com.tc.spring.custom.handler;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractBeanDefinitionParser;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

import com.tc.spring.custom.entity.User;  
 
/**
 * 
 * @author cai.tian
 * 自定义标签
 */
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
        //注册到spring 环境  ---内部实现DefaultListableBeanFactory registerBeanDefinition 注册一个BeanDefinition
		parserContext.getRegistry().registerBeanDefinition("user", bean.getBeanDefinition());
	
		return null;
	} 
	
	@Override
	protected boolean shouldGenerateId() {
		return true;
	}
}  