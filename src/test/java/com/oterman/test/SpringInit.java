package com.oterman.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringInit {
	protected static ApplicationContext applicationContext;
	static{
		applicationContext=new ClassPathXmlApplicationContext("spring/applicationContext.xml");
	}

}
