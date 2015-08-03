package com.oterman.oa.service.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oterman.oa.dao.PrivilegeDao;
import com.oterman.oa.dao.base.BaseDao;
import com.oterman.oa.domain.Privilege;
import com.oterman.oa.domain.User;
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

	@Transactional
	public Collection<Privilege> getMenuItemsByUid(User user) {
		return this.privilegeDao.getMenuItemsByUid(user);
	}
	

}
