package com.oterman.test;

import java.util.Collection;

import org.junit.Test;

import com.oterman.oa.domain.User;
import com.oterman.oa.service.UserService;

public class TestUser extends SpringInit {

	@Test
	public void testAdd(){
		UserService userService=(UserService) this.applicationContext.getBean("userService");
		User user=new User();
		user.setUsername("张三33试试");
		user.setEmail("zhangsan@xx.com");
		userService.saveEntry(user);
		
	}
	
	@Test
	public void testQueryAll(){
		UserService userService=(UserService) this.applicationContext.getBean("userService");
		String hql="from User u left join fetch u.department left join fetch u.roles ";
		Collection<User> list = userService.createQuery(hql);
		
		System.out.println(list.size());
		
	}
	
	@Test
	public void testAddUser(){
		
		
	}
	
}
