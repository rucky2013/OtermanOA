package com.oterman.oa.dao.impl;

import org.springframework.stereotype.Repository;

import com.oterman.oa.dao.DepartmentDao;
import com.oterman.oa.dao.base.impl.BaseDaoImpl;
import com.oterman.oa.domain.Department;

@Repository("departmentDao")
public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements DepartmentDao{
	

}
