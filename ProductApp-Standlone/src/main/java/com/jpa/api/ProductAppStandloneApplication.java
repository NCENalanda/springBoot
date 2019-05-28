package com.jpa.api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jpa.api.service.ProductService;
import com.jpa.api.service.ProductTypeService;

@SpringBootApplication
public class ProductAppStandloneApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductAppStandloneApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ProductTypeService ser) {
		return (args) ->{
			//ser.getAllProduct();
			ser.search();
		};
	}
}
