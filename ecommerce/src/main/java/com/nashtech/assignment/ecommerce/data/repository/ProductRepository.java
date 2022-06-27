package com.nashtech.assignment.ecommerce.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



import com.nashtech.assignment.ecommerce.data.entities.ProductFeature;
import com.nashtech.assignment.ecommerce.data.entities.Products;


@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {
	
	@Query(value = "select * from products where product_id = :id", nativeQuery = true)
	Products findProductsById(int id);
	
	@Query(value = "select * from products order by product_price asc", nativeQuery = true)
	List<Products> getProductByPriceIncrease();
	
	@Query(value = "select * from products order by product_price desc", nativeQuery = true)
	List<Products> getProductByPriceDecrease();
	
	@Query(value = "SELECT "
			+ "NEW com.nashtech.assignment.ecommerce.data.entities.ProductFeature(d.productPrice, d.productName , p.productCatogeryName) "
			+ "FROM Products d "
			+ "INNER JOIN d.productCatogery p where p.productCatogeryName = :name")
	public List<ProductFeature> getListProductByCatogery(String name);
	
	
	

	
	
	
	
	
	

	

}
