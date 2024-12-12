package com.example.vehiclerentingapplication.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import com.example.vehiclerentingapplication.entity.Image;

public interface ImageService {


	void addUser_ProfilePicture(int userId, MultipartFile multipartFile);
	
	Image findImageById( int imageId);

}
