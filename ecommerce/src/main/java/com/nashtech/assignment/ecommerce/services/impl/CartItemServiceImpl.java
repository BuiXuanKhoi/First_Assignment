package com.nashtech.assignment.ecommerce.services.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nashtech.assignment.ecommerce.DTO.request.CartDetailRequestDTO;
import com.nashtech.assignment.ecommerce.DTO.respond.MessageRespond;
import com.nashtech.assignment.ecommerce.data.entities.CartItems;
import com.nashtech.assignment.ecommerce.data.entities.Products;
import com.nashtech.assignment.ecommerce.data.entities.Users;
import com.nashtech.assignment.ecommerce.data.repository.CartItemRepository;
import com.nashtech.assignment.ecommerce.data.repository.ProductRepository;
import com.nashtech.assignment.ecommerce.data.repository.UserRepository;
import com.nashtech.assignment.ecommerce.exception.ResourceNotFoundException;
import com.nashtech.assignment.ecommerce.security.localuser.UserLocal;
import com.nashtech.assignment.ecommerce.service.CarItemService;


@Service
public class CartItemServiceImpl implements CarItemService {
	
	private CartItemRepository cartItemRepository;
	
	private UserLocal userLocal;
	
	private UserRepository userRepository;
	
	private ProductRepository productRepository;
	
	private ModelMapper modelMapper;
	
	
	@Autowired
	public CartItemServiceImpl(CartItemRepository cartItemRepository, UserLocal userLocal,
			UserRepository userRepository, ProductRepository productRepository, ModelMapper modelMapper) {
		this.cartItemRepository = cartItemRepository;
		this.userLocal = userLocal;
		this.userRepository = userRepository;
		this.productRepository = productRepository;
		this.modelMapper = modelMapper;
	}



	@Override
	public CartItems saveCartItem(CartDetailRequestDTO cartDetailRequestDTO, int productId) 
	{
		
		CartItems cartItems = modelMapper.map(cartDetailRequestDTO, CartItems.class);
		String userName = userLocal.getLocalUser();
		Users users = userRepository.findByUserName(userName).get();
		Optional<Products> productOptional = productRepository.findById(productId);
		if(productOptional.isPresent()) 
		{
			Products products = productOptional.get();
			cartItems.setUsers(users);
			cartItems.setProduct(products);
			
			CartItems cartItemExisted = cartItemRepository.getCartItemByUserAndProduct(users.getUserId(), productId); // Check if cart item existed
			
			if(cartItemExisted != null) 
			{
				cartItems.setCartItemId(cartItemExisted.getCartItemId()); // If existed, take existed id to update.
				int totalQuantity = cartItemExisted.getCartItemQuantity() + cartItems.getCartItemQuantity();
				cartItems.setCartItemQuantity(totalQuantity);
				int totalPrice = caculateProductPrice(productId, totalQuantity);
				cartItems.setCartItemTotalPrice(totalPrice);
			}
			return this.cartItemRepository.save(cartItems); // It will be post method if cart item not existed
		}
		
		throw new ResourceNotFoundException("Product Not Found With ID : " + productId);
	
	}

	@Override
	public ResponseEntity<?> deleteCartItem(int cartItemId) {
		Optional<CartItems> cartItemOptional = this.cartItemRepository.findById(cartItemId);
		if(cartItemOptional.isPresent()) {
			this.cartItemRepository.deleteById(cartItemId);
			return ResponseEntity.ok(new MessageRespond(HttpStatus.OK.value(),"Delete Success"));
		}
		throw new ResourceNotFoundException("Cart Item Not Found With Id : " + cartItemId);
	}
	
	
	public int caculateProductPrice(int productId, int quantity) {
		Optional<Products> productOptional = productRepository.findById(productId);
		if(productOptional.isPresent()) {
			Products products = productOptional.get();
			return products.getProductPrice()*quantity;
		}
		throw new ResourceNotFoundException("Products Not Found With ID : " + productId);
		
	}



	@Override
	public void deleteAllCartItemByOwner() {
		
		String userName = userLocal.getLocalUser();
		Users users = userRepository.findByUserName(userName).get();
		
		this.cartItemRepository.deleteAllCart(users.getUserId());
	}



	@Override
	public List<CartItems> getAllCartItemsByOwner() {
		String userName = userLocal.getLocalUser();
		Users users = userRepository.findByUserName(userName).get();
		System.out.println("Cart Item  " + users.getCartItems().toString());
		List<CartItems> listCartItems =  users.getCartItems();
		if(!listCartItems.isEmpty()) {
			return listCartItems;
		}
		throw new ResourceNotFoundException("You haven't put anything in this Cart");
	}
	
	

}
