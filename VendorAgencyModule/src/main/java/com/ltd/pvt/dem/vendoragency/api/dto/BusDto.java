package com.ltd.pvt.dem.vendoragency.api.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import com.ltd.pvt.dem.vendoragency.api.utility.RegularExpressionPattern;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(reference="Bus")
public class BusDto  {
	@ApiModelProperty(value="email as username", required=true)
	@Email(message="Email Formate")
	private String agencyUsername;
	
	@ApiModelProperty(value="bus route name", required=true)
	@Pattern(regexp=RegularExpressionPattern.REG_EXP_NAME)
	private String busRouteName;

	@NotNull(message=" Null not Allow ")
	@ApiModelProperty
	private String busNo;
	
	@Pattern(regexp=RegularExpressionPattern.REG_EXP_NAME,message ="isAc are")
	@ApiModelProperty(example="NonAc,AC")
	private String isAC;
	
	@Positive(message="total seat")
	@ApiModelProperty
	private int totalSeat;

	@Pattern(regexp=RegularExpressionPattern.REG_EXP_NAME, message="type")
	@ApiModelProperty(example="Sleeper, chaircar")
	private String type;

	public BusDto() {
	}

	public String getAgencyUsername() {
		return agencyUsername;
	}

	public String getBusRouteName() {
		return busRouteName;
	}

	public String getBusNo() {
		return busNo;
	}

	public String getIsAC() {
		return isAC;
	}

	public int getTotalSeat() {
		return totalSeat;
	}

	public String getType() {
		return type;
	}

	public void setAgencyUsername(String agencyUsername) {
		this.agencyUsername = agencyUsername;
	}

	public void setBusRouteName(String busRouteName) {
		this.busRouteName = busRouteName;
	}

	public void setBusNo(String busNo) {
		this.busNo = busNo;
	}

	public void setIsAC(String isAC) {
		this.isAC = isAC;
	}

	public void setTotalSeat(int totalSeat) {
		this.totalSeat = totalSeat;
	}

	public void setType(String type) {
		this.type = type;
	}

	

}