package com.nashtech.assignment.ecommerce.controllers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nashtech.assignment.ecommerce.data.entities.OrderItem;
import com.nashtech.assignment.ecommerce.service.OrderItemService;

@RestController
@RequestMapping("/orders/")
public class OrderItemController {
	
	private OrderItemService orderItemService;
	
	
	@Autowired
	public OrderItemController(OrderItemService orderItemService) {
		super();
		this.orderItemService = orderItemService;
	}



	@PutMapping(value = "/{id}")
	public OrderItem updateOrderItem(@PathVariable("id") int id, @RequestBody OrderItem orderItem) {
		return this.orderItemService.uploadOrderItem(id, orderItem);
	}
	
	

}
