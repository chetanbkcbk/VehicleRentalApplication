package com.example.vehiclerentingapplication.service;

import org.springframework.web.multipart.MultipartFile;

import com.example.vehiclerentingapplication.entity.User;

public interface UserService {

	User register(User user);

	void addUser_ProfilePicture(int userId, MultipartFile multipartFile);

}
