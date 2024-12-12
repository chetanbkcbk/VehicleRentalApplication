package com.example.vehiclerentingapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.vehiclerentingapplication.utility.ErrorStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure> handleUserNotFoundById(UserNotFoundByIdException ex) {
		
		ErrorStructure<String > errorStructure=new ErrorStructure<String>();
		errorStructure.setStatuscode(HttpStatus.NOT_FOUND.value());
		errorStructure.setMessage(ex.getMessage());
		errorStructure.setData("User requested userid not present in the database");
		
		return new ResponseEntity<ErrorStructure>(errorStructure,HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<ErrorStructure> handleFailedToUploadImage(FailedToUploadImageException ex) {
		
		ErrorStructure<String > errorStructure=new ErrorStructure<String>();
		errorStructure.setStatuscode(HttpStatus.BAD_REQUEST.value());
		errorStructure.setMessage(ex.getMessage());
		errorStructure.setData("Failed to upload that particular image into the database");
		
		return new ResponseEntity<ErrorStructure>(errorStructure,HttpStatus.BAD_REQUEST);
	}

}
