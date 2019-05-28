package com.jpa.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.api.model.Email1;

public interface EmailRepository extends JpaRepository<Email1, Integer> {

}
