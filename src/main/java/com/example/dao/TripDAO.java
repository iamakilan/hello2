package com.example.dao;

import java.util.List;

import com.example.bean.Trip;

public interface TripDAO {

	public String dbAccess();
	
	public void addTrip(Trip trip);
//	public void updateTrip(Trip trip);
//	public List<Trip> listPersons();
//	public Trip getPersonById(int id);
//	public void removePerson(int id);
	
	//https://www.journaldev.com/3531/spring-mvc-hibernate-mysql-integration-crud-example-tutorial
}
