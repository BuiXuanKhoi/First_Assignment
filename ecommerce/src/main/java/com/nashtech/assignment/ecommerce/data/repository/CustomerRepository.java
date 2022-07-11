package com.nashtech.assignment.ecommerce.data.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nashtech.assignment.ecommerce.data.entities.Customers;


@Repository
public interface CustomerRepository extends JpaRepository<Customers, Integer> {
	
	@Query(value = "select * from customers where user_id = :userId", nativeQuery = true)	
	public Optional<Customers> findCustomerByUser(int userId);
	

}
