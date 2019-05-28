package com.rest.user.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rest.user.api.dto.UserSignup;
import com.rest.user.api.dto.UserSignin;
import com.rest.user.api.model.User;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class UserConfig {
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.rest.user.api.controller")).paths(regex("/user.*"))
				.build();
	}

	private ApiInfo apiInfo() {

		return new ApiInfoBuilder().title("User Service").build();
	}

	public User convertDtoToModel(UserSignup dto) {
		User model = null;
		model = new User();
		model.setFirsrname(dto.getFirsrname());
		model.setLastname(dto.getLastname());
		model.setUsername(dto.getUsername());
		model.setContact(dto.getContact());
		model.setAddress(dto.getAddress());
		model.setPassword(dto.getPassword());
		return model;
	}

	public UserSignup convertModelToDto(User model) {
		UserSignup dto = null;
		dto = new UserSignup();
		dto.setUsername(model.getUsername());
		dto.setFirsrname(model.getUsername());
		dto.setLastname(model.getLastname());
		dto.setContact(model.getContact());
		dto.setAddress(model.getAddress());
		dto.setPassword("***********");
		return dto;
	}

	public User convertSigninToModel(UserSignin signin) {
		User model = null;
		model = new User();
		model.setUsername(signin.getUsername());
		model.setPassword(signin.getPassword());
		return model;
	}

}
