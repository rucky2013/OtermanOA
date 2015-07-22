package com.oterman.oa.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.oterman.oa.dao.PersonDao;
import com.oterman.oa.domain.Person;
import com.oterman.oa.service.PersonService;

@Service("personService")
public class PersonServiceImpl implements PersonService {
	
	@Resource(name="personDaoImpl")
	private PersonDao personDao;
	public void savePerson(Person person) {
		this.personDao.savePerson(person);
	}

}
