package com.nashtech.assignment.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nashtech.assignment.ecommerce.data.entities.Users;


public interface UserService {
	
	public List<Users> getAllUsers();
	
	public Users findUserByName(String userName);
	
	public Users addNewUser(Users users);
	
	public Users updateUsers(Users users);
	
	public void deleteUserById(int id);
	
	public Optional<Users> findUserById(int id);
	

	
	

}
