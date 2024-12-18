package com.example.vehiclerentingapplication.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import com.example.vehiclerentingapplication.entity.Image;

public interface ImageService {


	void addUser_ProfilePicture( MultipartFile multipartFile);
	
	Image findImageById( int imageId);

	void addVehicleImages(int vehicleId, List<MultipartFile> multipartFile);

}
