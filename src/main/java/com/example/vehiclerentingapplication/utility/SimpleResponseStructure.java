package com.example.vehiclerentingapplication.utility;

public class SimpleResponseStructure {
	
	private int statusCode;
	private String message;

	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public static SimpleResponseStructure create(int statusCode, String message) {
		 SimpleResponseStructure simpleResponseStructure = new SimpleResponseStructure();
         simpleResponseStructure.setStatusCode(statusCode);
         simpleResponseStructure.setMessage(message);
         
         return simpleResponseStructure;
	}
}
