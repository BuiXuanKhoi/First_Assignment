package com.nashtech.assignment.ecommerce.exceptions.handler;

import java.net.http.HttpHeaders;
import java.util.HashMap;
import java.util.Map;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException.Unauthorized;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.nashtech.assignment.ecommerce.DTO.respond.ErrorResponse;
import com.nashtech.assignment.ecommerce.exception.ApiDeniedException;
import com.nashtech.assignment.ecommerce.exception.ResourceAlreadyExistException;
import com.nashtech.assignment.ecommerce.exception.ResourceNotFoundException;
import com.nashtech.assignment.ecommerce.exception.UnAuthorizationException;

import aj.org.objectweb.asm.Handle;
import net.bytebuddy.asm.Advice.Return;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class GlobalExceptionsHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler({ResourceNotFoundException.class})
	protected ResponseEntity<ErrorResponse> handleNotFoundException( ResourceNotFoundException rsnf){
		
		int statusCode = HttpStatus.NOT_FOUND.value();
		String message = rsnf.getMessage();
		
		ErrorResponse errorResponse = new ErrorResponse(statusCode, message); 
		
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler({IllegalArgumentException.class})
	protected ResponseEntity<ErrorResponse> handleWrongArgumentException( IllegalArgumentException ilex){
		
		int statusCode = HttpStatus.BAD_REQUEST.value();
		String message = ilex.getMessage();
		
		ErrorResponse errorResponse = new ErrorResponse(statusCode, message);
		
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	

	
	@ExceptionHandler({AccessDeniedException.class})
	protected ResponseEntity<ErrorResponse> handleApiDeniedException(AccessDeniedException apiDeniedException){
		int statusCode = HttpStatus.FORBIDDEN.value();
		
		String message = "You dont have enough permission to access this api";
		
		ErrorResponse errorResponse = new ErrorResponse(statusCode, message);
		
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.FORBIDDEN);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			org.springframework.http.HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();

			errors.put(fieldName, errorMessage);
		});
		ErrorResponse error = new ErrorResponse(400, "Validation Error", errors);
		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler({UnAuthorizationException.class})
	protected ResponseEntity<ErrorResponse> handleUnauthorizedException(UnAuthorizationException unath){
		String message = "Please log in";
		int statusCode = HttpStatus.UNAUTHORIZED.value();
		
		ErrorResponse errorResponse = new ErrorResponse(statusCode, message);
		
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.UNAUTHORIZED);
	}



	
	
	



	
	


}
