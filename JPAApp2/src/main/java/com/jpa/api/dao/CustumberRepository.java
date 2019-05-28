package com.jpa.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.api.model.Custumber1;


public interface CustumberRepository extends JpaRepository<Custumber1, Integer> {
         Custumber1 findByFirstName(String str);
}
