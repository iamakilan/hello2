package com.example.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bean.Trip;

@Service("tripDAO")
public class TripDAOImpl implements TripDAO {

	@Autowired
	private SessionFactory sessionFactory;

//	public void setSessionFactory(SessionFactory sf) {
//		this.sessionFactory = sf;
//	}

	@Override
	public String dbAccess() {

		return "Saved in DB";
	}

	@Override
	public void addTrip(Trip trip) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(trip);

	}

}
