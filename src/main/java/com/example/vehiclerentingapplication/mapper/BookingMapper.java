package com.example.vehiclerentingapplication.mapper;

import org.springframework.stereotype.Component;

import com.example.vehiclerentingapplication.entity.Booking;
import com.example.vehiclerentingapplication.requestdto.BookingRequest;
import com.example.vehiclerentingapplication.responsedto.BookingResponse;


@Component
public class BookingMapper {

	
public Booking mapToBooking(BookingRequest request, Booking booking) {
		
		booking.setStatus(request.getStatus());
		booking.setTotalPayableAmount(request.getTotalPayableAmount());
		booking.setRentingType(request.getRentingType());
		//booking.setDuration(request.getDuration());
	
		return booking;	
		
	}
	
	
	public BookingResponse mapToBookingResponse(Booking booking) {
		
		BookingResponse bookingResponse=new BookingResponse();
		bookingResponse.setBookingId(booking.getBookingId());
		bookingResponse.setStatus(booking.getStatus());
		bookingResponse.setTotalPayableAmount(booking.getTotalPayableAmount());
		bookingResponse.setRentingType(booking.getRentingType());
		bookingResponse.setDuration(booking.getDuration());
		

		
		return bookingResponse;
		
	}
	
	
	
}
