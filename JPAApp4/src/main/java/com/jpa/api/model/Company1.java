package com.jpa.api.model;

import java.io.Serializable;
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
public class Company1 implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1768854L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="com_id")
	private int comId;
	private String compName;
	private String  comType;
	
	@ManyToMany(cascade=CascadeType.ALL,
			    fetch=FetchType.EAGER)
	@JoinTable(name="comp_user",
    joinColumns=@JoinColumn(name="com_id",referencedColumnName="com_id"),
    inverseJoinColumns=@JoinColumn(name="user_id",referencedColumnName="user_id"))
	private Set<User1> users;
	
	public Company1() {
		// TODO Auto-generated constructor stub
	}

	public Company1(String compName, String comType) {
		super();
		this.compName = compName;
		this.comType = comType;
	}
	
	public Company1(String compName) {
		super();
		this.compName = compName;
		if(this.comType==null)
		this.comType = "REAL_STATE";
	}

	@Override
	public String toString() {
		return "Company1 [compName=" + compName + ", comType=" + comType + "]";
	}

	public int getComId() {
		return comId;
	}

	public void setComId(int comId) {
		this.comId = comId;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getComType() {
		return comType;
	}

	public void setComType(String comType) {
		this.comType = comType;
	}

	public Set<User1> getUsers() {
		return users;
	}

	public void setUsers(Set<User1> users) {
		this.users = users;
	}

}
