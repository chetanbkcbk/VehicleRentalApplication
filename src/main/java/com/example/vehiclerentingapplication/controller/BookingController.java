package com.example.vehiclerentingapplication.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.vehiclerentingapplication.requestdto.BookingRequest;
import com.example.vehiclerentingapplication.responsedto.BookingResponse;
import com.example.vehiclerentingapplication.service.BookingService;
import com.example.vehiclerentingapplication.utility.ResponseStructure;
import com.example.vehiclerentingapplication.utility.RestResponseBuilder;

@RestController
public class BookingController {

	
	private final BookingService bookingService;
	private final RestResponseBuilder responseBuilder;

	
	
	public BookingController(BookingService bookingService, RestResponseBuilder responseBuilder) {
		super();
		this.bookingService = bookingService;
		this.responseBuilder = responseBuilder;
	}



	@PostMapping("/bookings")
	public ResponseEntity<ResponseStructure<BookingResponse>> createBooking(@RequestBody BookingRequest bookingRequest,@RequestParam int listingId,@RequestParam int pickUpLocationId,@RequestParam int dropLocationId)
	
	{
		BookingResponse bookingResponse=bookingService.createBooking(bookingRequest,listingId,pickUpLocationId,dropLocationId);
		return responseBuilder.success(HttpStatus.CREATED, "booking created successfully", bookingResponse);

	}
	
}
	
	

