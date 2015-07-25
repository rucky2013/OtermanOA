package com.oterman.oa.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oterman.oa.dao.base.BaseDao;
import com.oterman.oa.domain.Department;
import com.oterman.oa.service.DepartmentService;
import com.oterman.oa.service.base.impl.BaseServiceImpl;

@Service("departmentService")
public class DepartmentServiceImpl extends BaseServiceImpl<Department> implements DepartmentService{
	
	@Resource(name="departmentDao")
	private BaseDao departmentDao;
	
	@Override
	public BaseDao<Department> getBaseDao() {
		return departmentDao;
	}

}
