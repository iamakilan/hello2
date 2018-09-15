package com.example.controller;

import java.util.Collections;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.bean.Test;
import com.example.bean.Trip;
import com.example.service.TestService;
import com.example.service.TripService;

@Controller
@RequestMapping("/")
public class TransportController {
	// static Logger logger = Logger.getLogger(TransportController.class);
	
//	@Autowired
//	private TripService tripService;
	
	@Autowired
	private TestService testService;
	
	@GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Map test() {
		// logger.info("Test method called");
		return Collections.singletonMap("response", "Hello World");
	}

	@GetMapping(value = "/testParam", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Map testParam(@RequestParam String message) {
		// logger.info("Test method called");
		System.out.println("the param is : " + message);
		return Collections.singletonMap("response", "Hello World");
	}

//	@ResponseStatus(code = HttpStatus.OK)
//	@PostMapping(value = "/trip", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public @ResponseBody String createTrip(@RequestBody @Valid Trip trip) {
//
//		System.out.println("Out put : " + trip.getPassengerId());
//		System.out.println("Out put : " + trip.getDropOff());
//		
//		String createdTripId = tripService.tripService();
//		return "{\"tripId\":\"" + createdTripId +"\"}";
//	}

	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(value = "/testtrip", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String testcreateTrip(@RequestBody Test test) {

		System.out.println("The test methos called : " + test.getName());
		testService.addTest(test);
		
		return "{\"response\":\"success\"}";
	}

}
