package com.nashtech.assignment.ecommerce.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nashtech.assignment.ecommerce.data.entities.Users;
import com.nashtech.assignment.ecommerce.data.repository.UserRepository;
import com.nashtech.assignment.ecommerce.service.UserService;


@Service
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
	public Users addNewUser(Users users) {
		return this.userRepository.saveAndFlush(users);
	}

	@Override
	public Users findUserByName(String userName) {
		return null;
	}

	@Override
	public Users updateUsers(Users users) {
		return this.userRepository.saveAndFlush(users);
	}

	@Override
	public void deleteUserById(int id) 
	{
		this.userRepository.deleteById(id);
	}

	@Override
	public Optional<Users> findUserById(int id) {
		return this.userRepository.findById(id);
	}
	
	



	
	
	

}
