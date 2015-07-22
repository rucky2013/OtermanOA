package com.oterman.test;

import org.junit.Test;

public class TestSessionFactory extends SpringInit {
	
	@Test
	public void test(){
		System.out.println(this.applicationContext.getBean("sessionFactory"));
	}

}
