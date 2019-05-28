package com.jpa.api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jpa.api.model.ProductModel;



@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Integer>{

	//@Query("select p from ProductModel p orderby asc") XXXXX   orderby asc
	@Query("select p from ProductModel p") // Success
	public List<ProductModel> getProductQuery();
	
	
	public List<ProductModel> findAllByOrderByProdIdAsc(); //Success
	public List<ProductModel> findAllByOrderByProdIdDesc();//Success
	
	@Query("select u from ProductModel u")//Success
	List<ProductModel> findAllfromQuery();
	
	
	//@Query("select u.ProdId from ProductModel u")  UnSuccess cause of u.ProdId   // So property as well as same not camel Type Representation
	@Query("select u.prodId from ProductModel u")//success  
	List<Integer> findProdIdquery();
	
	@Query("select u from ProductModel u where u.prodId = ?1")
	List<ProductModel> findProdIdquery(int id);
	
}
