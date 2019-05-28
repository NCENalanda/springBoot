package com.jpa.api.adaptor;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.jpa.api.dto.ProductDto;
import com.jpa.api.model.ProductModel;

@Component
public class ProductAdaptor implements ProductAdapterInterface {
	
	
	private static final Logger log = LoggerFactory.getLogger(ProductAdaptor.class);


	@Override
	public ProductDto adaptor(ProductModel model) {
		// TODO Auto-generated method stub
		ProductDto dto=new ProductDto();
		log.info(" CONVERT  MODEL TO DTO  "+this.getClass().getName());
		
		BeanUtils.copyProperties(model, dto);
		return dto;
	}

	@Override
	public ProductModel adaptor(ProductDto dto) {
		// TODO Auto-generated method stub
		ProductModel model=new ProductModel();
		log.info(" CONVERT DTO TO Model  "+this.getClass().getName());
		BeanUtils.copyProperties(dto, model);
		return model;
	}

	@Override
	public List<ProductDto> adaptor(List<ProductModel> listModel) {
		// TODO Auto-generated method stub
		log.info(" CONVERT  List MODEL TO List DTO  "+this.getClass().getName());
		List<ProductDto> listDto=new ArrayList<>();
		listModel.forEach(model->{
			listDto.add(this.adaptor(model));
		});
		return listDto;
	}
	
	@Override
	public List<ProductModel> adaptorList(List<ProductDto> listDto) {
		// TODO Auto-generated method stub
		log.info(" CONVERT  List DTO to List Model  "+this.getClass().getName());
		List<ProductModel> listModel=new ArrayList<>();
		listDto.forEach(dto->{
			listModel.add(this.adaptor(dto));
		});
		return listModel;
	}

}
