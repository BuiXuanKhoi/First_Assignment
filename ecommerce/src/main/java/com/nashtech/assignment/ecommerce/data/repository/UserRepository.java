package com.nashtech.assignment.ecommerce.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nashtech.assignment.ecommerce.data.entities.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {

}
