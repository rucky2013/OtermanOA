package com.oterman.oa.service.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oterman.oa.dao.PrivilegeDao;
import com.oterman.oa.dao.RoleDao;
import com.oterman.oa.dao.base.BaseDao;
import com.oterman.oa.domain.Privilege;
import com.oterman.oa.domain.Role;
import com.oterman.oa.service.RoleService;
import com.oterman.oa.service.base.impl.BaseServiceImpl;

@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<Role> implements
		RoleService {

	@Resource(name = "roleDao")
	private RoleDao roleDao;

	@Resource(name = "privilegeDao")
	private PrivilegeDao privilegeDao;

	@Override
	public BaseDao<Role> getBaseDao() {
		return roleDao;
	}

	@Transactional
	public Collection<Role> getAllRolesByUid(Long uid) {
		return roleDao.getAllRolesByUid(uid);
	}

	@Transactional
	public Collection<Role> getAllRolesWithPrivilege() {
		return roleDao.getAllRolesWithPrivilege();
	}

	@Transactional
	public void buildRoleAndPrivileges(Long rid, Long[] ids) {
		Role role = this.roleDao.getEleById(rid);
		if (ids != null) {
			Set<Privilege> privileges = new HashSet<Privilege>();
			for (Long id : ids) {
				privileges.add(privilegeDao.getEleById(id));
			}
			role.setPrivileges(privileges);
		} else {
			role.setPrivileges(null);
		}

		roleDao.saveEntry(role);
	}

}
