package com.example.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.delivery.model.Authority;

 /*
  	Esse repository será responsável pelas consultas 
  	das regras do usuário no banco de dados.
  */

public interface AuthorityRepository extends JpaRepository<Authority, String>{
	
	Authority findByName(String name);
	
}