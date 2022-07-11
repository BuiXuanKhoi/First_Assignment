package com.nashtech.assignment.ecommerce.service;

import static org.mockito.ArgumentMatchers.intThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.nashtech.assignment.ecommerce.DTO.respond.UserRespondDTO;
import com.nashtech.assignment.ecommerce.data.entities.Users;
import com.nashtech.assignment.ecommerce.data.repository.UserRepository;
import com.nashtech.assignment.ecommerce.services.impl.UserServiceImpl;

public class UserServiceTest {
	
	
	@Mock
	UserService userService;
	
	@MockBean
	UserRepository userRepository;
	
	@InjectMocks
	UserServiceImpl userServiceImpl;
	
	@Test
	public UserRespondDTO testWhenGetAll_thenReturnList() {
		
		List<Users> mockUsers = new ArrayList<Users>();
		
		for(int i=0; i<5; i++){
			
		}
		Mockito.when(userRepository.findAll()).thenReturn(mockUsers);
		
		List<UserRespondDTO> actualUsers = userServiceImpl.getAllUsers();
		
		return null;
			
	}

}
