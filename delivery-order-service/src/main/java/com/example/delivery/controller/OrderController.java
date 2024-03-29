package com.example.delivery.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.delivery.model.Order;
import com.example.delivery.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

/*
 	Aqui expõe os endpoints, para que seja possível o acesso.
 */

@RestController
@RequestMapping(value = "/api/orders", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {

	@Autowired
	private OrderService orderService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Order> save(@RequestBody Order order) {
		return ResponseEntity.ok(orderService.save(order));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Order> findById(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(orderService.findById(id));
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Iterable<Order>> findAll() {
		return ResponseEntity.ok().body(orderService.findAll());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
		orderService.delete(id);
		return ResponseEntity.ok().build();
	}
}
