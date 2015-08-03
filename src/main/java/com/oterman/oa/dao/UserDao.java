package com.oterman.oa.dao;

import com.oterman.oa.dao.base.BaseDao;
import com.oterman.oa.domain.User;

/**
 * 操作Person实体的数据库接口，实现BaseDao，可以在这里写操作book的特有的方法；
 *
 */
public interface UserDao extends BaseDao<User> {
	public User queryByCondition(User user);
}
