package com.nashtech.assignment.ecommerce.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.nashtech.assignment.ecommerce.data.entities.CartItems;
import com.nashtech.assignment.ecommerce.data.entities.Customers;
import com.nashtech.assignment.ecommerce.data.entities.Products;

@Repository
public interface CartItemRepository extends JpaRepository<CartItems, Integer> {
	
	
	@Query(value = "select * from cart_detail c "
			+ "inner join products p on c.product_id = p.product_id  ", nativeQuery = true)
	CartItems findByCartAndProductName(int cart_id, String product_name);
	
	@Query(value = "select * from cart_detail where cart_id = :cartId", nativeQuery = true)
	List<CartItems> getCartItemByCart(int cartId);
	
	
	@Query(value = "select * from cart_detail where user_id = :userId and product_id = :productId", nativeQuery = true)
	CartItems getCartItemByUserAndProduct(int userId, int productId);
	
	@Modifying
	@Query(value = "delete from cart_detail where user_id = :userId", nativeQuery = true)
	public void deleteAllCart(int userId);
	
	
	

}
