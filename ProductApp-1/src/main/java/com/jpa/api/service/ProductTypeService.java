package com.jpa.api.service;

import java.util.List;

import com.jpa.api.model.ProductType;

public interface ProductTypeService {

	public ProductType add();
	List<String> search(String str);
	public List<String> getAllType();
}
