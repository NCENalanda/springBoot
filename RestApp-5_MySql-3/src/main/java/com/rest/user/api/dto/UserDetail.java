package com.rest.user.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
@AllArgsConstructor
public class UserDetail {
	
	@ApiModelProperty(value="Address",required=true)
	private String address;
	
	@ApiModelProperty(value="Mobile",required=true)
	private String contact;

	@ApiModelProperty(value="firstName")
	private String firstname;

	@ApiModelProperty(value="lastName")
	private String lastname;

	@ApiModelProperty(value="email as username")
	private String username;
	
	public UserDetail() {
		// TODO Auto-generated constructor stub
	}


	public String getAddress() {
		return address;
	}

	public String getContact() {
		return contact;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
}
