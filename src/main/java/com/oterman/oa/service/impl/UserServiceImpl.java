package com.oterman.oa.service.impl;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.oterman.oa.dao.DepartmentDao;
import com.oterman.oa.dao.RoleDao;
import com.oterman.oa.dao.base.BaseDao;
import com.oterman.oa.domain.Department;
import com.oterman.oa.domain.Role;
import com.oterman.oa.domain.User;
import com.oterman.oa.service.UserService;
import com.oterman.oa.service.base.impl.BaseServiceImpl;


@Controller("userService")
@Scope("prototype")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

	@Resource(name="userDao")
	private BaseDao userDao;
	
	@Resource(name="departmentDao")
	private DepartmentDao departmentDao;
	
	@Resource(name="roleDao")
	private RoleDao roleDao;
	
	@Override
	public BaseDao<User> getBaseDao() {
		return userDao;
	}

	/**
	 * 处理添加逻辑
	 */
	@Transactional
	public void addUser(User model, Long did, Long[] rids) {
		Department department = this.departmentDao.getEleById(did);
		model.setDepartment(department);
		
		Set<Role> set=new HashSet<Role>();
		for (int i = 0; i < rids.length; i++) {
			set.add(this.roleDao.getEleById(rids[i]));
		}
		model.setRoles(set);
		
		userDao.saveEntry(model);
		
	}

}
