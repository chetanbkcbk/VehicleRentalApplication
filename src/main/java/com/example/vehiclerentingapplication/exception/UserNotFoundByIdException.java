package com.example.vehiclerentingapplication.exception;

public class UserNotFoundByIdException extends RuntimeException{

	public UserNotFoundByIdException(String message) {
		super(message);
	}
	
}
