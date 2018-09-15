package com.example.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.bean.Trip;


@Component("tripValidator")
public class TripValidator implements Validator {

	/*
	 * https://www.baeldung.com/spring-data-rest-validators
	 */
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Trip.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Trip trip = (Trip)obj;
		
		if (checkInputString(trip.getPickUp())) {
            errors.rejectValue("name", "name.empty");
        }
		
		
		// TODO Auto-generated method stub
		
	}
	
	 private boolean checkInputString(String input) {
		 // to modify with string utils.
	        return (input == null || input.trim().length() == 0);
	    }

}
