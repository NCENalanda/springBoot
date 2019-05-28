package com.jpa.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.api.model.User2;
import java.math.BigInteger;
import java.util.List;

public interface UserRepository extends JpaRepository<User2, Integer>{

	User2 findByUserName(String userName);
	List<User2> findByPhoneNo(BigInteger phoneno);
}
