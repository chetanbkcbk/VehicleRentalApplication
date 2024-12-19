package com.example.vehiclerentingapplication.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.vehiclerentingapplication.requestdto.UserRequest;
import com.example.vehiclerentingapplication.requestdto.VehicleRequest;
import com.example.vehiclerentingapplication.responsedto.UserResponse;
import com.example.vehiclerentingapplication.responsedto.VehicleResponse;
import com.example.vehiclerentingapplication.service.VehicleService;
import com.example.vehiclerentingapplication.utility.ResponseStructure;
import com.example.vehiclerentingapplication.utility.RestResponseBuilder;

@RestController
public class VehicleController {

	private final VehicleService vehicleService;
	private final RestResponseBuilder responseBuilder;

	public VehicleController(VehicleService vehicleService,RestResponseBuilder responseBuilder) {
		super();
		this.vehicleService = vehicleService;
		this.responseBuilder = responseBuilder;

	}

	@PostMapping("/add-vehicles")
	@PreAuthorize("hasAuthority('ADMIN')")    //which endpoint are u trying to protect for the ADMIN
public ResponseEntity<ResponseStructure<VehicleResponse>>	addVehicle(@RequestBody VehicleRequest vehicleRequest)
{
		VehicleResponse vehicleResponse= vehicleService.addVehicle(vehicleRequest);

		return responseBuilder.success(HttpStatus.CREATED, "Vehicle Added successfully", vehicleResponse);
}
	
	
	@GetMapping("/vehicles")
	public ResponseEntity<ResponseStructure<List<VehicleResponse>>>	findAllVehicles()
	{
		List<VehicleResponse >vehicleResponse= vehicleService.findAllVehicles();

			return responseBuilder.success(HttpStatus.FOUND, "Vehicles Found successfully", vehicleResponse);
	}	
	
	@PutMapping("/vehicles/{vehicleId}")
	@PreAuthorize("hasAuthority('ADMIN')") 
	public ResponseEntity<ResponseStructure<VehicleResponse>> updateVehicleById(@RequestBody VehicleRequest vehicleRequest,@PathVariable int vehicleId){
		
	VehicleResponse vehicleResponse=vehicleService.updateVehicleById(vehicleRequest,vehicleId);
		return responseBuilder.success(HttpStatus.OK, "Vehicle Updated ",vehicleResponse);
	}

	
	
}
