package com.ltd.pvt.dem.vendoragency.api.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import com.ltd.pvt.dem.vendoragency.api.utility.RegularExpressionPattern;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="Bus Route")
public class BusRoute {
	@ApiModelProperty(value="bus route name", required=true)
	@Pattern(regexp=RegularExpressionPattern.REG_EXP_NAME)
	private String busRouteName;

	
	@ApiModelProperty(value="destination city", required=true)
	@Pattern(regexp=RegularExpressionPattern.REG_EXP_NAME)
	private String destination;

	@ApiModelProperty(value=" origin city ", required=true)
	@Pattern(regexp=RegularExpressionPattern.REG_EXP_NAME)
	private String origin;

	@ApiModelProperty(required=true)
	@Email(message=" as Email formate ")
	private String username;

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	

	public String getDestination() {
		return destination;
	}

	public String getOrigin() {
		return origin;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getBusRouteName() {
		return busRouteName;
	}

	public void setBusRouteName(String busRouteName) {
		this.busRouteName = busRouteName;
	}

}
