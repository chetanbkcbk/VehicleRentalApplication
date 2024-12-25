package com.example.vehiclerentingapplication.requestdto;

import com.example.vehiclerentingapplication.enums.UserRole;

import jakarta.validation.constraints.Email; 
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class UserRequest {
	
	@NotNull(message = "username cannot be null")
	@NotBlank(message = "username cannot be blank")
	@Pattern(regexp = "^[a-zA-Z0-9-_]+$", message = "username can only contain alphanumeric characters, hyphens, underscores, plus signs, and dollar signs")
	private String username;
	
	@NotNull(message = "email cannot be null")
	@NotBlank(message = "email cannot be blank")
	@Email(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", 
	        message = "Invalid email format. Please enter a valid email address."
	        )
	private String email;
	
	@NotNull(message = "phonenumber cannot be null")
	@NotBlank(message = "phonenumber cannot be blank")
	private String phoneNumber;
	
	@NotNull(message ="password cannot be null" )
	@NotBlank(message = "password cannot be blank")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+={}:;\"'<>,.?/~`-])[A-Za-z\\d!@#$%^&*()_+={}:;\"'<>,.?/~`-]{8,}$", 
    message = "Password must contain at least one uppercase letter, one lowercase letter, one digit, one special character, and be at least 8 characters long.")

	private String password;
//	private UserRole role;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
//	public UserRole getRole() {
//		return role;
//	}
//	public void setRole(UserRole role) {
//		this.role = role;
//	}
	

}
