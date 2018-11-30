package com.ws.rest.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ws.rest.model.entities.User;


@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> 
{
    User findByEmailAndPassword(String email, String password);
}