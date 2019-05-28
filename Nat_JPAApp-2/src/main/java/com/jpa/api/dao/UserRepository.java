package com.jpa.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.api.model.User3;
import java.math.BigInteger;
import java.util.List;

public interface UserRepository extends JpaRepository<User3, Integer>{

	User3 findByUserName(String userName);
	List<User3> findByPhoneNo(BigInteger phoneno);
}
