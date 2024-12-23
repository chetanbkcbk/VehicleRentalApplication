package com.example.vehiclerentingapplication.serviceimpl;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

import org.springframework.stereotype.Service;

import com.example.vehiclerentingapplication.entity.Booking;
import com.example.vehiclerentingapplication.entity.DropLocation;
import com.example.vehiclerentingapplication.entity.Location;
import com.example.vehiclerentingapplication.entity.PickUp;
import com.example.vehiclerentingapplication.entity.VehicleListing;
import com.example.vehiclerentingapplication.exception.NoSuchLocationException;
import com.example.vehiclerentingapplication.exception.NoVehicleListingException;
import com.example.vehiclerentingapplication.mapper.BookingMapper;
import com.example.vehiclerentingapplication.mapper.DropLocationMapper;
import com.example.vehiclerentingapplication.mapper.PickUpMapper;
import com.example.vehiclerentingapplication.mapper.VehicleListingMapper;
import com.example.vehiclerentingapplication.mapper.VehicleMapper;
import com.example.vehiclerentingapplication.repository.BookingRepository;
import com.example.vehiclerentingapplication.repository.DropRepository;
import com.example.vehiclerentingapplication.repository.LocationRepository;
import com.example.vehiclerentingapplication.repository.PickUpRepository;
import com.example.vehiclerentingapplication.repository.VehicleListingRepository;
import com.example.vehiclerentingapplication.requestdto.BookingRequest;
import com.example.vehiclerentingapplication.responsedto.BookingResponse;
import com.example.vehiclerentingapplication.security.AuthUtil;
import com.example.vehiclerentingapplication.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService{

	private final BookingRepository bookingRepository;
	
	private final BookingMapper bookingMapper;
	
	private final AuthUtil authUtil;
	
	private final VehicleListingRepository vehicleListingRepository;
	
	private final LocationRepository locationRepository;
	
	private final PickUpRepository pickUpRepository;
	
	private final DropRepository dropRepository;
	
	private final PickUpMapper pickUpMapper;
	
	private final DropLocationMapper dropLocationMapper;
	
	private final VehicleListingMapper vehicleListingMapper;
	
	private final VehicleMapper vehicleMapper;

	
	public BookingServiceImpl(BookingRepository bookingRepository, BookingMapper bookingMapper, AuthUtil authUtil,
			VehicleListingRepository vehicleListingRepository, LocationRepository locationRepository,
			PickUpRepository pickUpRepository, DropRepository dropRepository, PickUpMapper pickUpMapper,
			DropLocationMapper dropLocationMapper, VehicleListingMapper vehicleListingMapper,
			VehicleMapper vehicleMapper) {
		super();
		this.bookingRepository = bookingRepository;
		this.bookingMapper = bookingMapper;
		this.authUtil = authUtil;
		this.vehicleListingRepository = vehicleListingRepository;
		this.locationRepository = locationRepository;
		this.pickUpRepository = pickUpRepository;
		this.dropRepository = dropRepository;
		this.pickUpMapper = pickUpMapper;
		this.dropLocationMapper = dropLocationMapper;
		this.vehicleListingMapper = vehicleListingMapper;
		this.vehicleMapper = vehicleMapper;
	}



	@Override
	public void createBooking(BookingRequest bookingRequest, int listingId, int pickUpLocationId, int dropLocationId) {

		Location pickUpLocation = locationRepository.findById(pickUpLocationId).orElseThrow(()-> new NoSuchLocationException("no such pickup Id"));
		Location dropLocationPlace = locationRepository.findById(dropLocationId).orElseThrow(()-> new NoSuchLocationException("no such drop Id"));
		VehicleListing vehicleListing = vehicleListingRepository.findById(listingId).orElseThrow(()-> new NoVehicleListingException("no such listing Id"));
		
		Booking booking=bookingMapper.mapToBooking(bookingRequest, new Booking());
		
		Duration duration;
        try {
            duration = Duration.parse(bookingRequest.getDuration());
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid duration format. Please use ISO 8601 format (e.g., P2D).");
        }

		
		PickUp pickUp=new PickUp();
		
		pickUp.setDate(LocalDate.now());
		pickUp.setTime(LocalTime.now());
		pickUp.setLocation(pickUpLocation);
		
		
		DropLocation dropLocation=new DropLocation();
		
		dropLocation.setDate(pickUp.getDate().plusDays(duration.toDays()));
		dropLocation.setTime(LocalTime.now());
		dropLocation.setLocation(dropLocationPlace);
		
		
		  // Save the pickup and drop location entities
        pickUp = pickUpRepository.save(pickUp);
        dropLocation = dropRepository.save(dropLocation);

		
        booking.setPickupInfo(pickUp);
        booking.setDropInfo(dropLocation);
        booking.setDuration(bookingRequest.getDuration()); // Store the duration if needed

        booking.setUser(authUtil.getCurrentUser());	
        booking.setVehicleListing(vehicleListing);
		
		
         bookingRepository.save(booking);
         
         BookingResponse bookingResponse = bookingMapper.mapToBookingResponse(booking);
         bookingResponse.setPickup(pickUpMapper.mapToPickUpResponse(pickUp));
         bookingResponse.setDrop(dropLocationMapper.mapToDropResponse(dropLocation));
         bookingResponse.setVehicle(vehicleListingMapper.mapToVehicleListingResponse(vehicleListing));
        
         bookingResponse.setVehicleModel(vehicleMapper.mapToVehicleResponse(vehicleListing.getVehicle()));
        
	}

}
