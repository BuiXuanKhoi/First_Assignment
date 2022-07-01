package com.nashtech.assignment.ecommerce.controllers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
		this.orderItemService = orderItemService;
	}
	
	@GetMapping("/{name}")
	public OrderItem getOrderItemByName(@PathVariable("name") String orderName) {
		return this.orderItemService.getOrderItemByProductName(orderName);
	}
	
	@PostMapping("/new")
	public OrderItem addNewOrderItem(@RequestBody OrderItem orderItem) {
		return this.orderItemService.addNewOrderItem(orderItem);
	}


	
	

}
