package com.nashtech.assignment.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nashtech.assignment.ecommerce.data.entities.Users;

@Service
public interface UserService {
	
	public List<Users> getAllUsers();
	
	public Users findUserById(int id);

}
