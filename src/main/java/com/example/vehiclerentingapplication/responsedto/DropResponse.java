package com.example.vehiclerentingapplication.responsedto;

import java.time.LocalDate;
import java.time.LocalTime;

public class DropResponse {
	
	private int dropId;
	private LocalDate date;
	private LocalTime time;
	
	private LocationResponse location;
	
	
	public int getDropId() {
		return dropId;
	}
	public void setDropId(int dropId) {
		this.dropId = dropId;
	}
	public LocationResponse getLocation() {
		return location;
	}
	public void setLocation(LocationResponse location) {
		this.location = location;
	}
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
