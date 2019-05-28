package com.jpa.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role1 implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 15465742425L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="r_id")
	private int rId;
	private String role;
	
	public Role1() {
		if(role==null)
			role="USER";
	}
	
	public Role1(String role) {
		super();
		this.role = role;
	}

	public int getrId() {
		return rId;
	}
	public void setrId(int rId) {
		this.rId = rId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Role [role=" + role + "]";
	}
}
