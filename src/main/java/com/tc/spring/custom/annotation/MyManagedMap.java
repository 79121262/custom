package com.tc.spring.custom.annotation;

import java.util.Map;

/**
 * ���� spring ����ManagedMap ����
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
