package com.jpa.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.api.model.Department1;
import com.jpa.api.model.Employee1;

public interface EmpolyeeRepository extends JpaRepository<Employee1, Integer> {

}
