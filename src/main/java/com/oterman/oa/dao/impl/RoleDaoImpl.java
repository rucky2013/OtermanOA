package com.oterman.oa.dao.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.oterman.oa.dao.RoleDao;
import com.oterman.oa.dao.base.impl.BaseDaoImpl;
import com.oterman.oa.domain.Role;

@Repository("roleDao")
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {

	public Collection<Role> getAllRolesByUid(Long uid) {
		List<Role> userRoles = this.hibernateTemplate.find("from Role r inner join fetch r.users u where u.uid=?",uid);
		Collection<Role> allRoles = this.queryAll();
		for (Role role : allRoles) {
			for (Role role2 : userRoles) {
				if(role2.getRid()==role.getRid()){
					role.setChecked(true);
					break;
				}
				
			}
		}
		
		return allRoles;
	}

}
