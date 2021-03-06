package com.oterman.oa.service.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.oterman.oa.dao.DepartmentDao;
import com.oterman.oa.dao.RoleDao;
import com.oterman.oa.dao.UserDao;
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
	private UserDao userDao;
	
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

	/**
	 * 处理更新逻辑
	 */
	@Transactional
	public void updateUser(User model, Long did, Long[] rids) {
		Department department = this.departmentDao.getEleById(did);
		model.setDepartment(department);
		
		Set<Role> set=new HashSet<Role>();
		for (int i = 0; i < rids.length; i++) {
			set.add(this.roleDao.getEleById(rids[i]));
		}
		model.setRoles(set);
		
		userDao.updateEntry(model);
	}

	/**
	 * 更新user的role
	 */
	@Transactional
	public void updateUserWithRoles(Long uid, Long[] rids) {
		User user=this.userDao.getEleById(uid);
		
		Set<Role> set=new HashSet<Role>();
		for (int i = 0; i < rids.length; i++) {
			set.add(this.roleDao.getEleById(rids[i]));
		}
		
		user.setRoles(set);
		
		this.saveEntry(user);
		
	}

	@Transactional(readOnly=true)
	public User findUserByCondition(String username ,String password) {
		
		Map<String, Object> map=new HashMap();
		map.put("username", username);
		map.put("password", password);
		
		return this.userDao.queryByCondition(map);
	}

	public User findUserByUsername(String username) {
		Map<String, Object> map=new HashMap();
		map.put("username", username);
		
		return this.userDao.queryByCondition(map);
	}

}
