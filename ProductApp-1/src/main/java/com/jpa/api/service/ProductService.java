package com.jpa.api.service;

import java.util.List;

import com.jpa.api.dto.CustomSort;
import com.jpa.api.dto.ProductDto;

public interface ProductService {

	ProductDto addProduct(ProductDto dto);
	List<ProductDto> getAllProduct();
	ProductDto getProduct(int id);
	String deleteProduct(int id);
	List<ProductDto> getAllProduct(CustomSort sort);
}
