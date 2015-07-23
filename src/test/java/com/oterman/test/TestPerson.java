package com.oterman.test;

import org.junit.Test;

import com.oterman.oa.domain.Person;
import com.oterman.oa.service.PersonService;

public class TestPerson extends SpringInit {
	
	@Test
	public void testSavePerson(){
		Person p=new Person();
		p.setPgender("男");
		p.setPname("小张22");
		
		PersonService personService=(PersonService) applicationContext.getBean("personService");
		personService.saveEntry(p);
	}
}
