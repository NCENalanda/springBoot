package com.jpa.api.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity

public class User2 implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1576890L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	
	private int userId;
	@Column(unique=true)
	
	private String userName;

	private String password;
	
	private BigInteger phoneNo;
	
	@ManyToMany(targetEntity=Role2.class,
			    cascade=CascadeType.ALL)
	
	@JoinTable(name="user2_role2",
	           joinColumns=@JoinColumn(name="user_id",referencedColumnName="user_id",unique=false),
	           inverseJoinColumns=@JoinColumn(name="role_id",referencedColumnName="role_id",unique=false))
	private Set<Role2> roles=new HashSet<>();
	
	public User2() {
		// TODO Auto-generated constructor stub
		this.phoneNo = new BigInteger("8877290173");
	}

	public User2(String userName, String password, BigInteger phoneNo) {
		super();
		this.userName = userName;
		this.password = password;
		this.phoneNo = new BigInteger("8877290173");
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BigInteger getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(BigInteger phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Set<Role2> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role2> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User2 [userName=" + userName + ", password=" + password + ", phoneNo=" + phoneNo + "]";
	}

}
