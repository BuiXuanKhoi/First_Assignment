package com.nashtech.assignment.ecommerce.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nashtech.assignment.ecommerce.data.entities.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {
	
	

}
