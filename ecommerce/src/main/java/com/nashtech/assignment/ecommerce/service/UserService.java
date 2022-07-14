package com.nashtech.assignment.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.nashtech.assignment.ecommerce.DTO.request.BanRequest;
import com.nashtech.assignment.ecommerce.DTO.request.UnbanRequest;
import com.nashtech.assignment.ecommerce.DTO.request.UserRequestDTO;
import com.nashtech.assignment.ecommerce.DTO.request.UserUpdateDTO;
import com.nashtech.assignment.ecommerce.DTO.request.VertiRequest;
import com.nashtech.assignment.ecommerce.DTO.respond.UserRespondDTO;
import com.nashtech.assignment.ecommerce.data.entities.Users;


public interface UserService {
	
	public List<UserRespondDTO> getAllUsers();
	
	public UserRespondDTO findUserByName(String userName);
	
	public UserRespondDTO updateUsers(UserUpdateDTO userUpdateDTO);
	
	public ResponseEntity<?> blockUser( BanRequest banRequest);
	
	public ResponseEntity<?> unbanUser(VertiRequest vertiRequest);
	
	public ResponseEntity<?> sendUnbanRequest(UnbanRequest unbanRequest);
	
	
	
	

	
	

}
