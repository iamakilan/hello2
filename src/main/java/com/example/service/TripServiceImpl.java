package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bean.Trip;
import com.example.dao.TripDAO;

@Service("tripService")
public class TripServiceImpl  implements TripService{
	
	@Autowired
	private TripDAO tripDAO;

	public String tripService() {
		return tripDAO.dbAccess();
	}

	@Override
	@Transactional
	public void addTrip(Trip trip) {
		this.tripDAO.addTrip(trip);
		
	}
	
	
}
