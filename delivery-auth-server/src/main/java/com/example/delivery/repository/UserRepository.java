package com.example.delivery.repository;


import com.example.delivery.model.User;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


/*
 	Aqui defino as consultas referentes aos usuários.
 */
public interface UserRepository extends JpaRepository<User, String>{
	
	@Query("SELECT u FROM User u WHERE LOWER(u.username) = LOWER(:username)")
    Optional<User> findByUsername(@Param("username") String username);
}