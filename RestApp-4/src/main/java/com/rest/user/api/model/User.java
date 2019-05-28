package com.rest.user.api.model;

import java.io.Serializable;
import javax.persistence.*;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the USER_DETAILS database table.
 * 
 */
@Entity
@Table(name="USER_DETAILS")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long userid;

	@ApiModelProperty(value="Address")
	private String address;

	@ApiModelProperty(value="Mobile")
	private String contact;

	@Temporal(TemporalType.DATE)
	private Date datecreated;

	@ApiModelProperty(value="firstname")
	private String firsrname;

	private BigDecimal isactive;

	@ApiModelProperty(value="firstname")
	private String lastname;

	private String oldpassword;

	@ApiModelProperty(value="firstname")
	private String password;

	@ApiModelProperty(value="email as username")
	private String username;

	public User() {
	}

	public long getUserid() {
		return this.userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Date getDatecreated() {
		return this.datecreated;
	}

	public void setDatecreated(Date datecreated) {
		this.datecreated = datecreated;
	}

	public String getFirsrname() {
		return this.firsrname;
	}

	public void setFirsrname(String firsrname) {
		this.firsrname = firsrname;
	}

	public BigDecimal getIsactive() {
		return this.isactive;
	}

	public void setIsactive(BigDecimal isactive) {
		this.isactive = isactive;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getOldpassword() {
		return this.oldpassword;
	}

	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}