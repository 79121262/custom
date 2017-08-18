package com.tc.spring.custom;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tc.spring.custom.entity.ScanClass1;
import com.tc.spring.custom.entity.User;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml" }, inheritLocations = true)
public class SpringCustomTest {

	@Autowired
	private User user;
	
	@Autowired
	private ScanClass1 scanClass1;
	
	@Test
	public void demo() throws Exception {
		
		System.out.println(user.getUserName());
		scanClass1.print();
		
	}

	@Test
	  public void test2(){  
	        System.out.println("app classload----------------------");  
	        final String s = System.getProperty("java.class.path");  
	        System.out.println(s);  
	      
	    }  
}