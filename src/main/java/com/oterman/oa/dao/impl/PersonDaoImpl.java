package com.oterman.oa.dao.impl;

import org.springframework.stereotype.Repository;

import com.oterman.oa.dao.PersonDao;
import com.oterman.oa.dao.base.impl.BaseDaoImpl;
import com.oterman.oa.domain.Person;

/**
 * 操作book的数据库实现类。
 * @author oterman
 *
 */
@Repository("personDaoImpl")
public class PersonDaoImpl extends BaseDaoImpl<Person> implements PersonDao {

}
