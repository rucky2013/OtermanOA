package com.oterman.oa.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oterman.oa.dao.PrivilegeDao;
import com.oterman.oa.dao.base.BaseDao;
import com.oterman.oa.domain.Department;
import com.oterman.oa.domain.Privilege;
import com.oterman.oa.service.PrivilegeService;
import com.oterman.oa.service.base.impl.BaseServiceImpl;

@Service("privilegeService")
public class PrivilegeServiceImpl extends BaseServiceImpl<Privilege> implements PrivilegeService{
	
	@Resource(name="privilegeDao")
	private PrivilegeDao privilegeDao;


	@Override
	public BaseDao<Privilege> getBaseDao() {
		return this.privilegeDao;
	}
	

}
