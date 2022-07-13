package com.nashtech.assignment.ecommerce.controllers.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nashtech.assignment.ecommerce.DTO.request.CartDetailRequestDTO;
import com.nashtech.assignment.ecommerce.data.entities.CartItems;
import com.nashtech.assignment.ecommerce.service.CarItemService;


@RestController
@RequestMapping("/api/carts")
public class CartController {
	
	@Autowired
	private CarItemService carItemService;
	
	
	@GetMapping
	@PreAuthorize("hasAuthority('CUSTOMER') or hasAuthority('ADMIN')")
	public List<CartItems> getAllCartByOwner(){
		return this.carItemService.getAllCartItemsByOwner();	
	}
	
	@PutMapping
	@PreAuthorize("hasAuthority('CUSTOMER') or hasAuthority('ADMIN')")
	public CartItems saveCartItems(
			@Valid @RequestBody CartDetailRequestDTO cartDetailRequestDTO,
			@RequestParam(name = "product", required = true) int productId
			) {
		return this.carItemService.saveCartItem(cartDetailRequestDTO, productId);
	}
	
	@DeleteMapping
	@PreAuthorize("hasAuthority('CUSTOMER') or hasAuthority('ADMIN')")
	public ResponseEntity<?> deleteAllCartItemByOwner(){
		this.carItemService.deleteAllCartItemByOwner();
		return ResponseEntity.ok("Delete Success"); 
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('CUSTOMER') or hasAuthority('ADMIN')")
	public ResponseEntity<?> deleteCartItem(
			@PathVariable("id") int cartItemId){
		return this.carItemService.deleteCartItem(cartItemId);
	}
	
	

}
