package com.oterman.test;

import org.junit.Test;

import com.oterman.oa.domain.Person;
import com.oterman.oa.domain.User;
import com.oterman.oa.service.PersonService;
import com.oterman.oa.service.PrivilegeService;
import com.oterman.oa.struts2.action.PersonAction;


public class TestPrivilege extends SpringInit {
	
	@Test
	public  void testGetPrivielgeByUid(){
		PrivilegeService privilegeService=(PrivilegeService) this.applicationContext.getBean("privilegeService");
		User user=new User();
		user.setUsername("张三");
		user.setUid(1L);
		privilegeService.getMenuItemsByUid(user);
	}
}
