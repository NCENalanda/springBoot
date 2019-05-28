package com.ltd.pvt.dem.vendoragency.api.dto;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

public class BusStatus {
	
	@NotNull(message=" Null not Allow ")
	@ApiModelProperty
	private String bus_no;

}
