package com.nashtech.assignment.ecommerce.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nashtech.assignment.ecommerce.data.entities.Orders;
import com.nashtech.assignment.ecommerce.data.repository.OrderRepository;
import com.nashtech.assignment.ecommerce.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	private OrderRepository orderRepository;
	
	
	public OrderServiceImpl(@Autowired OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}


	@Override
	public Orders findOrderByOwnerPhoneNumber(int phone) {
		return orderRepository.findOrdersByOwnerId(phone);
	}
	
	

}
