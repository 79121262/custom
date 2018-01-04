package com.tc.spring.custom;

import java.lang.reflect.Method;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tc.spring.custom.annotation.MyManagedMap;
import com.tc.spring.custom.entity.ScanClass1;
import com.tc.spring.custom.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml" }, inheritLocations = true)
public class SpringCustomTest {

	@Autowired
	private User user;

	@Autowired
	private ScanClass1 scanClass1;
	@Autowired
	private MyManagedMap   myManagedMap;
	
	
	@Value("${abc}")
	private String s;
	
	@Test
	public void demo() throws Exception {

		System.out.println(user.getUserName());
		scanClass1.print();

		Map<Object, Object> targetDataSources = myManagedMap.getTargetDataSources();
		
		User user = (User)targetDataSources.get("cctv-user");
		
		System.out.println(user.getEmail());
		//scanClass1.print();
		
	}

	@Test
	public void test2() {
		System.out.println("app classload----------------------");
		final String s = System.getProperty("java.class.path");
		System.out.println(s);
	}
	
	@Test
	public void test3() {
		LocalVariableTableParameterNameDiscoverer parameterNameDiscoverer = new LocalVariableTableParameterNameDiscoverer();
		
		Method[] methods = User.class.getMethods();
		
		for (Method method2 : methods) {
			String[] parameterNames = parameterNameDiscoverer.getParameterNames(method2);
			if(parameterNames!=null){
				for (String string : parameterNames) {
					System.out.println(string);
				}
			}
		}
	}
	
	@Test
	public void test4() {
		System.out.println(s);
	}
	
}