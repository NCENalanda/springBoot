package com.jpa.api.controller;

import java.util.List;



import org.springframework.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.api.dto.CustomSort;
import com.jpa.api.dto.ProductDto;
import com.jpa.api.service.Java8FeatureImple;
import com.jpa.api.service.ProductService;

@RestController
@RequestMapping("/product/admin")
public class ProductController {
	
	
	private static final Logger log = LoggerFactory.getLogger(ProductController.class);

	
	@Autowired  //(required=true)
	private ProductService serviceProduct;
	
	
	/*@GetMapping("/get/{id}")
	public ProductDto getProduct( @PathVariable("id")  int id) {
		return serviceProduct.getProduct(id);
	}*/
	
	@GetMapping("/get/{id}")
	public ProductDto getProduct( @PathVariable("id")  int id) {
		log.info("getProduct()    "+this.getClass().getName());
		return serviceProduct.getProduct(id);
	}

	
	@GetMapping("/all")
	//@CrossOrigin(origins="http://localhost:4200")
	public List<ProductDto> getProductAll() {
		log.info("getProductAll()    "+this.getClass().getName());
		return serviceProduct.getAllProduct();
	}
	
	@PostMapping("/sort")
	//@CrossOrigin(origins="http://localhost:4200")
	public Object getProductSortBy(@RequestBody CustomSort sort) {
		log.info("getProductSortBy"+sort+"()     "+this.getClass().getName());
		return serviceProduct.getAllProduct(sort);
	}
	
	
	
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public ProductDto saveProduct(@RequestBody ProductDto dto) {
		log.info("saveProduct()    "+this.getClass().getName());
		return serviceProduct.addProduct(dto);
	}
	
	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.OK)
	public String deleteProduct(@PathVariable("id") int id) {
		log.info("deleteProduct()    "+this.getClass().getName());
		return serviceProduct.deleteProduct(id);
	}

}
