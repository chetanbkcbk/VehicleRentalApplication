package com.example.vehiclerentingapplication.responsedto;

import java.time.LocalDate;
import java.time.LocalTime;

public class DropResponse {
	
	private int dropId;
	private LocalDate date;
	private LocalTime time;
	
	public int getPickupId() {
		return dropId;
	}
	public void setPickupId(int dropId) {
		this.dropId = dropId;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	
}