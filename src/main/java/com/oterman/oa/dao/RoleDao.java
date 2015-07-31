package com.oterman.oa.dao;

import java.util.Collection;

import com.oterman.oa.dao.base.BaseDao;
import com.oterman.oa.domain.Role;

public interface RoleDao extends BaseDao<Role> {
	public Collection<Role> getAllRolesByUid(Long uid);

}
