package com.jpa.api.model;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Phone1 implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="p_id")
	private int         pId;
	
	private BigInteger  phoneNo;
	private String     type;
	
	public Phone1() {
		// TODO Auto-generated constructor stub
	}
	public Phone1(BigInteger  phoneNo) {
		if(this.type==null)
			this.type="HOME";
		this.phoneNo=phoneNo;
	}
	
	public Phone1(BigInteger phoneNo, String type) {
		super();
		this.phoneNo = phoneNo;
		this.type = type;
	}

	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public BigInteger getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(BigInteger phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Phone1 [phoneNo=" + phoneNo + ", type=" + type + "]";
	}
}
