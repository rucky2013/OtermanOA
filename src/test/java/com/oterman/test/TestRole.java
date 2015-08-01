package com.oterman.test;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import com.oterman.oa.domain.Role;
import com.oterman.oa.service.RoleService;

public class TestRole extends SpringInit{

	@Test
	public void testSaveRole(){
		RoleService roleService=(RoleService) this.applicationContext.getBean("roleService");
		Role role=new Role();
		role.setName("滚蛋部");
		role.setDescription("滚蛋人员专属部门");
		roleService.saveEntry(role);
		
	}
	
	/**
	 * 
	 */
	@Test
	public void testQueryByUid(){
		RoleService roleService=(RoleService) this.applicationContext.getBean("roleService");
		Collection<Role> roles = roleService.getAllRolesByUid(6l);
		System.out.println(roles);
	}
	
	@Test
	public void testGetAllRoleWithPrivilege(){
		RoleService roleService=(RoleService) this.applicationContext.getBean("roleService");
		Collection<Role> list= roleService.getAllRolesWithPrivilege();
		System.out.println(list);
		
	}
	
	
}
