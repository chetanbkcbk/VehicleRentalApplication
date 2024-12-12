package com.example.vehiclerentingapplication.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class RestResponseBuilder {
	
	 public <T> ResponseEntity<ResponseStructure<T>> success(HttpStatus status, String message, T data) {
		 	return ResponseEntity
		 			.status(status)
		 			.body(ResponseStructure.create(status.value(), message, data));
	    }
	 
	 
	 public <T> ResponseEntity<SimpleResponseStructure> success(HttpStatus status, String message) {
	        return ResponseEntity
	        		.status(status)
	        		.body(SimpleResponseStructure.create(status.value(), message));
	    }
}
