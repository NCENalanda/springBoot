package com.jpa.api.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.api.dto.ProductDto;
import com.jpa.api.service.ProductService;

@RestController
@RequestMapping("/product/admin")
public class ProductController {
	@Autowired
	private ProductService serviceProduct;
	
	/*@GetMapping("/get/{id}")
	public ProductDto getProduct( @PathVariable("id")  int id) {
		return serviceProduct.getProduct(id);
	}*/
	
	@GetMapping("/get{id}")
	public ProductDto getProduct( @PathVariable("id")  int id) {
		return serviceProduct.getProduct(id);
	}

	
	@GetMapping("/all")
	public List<ProductDto> getProductAll() {
		return serviceProduct.getAllProduct();
	}
	
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public ProductDto saveProduct(@RequestBody ProductDto dto) {
		return serviceProduct.addProduct(dto);
	}
	
	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.OK)
	public String deleteProduct(@PathVariable("id") int id) {
		return serviceProduct.deleteProduct(id);
	}

}
