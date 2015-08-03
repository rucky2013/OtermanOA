package com.oterman.oa.service;

import com.oterman.oa.domain.User;
import com.oterman.oa.service.base.BaseService;

public interface UserService extends BaseService<User> {
	public void addUser(User model,Long did,Long[] rids);
	
	public void updateUser(User model,Long did,Long[] rids);
	
	public void updateUserWithRoles(Long uid,Long[] rids);
	
	public User findUserByCondition(String username,String  password);
	
}
