package com.jpa.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.api.model.User1;

public interface UserRepository extends JpaRepository<User1, Integer> {

}
