package com.example.vehiclerentingapplication.requestdto;


import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

import com.example.vehiclerentingapplication.enums.BookingStatus;
import com.example.vehiclerentingapplication.enums.RentingType;

public class BookingRequest {
	
	private BookingStatus status;
	private Double totalPayableAmount;
	private RentingType rentingType;
	private long durationInDays;
	
	private LocalDate pickUpDate;
	private LocalTime pickUpTime;
	
	private LocalTime dropTime;
	
	public LocalDate getPickUpDate() {
		return pickUpDate;
	}
	public void setPickUpDate(LocalDate pickUpDate) {
		this.pickUpDate = pickUpDate;
	}
	public LocalTime getPickUpTime() {
		return pickUpTime;
	}
	public void setPickUpTime(LocalTime pickUpTime) {
		this.pickUpTime = pickUpTime;
	}
	
	public LocalTime getDropTime() {
		return dropTime;
	}
	public void setDropTime(LocalTime dropTime) {
		this.dropTime = dropTime;
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
	public long getDurationInDays() {
		return durationInDays;
	}
	public void setDurationInDays(long durationInDays) {
		this.durationInDays = durationInDays;
	}
	
}
