package com.nashtech.assignment.ecommerce.data.repository;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nashtech.assignment.ecommerce.data.entities.Users;


@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
	

	

	


}
