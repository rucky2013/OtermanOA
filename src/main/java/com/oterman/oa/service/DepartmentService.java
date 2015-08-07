package com.oterman.oa.service;

import java.util.Collection;

import com.oterman.oa.domain.Department;
import com.oterman.oa.service.base.BaseService;

public interface DepartmentService extends BaseService<Department> {
	public Collection<Department> getAllDepartment();
	
}
