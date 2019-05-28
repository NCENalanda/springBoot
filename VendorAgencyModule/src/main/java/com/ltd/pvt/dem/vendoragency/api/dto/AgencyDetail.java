package com.ltd.pvt.dem.vendoragency.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@ApiModel(value="User Detail")
public class AgencyDetail {
	
	@ApiModelProperty(value="Address")
	private String address;
	
	@ApiModelProperty(value="Mobile")
	private String contact;

	@ApiModelProperty(name="OwnerName")
	private String ownerName;

	public String getOwnerName() {
		return ownerName;
	}


	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	@ApiModelProperty(value="Username")
	private String username;
	
	@ApiModelProperty(name="Username")
	private String agencyName;
	
	public String getAgencyName() {
		return agencyName;
	}


	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}


	public AgencyDetail() {
		// TODO Auto-generated constructor stub
	}


	public String getAddress() {
		return address;
	}

	public String getContact() {
		return contact;
	}

	

	public String getUsername() {
		return username;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
}
