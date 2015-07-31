package com.oterman.oa.service;

import java.util.Collection;

import com.oterman.oa.domain.Role;
import com.oterman.oa.service.base.BaseService;

public interface RoleService extends BaseService<Role> {

	/**
	 * 得到所有的role，并根据uid，得到uid下的role，将这些rule的checked设置为true；
	 */
	public Collection<Role> getAllRolesByUid(Long uid);
	
}
