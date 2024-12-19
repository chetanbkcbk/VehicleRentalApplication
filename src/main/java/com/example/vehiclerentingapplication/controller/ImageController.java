package com.example.vehiclerentingapplication.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.vehiclerentingapplication.entity.Image;
import com.example.vehiclerentingapplication.service.ImageService;
import com.example.vehiclerentingapplication.utility.RestResponseBuilder;
import com.example.vehiclerentingapplication.utility.SimpleResponseStructure;

@RestController
public class ImageController {

	private final ImageService imageService;
	
	private final RestResponseBuilder responseBuilder;
	

	public ImageController(ImageService imageService,RestResponseBuilder responseBuilder) {
		super();
		this.imageService = imageService;
		this.responseBuilder=responseBuilder;
	}
	
	@PostMapping("/users/images")
	public ResponseEntity<SimpleResponseStructure> addUser_ProfilePicture(MultipartFile multipartFile)
	{
		imageService.addUser_ProfilePicture(multipartFile);
		return responseBuilder.success(HttpStatus.OK, "User profile picture updated");
	}
	
	@GetMapping("/images/{imageId}")
	public ResponseEntity<byte[]> findImageById(@PathVariable int imageId){
		Image image=imageService.findImageById(imageId);
		 byte[] imageBytes = image.getImageBytes(); 
		    return ResponseEntity.ok()
		            .contentType(MediaType.valueOf(image.getContentType()))
		            .body(imageBytes);
		} 
	
	@PostMapping("/vehicles/{vehicleId}/images")
	@PreAuthorize("hasAuthority('ADMIN')") 
	public ResponseEntity<SimpleResponseStructure> addVehicleImages(@PathVariable int vehicleId,List<MultipartFile> multipartFiles)
	{
		imageService.addVehicleImages(vehicleId,multipartFiles);
		return responseBuilder.success(HttpStatus.OK, "VehicleImages added");
	}
	
	
	}
	

