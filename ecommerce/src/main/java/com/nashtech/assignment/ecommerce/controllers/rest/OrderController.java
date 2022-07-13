package com.nashtech.assignment.ecommerce.controllers.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nashtech.assignment.ecommerce.DTO.request.OrderRequestDTO;
import com.nashtech.assignment.ecommerce.data.entities.Orders;
import com.nashtech.assignment.ecommerce.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	
	
	


	@PostMapping
	@PreAuthorize("hasAuthority('CUSTOMER')")
	public Orders createOrder( @Valid @RequestBody OrderRequestDTO orderRequestDTO){
		return this.orderService.createOrders(orderRequestDTO);
	}
	
	@GetMapping
	@PreAuthorize("hasAuthority('CUSTOMER')")
	public List<Orders> getListOrderByOwner(){
		return this.orderService.getListOrderByOwner();
	}
	
	
	@DeleteMapping
	@PreAuthorize("hasAuthority('CUSTOMER')")
	public ResponseEntity<?> deleteOrderById(@RequestParam(name = "id", required = true) int orderId){
		this.orderService.deleteOrder(orderId);
		return ResponseEntity.ok("Delete Order Success");
	}
	
	

}
