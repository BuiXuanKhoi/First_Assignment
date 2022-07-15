	package com.nashtech.assignment.ecommerce.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nashtech.assignment.ecommerce.DTO.request.OrderRequestDTO;
import com.nashtech.assignment.ecommerce.data.entities.CartItems;
import com.nashtech.assignment.ecommerce.data.entities.Orders;
import com.nashtech.assignment.ecommerce.data.entities.Users;
import com.nashtech.assignment.ecommerce.data.repository.OrderRepository;
import com.nashtech.assignment.ecommerce.data.repository.UserRepository;
import com.nashtech.assignment.ecommerce.exception.ResourceNotFoundException;
import com.nashtech.assignment.ecommerce.security.localuser.UserLocal;
import com.nashtech.assignment.ecommerce.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	private OrderRepository orderRepository;
	
	private ModelMapper modelMapper;
	
	private UserLocal userLocal;
	
	private UserRepository userRepository;
	
	
	private CartItemServiceImpl cartItemServiceImpl;
	
	private OrderItemServiceImpl orderItemServiceImpl;
	
	
	@Autowired
	public OrderServiceImpl(OrderRepository orderRepository, ModelMapper modelMapper, UserLocal userLocal,
			UserRepository userRepositoryl, CartItemServiceImpl cartItemServiceImpl,
			OrderItemServiceImpl orderItemServiceImpl) {
		this.orderRepository = orderRepository;
		this.modelMapper = modelMapper;
		this.userLocal = userLocal;
		this.userRepository = userRepositoryl;
		this.cartItemServiceImpl = cartItemServiceImpl;
		this.orderItemServiceImpl = orderItemServiceImpl;
	}



	@Override
	public Orders createOrders(OrderRequestDTO orderRequestDTO) {
		
		String userName = userLocal.getLocalUser();
		
		Users users = userRepository.findByUserName(userName).get();
		
		List<CartItems> cartListing = cartItemServiceImpl.getAllCartItemsByOwner();
				
		if(!cartListing.isEmpty()) 
		{
			Orders orders = modelMapper.map(orderRequestDTO, Orders.class);
			orders.setUsers(users);
			orders.setOrderCreateDay(new Date());
			
			Orders newOrders =  this.orderRepository.save(orders);
			
			for (CartItems cartItems : cartListing) 
			{
				this.orderItemServiceImpl.addNewOrderItem(cartItems, newOrders.getOrderId());
			}
			this.cartItemServiceImpl.deleteAllCartItemByOwner();
			
			return newOrders;
			
		}
		
		throw new ResourceNotFoundException("Your Cart Is Empty");
	
	}



	@Override
	public List<Orders> getListOrderByOwner() {
		String userName = userLocal.getLocalUser();
		Users users = userRepository.findByUserName(userName).get();
		int userId = users.getUserId();
		List<Orders> listOrders = this.orderRepository.getListOrderByOwner(userId);
		if(!listOrders.isEmpty()) 
		{
			return listOrders;
		}
		throw new ResourceNotFoundException("This user havent buy anything");
	}



	@Override
	public void deleteOrder(int orderId) {
		this.orderRepository.deleteById(orderId);
	}
	
	

}
