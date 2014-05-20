package org.groept.cloudMigration.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.bson.types.ObjectId;
import org.groept.cloudMigration.model.CacheRecord;
import org.groept.cloudMigration.model.Court;
import org.groept.cloudMigration.model.Hall;
import org.groept.cloudMigration.model.Reservation;
import org.groept.cloudMigration.model.TimeInterval;
import org.groept.cloudMigration.service.CacheRecordService;
import org.groept.cloudMigration.service.ReservationService;
import org.groept.cloudMigration.service.SubscriberService;
import org.groept.cloudMigration.service.TimeIntervalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class ReservationController {

	
private static final Logger logger = LoggerFactory.getLogger(ReservationController.class);
	
	private ReservationService reservationService;
	@Autowired
	private TimeIntervalService timeIntervalService;
	@Autowired
	private SubscriberService subscriberService;
	//@Autowired
	//private CacheRecordService cacheRecordService; 
	
	
	@RequestMapping(value="/reservationList", method=RequestMethod.GET)
	public ModelAndView list() {
		logger.info("Listing reservations.");
		
		Collection<Reservation> reservations = reservationService.getReservations();
		Map<String,Object>model = new HashMap<String,Object>();
		model.put("reservations", reservations);
		return new ModelAndView("reservation/reservationList", model);
	}
	
	
	
	
	

	@RequestMapping(value="/getReservation", method=RequestMethod.GET)
	public ModelAndView fetchReservation(@RequestParam("reservationId") ObjectId reservationId) {
		logger.info("Fetching reservation " + reservationId);
		Reservation reservation = reservationService.getReservation(reservationId);
		Map<String,Object>modelAndView = new HashMap<String,Object>();
		modelAndView.put("reservation", reservation);
		return new ModelAndView("reservation/modifyReservation", modelAndView);
	}
	
	
	@RequestMapping(value="/deleteReservation", method=RequestMethod.GET)
	public String deleteReservation(@RequestParam("reservationId") ObjectId reservationId) {
		logger.info("Deleting reservation " + reservationId);
		
		for(TimeInterval tv:reservationService.getReservation(reservationId).getTimeInterval())
			timeIntervalService.deleteTimeInterval(tv.getId());
		
		subscriberService.deleteSubscriber(reservationService.getReservation(reservationId).getSubscriber().getId());			
		reservationService.deleteReservation(reservationId);		
		return "redirect:reservationList";
	}
	
	

	@RequestMapping(value="/newReservation", method=RequestMethod.GET)
	public ModelAndView newReservation() {
		logger.info("Create new reservation instance");
		Reservation reservation = new Reservation();
		Map<String,Object>model = new HashMap<String,Object>();
		model.put("reservation", reservation);
		return new ModelAndView("reservation/newReservation", model);
	}
	
	
	
	@RequestMapping(value="/saveReservation", method=RequestMethod.POST)
	public String createReservation(@ModelAttribute("reservation") Reservation reservation,
			BindingResult result, Model model) {
		logger.info("Save reservation instance");
		reservationService.saveReservation(reservation);
		return "redirect:reservationList";
	}
	
	@RequestMapping(value="/updateReservation", method=RequestMethod.POST)
	public String updateReservation(@ModelAttribute("reservation") Reservation reservation,
			BindingResult result, Model model) {
		logger.info("Save reservation instance");
		reservationService.editReservation(reservation);
		return "redirect:reservationList";
	}
	
	
	

	@RequestMapping(value="/showTimeIntervalList", method=RequestMethod.GET)
	public ModelAndView HalladdCourt(@RequestParam("reservationId") ObjectId reservationId) {
		logger.info("Add court for hall " + reservationId);
		Reservation reservation = reservationService.getReservation(reservationId);
		Collection<TimeInterval> timeIntervals = timeIntervalService.getTimeIntervals();
		Map<String,Object>modelAndView = new HashMap<String,Object>();
		modelAndView.put("reservation", reservation);
		modelAndView.put("timeIntervals", timeIntervals);
		return new ModelAndView("reservation/showTimeIntervalList", modelAndView);
	}
	
	
	@RequestMapping(value="/reservationAddTime", method=RequestMethod.GET)
	public String reservationAddTime(@RequestParam("reservationId") ObjectId reservationId,@RequestParam("timeIntervalId") ObjectId timeIntervalId) {
		logger.info("Add timeInterval to Reservation " + reservationId);
		reservationService.addTimeInterval( timeIntervalId,reservationId);
		
		System.out.println("OK");
		return "redirect:reservationList";
	}
	

	
	@Autowired
	public void setReservationService(ReservationService reservationService) {
		this.reservationService = reservationService;
	}
	
}
