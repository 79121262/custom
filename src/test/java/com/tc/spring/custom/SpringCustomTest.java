package com.tc.spring.custom;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tc.spring.custom.entity.User;


public class SpringCustomTest {

	@Test
	public void demo() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
		User user = (User) ac.getBean("user");
		System.out.println(user.getUserName());
		
		
//		 Class<?> handlerClass =
//		 ClassUtils.forName("com.tc.spring.custom.handler.MyNamespaceHandler",
//				 ClassLoader.getSystemClassLoader());
//		 //Launcher
//		 System.out.println(handlerClass);
	}

	@Test
	  public void test2(){  
	        System.out.println("app classload----------------------");  
	        final String s = System.getProperty("java.class.path");  
	        System.out.println(s);  
	      
	    }  
}