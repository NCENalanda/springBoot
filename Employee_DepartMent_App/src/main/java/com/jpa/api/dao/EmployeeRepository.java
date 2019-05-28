package com.jpa.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.api.model.EmployeeModel;


public interface EmployeeRepository extends JpaRepository<EmployeeModel, Integer> {
	
  boolean	existsByEmail(String email);

}
