package com.nashtech.assignment.ecommerce.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nashtech.assignment.ecommerce.data.entities.Products;


@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {
	
	@Query(value = "select * from products where product_id = :id", nativeQuery = true)
	Products findProductsById(int id);
	


	
	
	
	
	
	

	

}
