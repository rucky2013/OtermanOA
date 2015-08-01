package com.oterman.oa.dao.impl;

import org.springframework.stereotype.Repository;

import com.oterman.oa.dao.DepartmentDao;
import com.oterman.oa.dao.PrivilegeDao;
import com.oterman.oa.dao.base.impl.BaseDaoImpl;
import com.oterman.oa.domain.Privilege;

@Repository("privilegeDao")
public class PrivilegeDaoImpl extends BaseDaoImpl<Privilege> implements PrivilegeDao{
	

}
