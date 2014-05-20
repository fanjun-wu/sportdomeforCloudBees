package org.groept.cloudMigration.frontend.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.groept.cloudMigration.dao.CourtDao;
import org.groept.cloudMigration.model.Admin;
import org.groept.cloudMigration.model.Capability;
import org.groept.cloudMigration.model.Court;
import org.groept.cloudMigration.model.Hall;
import org.groept.cloudMigration.model.Reservation;
import org.groept.cloudMigration.model.Subscriber;
import org.groept.cloudMigration.model.TimeInterval;
import org.groept.cloudMigration.service.AdminService;
import org.groept.cloudMigration.service.CapabilityService;
import org.groept.cloudMigration.service.CourtService;
import org.groept.cloudMigration.service.HallService;
import org.groept.cloudMigration.service.ReservationService;
import org.groept.cloudMigration.service.SubscriberService;
import org.groept.cloudMigration.service.TimeIntervalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/fanjun")
public class TestController {

	private static final Logger logger = LoggerFactory.getLogger(TestController.class);

	private CapabilityService capabilityService;
	private TimeIntervalService timeIntervalService;
	private AdminService adminService;
	private CourtService courtService;
	private HallService hallService;
	private ReservationService reservationService;
	private SubscriberService subscriberService;
	@Autowired
	private MongoTemplate mongoTemplate;
	

	TestController() {
		
	}
	@RequestMapping(value="/testtt", method=RequestMethod.GET)
	public void simpletest3() {
	  Court c=(Court) courtService.getCourts().get(0);
	  
	  Query query = new Query(Criteria.where("name").is("aq"));
	  Update update=new Update();
	  update.set("name", "aaaaaaaa");
	  mongoTemplate.updateFirst(query, update, Court.class);
	 // mongoTemplate.updateFirst(query, new Update(), Court.class);
	 
	  System.out.println("OK");
		
	}
	
	@RequestMapping(value="/test5", method=RequestMethod.GET)
	public void simpletest5() {
	  Hall h1=(Hall) hallService.getHalls().get(0);
	  //h1.getCourt().size();
	  hallService.listofCourts(h1.getId());
	 
	  System.out.println("OK"+  hallService.listofCourts(h1.getId()).size());
		
	}
	
