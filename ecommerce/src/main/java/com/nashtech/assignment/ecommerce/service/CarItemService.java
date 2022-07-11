package com.nashtech.assignment.ecommerce.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.nashtech.assignment.ecommerce.DTO.request.CartDetailRequestDTO;
import com.nashtech.assignment.ecommerce.data.entities.CartItems;

public interface CarItemService {
	
	
	
	public CartItems saveCartItem(CartDetailRequestDTO cartDetailRequestDTO, int productId);
	
	public ResponseEntity<?> deleteCartItem(int cartItemId);
	
	public void deleteAllCartItemByOwner();
	
	public List<CartItems> getAllCartItemsByOwner();

}
