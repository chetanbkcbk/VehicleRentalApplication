package com.example.vehiclerentingapplication.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.vehiclerentingapplication.requestdto.LocationRequest;
import com.example.vehiclerentingapplication.responsedto.LocationResponse;
import com.example.vehiclerentingapplication.service.LocationService;
import com.example.vehiclerentingapplication.utility.ResponseStructure;
import com.example.vehiclerentingapplication.utility.RestResponseBuilder;

@RestController
public class LocationController {

	private final LocationService locationService;
	private final RestResponseBuilder responseBuilder;

	
	

	public LocationController(LocationService locationService, RestResponseBuilder responseBuilder) {
		super();
		this.locationService = locationService;
		this.responseBuilder = responseBuilder;
	}




	@PostMapping("/add-location")
	@PreAuthorize("hasAuthority('RENTING_PARTNER')") 
	public ResponseEntity<ResponseStructure<LocationResponse>> addLocation(@RequestBody LocationRequest locationRequest)
	{
		LocationResponse locationResponse=locationService.addLocation(locationRequest);
		return responseBuilder.success(HttpStatus.CREATED, "Location Added successfully", locationResponse);

	}
	
	@GetMapping("/locations")
	public ResponseEntity<ResponseStructure<List<LocationResponse>>> findAllLocationsByListingId(@RequestParam int listingId)
	{
	List<LocationResponse> locationResponses=locationService.findAllLocationsByListingId(listingId);
	return responseBuilder.success(HttpStatus.FOUND, "Locations based on listig id found", locationResponses);
	}
	
	
}
