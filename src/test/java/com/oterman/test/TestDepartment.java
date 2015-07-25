package com.oterman.test;

import org.junit.Test;

import com.oterman.oa.domain.Department;
import com.oterman.oa.service.DepartmentService;
import com.oterman.oa.struts2.action.DepartmentAction;

public class TestDepartment extends SpringInit{
	
	@Test
	public void testSaveDepartment(){
		DepartmentService departmentSerivce=(DepartmentService) this.applicationContext.getBean("departmentService");
		Department department=new Department();
		department.setDescription("美女多哦");
		department.setName("公关部");
		
		departmentSerivce.saveEntry(department);
		
	}
	
	@Test
	public void tesetDepartmentAction(){
		DepartmentAction departmentAction= (DepartmentAction) this.applicationContext.getBean("departmentAction");
		System.out.println(departmentAction);
	}
	
	
}
