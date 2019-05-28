package com.ltd.pvt.dem.vendoragency.api.dto;

import javax.validation.constraints.Email;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="Usermame")
public class UserName {
	
	@ApiModelProperty(required=true)
	@Email(message=" as Email formate ")
	private String username;

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
