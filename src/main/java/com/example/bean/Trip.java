package com.example.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "TRIP")
public class Trip {
	@JsonIgnore
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int passengerId;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String pickUp;
	
	private String dropOff;

	public int getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	public String getPickUp() {
		return pickUp;
	}

	public void setPickUp(String pickUp) {
		this.pickUp = pickUp;
	}

	public String getDropOff() {
		return dropOff;
	}

	public void setDropOff(String dropOff) {
		this.dropOff = dropOff;
	}

}
