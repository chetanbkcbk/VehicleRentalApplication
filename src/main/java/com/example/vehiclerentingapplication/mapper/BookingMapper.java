package com.example.vehiclerentingapplication.mapper;

import java.time.Duration;

import org.springframework.stereotype.Component;

import com.example.vehiclerentingapplication.entity.Booking;
import com.example.vehiclerentingapplication.entity.DropLocation;
import com.example.vehiclerentingapplication.entity.PickUp;
import com.example.vehiclerentingapplication.entity.User;
import com.example.vehiclerentingapplication.entity.VehicleListing;
import com.example.vehiclerentingapplication.requestdto.BookingRequest;
import com.example.vehiclerentingapplication.responsedto.BookingResponse;


@Component
public class BookingMapper {

	
public Booking mapToBooking(BookingRequest request, Booking booking,PickUp pickUpInfo,DropLocation dropInfo,Duration duration,User user,VehicleListing vehicleListing) {
		
		booking.setStatus(request.getStatus());
		booking.setTotalPayableAmount(request.getTotalPayableAmount());
		booking.setRentingType(request.getRentingType());
		booking.setDuration(duration);
		booking.setPickupInfo(pickUpInfo);
		booking.setDropInfo(dropInfo);
		booking.setUser(user);
		booking.setVehicleListing(vehicleListing);
		
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
