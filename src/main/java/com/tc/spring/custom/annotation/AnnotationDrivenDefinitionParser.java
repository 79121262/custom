package com.tc.spring.custom.annotation;

import org.springframework.aop.config.AopNamespaceUtils;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.cache.annotation.AnnotationCacheOperationSource;
import org.w3c.dom.Element;

public class AnnotationDrivenDefinitionParser implements BeanDefinitionParser {

	@Override
	public BeanDefinition parse(Element element, ParserContext parserContext) {
		// TODO Auto-generated method stub
		AopAutoProxyConfigurer.configureAutoProxyCreator(element, parserContext);
		return null;
	}

	private static class AopAutoProxyConfigurer {

		public static void configureAutoProxyCreator(Element element, ParserContext parserContext) {
			AopNamespaceUtils.registerAutoProxyCreatorIfNecessary(parserContext, element);
			
			Object eleSource = parserContext.extractSource(element);
			// Create the CacheOperationSource definition.
			RootBeanDefinition sourceDef = new RootBeanDefinition(AnnotationCacheOperationSource.class);
			sourceDef.setSource(eleSource);
			sourceDef.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
			String sourceName = parserContext.getReaderContext().registerWithGeneratedName(sourceDef);
			
			
		}
	}

}