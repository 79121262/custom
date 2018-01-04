package com.tc.spring.custom.property;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

public class TcPropertyPlaceholderBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {
	private static final String SYSTEM_PROPERTIES_MODE_ATTRIB = "system-properties-mode";
	private static final String SYSTEM_PROPERTIES_MODE_DEFAULT = "ENVIRONMENT";
	
	@Override
	protected Class<?> getBeanClass(Element element) {
		if (element.getAttribute(SYSTEM_PROPERTIES_MODE_ATTRIB).equals(SYSTEM_PROPERTIES_MODE_DEFAULT)) {
			return TcPropertySourcesPlaceholderConfigurer.class;
		}
		return PropertyPlaceholderConfigurer.class;
	}
	
	@Override
	protected void doParse(Element element, BeanDefinitionBuilder builder) {
		/**
		 * Ö§³Öspring-context
		 */
		super.doParse(element, builder);

		/**
		 * init all props
		 */
		//PropertiesUtils.getPropsConfig(element);
		PropertyHolder.getProperties().put("abc", "hello word spring properties");
	}
	
	@Override
	protected void doParse(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {
		this.doParse(element, builder);
		
		System.out.println("this.doParse");
	}
	
	@Override
	protected boolean shouldGenerateId() {
		return true;
	}
	
	
}
