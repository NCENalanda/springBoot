package com.rest.user.api.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



import io.swagger.annotations.ApiModelProperty;


/**
 * The persistent class for the USER_DETAILS database table.
 * 
 */

public class UserSignup implements Serializable {
	@NotNull(message="Address can not be null")
	@NotEmpty(message="Address can not be empty")
	@Size(min=3,max=40, message="Address must be between 3 to 40 characters")
	@ApiModelProperty(value="Address",required=true)
	private String address;

	@NotNull(message="contact can not be null")
	@NotEmpty(message="contact can not be empty")
	@Size(min=10,max=10, message="Mobile no must be 10 digits")
	@ApiModelProperty(value="Mobile",required=true)
	private String contact;

	@NotNull(message="firstName can not be null")
	@NotEmpty(message="firstName can not be empty")
	@Size(min=3,max=20, message="firstName must be between 3 to 20 characters")
	@ApiModelProperty(value="firstName",required=true)
	private String firsrname;

	@NotNull(message="lastName can not be null")
	@NotEmpty(message="lastName can not be empty")
	@Size(min=3,max=20, message="lastName must be between 3 to 20 characters")
	@ApiModelProperty(value="lastName",required=true)
	private String lastname;

	@NotNull(message="password can not be null")
	@NotEmpty(message="password can not be empty")
	@Size(min=6,max=15, message="password must be between 6 to 15 characters")
	@ApiModelProperty(value="Password", required=true)
	private String password;
	
	@NotNull(message="confirmpassword can not be null")
	@NotEmpty(message="confirmpassword can not be empty")
	@Size(min=6,max=15, message="confirmpassword must be between 6 to 15 characters")
	@ApiModelProperty(value="ConfirmPassword", required=true)
	private String confirmpassword;

	/*@NotNull(message="username can not be null")
	@NotEmpty(message="username can not be empty")
	@Size(min=6,max=10, message="username must be between 3 to 10 characters")
	*/
	@Email(message=" should be email formate")
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