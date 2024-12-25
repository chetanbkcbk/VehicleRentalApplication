package com.example.vehiclerentingapplication.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.boot.autoconfigure.graphql.GraphQlProperties.Schema.Inspection;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class PickUp {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pickupId;
	private LocalDate date;
	private LocalTime time;
	
	@ManyToOne
	private Location location;
	//private Inspection inspection;

	public int getPickupId() {
		return pickupId;
	}

	public void setPickupId(int pickupId) {
		this.pickupId = pickupId;
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

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}
