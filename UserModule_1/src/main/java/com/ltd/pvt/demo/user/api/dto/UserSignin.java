package com.ltd.pvt.demo.user.api.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

public class UserSignin {
	
	private static final String REG_EXP_PASSWORD   =  "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%*?&])[A-Za-z0-9@$!%*?&]{6,15}$";
	
	
	@Email(message=" should be email formate")
	@ApiModelProperty(value="email as username", required=true)
	private String username;
	
	@NotNull(message="Password can not be null")
	@NotEmpty(message="Password can not be empty")
	@Pattern(regexp=REG_EXP_PASSWORD,
	message="Password Must  Be Between 6 To 15 Character Include Atleast "
			+ " One LowerCase, UpperCase, Digits, and Special Character")
	@ApiModelProperty(value="Password", required=true)
	private String password;
	
	
	
	@ApiModelProperty(value="email as username", required=true)
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
