package com.jpa.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.api.model.Custumber;

public interface UserRepository extends JpaRepository<Custumber, Integer> {

}
