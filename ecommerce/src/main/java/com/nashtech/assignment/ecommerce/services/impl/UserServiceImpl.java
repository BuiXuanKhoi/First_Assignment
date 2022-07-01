package com.nashtech.assignment.ecommerce.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nashtech.assignment.ecommerce.DTO.request.UserRequestDTO;
import com.nashtech.assignment.ecommerce.DTO.respond.UserRespondDTO;
import com.nashtech.assignment.ecommerce.data.entities.Users;
import com.nashtech.assignment.ecommerce.data.repository.UserRepository;
import com.nashtech.assignment.ecommerce.exception.ResourceNotFoundException;
import com.nashtech.assignment.ecommerce.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	
	private ModelMapper modelMapper;
	
	@Autowired
	public UserServiceImpl( UserRepository userRepository, ModelMapper modelMapper) 
	{
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public List<UserRespondDTO> getAllUsers() 
	{
		List<Users> userList =  this.userRepository.findAll();
		
		if(userList.isEmpty()) {
			throw new ResourceNotFoundException("Dont have any user yet");
		}
		
		List<UserRespondDTO> listUserRespond = new ArrayList<UserRespondDTO>();
		
		userList.forEach(user-> listUserRespond.add(modelMapper.map(user, UserRespondDTO.class)) );
		return listUserRespond;
	}

	@Override
	public UserRespondDTO addNewUser(UserRequestDTO userRequestDTO) {
		Users users = modelMapper.map(userRequestDTO, Users.class);
		Users savedUser = this.userRepository.save(users);
		return modelMapper.map(savedUser, UserRespondDTO.class);
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
