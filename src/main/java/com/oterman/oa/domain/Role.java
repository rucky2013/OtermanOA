package com.oterman.oa.domain;

import java.io.Serializable;
import java.util.Set;

public class Role implements Serializable,Comparable<Role>{
	private Long rid;
	private Long pid;//父节点id
	private String name;
	private String description;
	private Set<User> users;//角色和员工多对多
	private Set<Privilege> privileges;//角色与权限是多对多的关系
	
	private boolean checked;
	
	
	
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public Set<Privilege> getPrivileges() {
		return privileges;
	}
	public void setPrivileges(Set<Privilege> privileges) {
		this.privileges = privileges;
	}
	public Long getRid() {
		return rid;
	}
	public void setRid(Long rid) {
		this.rid = rid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	/**
	 * 实现排序
	 */
	public int compareTo(Role role) {
//		if(this.rid>role.getRid()){
//			return 1;
//		}else if(this.rid==role.getRid()){
//			return 0;
//		}else{
//			return -1;
//		}
		return this.rid>role.getRid()?1:(this.rid==role.getRid()?0:-1);
	}
}
