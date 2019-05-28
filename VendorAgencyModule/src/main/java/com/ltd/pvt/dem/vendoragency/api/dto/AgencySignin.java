package com.ltd.pvt.dem.vendoragency.api.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.ltd.pvt.dem.vendoragency.api.utility.RegularExpressionPattern;

import io.swagger.annotations.ApiModelProperty;

public class AgencySignin {
	
	
	@Email(message=" should be email formate")
	@ApiModelProperty(value="email as username", required=true)
	private String username;
	
	@NotNull(message="Password can not be null")
	@NotEmpty(message="Password can not be empty")
	@Pattern(regexp=RegularExpressionPattern.REG_EXP_PASSWORD,
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

	public void setUsername(@Email String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
