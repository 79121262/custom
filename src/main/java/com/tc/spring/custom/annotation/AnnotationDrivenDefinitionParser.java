package com.tc.spring.custom.annotation;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.xml.AbstractBeanDefinitionParser;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;
/**
 * 
 * @author cai.tian
 * 自定义注解
 */

public class AnnotationDrivenDefinitionParser extends AbstractBeanDefinitionParser implements BeanDefinitionParser {

	private static class AopAutoProxyConfigurer {
		public static void configureAutoProxyCreator(Element element, ParserContext parserContext) {
			//拿到xml base-package 包名
			String packagea = element.getAttribute("base-package");
			if (StringUtils.hasText(packagea)) {
				BeanDefinitionRegistry registry = parserContext.getReaderContext().getRegistry();
				ResourceLoader resourceLoader = parserContext.getReaderContext().getResourceLoader();
				com.tc.spring.custom.annotation.Scanner scanner = new com.tc.spring.custom.annotation.Scanner(registry);
				scanner.setResourceLoader(resourceLoader);
				scanner.scan(packagea);
			}

		}
	}

	@Override
	protected AbstractBeanDefinition parseInternal(Element element, ParserContext parserContext) {
		AopAutoProxyConfigurer.configureAutoProxyCreator(element, parserContext);
		return null;
	}

}