package com.nashtech.assignment.ecommerce.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nashtech.assignment.ecommerce.data.entities.Users;
import com.nashtech.assignment.ecommerce.data.repository.UserRepository;
import com.nashtech.assignment.ecommerce.service.UserService;

public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	
	public UserServiceImpl(@Autowired UserRepository userRepository) 
	{
		this.userRepository = userRepository;
	}

	@Override
	public List<Users> getAllUsers() 
	{
		return this.userRepository.findAll();
	}

	@Override
	public Users findUserById(int id)
	{
		return this.userRepository.getOne(id);
	}
	
	

}
