package com.ltd.pvt.dem.vendoragency.api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ltd.pvt.dem.vendoragency.api.model.Agency;


/**
 * This is UserRepository Interface
 * 
 * 
 * */
public interface UserRepository extends JpaRepository<Agency, Long> {

	void save(List<Agency> users);

	Agency findByAgencyEmail(String userName);
	List<Agency> findByBusServices(List busservices);

}
