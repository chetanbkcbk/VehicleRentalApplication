package com.example.vehiclerentingapplication.responsedto;

import java.time.Duration;

import com.example.vehiclerentingapplication.enums.BookingStatus;
import com.example.vehiclerentingapplication.enums.RentingType;

public class BookingResponse {
	
	private int bookingId;
	private BookingStatus status;
	private Double totalPayableAmount;
	
	private RentingType rentingType;
	private long duration;
	
	private VehicleResponse vehicleModel;
	private VehicleListingResponse vehicle;
	
	private PickUpResponse pickup;
	
	private DropResponse drop;
	
	public BookingStatus getStatus() {
		return status;
	}
	
	public VehicleResponse getVehicleModel() {
		return vehicleModel;
	}
	public void setVehicleModel(VehicleResponse vehicleModel) {
		this.vehicleModel = vehicleModel;
	}
	public VehicleListingResponse getVehicle() {
		return vehicle;
	}
	public void setVehicle(VehicleListingResponse vehicle) {
		this.vehicle = vehicle;
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
	public long getDuration() {
		return duration;
	}
	public void setDuration(long l) {
		this.duration = l;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public PickUpResponse getPickup() {
		return pickup;
	}

	public void setPickup(PickUpResponse pickup) {
		this.pickup = pickup;
	}

	public DropResponse getDrop() {
		return drop;
	}

	public void setDrop(DropResponse drop) {
		this.drop = drop;
	}

}
