package com.jpa.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.api.model.Role3;

public interface RoleRepository extends JpaRepository<Role3, Integer> {

	Role3 findByRole(String role);

	
}
