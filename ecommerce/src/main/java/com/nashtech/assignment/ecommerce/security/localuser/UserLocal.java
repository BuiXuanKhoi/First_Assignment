package com.nashtech.assignment.ecommerce.security.localuser;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.nashtech.assignment.ecommerce.exception.ResourceNotFoundException;

@Component
public class UserLocal {
	
	public String getLocalUser() 
	{
		String userName =  SecurityContextHolder.getContext().getAuthentication().getName();
		
		if(userName != null) 
		{
			return userName;
		}
		throw new ResourceNotFoundException("User Not Found. Maybe you haven't log in");
	}
	
//	public String getRoleUser() {
//		UserDetails userDetails =  (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		Collection<? extends GrantedAuthority> role = userDetails.getAuthorities();
//	}

}