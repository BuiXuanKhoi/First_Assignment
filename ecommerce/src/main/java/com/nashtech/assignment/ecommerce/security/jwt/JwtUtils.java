package com.nashtech.assignment.ecommerce.security.jwt;

import java.util.Date;

import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction;
import org.postgresql.shaded.com.ongres.scram.common.message.ClientFinalMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.nashtech.assignment.ecommerce.exception.UnAuthorizationException;
import com.nashtech.assignment.ecommerce.security.serviceImpl.UserDetailImpl;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;


@Component
public class JwtUtils {
	
	
	private final String jwtSecretKey;
	
	private final int jwtExpiration;
	
	
	
	
	public JwtUtils(@Value("${ecommerce.app.jwtSecretKey}") final String jwtSecretKey, @Value("${ecommerce.app.jwtExpiration}") final int jwtExpiration) 
	{
		this.jwtSecretKey = jwtSecretKey;
		this.jwtExpiration = jwtExpiration;
	}

	public String generateToken(Authentication authentication) 
	{
		UserDetailImpl userPrincipal = (UserDetailImpl) authentication.getPrincipal();
		return Jwts.builder()
				.setSubject(userPrincipal.getUsername())
				.setIssuedAt(new Date())
				.setExpiration(new Date(new Date().getTime() + jwtExpiration))
				.signWith(SignatureAlgorithm.HS512, jwtSecretKey)
				.compact();
	}
	
	
	public String getUserNameFromToken(String token) {
		return Jwts.parser().setSigningKey(jwtSecretKey).parseClaimsJws(token).getBody().getSubject();
	}
	
	
	
	public boolean validateToken(String authToken) 
	{
		try {
			Jwts.parser().setSigningKey(jwtSecretKey).parseClaimsJws(authToken);
			return true;
		} 
		catch (SignatureException signature) 
		{
			throw new UnAuthorizationException("Invalid JWT Signature :" + signature.getMessage());
		}
		catch (MalformedJwtException malformException) 
		{
			throw new UnAuthorizationException("Invalid Jwt Token :"+ malformException.getMessage());
		}
		catch (ExpiredJwtException expiredException)
		{
			throw new UnAuthorizationException("JWT Token is expired :" + expiredException.getMessage());
		}
		catch (UnsupportedJwtException unsupportException) 
		{
			throw new UnAuthorizationException("JWT Token is unsupported: "+ unsupportException.getMessage());
		}
		catch (IllegalArgumentException jwtEmtyException) 
		{
			throw new UnAuthorizationException("JWT Token is Empty: "+ jwtEmtyException.getMessage());
		}
		catch (Exception e) {
			throw new UnAuthorizationException("Please Log in");
		}
	}

}
