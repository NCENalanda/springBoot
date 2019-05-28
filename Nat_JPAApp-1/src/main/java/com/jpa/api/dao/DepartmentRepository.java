package com.jpa.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.api.model.Department1;

public interface DepartmentRepository extends JpaRepository<Department1, Integer>
{

}
