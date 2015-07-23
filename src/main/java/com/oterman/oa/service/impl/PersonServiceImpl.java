package com.oterman.oa.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oterman.oa.dao.PersonDao;
import com.oterman.oa.dao.base.BaseDao;
import com.oterman.oa.domain.Person;
import com.oterman.oa.service.PersonService;
import com.oterman.oa.service.base.impl.BaseServiceImpl;

@Service("personService")
public class PersonServiceImpl extends BaseServiceImpl<Person> implements PersonService {
	
	//引入baseDao
	@Resource(name="personDaoImpl")
	private BaseDao personDao;
	
	/**
	 * 实现父类的方法，将运行中的baseDao交给父类；
	 */
	@Override
	public BaseDao<Person> getBaseDao() {
		return personDao;
	}

}
