package com.jpa.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ProductApp1Application {

	public static void main(String[] args) {
		SpringApplication.run(ProductApp1Application.class, args);
	}

}
