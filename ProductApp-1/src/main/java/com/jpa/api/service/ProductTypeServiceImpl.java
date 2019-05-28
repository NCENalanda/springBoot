package com.jpa.api.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.api.dao.ProductTypeRepository;
import com.jpa.api.model.ProductType;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

private static final Logger log = LoggerFactory.getLogger(ProductTypeServiceImpl.class);

	@Autowired
	private ProductTypeRepository repoType;
	@Override
	public ProductType add() {
		//List<ProductType> listType = new ArrayList<>();
		
		return null;
	}
	
	@Override
	public List<String> search(String str) {

		log.info("searchProductType()    "+this.getClass().getName());
		return repoType.search(str);
		
	}

	@Override
	public List<String> getAllType() {
		// TODO Auto-generated method stub
		log.info("getAllProductType()    "+this.getClass().getName());
		return repoType.getAllType();
	}

}
