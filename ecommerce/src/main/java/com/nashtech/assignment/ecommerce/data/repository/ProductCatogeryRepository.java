package com.nashtech.assignment.ecommerce.data.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nashtech.assignment.ecommerce.data.entities.ProductCatogery;


@Repository
public interface ProductCatogeryRepository extends JpaRepository<ProductCatogery, Integer> {
	
	@Query(value = "select * from product_catogery where product_catogery_name = :name", nativeQuery = true)
	public Optional<ProductCatogery> getCatogeryByName(String name);
	


}
