package com.oterman.oa.dao.impl;

import java.util.Collection;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.oterman.oa.dao.UserDao;
import com.oterman.oa.dao.base.impl.BaseDaoImpl;
import com.oterman.oa.domain.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
	
	
	/**使用sql语句来查询,要结合多表:
	 * sql:
			SELECT u.username,d.name,r.name
			FROM USER u 
			LEFT OUTER JOIN department d ON d.did=u.did
			LEFT OUTER JOIN user_role ur ON ur.uid=u.uid
			LEFT OUTER JOIN role r ON r.rid=ur.rid

	 * 
	 */
	@Override
	public Collection<User> queryAll() {
		StringBuffer queryString=new StringBuffer("from User u  ");
		queryString.append(" left outer join fetch u.department  ");
		queryString.append(" left outer join fetch u.roles ");
		
		return this.hibernateTemplate.find(queryString.toString());
	}

}
