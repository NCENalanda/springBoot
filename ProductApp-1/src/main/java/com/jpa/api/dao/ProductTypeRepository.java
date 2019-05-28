package com.jpa.api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jpa.api.model.ProductType;

public interface ProductTypeRepository extends JpaRepository<ProductType, Integer>{

	@Query("select p2.type from ProductType p2 "
			+ "where p2.parentType = (select p1.type from ProductType p1 where p1.type = ?1)")
	List<String> search(String str);
	
	@Query("select p.type from ProductType p")
	List<String> getAllType();
}
