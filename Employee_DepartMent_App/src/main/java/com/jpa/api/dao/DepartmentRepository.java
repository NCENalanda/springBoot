package com.jpa.api.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;



import com.jpa.api.model.DepartmentModel;

public interface DepartmentRepository extends JpaRepository<DepartmentModel, Integer>
{
	Optional<DepartmentModel> findByDeptName(String departmentName);
	
	boolean existsByDeptName(String departmentName);
		
}
