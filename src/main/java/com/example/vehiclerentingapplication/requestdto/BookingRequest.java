package com.example.vehiclerentingapplication.requestdto;

import java.time.Duration;

import com.example.vehiclerentingapplication.enums.BookingStatus;
import com.example.vehiclerentingapplication.enums.RentingType;

public class BookingRequest {
	
	private BookingStatus status;
	private Double totalPayableAmount;
	private RentingType rentingType;
	private Duration duration;
	
	
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

}
