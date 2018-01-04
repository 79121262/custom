package com.tc.spring.custom.property;

import java.util.Properties;
public class PropertyHolder {
	private static Properties properties = new Properties();

	public static void addProperties(Properties properties) {
		try {
			PropertyHolder.properties.putAll(properties);
		} catch (Throwable e) {
		}
	}
	public static Properties getProperties() {
		return PropertyHolder.properties;
	}
}