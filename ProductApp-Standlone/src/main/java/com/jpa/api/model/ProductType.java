package com.jpa.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProductType {
	
	@Id private int typeId;
	
	@Column(unique=true) private String type;
	
	private String parentType;
	
	public ProductType() {
		// TODO Auto-generated constructor stub
	}
	public ProductType(int typeId, String type, String parentType) {
		super();
		this.typeId = typeId;
		this.type = type;
		this.parentType = parentType;
	}
	
	public int getTypeId() {
		return typeId;
	}
	public String getType() {
		return type;
	}
	public String getParentType() {
		return parentType;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setParentType(String parentType) {
		this.parentType = parentType;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProductType [typeId=").append(typeId).append(", type=").append(type).append(", parentType=")
				.append(parentType).append("]");
		return builder.toString();
	}

}
