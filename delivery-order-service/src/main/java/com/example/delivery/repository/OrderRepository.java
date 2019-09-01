package com.example.delivery.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.delivery.model.Order;


/*
 	Essa interface será responsável por fazer a “ponte” 
 	entre a camada de negócio e o banco de dados, 
 	podemos ver que ela está estendendo a Interface CrudRepository 
 	ela é uma interface do Spring Data JPA que fornece uma funcionalidade 
 	CRUD completa para a entidade que está sendo gerenciada.
 */
public interface OrderRepository extends CrudRepository<Order, Integer>{

}
