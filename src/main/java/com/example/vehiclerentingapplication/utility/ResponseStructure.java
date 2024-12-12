package com.example.vehiclerentingapplication.utility;

public class ResponseStructure<T> {

	private int statusCode;
	private String message;
	private T data;
	
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
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	public static <T> ResponseStructure<T> create(int statusCode, String message, T data) {
        ResponseStructure<T> responseStructure = new ResponseStructure<>();
        responseStructure.setStatusCode(statusCode);
        responseStructure.setMessage(message);
        responseStructure.setData(data);
        
        return responseStructure;
	}
	
}
