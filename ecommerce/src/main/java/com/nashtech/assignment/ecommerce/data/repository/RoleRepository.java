package com.nashtech.assignment.ecommerce.data.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nashtech.assignment.ecommerce.data.entities.Roles;

@Repository
public interface RoleRepository extends JpaRepository<Roles, Integer> {
	
	@Query(value = "select * from roles where catogery_user_role = :name", nativeQuery = true)
	public Optional<Roles> findRoleByName(String name);
	
	


}
