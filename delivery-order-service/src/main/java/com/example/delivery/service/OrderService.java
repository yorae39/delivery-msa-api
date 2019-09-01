package com.example.delivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.delivery.model.Order;
import com.example.delivery.repository.OrderRepository;


/*
 	Aqui estará o @Service nele poderia 
 	implementar ou chamar um fluxo de negócio 
 	relativo a entidade.
 */

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public Order save(@Validated Order order) {
		return orderRepository.save(order);
	}

	public Order findById(Integer id) {
		return orderRepository.findOne(id);
	}

	public Iterable<Order> findAll() {
		return orderRepository.findAll();
	}

	public void delete(Integer id) {
		orderRepository.delete(id);
	}
}
