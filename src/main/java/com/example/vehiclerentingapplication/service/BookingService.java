package com.example.vehiclerentingapplication.service;

import com.example.vehiclerentingapplication.requestdto.BookingRequest;
import com.example.vehiclerentingapplication.responsedto.BookingResponse;

public interface BookingService {

	BookingResponse createBooking(BookingRequest bookingRequest, int listingId, int pickUpLocationId, int dropLocationId);

}
