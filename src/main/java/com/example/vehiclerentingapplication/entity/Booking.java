package com.example.vehiclerentingapplication.entity;

import java.time.Duration;

import com.example.vehiclerentingapplication.enums.BookingStatus;
import com.example.vehiclerentingapplication.enums.RentingType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;


@Entity
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;
	
	@Enumerated(EnumType.STRING) 	
	private BookingStatus status;
	private Double totalPayableAmount;
	
	@Enumerated(EnumType.STRING) 
	private RentingType rentingType;
	private Duration duration;
	
	
	@ManyToOne
	private VehicleListing vehicleListing;
	
	@ManyToOne
	private User user;
	
	
	@OneToOne
	private PickUp pickupInfo;
	
	@OneToOne
	private DropLocation dropInfo;
	
	public PickUp getPickupInfo() {
		return pickupInfo;
	}

	public void setPickupInfo(PickUp pickupInfo) {
		this.pickupInfo = pickupInfo;
	}

	public DropLocation getDropInfo() {
		return dropInfo;
	}

	public void setDropInfo(DropLocation dropInfo) {
		this.dropInfo = dropInfo;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public BookingStatus getStatus() {
		return status;
	}

	public void setStatus(BookingStatus status) {
		this.status = status;
	}

	public Double getTotalPayableAmount() {
		return totalPayableAmount;
	}

	public void setTotalPayableAmount(Double totalPayableAmount) {
		this.totalPayableAmount = totalPayableAmount;
	}

	public RentingType getRentingType() {
		return rentingType;
	}

	public void setRentingType(RentingType rentingType) {
		this.rentingType = rentingType;
	}

	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}

	public VehicleListing getVehicleListing() {
		return vehicleListing;
	}

	public void setVehicleListing(VehicleListing vehicleListing) {
		this.vehicleListing = vehicleListing;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
