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
	
	@Query(value = "SELECT "
			+ "NEW com.nashtech.assignment.ecommerce.data.entities.ProductFeature(d.productPrice, d.productName , p.productCatogeryName) "
			+ "FROM Products d "
			+ "INNER JOIN d.productCatogery p where p.productCatogeryName = :catogeryName order by d.productPrice asc")
	List<ProductFeature> getProductByPriceIncrease(String catogeryName);
	
	@Query(value = "SELECT "
			+ "NEW com.nashtech.assignment.ecommerce.data.entities.ProductFeature(d.productPrice, d.productName , p.productCatogeryName) "
			+ "FROM Products d "
			+ "INNER JOIN d.productCatogery p where p.productCatogeryName = :catogeryName order by d.productPrice desc")
	List<ProductFeature> getProductByPriceDecrease(String catogeryName);
	
	@Query(value = "SELECT "
			+ "NEW com.nashtech.assignment.ecommerce.data.entities.ProductFeature(d.productPrice, d.productName , p.productCatogeryName) "
			+ "FROM Products d "
			+ "INNER JOIN d.productCatogery p where p.productCatogeryName = :name")
	public List<Optional<ProductFeature>> getListProductByCatogery(String name, Pageable pageable);
	
	
	

	
	
	
	
	
	

	

}
