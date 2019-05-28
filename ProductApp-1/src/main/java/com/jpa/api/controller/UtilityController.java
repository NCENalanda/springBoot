package com.jpa.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.api.service.ProductTypeService;

@RestController
@RequestMapping("/product/util")
public class UtilityController {
	
	private static final Logger log = LoggerFactory.getLogger(UtilityController.class);

	private List<String> listType = new ArrayList<>();
	private List<String> listBrand = new ArrayList<>();
	@Autowired
	private ProductTypeService serviceType;
	
	
	@GetMapping("/searchType/{search}")
	public List<String> searchType(@PathVariable("search") String str){
		log.info("searchProductType()    "+this.getClass().getName());
		log.info("Search  ::"+str);
		return serviceType.search(str);
	}
	@GetMapping("/getType")
	public List<String> getAllType(){
		log.info("getProductType()    "+this.getClass().getName());
		return serviceType.getAllType();
	}
	
	@GetMapping("/getBrand")
	public List<String> getAllBrand(){
		log.info("getAllBrand()    "+this.getClass().getName());
		return listBrand;
	}
	 /* 
	//non static Block
	{ listType.add("Book");listType.add("electronics");listType.add("Home and Furniture");
	listType.add("Fashion");listType.add("TV & Appliances");listType.add("Sports");listType.add("Beauty and Personal care");
	}*/
	{ 
		listBrand.add("Safari");listBrand.add("Acer");listBrand.add("Dell");listBrand.add("HP");listBrand.add("Voltas");listBrand.add("Blue Star");
		listBrand.add("Peter England");listBrand.add("Campus Sutra");listBrand.add("Nike");listBrand.add("Red Tape");listBrand.add("Nike");
		listBrand.add("MI");listBrand.add("Samsung");listBrand.add("Hindustan Unilever");listBrand.add("Oppo");listBrand.add("Pantajli");
		listBrand.add("HP");listBrand.add("Apple");listBrand.add("Bajaj");listBrand.add("HP");listBrand.add("Havells");listBrand.add("Philips");
		listBrand.add("LG");listBrand.add("Bombay Dyeing");listBrand.add("Raymond");listBrand.add("others");
	}
	
	
}
