package com.jpa.api.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jpa.api.model.ProductType;

public interface ProductTypeRepository extends JpaRepository<ProductType, Integer>{

	//@Query("select p from ProductType p")
	//List<ProductType> search();
	//Optional<List<ProductType>> search();
	
	/*
	@Query("select p.type from ProductType p")
	List<String> search();
	*/
	/*@Query("select p1.type, p2.parentType from ProductType p1, ProductType p2 "
			+ "where p2.parentType = p1.type")
	List<Object> search();
	*/
	/*
	@Query("select count(*) from ProductType p2 "
			+ "where p2.parentType = (select p1.type from ProductType p1 where p1.type = 'Toys')")
	List<Object> search();
	*/
	@Query("select p2.type from ProductType p2 "
			+ "where p2.parentType = (select p1.type from ProductType p1 where p1.type = ?1)")
	List<String> search(String str);
}
