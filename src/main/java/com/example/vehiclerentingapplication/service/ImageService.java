package com.example.vehiclerentingapplication.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {


	void addUser_ProfilePicture(int userId, MultipartFile multipartFile);

}
