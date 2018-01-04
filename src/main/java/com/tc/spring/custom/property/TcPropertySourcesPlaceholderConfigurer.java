package com.tc.spring.custom.property;

import java.io.IOException;
import java.util.Properties;

import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

public class TcPropertySourcesPlaceholderConfigurer extends PropertySourcesPlaceholderConfigurer {

	@Override
	protected void loadProperties(Properties props) throws IOException {
		// PropertyHolder.addProperties(props);

		props.putAll(PropertyHolder.getProperties());
	}

}