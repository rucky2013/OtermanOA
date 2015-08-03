package com.oterman.oa.dao.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.oterman.oa.dao.PrivilegeDao;
import com.oterman.oa.dao.base.impl.BaseDaoImpl;
import com.oterman.oa.domain.Privilege;
import com.oterman.oa.domain.User;

@Repository("privilegeDao")
public class PrivilegeDaoImpl extends BaseDaoImpl<Privilege> implements PrivilegeDao{
	/**发出的sql语句：
    select
        privilege0_.id as id6_0_,
        role2_.rid as rid2_1_,
        user4_.uid as uid5_2_,
        privilege0_.description as descript2_6_0_,
        privilege0_.name as name6_0_,
        privilege0_.pid as pid6_0_,
        privilege0_.type as type6_0_,
        privilege0_.icon as icon6_0_,
        privilege0_.isParent as isParent6_0_,
        role2_.description as descript2_2_1_,
        role2_.name as name2_1_,
        role2_.pid as pid2_1_,
        roles1_.id as id6_0__,
        roles1_.rid as rid0__,
        user4_.username as username5_2_,
        user4_.sex as sex5_2_,
        user4_.email as email5_2_,
        user4_.phone as phone5_2_,
        user4_.password as password5_2_,
        user4_.did as did5_2_,
        users3_.rid as rid2_1__,
        users3_.uid as uid1__ 
    from
        Privilege privilege0_ 
    inner join
        role_privilege roles1_ 
            on privilege0_.id=roles1_.id 
    inner join
        Role role2_ 
            on roles1_.rid=role2_.rid 
    inner join
        user_role users3_ 
            on role2_.rid=users3_.rid 
    inner join
        User user4_ 
            on users3_.uid=user4_.uid 
    where
        user4_.uid=?
	 * 
	 * 
	 */
	public Collection<Privilege> getMenuItemsByUid(User user) {
		StringBuffer buffer=new StringBuffer();
		/*
		buffer.append("from User u");
		buffer.append(" inner join fetch u.roles r");
		buffer.append(" inner join fetch r.privileges where u.uid=?");
		List<User> list= this.hibernateTemplate.find(buffer.toString(),user.getUid());
		System.out.println(new HashSet<User>(list).size());*/
		List list =null;
		if("admin".equals(user.getUsername())){
			buffer.append("from Privilege");//管理员查询所有的权限；
			list=this.hibernateTemplate.find(buffer.toString());
		}else{
			buffer.append("from Privilege p");
			buffer.append(" inner join fetch p.roles r");
			buffer.append(" inner join fetch r.users u");
			buffer.append(" where u.uid=? and p.type='1' ");
			list= this.hibernateTemplate.find(buffer.toString(),user.getUid());
		}

		return list;
	}
	

}
