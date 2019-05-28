package com.jpa.api.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Role2 implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1354658L;
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="role_id")
	
	private int roleId;
	@Column(unique=true)
	
	private String role;
	
	@ManyToMany(targetEntity=User2.class,
			    cascade=CascadeType.ALL)//,
			     //fetch=FetchType.EAGER)
			   // mappedBy="role2")
	@JoinTable(name="user2_role2",
			inverseJoinColumns=@JoinColumn(name="user_id",referencedColumnName="user_id",unique=false),
	           joinColumns=@JoinColumn(name="role_id",referencedColumnName="role_id",unique=false))
	
	private Set<User2> users=new HashSet<>();
	
	public Role2() {
		if(this.role==null) {
			this.role="USER";
			}
	}
	
	public Set<User2> getUsers() {
		return users;
	}

	public void setUsers(Set<User2> users) {
		this.users = users;
	}

	public Role2(String role) {
		super();
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "Role2 [role=" + role + "]";
	}

	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

}
