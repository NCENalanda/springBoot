package com.rest.user.api.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

public class UserSignin {
	
	@ApiModelProperty(value="email as username", required=true)
	private String username;
	
	@NotNull(message="password can not be null")
	@NotEmpty(message="password can not be empty")
	@Size(min=6,max=15, message="password must be between 6 to 15 characters")
	@ApiModelProperty(value="password",required=true)
	private String password;
	
	
	@Email(message=" should be email formate")
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
