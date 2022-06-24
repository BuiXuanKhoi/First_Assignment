package com.nashtech.assignment.ecommerce.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nashtech.assignment.ecommerce.data.entities.Customers;


@Repository
public interface CustomerRepository extends JpaRepository<Customers, Integer> {
	
	/*@Query("insert into customers(customer_date_of_birth, customer_address, customer_phone_numer, user_id)"
			+ "values" + "( :customers.customer_date_of_birth, :customers.customer_address, :customers.customer_phone_number, customers.user_id"
			+ "where " + "customers.user_id")
	public Customers addNewCustomer(Customers customers);*/

}
