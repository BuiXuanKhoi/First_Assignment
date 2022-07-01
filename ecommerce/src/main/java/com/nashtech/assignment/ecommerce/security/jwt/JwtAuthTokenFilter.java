package com.nashtech.assignment.ecommerce.security.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.aspectj.weaver.NewConstructorTypeMunger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.nashtech.assignment.ecommerce.security.serviceImpl.UserDetailServiceImpl;

@Component
public class JwtAuthTokenFilter extends OncePerRequestFilter {
	
	private final JwtUtils jwtUtils;
	
	private final UserDetailServiceImpl userDetailServiceImpl;
	
	private static final Logger logger = LoggerFactory.getLogger(JwtAuthTokenFilter.class);
	
	

	public JwtAuthTokenFilter(JwtUtils jtwUtils, UserDetailServiceImpl userDetailServiceImpl) {
		this.jwtUtils = jtwUtils;
		this.userDetailServiceImpl = userDetailServiceImpl;
	}



	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try
		{
			String jwt = parseJwt(request);
			if(jwt != null && jwtUtils.validateToken(jwt) ) 
			{
				String userName = jwtUtils.getUserNameFromToken(jwt);
				
				UserDetails userDetails = userDetailServiceImpl.loadUserByUsername(userName);
				
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			}
			
		} 
		catch (Exception e) 
		{
			logger.error("Cannot set authentication : ", e);
		}
		
		filterChain.doFilter(request, response);
		
	}
	
	
	private String parseJwt(HttpServletRequest request) {
		String headerAuth = request.getHeader("Authorization");
		
		if(StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
			return headerAuth.substring(7, headerAuth.length());
		}
		
		return null;
	}

}
