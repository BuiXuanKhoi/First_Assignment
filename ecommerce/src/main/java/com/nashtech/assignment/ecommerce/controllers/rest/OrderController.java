package com.nashtech.assignment.ecommerce.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nashtech.assignment.ecommerce.data.entities.Orders;
import com.nashtech.assignment.ecommerce.service.OrderService;

@RestController
@RequestMapping(name = "/orders")
public class OrderController {
	
	private OrderService orderService;
	
	
	
	@Autowired
	public OrderController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}


	@PostMapping
	public Orders createOrder(@RequestBody Orders orders) {
		return this.orderService.createOrders(orders);
	}
	
	@PutMapping("/details")
	public Orders updateOrder(@RequestBody Orders orders) {
		return this.orderService.updateOrders(orders);
	}
	

}
