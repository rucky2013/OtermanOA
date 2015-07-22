package com.oterman.test;

import org.junit.Test;

import com.oterman.oa.domain.Person;
import com.oterman.oa.service.PersonService;

public class TestDao extends SpringInit {
	
	@Test
	public void testSavePerson(){
		Person p=new Person();
		p.setPgender("男");
		p.setPname("小张");
		
		PersonService personService=(PersonService) applicationContext.getBean("personService");
		personService.savePerson(p);
	}
}
