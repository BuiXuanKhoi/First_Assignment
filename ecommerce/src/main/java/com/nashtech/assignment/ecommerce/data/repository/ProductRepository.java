package com.nashtech.assignment.ecommerce.data.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nashtech.assignment.ecommerce.DTO.respond.ProductRespondDTO;
import com.nashtech.assignment.ecommerce.data.entities.ProductFeature;
import com.nashtech.assignment.ecommerce.data.entities.Products;


@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {
	
	
	@Query(value = "select * from products "
			+ "where products.product_catogery_id = "
			+ ":productCatogeryId", nativeQuery = true)
	Page<Products> getPageProductByCatogery(int productCatogeryId, Pageable pageable);
	
	@Query(value = "select * from products", nativeQuery = true)
	Page<Products> getPageProducts(Pageable pageable);
	
	
	
	

	

	
	
	
	
	

	
	
	
	
	
	

	

}
