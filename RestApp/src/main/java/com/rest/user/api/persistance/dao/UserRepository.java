package com.rest.user.api.persistance.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.user.api.persistance.model.User;





@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String email);
}
