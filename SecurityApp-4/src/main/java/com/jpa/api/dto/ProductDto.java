package com.jpa.api.dto;

public class ProductDto {
	
	
	
	private int prodId;
	private String prodName;
	private double price;
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
	@Override
	public String toString() {
		return String.format("ProductDto [prodId=%s, prodName=%s, price=%s]", prodId, prodName, price);
	}

}
