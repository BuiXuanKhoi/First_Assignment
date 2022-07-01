package com.nashtech.assignment.ecommerce.security.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.nashtech.assignment.ecommerce.data.entities.Users;
import com.nashtech.assignment.ecommerce.data.repository.UserRepository;
import com.nashtech.assignment.ecommerce.exception.UnAuthorizationException;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	
	private UserRepository userRepository;

	public UserDetailServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		Optional<Users> usersOptional = userRepository.findByUserName(username);
		if(usersOptional.isPresent())
		{
			Users users = usersOptional.get();
			return UserDetailImpl.build(users);
			
		}
		
		throw new UnAuthorizationException("Wrong User Name");
	}
	
	

}
