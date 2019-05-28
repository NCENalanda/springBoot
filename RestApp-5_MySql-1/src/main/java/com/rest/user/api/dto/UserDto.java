package com.rest.user.api.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;


/**
 * The persistent class for the USER_DETAILS database table.
 * 
 */

public class UserDto implements Serializable {
	
	@ApiModelProperty(value="Address")
	private String address;

	@ApiModelProperty(value="Mobile")
	private String contact;

	@ApiModelProperty(value="firstname")
	private String firsrname;

	@ApiModelProperty(value="firstname")
	private String lastname;

	@ApiModelProperty(value="firstname")
	private String password;

	@ApiModelProperty(value="email as username")
	private String username;

	public UserDto() {
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

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}