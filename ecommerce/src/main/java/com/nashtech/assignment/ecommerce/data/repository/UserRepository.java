package com.nashtech.assignment.ecommerce.data.repository;

import java.sql.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nashtech.assignment.ecommerce.data.entities.Users;


@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
	
	
	@Query(value = "select * from users u where u.user_name = cast(:userName as text)", nativeQuery = true)
	public Optional<Users> findByUserName(String userName);
	
	
	@Query(value = "select * from users u where u.user_email = cast(:userEmail as text)", nativeQuery =  true)
	public Optional<Users> findByEmail(String userEmail);
	

	

	


}
