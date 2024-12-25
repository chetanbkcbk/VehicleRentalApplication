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
import com.example.vehiclerentingapplication.enums.RentingType;
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
import com.example.vehiclerentingapplication.responsedto.PickUpResponse;
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
	public BookingResponse createBooking(BookingRequest bookingRequest, int listingId, int pickUpLocationId, int dropLocationId) {

		Location pickUpLocation = locationRepository.findById(pickUpLocationId).orElseThrow(()-> new NoSuchLocationException("no such pickup Id"));
		Location dropLocationPlace = locationRepository.findById(dropLocationId).orElseThrow(()-> new NoSuchLocationException("no such drop Id"));
		VehicleListing vehicleListing = vehicleListingRepository.findById(listingId).orElseThrow(()-> new NoVehicleListingException("no such listing Id"));

		//	Booking booking=bookingMapper.mapToBooking(bookingRequest, new Booking());
		Duration duration;
		final int MAX_UNLIMITED_DAYS = 30;
		double totalAmount;

		if(bookingRequest.getRentingType()==RentingType.LIMITED)
		{
			duration=Duration.ofDays(bookingRequest.getDurationInDays());
			totalAmount=calculateAmount(vehicleListing, bookingRequest.getDurationInDays());
		}
		else
		{
			duration=Duration.ofDays(MAX_UNLIMITED_DAYS);
			totalAmount=calculateAmount(vehicleListing, MAX_UNLIMITED_DAYS);

		}

		PickUp pickUp=new PickUp();

		//		pickUp.setDate(bookingRequest.getPickUpDate());
		//		pickUp.setTime(bookingRequest.getPickUpTime());
		//		pickUp.setLocation(pickUpLocation);

		pickUp=pickUpMapper.mapToPickUp(pickUp, bookingRequest, pickUpLocation);


		DropLocation dropLocation=new DropLocation();

		dropLocation.setDate(pickUp.getDate().plusDays(duration.toDays()));
		//		dropLocation.setTime(bookingRequest.getDropTime());   //pickUp.getTime().plusHours(duration.toHours())
		//		dropLocation.setLocation(dropLocationPlace);

		dropLocation=dropLocationMapper.mapToDrop(dropLocation, bookingRequest, dropLocationPlace);


		// Save the pickup and drop location entities
		pickUp = pickUpRepository.save(pickUp);
		dropLocation = dropRepository.save(dropLocation);

		//		
		//        booking.setPickupInfo(pickUp);
		//        booking.setDropInfo(dropLocation);
		//        booking.setDuration(duration); // Store the duration if needed
		//
		//        booking.setUser(authUtil.getCurrentUser());	
		//        booking.setVehicleListing(vehicleListing);

		Booking booking = bookingMapper.mapToBooking(bookingRequest, new Booking(), pickUp, dropLocation, duration, authUtil.getCurrentUser(), vehicleListing);
						  booking.setTotalPayableAmount(totalAmount);
		bookingRepository.save(booking);

		BookingResponse bookingResponse = bookingMapper.mapToBookingResponse(booking);

		bookingResponse.setPickup(pickUpMapper.mapToPickUpResponse(pickUp,pickUpLocation));
		bookingResponse.setDrop(dropLocationMapper.mapToDropResponse(dropLocation,dropLocationPlace));
		bookingResponse.setVehicle(vehicleListingMapper.mapToVehicleListingResponse(vehicleListing));
		bookingResponse.setDuration(booking.getDuration().toDays());
		bookingResponse.setVehicleModel(vehicleMapper.mapToVehicleResponse(vehicleListing.getVehicle()));

		return bookingResponse;
	}


	private double calculateAmount(VehicleListing vehicleListing,long days){
		return vehicleListing.getPricePerDay()  * days;
	}
	
}
