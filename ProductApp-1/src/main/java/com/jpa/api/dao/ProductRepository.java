package com.jpa.api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jpa.api.model.ProductModel;

public interface ProductRepository extends JpaRepository<ProductModel, Integer>{

	
	
}
