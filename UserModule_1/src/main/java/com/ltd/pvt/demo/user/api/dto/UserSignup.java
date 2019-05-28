package com.ltd.pvt.demo.user.api.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;


public class UserSignup {
	
	
	
	
	private static final String REG_EXP_ADDRESS    =  "[a-zA-Z]{3,30}";
	private static final String REG_EXP_NAME       =  "[a-zA-Z]{3,20}";
	private static final String REG_EXP_MOBILE     =  "[3-9][0-9]{9}";
	private static final String REG_EXP_PASSWORD   =  "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%*?&])[A-Za-z0-9@$!%*?&]{6,15}$";
	
	@NotNull(message="Address can not be null")
	@NotEmpty(message="Address can not be empty")
	@Pattern(regexp=REG_EXP_ADDRESS,message="Address Must  Be Between 3 To 30 Character ")
	@ApiModelProperty(value="Address",required=true)
	private String address;

	@NotNull(message="Mobile Num can not be null")
	@NotEmpty(message="Mobile Num can not be empty")
	@Pattern(regexp=REG_EXP_MOBILE,message="Mobile Num Must  Be 10 digit")
	@ApiModelProperty(value="Mobile",required=true)
	private String contact;

	@NotNull(message="FirstName can not be null")
	@NotEmpty(message="FirstName can not be empty")
	@Pattern(regexp=REG_EXP_NAME,message="FirstName Must  Be Between 3 To 20 Character")
	@ApiModelProperty(value="FirstName",required=true)
	private String firsrName;

	@NotNull(message="LastName can not be null")
	@NotEmpty(message="LastName can not be empty")
	@Pattern(regexp=REG_EXP_NAME,message="LastName Must  Be Between 3 To 20 Character")
	@ApiModelProperty(value="LastName",required=true)
	private String lastName;

	@NotNull(message="Password can not be null")
	@NotEmpty(message="Password can not be empty")
	@Pattern(regexp=REG_EXP_PASSWORD,
	message="Password Must  Be Between 6 To 15 Character Include Atleast "
			+ " One LowerCase, UpperCase, Digits, and Special Character")
	@ApiModelProperty(value="Password", required=true)
	private String password;
	
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
		return this.firsrName;
	}

	public void setFirsrname(String firsrname) {
		this.firsrName = firsrname;
	}

	public String getLastname() {
		return this.lastName;
	}

	public void setLastname(String lastname) {
		this.lastName = lastname;
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