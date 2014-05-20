package org.groept.cloudMigration.frontend.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.groept.cloudMigration.model.Capability;
import org.groept.cloudMigration.model.Court;
import org.groept.cloudMigration.model.Hall;
import org.groept.cloudMigration.service.impl.FrontendService;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	@Autowired
	private FrontendService frontendService;
	
	
	//===================================================================================
	//===================================================================================
	//in /getCapabilities  GET ----> none variables calculated
	//in /getCapabilities  POST ----> _capability,_allCourtsThisCap
	//in /getDate POST  ----> dateSelected, _timeIntervals, _reservations
	//in /getTimeIntervals GET--->  _startTimeSetAvailable
	//in /getTimeIntervals POST--->  _startTimeRecieved
	//in /getHalls GET ---> _hallsAvailable
	//in /getHalls POST ---> _nameOfHallRecieved
	//in /getCourts GET ---> _courtsAvailable
	//in /getCourts POST ---> _nameOfCourtRecieved
	//in /getUserInfo  POST---> _subscriber
	//===================================================================================
	//===================================================================================
	

	@RequestMapping(value = "/getCapabilities", method = RequestMethod.GET)
	public @ResponseBody
	List<Capability> getCapabilities() {

		return frontendService.getCapabilities();
				
	}

	
	@RequestMapping(value = "/getCapabilities", method = RequestMethod.POST)
	public @ResponseBody
	void getCapabilitySelected(@RequestBody String capability) {

		System.out.println("inside //getCapabilities  POST");
		System.out.println("Capability recieved: "+capability);
		
		frontendService.getCapabilitySelected(capability);
		
		
		
	}
	

	
	
	@RequestMapping(value="/getDate", method=RequestMethod.POST)
	public @ResponseBody void getDateSelected(@RequestBody String dateRecieved)
	{		

		System.out.println("inside /getDate  POST");
		System.out.println("Date recieved: "+dateRecieved);
		
		frontendService.getDateSelected(dateRecieved);
		
	}
	



	@RequestMapping(value = "/getTimeIntervals", method = RequestMethod.GET)
	public @ResponseBody
	List<Integer> getTimeIntervals() {
		
		return frontendService.getTimeIntervals();
		
	}

	
	
	
	@RequestMapping(value = "/getTimeIntervals", method = RequestMethod.POST)
	public @ResponseBody
	void getTimeIntervalSelected(@RequestBody String interval) {
		
		frontendService.getTimeIntervalSelected(interval);
		
	}

	
	@RequestMapping(value = "/getHalls", method = RequestMethod.GET)
	public @ResponseBody
	Set<Hall> getHallAvailables() {
		
		return frontendService.getHallAvailables();
	}
	
	
	@RequestMapping(value = "/getHalls", method = RequestMethod.POST)
	public @ResponseBody
	void getHallSelected(@RequestBody String hall) {

		frontendService.getHallSelected(hall);
	}
	


	@RequestMapping(value = "/getCourts", method = RequestMethod.GET)
	public @ResponseBody
	Set<Court> getCourts() {

		return frontendService.getCourts();
	}
	
	@RequestMapping(value = "/getCourts", method = RequestMethod.POST)
	public @ResponseBody
	void getCourtSelected(@RequestBody String court) {
		frontendService.getCourtSelected(court);
		
	}
	
	
	@RequestMapping(value="/getUserInfo", method=RequestMethod.POST)
	public @ResponseBody void getUserInfo(@RequestBody String user)
	{				
		frontendService.getUserInfo(user);
		
	}


	@RequestMapping(value="/getHall1ReservationInfo", method=RequestMethod.GET)
	public @ResponseBody List<Integer> getHall1ReservationInfo()
	{
		return frontendService.getHall1ReservationInfo();
	}


	
}
