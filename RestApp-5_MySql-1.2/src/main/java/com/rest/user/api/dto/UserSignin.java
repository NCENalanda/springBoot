package com.rest.user.api.dto;

import io.swagger.annotations.ApiModelProperty;

public class UserSignin {
	
	@ApiModelProperty(value="email as username", required=true)
	private String username;
	
	@ApiModelProperty(value="password",required=true)
	private String password;

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
