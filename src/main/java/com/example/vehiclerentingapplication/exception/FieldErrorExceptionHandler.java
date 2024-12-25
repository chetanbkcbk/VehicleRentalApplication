package com.example.vehiclerentingapplication.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.vehiclerentingapplication.utility.ErrorStructure;

@RestControllerAdvice
public class FieldErrorExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<ErrorStructure<List<Map<String, Object>>>> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
		
	List<Map<String, Object>> ers = ex.getAllErrors().stream()
			  .map(er-> (FieldError)er )
			  .map(er-> 
					  	{
				Map<String,Object> error = new HashMap<String,Object>() ; 
				error.put("field", er.getField());
				error.put("rejectedValue", er.getRejectedValue());
				error.put("defaultMessage", er.getDefaultMessage());
				return error;
				
					  	}).toList();
					  	
		
	 ErrorStructure<List<Map<String, Object>>> errorStructure = new ErrorStructure<>();
	    errorStructure.setStatuscode(HttpStatus.BAD_REQUEST.value());
	    errorStructure.setMessage("Validation failed");
	    errorStructure.setData(ers);

	    // Return the ResponseEntity with the ErrorStructure
	    return new ResponseEntity<ErrorStructure<List<Map<String, Object>>>>(errorStructure, HttpStatus.BAD_REQUEST);
	}		
	}

	

