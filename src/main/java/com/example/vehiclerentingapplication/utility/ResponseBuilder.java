package com.example.vehiclerentingapplication.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseBuilder {
	
	 public <T> ResponseEntity<ResponseStructure<T>> sendResponse(HttpStatus status, String message, T data) {
	        ResponseStructure<T> responseStructure = new ResponseStructure<>();
	        responseStructure.setStatusCode(status.value());
	        responseStructure.setMessage(message);
	        responseStructure.setData(data);

	        return new ResponseEntity<>(responseStructure, status);
	    }

}