	@RequestMapping(value="/tes", method=RequestMethod.GET)
	public void simpletest4() {
		Capability BK=new Capability("Basketball","good","no");
		Capability BD=new Capability("Badminton","good","no");
		
		Capability TN=new Capability("Tennis","good","no");
		Capability PP=new Capability("Pingpong","good","no");
		
		capabilityService.saveCapability(BD);
		capabilityService.saveCapability(BK);
		capabilityService.saveCapability(TN);
		capabilityService.saveCapability(PP);
		
		
		
		Court B1=new Court("B1","no");
		courtService.saveCourt(B1);
		BD.addCourt(B1);
		BK.addCourt(B1);
		TN.addCourt(B1);
		PP.addCourt(B1);
		courtService.saveCourt(B1);
		capabilityService.saveCapability(BD);
		capabilityService.saveCapability(BK);
		capabilityService.saveCapability(TN);
		capabilityService.saveCapability(PP);
		
		
		
	 
	  System.out.println("OK");
		
	}
	
	
	@RequestMapping(value="/testmid", method=RequestMethod.GET)
	public void simpletest2() {
		
		Capability BK=new Capability("Basketball","good","no");
		Capability BD=new Capability("Badminton","good","no");
		
		Capability TN=new Capability("Tennis","good","no");
		Capability PP=new Capability("Pingpong","good","no");
		
		capabilityService.saveCapability(BD);
		capabilityService.saveCapability(BK);
		capabilityService.saveCapability(TN);
		capabilityService.saveCapability(PP);
		
		
		
		Court B1=new Court("B1","no");
		courtService.saveCourt(B1);
		BD.addCourt(B1);
		B1.addCapability(BD);
		courtService.saveCourt(B1);
		capabilityService.saveCapability(BD);
		
		
		Court B2=new Court("B2","no");
		courtService.saveCourt(B2);
		BD.addCourt(B2);
		B2.addCapability(BD);
		courtService.saveCourt(B2);
		capabilityService.saveCapability(BD);
		
		Court B3=new Court("B3","no");
		courtService.saveCourt(B3);
		BD.addCourt(B3);
		B3.addCapability(BD);
		courtService.saveCourt(B3);
		capabilityService.saveCapability(BD);
		
		Court B4=new Court("B4","no");
		courtService.saveCourt(B4);
		BK.addCourt(B4);
		B4.addCapability(BK);
		courtService.saveCourt(B4);
		capabilityService.saveCapability(BK);
		
		Court B5=new Court("B5","no");
		courtService.saveCourt(B5);
		BK.addCourt(B5);
		B5.addCapability(BK);
		courtService.saveCourt(B5);
		capabilityService.saveCapability(BK);
		
		Court B6=new Court("B6","no");
		courtService.saveCourt(B6);
		BK.addCourt(B6);
		B6.addCapability(BK);
		courtService.saveCourt(B6);
		capabilityService.saveCapability(BK);
		
		Court TN1=new Court("TN1","no");
		courtService.saveCourt(TN1);
		TN.addCourt(TN1);
		TN1.addCapability(TN);
		courtService.saveCourt(TN1);
		capabilityService.saveCapability(TN);
		
		Court TN2=new Court("TN2","no");
		courtService.saveCourt(TN2);
		TN.addCourt(TN2);
		TN2.addCapability(TN);
		courtService.saveCourt(TN2);
		capabilityService.saveCapability(TN);
		
		Court TN3=new Court("TN3","no");
		courtService.saveCourt(TN3);
		TN.addCourt(TN3);
		TN3.addCapability(TN);
		courtService.saveCourt(TN3);
		capabilityService.saveCapability(TN);
		
		Court TN4=new Court("TN4","no");
		courtService.saveCourt(TN4);
		TN.addCourt(TN4);
		TN4.addCapability(TN);
		courtService.saveCourt(TN4);
		capabilityService.saveCapability(TN);
		
		Court PP1=new Court("PP1","no");
		courtService.saveCourt(PP1);
		PP.addCourt(PP1);
		PP1.addCapability(PP);
		courtService.saveCourt(PP1);
		capabilityService.saveCapability(PP);
		
		Court PP2=new Court("PP2","no");
		courtService.saveCourt(PP2);
		PP.addCourt(PP2);
		PP2.addCapability(PP);
		courtService.saveCourt(PP2);
		capabilityService.saveCapability(PP);
		
		Court PP3=new Court("PP3","no");
		courtService.saveCourt(PP3);
		PP.addCourt(PP3);
		PP3.addCapability(PP);
		courtService.saveCourt(PP3);
		capabilityService.saveCapability(PP);
		
		Court PP4=new Court("PP4","no");
		courtService.saveCourt(PP4);
		PP.addCourt(PP4);
		PP4.addCapability(PP);
		courtService.saveCourt(PP4);
		capabilityService.saveCapability(PP);
		
		Court PP5=new Court("PP5","no");
		courtService.saveCourt(PP5);
		PP.addCourt(PP5);
		PP5.addCapability(PP);
		courtService.saveCourt(PP5);
		capabilityService.saveCapability(PP);
		
		Court PP6=new Court("PP6","no");
		courtService.saveCourt(PP6);
		PP.addCourt(PP6);
		PP6.addCapability(PP);
		courtService.saveCourt(PP6);
		capabilityService.saveCapability(PP);
		
		
		Set<Court> courtSet=new HashSet<Court>();
		courtSet.add(PP6);
		courtSet.add(PP5);
		courtSet.add(PP4);
		courtSet.add(PP3);
		courtSet.add(PP2);
		courtSet.add(PP1);
		courtSet.add(TN4);
		courtSet.add(TN3);
		courtSet.add(TN2);
		courtSet.add(TN1);
		courtSet.add(B6);
		courtSet.add(B5);
		courtSet.add(B4);
		courtSet.add(B3);
		courtSet.add(B2);
		courtSet.add(B1);
		
		
		Admin admin=new Admin("conna","conna@gmail.com","0483359884","M",23,"admin");
		
		adminService.saveAdmin(admin);
		
		Hall hall=new Hall("HALL1",8,14,"no");
		hall.setAdmin(admin);
		admin.setHall(hall);
		hallService.saveHall(hall);
		adminService.saveAdmin(admin);
		
		
		
		for(Court c:courtSet)
		{
			c.setHall(hall);
			//hall.addCourt(c);
			courtService.saveCourt(c);
			hallService.saveHall(hall);
		}
		
//////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////
		
		Subscriber s1=new Subscriber("lihua1","lihua1@gmail.com","0254846854","M",23,"dsqdq484sdqsdsq");
		Subscriber s2=new Subscriber("lihua2","lihua2@gmail.com","0254846854","M",23,"dsqdq484sdqsdsq");
		Subscriber s3=new Subscriber("lihua3","lihua3@gmail.com","0254846854","M",23,"dsqdq484sdqsdsq");
		Subscriber s4=new Subscriber("lihua4","lihua4@gmail.com","0254846854","M",23,"dsqdq484sdqsdsq");
		Subscriber s5=new Subscriber("lihua5","lihua5@gmail.com","0254846854","M",23,"dsqdq484sdqsdsq");
		
		subscriberService.saveSubscriber(s1);  
		subscriberService.saveSubscriber(s2);  
		subscriberService.saveSubscriber(s3);  
		subscriberService.saveSubscriber(s4);  
		subscriberService.saveSubscriber(s5);  
		
		
		TimeInterval t1=new TimeInterval(9,getDateByString("2014-3-20"));
		TimeInterval t2=new TimeInterval(9,getDateByString("2014-3-20"));
		TimeInterval t3=new TimeInterval(10,getDateByString("2014-3-20"));
		TimeInterval t4=new TimeInterval(11,getDateByString("2014-3-20"));
		TimeInterval t5=new TimeInterval(12,getDateByString("2014-3-20"));
		
		timeIntervalService.saveTimeInterval(t1);
		timeIntervalService.saveTimeInterval(t2);
		timeIntervalService.saveTimeInterval(t3);
		timeIntervalService.saveTimeInterval(t4);
		timeIntervalService.saveTimeInterval(t5);
		
						
		Set<TimeInterval> timeIntervals1=new HashSet<TimeInterval>();
		timeIntervals1.add(t1);
		Set<TimeInterval> timeIntervals2=new HashSet<TimeInterval>();
		timeIntervals2.add(t2);
		Set<TimeInterval> timeIntervals3=new HashSet<TimeInterval>();
		timeIntervals3.add(t3);
		Set<TimeInterval> timeIntervals4=new HashSet<TimeInterval>();
		timeIntervals4.add(t4);
		Set<TimeInterval> timeIntervals5=new HashSet<TimeInterval>();
		timeIntervals5.add(t5);
		
		Reservation r1=new Reservation("book basket","no");
		Reservation r2=new Reservation("book basket","no");
		Reservation r3=new Reservation("book badminton","no");
		Reservation r4=new Reservation("book badminton","no");
		Reservation r5=new Reservation("book tennis","no");
		
		reservationService.saveReservation(r1); 
		reservationService.saveReservation(r2); 
		reservationService.saveReservation(r3); 
		reservationService.saveReservation(r4); 
		reservationService.saveReservation(r5); 
		
		
		for(Court c:courtSet)
		{
			for(Capability cap:courtService.listofCapabilitys(c.getId()))
			{	
			if(cap.getResource().equalsIgnoreCase("basketball"))
			{
				r1.setCourt(c);
				r2.setCourt(c);
				
				/*c.addReservation(r1);
				c.addReservation(r2);*/
				
				
				reservationService.saveReservation(r1); 
				reservationService.saveReservation(r2); 
				 
				courtService.saveCourt(c);
				
			}
			if(cap.getResource().equalsIgnoreCase("badminton"))
			{
				r3.setCourt(c);
				r4.setCourt(c);
				/*c.addReservation(r3);
				c.addReservation(r4);*/
				reservationService.saveReservation(r3); 
				reservationService.saveReservation(r4); 
				courtService.saveCourt(c);
			}		
			if(cap.getResource().equalsIgnoreCase("tennis"))
			{
				r5.setCourt(c);
				/*c.addReservation(r5);*/
				reservationService.saveReservation(r5);
				courtService.saveCourt(c);
			}			
		}
		}
		
		
		
		r1.setSubscriber(s1);		
		r1.addTimeInterval(t1);
		
		r2.setSubscriber(s2);		
		r2.addTimeInterval(t2);
				
		r3.setSubscriber(s3);		
		r3.addTimeInterval(t3);
			
		r4.setSubscriber(s4);		
		r4.addTimeInterval(t4);
			
		r5.setSubscriber(s5);		
		r5.addTimeInterval(t5);
		
		
		//save Reservation, TimeInterval, Court, Subscriber in relationtimeIntervalService.saveTimeInterval(t1);
		timeIntervalService.saveTimeInterval(t1);
		timeIntervalService.saveTimeInterval(t2);
		timeIntervalService.saveTimeInterval(t3);
		timeIntervalService.saveTimeInterval(t4);
		timeIntervalService.saveTimeInterval(t5);
		
		subscriberService.saveSubscriber(s1);  
		subscriberService.saveSubscriber(s2);  
		subscriberService.saveSubscriber(s3);  
		subscriberService.saveSubscriber(s4);  
		subscriberService.saveSubscriber(s5);  
		
		reservationService.saveReservation(r1); 
		reservationService.saveReservation(r2); 
		reservationService.saveReservation(r3); 
		reservationService.saveReservation(r4); 
		reservationService.saveReservation(r5); 
		
		System.out.println("haha");
		
		
		
		
		
	}
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public void simpletest() {
		
		Capability BK=new Capability("Basketball","good","no");
		Capability BD=new Capability("Badminton","good","no");
		
		capabilityService.saveCapability(BD);
		capabilityService.saveCapability(BK);
		
		//Set<Capability> BBCapSet=new HashSet<Capability>();
		//Set<Capability> BKCapSet=new HashSet<Capability>();
		//Set<Capability> BDCapSet=new HashSet<Capability>();
		
		//BBCapSet.add(BD);
		//BBCapSet.add(BK);
		
		//BKCapSet.add(BK);
		//BDCapSet.add(BD);
		
		Court B1=new Court("B1","no");
		courtService.saveCourt(B1);
		//B1.setCapability(BDCapSet);	
		BD.addCourt(B1);
		courtService.saveCourt(B1);
		capabilityService.saveCapability(BD);
		
		
		Court B2=new Court("B2","no");
		courtService.saveCourt(B2);
		//B2.setCapability(BKCapSet);
		BK.addCourt(B2);
		courtService.saveCourt(B2);
		capabilityService.saveCapability(BK);
		
		

		Admin admin=new Admin("conna","conna@gmail.com","0483359884","M",23,"admin");
		
		adminService.saveAdmin(admin);
		
		Hall hall=new Hall("HALL1",8,14,"no");
		hall.setAdmin(admin);
		admin.setHall(hall);
		hallService.saveHall(hall);
		adminService.saveAdmin(admin);
		
		
		Set<Court> courtSet=new HashSet<Court>();
		courtSet.add(B2);
		courtSet.add(B1);
		for(Court c:courtSet)
		{
			c.setHall(hall);
			//hall.addCourt(c);
			courtService.saveCourt(c);
			hallService.saveHall(hall);
		}
		
//////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////
		
		Subscriber s1=new Subscriber("lihua1","lihua1@gmail.com","0254846854","M",23,"dsqdq484sdqsdsq");
		Subscriber s2=new Subscriber("lihua2","lihua2@gmail.com","0254846854","M",23,"dsqdq484sdqsdsq");
		Subscriber s3=new Subscriber("lihua3","lihua3@gmail.com","0254846854","M",23,"dsqdq484sdqsdsq");
		Subscriber s4=new Subscriber("lihua4","lihua4@gmail.com","0254846854","M",23,"dsqdq484sdqsdsq");
		Subscriber s5=new Subscriber("lihua5","lihua5@gmail.com","0254846854","M",23,"dsqdq484sdqsdsq");
		
		subscriberService.saveSubscriber(s1);  
		subscriberService.saveSubscriber(s2);  
		subscriberService.saveSubscriber(s3);  
		subscriberService.saveSubscriber(s4);  
		subscriberService.saveSubscriber(s5);  
		
		
		TimeInterval t1=new TimeInterval(9,getDateByString("2014-3-20"));
		TimeInterval t2=new TimeInterval(9,getDateByString("2014-3-20"));
		TimeInterval t3=new TimeInterval(10,getDateByString("2014-3-20"));
		TimeInterval t4=new TimeInterval(11,getDateByString("2014-3-20"));
		TimeInterval t5=new TimeInterval(12,getDateByString("2014-3-20"));
		
		timeIntervalService.saveTimeInterval(t1);
		timeIntervalService.saveTimeInterval(t2);
		timeIntervalService.saveTimeInterval(t3);
		timeIntervalService.saveTimeInterval(t4);
		timeIntervalService.saveTimeInterval(t5);
		
						
		Set<TimeInterval> timeIntervals1=new HashSet<TimeInterval>();
		timeIntervals1.add(t1);
		Set<TimeInterval> timeIntervals2=new HashSet<TimeInterval>();
		timeIntervals2.add(t2);
		Set<TimeInterval> timeIntervals3=new HashSet<TimeInterval>();
		timeIntervals3.add(t3);
		Set<TimeInterval> timeIntervals4=new HashSet<TimeInterval>();
		timeIntervals4.add(t4);
		Set<TimeInterval> timeIntervals5=new HashSet<TimeInterval>();
		timeIntervals5.add(t5);
		
		Reservation r1=new Reservation("book basket","no");
		Reservation r2=new Reservation("book basket","no");
		Reservation r3=new Reservation("book badminton","no");
		Reservation r4=new Reservation("book badminton","no");
		Reservation r5=new Reservation("book basket","no");
		
		reservationService.saveReservation(r1); 
		reservationService.saveReservation(r2); 
		reservationService.saveReservation(r3); 
		reservationService.saveReservation(r4); 
		reservationService.saveReservation(r5); 
		
		
		for(Court c:courtSet)
		{
			for(Capability cap:courtService.listofCapabilitys(c.getId()))
			{	
			if(cap.getResource().equalsIgnoreCase("basketball"))
			{
				r1.setCourt(c);
				r2.setCourt(c);
				r5.setCourt(c);
				/*c.addReservation(r1);
				c.addReservation(r2);
				c.addReservation(r5);
				*/
				reservationService.saveReservation(r1); 
				reservationService.saveReservation(r2); 
				reservationService.saveReservation(r5); 
				courtService.saveCourt(c);
				
			}
			if(cap.getResource().equalsIgnoreCase("badminton"))
			{
				r3.setCourt(c);
				r4.setCourt(c);
				/*c.addReservation(r3);
				c.addReservation(r4);*/
				reservationService.saveReservation(r3); 
				reservationService.saveReservation(r4); 
				courtService.saveCourt(c);
			}			
		}
		}
		
		
		
		r1.setSubscriber(s1);		
		r1.addTimeInterval(t1);
		
		r2.setSubscriber(s2);		
		r2.addTimeInterval(t2);
				
		r3.setSubscriber(s3);		
		r3.addTimeInterval(t3);
			
		r4.setSubscriber(s4);		
		r4.addTimeInterval(t4);
			
		r5.setSubscriber(s5);		
		r5.addTimeInterval(t5);
		
		
		//save Reservation, TimeInterval, Court, Subscriber in relationtimeIntervalService.saveTimeInterval(t1);
		timeIntervalService.saveTimeInterval(t1);
		timeIntervalService.saveTimeInterval(t2);
		timeIntervalService.saveTimeInterval(t3);
		timeIntervalService.saveTimeInterval(t4);
		timeIntervalService.saveTimeInterval(t5);
		
		subscriberService.saveSubscriber(s1);  
		subscriberService.saveSubscriber(s2);  
		subscriberService.saveSubscriber(s3);  
		subscriberService.saveSubscriber(s4);  
		subscriberService.saveSubscriber(s5);  
		
		reservationService.saveReservation(r1); 
		reservationService.saveReservation(r2); 
		reservationService.saveReservation(r3); 
		reservationService.saveReservation(r4); 
		reservationService.saveReservation(r5); 
		
		System.out.println("haha");
		
		
	
		
	}

	

