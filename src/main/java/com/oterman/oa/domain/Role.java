package com.oterman.oa.domain;

import java.io.Serializable;
import java.util.Set;

public class Role implements Serializable{
	private Long rid;
	private String name;
	private String description;
	private Set<User> users;//角色和员工多对多
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
}
