package com.example.vehiclerentingapplication.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.vehiclerentingapplication.requestdto.VehicleListingRequest;
import com.example.vehiclerentingapplication.responsedto.VehicleListingResponse;
import com.example.vehiclerentingapplication.responsedto.VehicleResponse;
import com.example.vehiclerentingapplication.service.VehicleListingService;
import com.example.vehiclerentingapplication.utility.ResponseStructure;
import com.example.vehiclerentingapplication.utility.RestResponseBuilder;

@RestController
public class VehicleListingController {
	private final VehicleListingService vehicleListingService ;
	
	private final RestResponseBuilder responseBuilder;

	
	
	public VehicleListingController(VehicleListingService vehicleListingService, RestResponseBuilder responseBuilder) {
		super();
		this.vehicleListingService = vehicleListingService;
		this.responseBuilder = responseBuilder;
	}



	@PostMapping("/insert-vehiclelisting")
	@PreAuthorize("hasAuthority('RENTING_PARTNER')")
	public ResponseEntity<ResponseStructure<VehicleListingResponse>> insertVehicleListing(@RequestParam int vehicleId,@RequestBody VehicleListingRequest vehicleListingRequest) {
			VehicleListingResponse vehicleListingResponse=vehicleListingService.insertVehicleListing(vehicleId,vehicleListingRequest);
		return responseBuilder.success(HttpStatus.CREATED, "VehicleListing Created Successfully", vehicleListingResponse);
	}
}

	

