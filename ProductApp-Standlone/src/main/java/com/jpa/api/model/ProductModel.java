package com.jpa.api.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Product1")
public class ProductModel {
	
	
	@Id
	private int prodId;
	private String prodName;
	private double price;
	private String type;
	private String brand;
	public ProductModel() {
		// TODO Auto-generated constructor stub
	}
	public ProductModel(int prodId, String prodName, double price) {
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
		StringBuilder builder = new StringBuilder();
		builder.append("ProductModel [prodId=").append(prodId).append(", prodName=").append(prodName).append(", price=")
				.append(price).append(", type=").append(type).append(", brand=").append(brand).append("]");
		return builder.toString();
	}
	

}
