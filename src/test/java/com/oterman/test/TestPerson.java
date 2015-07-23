package com.oterman.test;

import org.junit.Test;

import com.oterman.oa.domain.Person;
import com.oterman.oa.service.PersonService;
import com.oterman.oa.struts2.action.PersonAction;


public class TestPerson extends SpringInit {
	
	@Test
	public void testSavePerson(){
		Person p=new Person();
		p.setPgender("男");
		p.setPname("小张22");
		PersonService personService=(PersonService) applicationContext.getBean("personService");
		personService.saveEntry(p);
	}
	
	@Test
	public void testAction_save(){
		PersonAction personAction = (PersonAction) applicationContext.getBean("personAction");
		personAction.savePerson();
	}
	@Test
	public void testAction_queryAll(){
		PersonAction personAction = (PersonAction) applicationContext.getBean("personAction");
		String listPerson = personAction.listPerson();
		System.out.println(listPerson);
	}
 
}
