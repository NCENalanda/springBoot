package com.jpa.api.service;

import java.util.List;

import com.jpa.api.model.ProductModel;

public interface ProductService {

	ProductModel addProduct(ProductModel dto);
	List<ProductModel> getAllProduct();
	ProductModel getProduct(int id);
	String deleteProduct(int id);
	public List<ProductModel> query();
	
}
