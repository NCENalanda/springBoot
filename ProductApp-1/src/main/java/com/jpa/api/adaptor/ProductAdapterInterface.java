package com.jpa.api.adaptor;

import java.util.List;

import com.jpa.api.dto.ProductDto;
import com.jpa.api.model.ProductModel;

public interface ProductAdapterInterface {
	
	ProductDto adaptor(ProductModel model);
	ProductModel adaptor(ProductDto dto);
	List<ProductDto>  adaptor(List<ProductModel> listModel);
	//List<ProductModel> adaptor(List<ProductDto> listDto);
	public List<ProductModel> adaptorList(List<ProductDto> listDto);

}
