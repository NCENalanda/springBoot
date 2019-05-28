package com.jpa.api.dto;

import java.io.Serializable;

public class ProductDto implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1232678L;
	private int prodId;
	private String prodName;
	private double price;
	private String type;
	private String brand;
	public ProductDto() {
		// TODO Auto-generated constructor stub
	}
	public ProductDto(int prodId, String prodName, double price) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.price = price;
	}
	public int getProdId() {
		return prodId;
	}
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	@Override
	public String toString() {
		return String.format("ProductDto [prodId=%s, prodName=%s, price=%s]", prodId, prodName, price);
	}

}
