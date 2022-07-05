package com.nashtech.assignment.ecommerce.data.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nashtech.assignment.ecommerce.DTO.request.ProductRequestDTO;
import com.nashtech.assignment.ecommerce.DTO.respond.ProductRespondDTO;
import com.nashtech.assignment.ecommerce.data.entities.ProductFeature;
import com.nashtech.assignment.ecommerce.data.entities.Products;


@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {
	
	@Query(value = "select * from products where product_id = :id", nativeQuery = true)
	Products findProductsById(int id);
	
	@Query(value = "select * from products "
			+ "where product_catogery_id = (select product_catogery_id from product_catogery where product_catogery_name = :catogeryName) "
			+ "order by product_price asc ", nativeQuery = true)
	List<Products> getProductByPriceIncrease(String catogeryName);
	
	@Query(value = "select * from products "
			+ "where product_catogery_id = (select product_catogery_id from product_catogery where product_catogery_name = :catogeryName) "
			+ "order by product_price desc ", nativeQuery = true)
	List<Products> getProductByPriceDecrease(String catogeryName);
	

	
	
	
	
	

	
	
	
	
	
	

	

}
