package com.ltd.pvt.demo.user.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@ApiModel(value="User Detail")
public class UserDetail {
	
	@ApiModelProperty(value="Address")
	private String address;
	
	@ApiModelProperty(value="Mobile")
	private String contact;

	@ApiModelProperty(value="FirstName")
	private String firstName;

	@ApiModelProperty(value="LastName")
	private String lastName;

	@ApiModelProperty(value="Username")
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
		return firstName;
	}

	public String getLastname() {
		return lastName;
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
		this.firstName = firstname;
	}

	public void setLastname(String lastname) {
		this.lastName = lastname;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
}