	/*@RequestMapping(value="/smallDataFacility",method=RequestMethod.GET)
	public void frontendtest1()
	{
		
		
		Capability BK=new Capability("Basketball","good","no");
		Capability BD=new Capability("Badminton","good","no");
		
		Set<Capability> BBCapSet=new HashSet<Capability>();
		Set<Capability> BKCapSet=new HashSet<Capability>();
		Set<Capability> BDCapSet=new HashSet<Capability>();
		
		BBCapSet.add(BD);
		BBCapSet.add(BK);
		
		BKCapSet.add(BK);
		BDCapSet.add(BD);
		
		
		Court B1=new Court("B1","no");
		B1.setCapability(BDCapSet);		
		Court B2=new Court("B2","no");
		B2.setCapability(BKCapSet);
		
				
		Set<Court> courtSet=new HashSet<Court>();
		courtSet.add(B2);
		courtSet.add(B1);

		Admin admin=new Admin("conna","conna@gmail.com","0483359884","M",23,"admin");
		
		adminService.saveAdmin(admin);
		
		Hall hall=new Hall("HALL1",8,14,"no");
		hall.setAdmin(admin);
		
		hallService.saveHall(hall);
		
		
		for(Court c:courtSet)
		{
			c.setHall(hall);
			courtService.saveCourt(c);
		}
			
	}

	

	@RequestMapping(value="/smallDataReservation",method=RequestMethod.GET)
	public void frontendreservationtest1()
	{
		
		
		
		
		Subscriber s1=new Subscriber("lihua1","lihua1@gmail.com","0254846854","M",23,"dsqdq484sdqsdsq");
		Subscriber s2=new Subscriber("lihua2","lihua2@gmail.com","0254846854","M",23,"dsqdq484sdqsdsq");
		Subscriber s3=new Subscriber("lihua3","lihua3@gmail.com","0254846854","M",23,"dsqdq484sdqsdsq");
		Subscriber s4=new Subscriber("lihua4","lihua4@gmail.com","0254846854","M",23,"dsqdq484sdqsdsq");
		Subscriber s5=new Subscriber("lihua5","lihua5@gmail.com","0254846854","M",23,"dsqdq484sdqsdsq");
		
		subscriberService.saveSubscriber(s1);  
		subscriberService.saveSubscriber(s2);  
		subscriberService.saveSubscriber(s3);  
		subscriberService.saveSubscriber(s4);  
		subscriberService.saveSubscriber(s5);  
		
		
		TimeInterval t1=new TimeInterval(9,getDateByString("2014-3-20"));
		TimeInterval t2=new TimeInterval(9,getDateByString("2014-3-20"));
		TimeInterval t3=new TimeInterval(10,getDateByString("2014-3-20"));
		TimeInterval t4=new TimeInterval(11,getDateByString("2014-3-20"));
		TimeInterval t5=new TimeInterval(12,getDateByString("2014-3-20"));
		
		timeIntervalService.saveTimeInterval(t1);
		timeIntervalService.saveTimeInterval(t2);
		timeIntervalService.saveTimeInterval(t3);
		timeIntervalService.saveTimeInterval(t4);
		timeIntervalService.saveTimeInterval(t5);
		
						
		Set<TimeInterval> timeIntervals1=new HashSet<TimeInterval>();
		timeIntervals1.add(t1);
		Set<TimeInterval> timeIntervals2=new HashSet<TimeInterval>();
		timeIntervals2.add(t2);
		Set<TimeInterval> timeIntervals3=new HashSet<TimeInterval>();
		timeIntervals3.add(t3);
		Set<TimeInterval> timeIntervals4=new HashSet<TimeInterval>();
		timeIntervals4.add(t4);
		Set<TimeInterval> timeIntervals5=new HashSet<TimeInterval>();
		timeIntervals5.add(t5);
		
		Reservation r1=new Reservation("book basket","no");
		Reservation r2=new Reservation("book basket","no");
		Reservation r3=new Reservation("book badminton","no");
		Reservation r4=new Reservation("book badminton","no");
		Reservation r5=new Reservation("book basket","no");
		
		reservationService.saveReservation(r1); 
		reservationService.saveReservation(r2); 
		reservationService.saveReservation(r3); 
		reservationService.saveReservation(r4); 
		reservationService.saveReservation(r5); 
		
		
		//Court courtTemp=new Court();
		for(int i=0;i<courtService.getCourts().size();i++)
		{			
			Court ct=(Court)courtService.getCourts().get(i);
			
			for(Capability cap:ct.getCapability())
			{	
				System.out.println(cap.getResource());
				if(cap.getResource().equalsIgnoreCase("basketball"))
				{
					//r1.setCourt(ct);
					//r2.setCourt(ct);
					//r5.setCourt(ct);
					//ct.addReservation(r1);
					////ct.addReservation(r2);
					//ct.addReservation(r5);
					
					//reservationService.saveReservation(r1); 
					//reservationService.saveReservation(r2); 
					//reservationService.saveReservation(r5); 
					courtService.saveCourt(ct);
					
				}
				if(cap.getResource().equalsIgnoreCase("badminton"))
				{
					//r3.setCourt(ct);
					//r4.setCourt(ct);
					ct.addReservation(r3);
					ct.addReservation(r4);
					//reservationService.saveReservation(r3); 
					//reservationService.saveReservation(r4); 
					//courtService.saveCourt(ct);
				}					
				
			}
		}
		
		r1.setSubscriber(s1);		
		r1.addTimeInterval(t1);
		
		r2.setSubscriber(s2);		
		r2.addTimeInterval(t2);
				
		r3.setSubscriber(s3);		
		r3.addTimeInterval(t3);
			
		r4.setSubscriber(s4);		
		r4.addTimeInterval(t4);
			
		r5.setSubscriber(s5);		
		r5.addTimeInterval(t5);
		
		
		//save Reservation, TimeInterval, Court, Subscriber in relationtimeIntervalService.saveTimeInterval(t1);
		timeIntervalService.saveTimeInterval(t1);
		timeIntervalService.saveTimeInterval(t2);
		timeIntervalService.saveTimeInterval(t3);
		timeIntervalService.saveTimeInterval(t4);
		timeIntervalService.saveTimeInterval(t5);
		
		subscriberService.saveSubscriber(s1);  
		subscriberService.saveSubscriber(s2);  
		subscriberService.saveSubscriber(s3);  
		subscriberService.saveSubscriber(s4);  
		subscriberService.saveSubscriber(s5);  
		
		reservationService.saveReservation(r1); 
		reservationService.saveReservation(r2); 
		reservationService.saveReservation(r3); 
		reservationService.saveReservation(r4); 
		reservationService.saveReservation(r5); 
		System.out.println("haha");
	}
	

	
	
	
	
	
	@RequestMapping(value="/mediumDataFacility",method=RequestMethod.GET)
	public void frontendtest0()
	{
		
		
		Capability BK=new Capability("Basketball","good","no");
		Capability BD=new Capability("Badminton","good","no");
		
		Capability TN=new Capability("Tennis","good","no");
		Capability PP=new Capability("Pingpong","good","no");
		
		Set<Capability> BBCapSet=new HashSet<Capability>();
		Set<Capability> BKCapSet=new HashSet<Capability>();
		Set<Capability> BDCapSet=new HashSet<Capability>();
		Set<Capability> TNCapSet=new HashSet<Capability>();
		Set<Capability> PPCapSet=new HashSet<Capability>();
		
		BBCapSet.add(BD);
		BBCapSet.add(BK);
		
		BKCapSet.add(BK);
		BDCapSet.add(BD);
		TNCapSet.add(TN);
		PPCapSet.add(PP);
		
		
		Court B1=new Court("B1","no");
		B1.setCapability(BDCapSet);		
		Court B2=new Court("B2","no");
		B2.setCapability(BDCapSet);
		Court B3=new Court("B3","no");
		B3.setCapability(BDCapSet);
		Court B4=new Court("B4","no");
		B4.setCapability(BKCapSet);
		Court B5=new Court("B5","no");
		B5.setCapability(BKCapSet);
		Court B6=new Court("B6","no");
		B6.setCapability(BKCapSet);
		
		
		
		Court TN1=new Court("TN1","no");
		TN1.setCapability(TNCapSet);
		Court TN2=new Court("TN2","no");
		TN2.setCapability(TNCapSet);
		Court TN3=new Court("TN3","no");
		TN3.setCapability(TNCapSet);
		Court TN4=new Court("TN4","no");
		TN4.setCapability(TNCapSet);
		
		Court PP1=new Court("PP1","no");
		PP1.setCapability(PPCapSet);
		Court PP2=new Court("PP2","no");
		PP2.setCapability(PPCapSet);
		Court PP3=new Court("PP3","no");
		PP3.setCapability(PPCapSet);
		Court PP4=new Court("PP4","no");
		PP4.setCapability(PPCapSet);
		Court PP5=new Court("PP5","no");
		PP5.setCapability(PPCapSet);
		Court PP6=new Court("PP6","no");
		PP6.setCapability(PPCapSet);
		
		
		Set<Court> courtSet=new HashSet<Court>();
		courtSet.add(PP6);
		courtSet.add(PP5);
		courtSet.add(PP4);
		courtSet.add(PP3);
		courtSet.add(PP2);
		courtSet.add(PP1);
		courtSet.add(TN4);
		courtSet.add(TN3);
		courtSet.add(TN2);
		courtSet.add(TN1);
		courtSet.add(B6);
		courtSet.add(B5);
		courtSet.add(B4);
		courtSet.add(B3);
		courtSet.add(B2);
		courtSet.add(B1);

		Admin admin=new Admin("conna","conna@gmail.com","0483359884","M",23,"admin");
		
		adminService.saveAdmin(admin);
		
		Hall hall=new Hall("HALL1",8,22,"no");
		hall.setAdmin(admin);
		
		hallService.saveHall(hall);
		
		
		for(Court c:courtSet)
		{
			c.setHall(hall);
			courtService.saveCourt(c);
		}
			
		

	}
	
	
	
	
	
	
	
	@RequestMapping(value="/mediumDataReservation",method=RequestMethod.GET)
	public void frontendreservationtest0()
	{
		
		Subscriber s1=new Subscriber("lihua1","lihua1@gmail.com","0254846854","M",23,"dsqdq484sdqsdsq");
		Subscriber s2=new Subscriber("lihua2","lihua2@gmail.com","0254846854","M",23,"dsqdq484sdqsdsq");
		Subscriber s3=new Subscriber("lihua3","lihua3@gmail.com","0254846854","M",23,"dsqdq484sdqsdsq");
		Subscriber s4=new Subscriber("lihua4","lihua4@gmail.com","0254846854","M",23,"dsqdq484sdqsdsq");
		Subscriber s5=new Subscriber("lihua5","lihua5@gmail.com","0254846854","M",23,"dsqdq484sdqsdsq");
		
		subscriberService.saveSubscriber(s1);  
		subscriberService.saveSubscriber(s2);  
		subscriberService.saveSubscriber(s3);  
		subscriberService.saveSubscriber(s4);  
		subscriberService.saveSubscriber(s5);  
		
		
		TimeInterval t1=new TimeInterval(9,getDateByString("2014-3-20"));
		TimeInterval t2=new TimeInterval(9,getDateByString("2014-3-20"));
		TimeInterval t3=new TimeInterval(10,getDateByString("2014-3-20"));
		TimeInterval t4=new TimeInterval(11,getDateByString("2014-3-20"));
		TimeInterval t5=new TimeInterval(12,getDateByString("2014-3-20"));
						
		Set<TimeInterval> timeIntervals1=new HashSet<TimeInterval>();
		timeIntervals1.add(t1);
		Set<TimeInterval> timeIntervals2=new HashSet<TimeInterval>();
		timeIntervals2.add(t2);
		Set<TimeInterval> timeIntervals3=new HashSet<TimeInterval>();
		timeIntervals3.add(t3);
		Set<TimeInterval> timeIntervals4=new HashSet<TimeInterval>();
		timeIntervals4.add(t4);
		Set<TimeInterval> timeIntervals5=new HashSet<TimeInterval>();
		timeIntervals5.add(t5);
		
		Reservation r1=new Reservation("book basket","no");
		Reservation r2=new Reservation("book basket","no");
		Reservation r3=new Reservation("book badminton","no");
		Reservation r4=new Reservation("book badminton","no");
		Reservation r5=new Reservation("book tennis","no");
		
		
		Court courtTemp=new Court();
		for(int i=0;i<courtService.getCourts().size();i++)
		{			
			Court ct=(Court)courtService.getCourts().get(i);
			for(Capability cap:ct.getCapability())
			{
				if(cap.getResource().equalsIgnoreCase("basketball"))
				{
					r1.setCourt(ct);
					r2.setCourt(ct);
				}
				if(cap.getResource().equalsIgnoreCase("badminton"))
				{
					r3.setCourt(ct);
					r4.setCourt(ct);
				}					
				if(cap.getResource().equalsIgnoreCase("tennis"))
				{
					r5.setCourt(ct);
					
				}
			}
		}
		
		r1.setSubscriber(s1);		
		r1.setTimeInterval(timeIntervals1);
		
		r2.setSubscriber(s2);		
		r2.setTimeInterval(timeIntervals2);
				
		r3.setSubscriber(s3);		
		r3.setTimeInterval(timeIntervals3);
			
		r4.setSubscriber(s4);		
		r4.setTimeInterval(timeIntervals4);
			
		r5.setSubscriber(s5);		
		r5.setTimeInterval(timeIntervals5);
		
		
		//save Reservation, TimeInterval, Court, Subscriber in relation
		reservationService.saveReservation(r1); 
		reservationService.saveReservation(r2); 
		reservationService.saveReservation(r3); 
		reservationService.saveReservation(r4); 
		reservationService.saveReservation(r5); 
	}
	
	
	

	@RequestMapping(value="/simpleTest",method=RequestMethod.GET)
	public void frontendtesttest()
	{
		
		
		Court c1=new Court("H1","no");
		Court c2=new Court("H2","no");
		
		Capability cap1=new Capability("Basketball","good","no");
		Capability cap2=new Capability("Badminton","good","no");
		
		Capability cap3=new Capability("tennis","good","no");
		
		
		Set<Capability> capabilities=new HashSet<Capability>();
		capabilities.add(cap1);
		capabilities.add(cap2);
		
		c1.setCapability(capabilities);
		
		courtService.saveCourt(c1);		//  court<---> capability save first
		
		
		Subscriber s1=new Subscriber("hj","kl","dg","uiyi",23,"dsqdq");
		subscriberService.saveSubscriber(s1);    //save subscriber first
		
		TimeInterval t1=new TimeInterval(9,new Date());
		TimeInterval t2=new TimeInterval(19,new Date());
		TimeInterval t3=new TimeInterval(14,new Date());
				
		Set<TimeInterval> timeIntervals=new HashSet<TimeInterval>();
		timeIntervals.add(t1);
		timeIntervals.add(t2);
		timeIntervals.add(t3);
		
		Reservation r1=new Reservation("no","no");
		
		r1.setCourt(c1);
		r1.setSubscriber(s1);
		r1.setTimeInterval(timeIntervals);
		
		reservationService.saveReservation(r1);  //save Reservation, TimeInterval, Court, Subscriber in relation
				
	}*/
	
	public Date getDateByString(String dateString)
	{
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");		
		
		Date date=new Date();
		try {
			date = formatter.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;		
	}
	
	
	@Autowired
	public void setCapabilityService(CapabilityService capabilityService) {
		this.capabilityService = capabilityService;
	}
	@Autowired
	public void setTimeIntervalService(TimeIntervalService timeIntervalService) {
		this.timeIntervalService = timeIntervalService;
	}
	@Autowired
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	@Autowired
	public void setCourtService(CourtService courtService) {
		this.courtService = courtService;
	}
	@Autowired
	public void setHallService(HallService hallService) {
		this.hallService = hallService;
	}
	@Autowired
	public void setReservationService(ReservationService reservationService) {
		this.reservationService = reservationService;
	}
	@Autowired
	public void setSubscriberService(SubscriberService subscriberService) {
		this.subscriberService = subscriberService;
	}
	
}