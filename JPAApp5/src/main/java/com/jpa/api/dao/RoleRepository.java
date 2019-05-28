package com.jpa.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.api.model.Role2;

public interface RoleRepository extends JpaRepository<Role2, Integer> {

	Role2 findByRole(String role);

	
}
