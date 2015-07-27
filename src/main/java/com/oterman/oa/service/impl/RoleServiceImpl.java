package com.oterman.oa.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oterman.oa.dao.RoleDao;
import com.oterman.oa.dao.base.BaseDao;
import com.oterman.oa.domain.Role;
import com.oterman.oa.service.RoleService;
import com.oterman.oa.service.base.impl.BaseServiceImpl;

@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {

	@Resource(name="roleDao")
	private RoleDao roleDao;
	
	@Override
	public BaseDao<Role> getBaseDao() {
		return roleDao;
	}

}
