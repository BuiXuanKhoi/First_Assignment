package com.nashtech.assignment.ecommerce.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nashtech.assignment.ecommerce.data.entities.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
