package com.oterman.oa.dao.impl;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.oterman.oa.dao.PersonDao;
import com.oterman.oa.domain.Person;

@Repository("personDaoImpl")
public class PersonDaoImpl implements PersonDao {
	
	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;

	public void savePerson(Person person) {
		hibernateTemplate.save(person);
	}

}
