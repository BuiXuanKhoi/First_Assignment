package com.nashtech.assignment.ecommerce.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nashtech.assignment.ecommerce.DTO.request.UserRequestDTO;
import com.nashtech.assignment.ecommerce.DTO.request.UserUpdateDTO;
import com.nashtech.assignment.ecommerce.DTO.respond.UserRespondDTO;
import com.nashtech.assignment.ecommerce.data.entities.Users;
import com.nashtech.assignment.ecommerce.data.repository.UserRepository;
import com.nashtech.assignment.ecommerce.exception.ResourceNotFoundException;
import com.nashtech.assignment.ecommerce.security.localuser.UserLocal;
import com.nashtech.assignment.ecommerce.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	
	private ModelMapper modelMapper;
	
	
	private UserLocal userLocal;
	
	@Autowired
	public UserServiceImpl( UserRepository userRepository, ModelMapper modelMapper, UserLocal userLocal) 
	{
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
		this.userLocal = userLocal;
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
	public UserRespondDTO findUserByName(String userName)
	{
		
		Optional<Users> userOptional = this.userRepository.findByUserName(userName);
		
		if(userOptional.isPresent()) 
		{
			Users users = userOptional.get();
			UserRespondDTO userFound = modelMapper.map(users, UserRespondDTO.class);
			return userFound;
		}
		
		throw new ResourceNotFoundException("User Not Found");		
	}

	@Override
	public UserRespondDTO updateUsers(UserUpdateDTO userUpdateDTO)
	{
	      String localUserName = userLocal.getLocalUser();
	      if(localUserName != null) {
	    	  int id = userRepository.getIdByName(localUserName);
	    	  Users users = modelMapper.map(userUpdateDTO, Users.class);
	    	  users.setUserId(id);
	    	  Users savedUser =  this.userRepository.save(users);
	    	  return modelMapper.map(savedUser, UserRespondDTO.class);
	      }
	      throw new ResourceNotFoundException("Please Log in first !");
		
	}
	


	
	



	
	
	

}
