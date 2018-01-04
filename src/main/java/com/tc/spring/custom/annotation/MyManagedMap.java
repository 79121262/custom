package com.tc.spring.custom.annotation;

import java.util.Map;

/**
 * ²âÊÔ spring ¼ÓÔØManagedMap ¹ı³Ì
 * @author cai.tian
 *
 */
public class MyManagedMap {
	private Map<Object, Object> targetDataSources;

	public Map<Object, Object> getTargetDataSources() {
		return targetDataSources;
	}

	public void setTargetDataSources(Map<Object, Object> targetDataSources) {
		this.targetDataSources = targetDataSources;
	}
	
	
}
