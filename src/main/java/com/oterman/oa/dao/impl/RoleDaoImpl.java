package com.oterman.oa.dao.impl;

import org.springframework.stereotype.Repository;

import com.oterman.oa.dao.RoleDao;
import com.oterman.oa.dao.base.impl.BaseDaoImpl;
import com.oterman.oa.domain.Role;

@Repository("roleDao")
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {

}
