package com.rest.user.api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.user.api.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	void save(List<User> users);

	User findByUsername(String userName);

}
