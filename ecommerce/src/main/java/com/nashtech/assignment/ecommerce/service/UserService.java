package com.nashtech.assignment.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nashtech.assignment.ecommerce.DTO.request.UserRequestDTO;
import com.nashtech.assignment.ecommerce.DTO.request.UserUpdateDTO;
import com.nashtech.assignment.ecommerce.DTO.respond.UserRespondDTO;
import com.nashtech.assignment.ecommerce.data.entities.Users;


public interface UserService {
	
	public List<UserRespondDTO> getAllUsers();
	
	public UserRespondDTO findUserByName(String userName);
	
	public UserRespondDTO updateUsers(UserUpdateDTO userUpdateDTO);
	
	
	

	
	

}
