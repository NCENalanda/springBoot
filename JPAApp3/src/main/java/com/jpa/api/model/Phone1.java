package com.jpa.api.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the phone1 database table.
 * 
 */
@Entity
@NamedQuery(name="Phone1.findAll", query="SELECT p FROM Phone1 p")
public class Phone1 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ph_id")
	private int phId;

	@Column(name="phone_no")
	private BigInteger phoneNo;

	@Column(name="phone_type")
	private String phoneType;

	/*//bi-directional many-to-one association to Custumber1
	@ManyToOne
	@JoinColumn(name="cust_id")*/
	private Custumber1 custumber1;

	public Phone1() {
	}

	public Phone1(BigInteger phoneNo, String phoneType) {
		super();
		this.phoneNo = phoneNo;
		this.phoneType = phoneType;
	}

	public int getPhId() {
		return this.phId;
	}

	public void setPhId(int phId) {
		this.phId = phId;
	}

	public BigInteger getPhoneNo() {
		return this.phoneNo;
	}

	public void setPhoneNo(BigInteger phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getPhoneType() {
		return this.phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	public Custumber1 getCustumber1() {
		return this.custumber1;
	}

	public void setCustumber1(Custumber1 custumber1) {
		this.custumber1 = custumber1;
	}

	@Override
	public String toString() {
		return "Phone1 [phoneNo=" + phoneNo + ", phoneType=" + phoneType + "]";
	}

}