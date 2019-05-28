package com.rest.user.api.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;


/**
 * The persistent class for the USER_DETAILS database table.
 * 
 */

public class UserSignup implements Serializable {
	
	@ApiModelProperty(value="Address",required=true)
	private String address;

	@ApiModelProperty(value="Mobile",required=true)
	private String contact;

	@ApiModelProperty(value="firstName",required=true)
	private String firsrname;

	@ApiModelProperty(value="lastName",required=true)
	private String lastname;

	@ApiModelProperty(value="Password", required=true)
	private String password;
	
	@ApiModelProperty(value="ConfirmPassword", required=true)
	private String confirmpassword;

	@ApiModelProperty(value="email as username", required=true)
	private String username;

	public UserSignup() {
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

	public String getFirsrname() {
		return this.firsrname;
	}

	public void setFirsrname(String firsrname) {
		this.firsrname = firsrname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}