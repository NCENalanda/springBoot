package com.jpa.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;



@SuppressWarnings("deprecaton")
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private RestAuthenticationEntryPoint restAuthenticationEntryPoint;
	
	@Autowired
	private MySavedRequestAwareAuthenticationSuccessHandler mySuccessHandler;
	
	private SimpleUrlAuthenticationFailureHandler myFailureHandler = new SimpleUrlAuthenticationFailureHandler();
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("ayush").password(encodePWD().encode("0101")).roles("ADMIN")
		.and()
		.withUser("Sudh").password(encodePWD().encode("1234")).roles("USER")
		.and()
		.withUser("piyush").password(encodePWD().encode("5678")).roles("USER");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		
		.exceptionHandling()
		.authenticationEntryPoint(restAuthenticationEntryPoint)
	    .and()
		.authorizeRequests()
		.antMatchers("/product/message").authenticated()
	    .antMatchers("/product/admin/**").hasRole("ADMIN")
	    .and()
	    .formLogin()
	    .successHandler(mySuccessHandler)
	    .failureHandler(myFailureHandler)
	    .and()
	    .logout()
	   
	    ;
		
	}
		
	@Bean
	public BCryptPasswordEncoder encodePWD() {
		
		return new BCryptPasswordEncoder();
	}

}
