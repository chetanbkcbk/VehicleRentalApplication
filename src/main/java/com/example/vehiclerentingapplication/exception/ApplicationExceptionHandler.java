package com.example.vehiclerentingapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.vehiclerentingapplication.utility.ErrorStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> handleUserNotFoundById(UserNotFoundByIdException ex) {
		
		ErrorStructure<String > errorStructure=new ErrorStructure<String>();
		errorStructure.setStatuscode(HttpStatus.NOT_FOUND.value());
		errorStructure.setMessage(ex.getMessage());
		errorStructure.setData("User requested userid not present in the database");
		
		return new ResponseEntity<ErrorStructure<String>>(errorStructure,HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> handleFailedToUploadImage(FailedToUploadImageException ex) {
		
		ErrorStructure<String > errorStructure=new ErrorStructure<String>();
		errorStructure.setStatuscode(HttpStatus.BAD_REQUEST.value());
		errorStructure.setMessage(ex.getMessage());
		errorStructure.setData("Failed to upload that particular image into the database");
		
		return new ResponseEntity<ErrorStructure<String>>(errorStructure,HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> handleImageNotFound(ImageNotFoundException ex) {
		
		ErrorStructure<String > errorStructure=new ErrorStructure<String>();
		errorStructure.setStatuscode(HttpStatus.NOT_FOUND.value());
		errorStructure.setMessage(ex.getMessage());
		errorStructure.setData("No image with such image id present in the database");
		
		return new ResponseEntity<ErrorStructure<String>>(errorStructure,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> handleVehicleNotFound(VehicleNotFoundException ex) {
		
		ErrorStructure<String > errorStructure=new ErrorStructure<String>();
		errorStructure.setStatuscode(HttpStatus.NOT_FOUND.value());
		errorStructure.setMessage(ex.getMessage());
		errorStructure.setData("No Vehicle with such vehicle id present in the database");
		
		return new ResponseEntity<ErrorStructure<String>>(errorStructure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> handleUsernameNotFound(UsernameNotFoundException ex) {
		
		ErrorStructure<String > errorStructure=new ErrorStructure<String>();
		errorStructure.setStatuscode(HttpStatus.NOT_FOUND.value());
		errorStructure.setMessage(ex.getMessage());
		errorStructure.setData("No such user email present in the database");
		
		return new ResponseEntity<ErrorStructure<String>>(errorStructure,HttpStatus.NOT_FOUND);
	}
	
	
}
