package org.groept.cloudMigration.frontend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	private CapabilityService capabilityService;
	private TimeIntervalService timeIntervalService;
	private AdminService adminService;
	private CourtService courtService;
	private HallService hallService;
	private ReservationService reservationService;
	private SubscriberService subscriberService;
	
	
	@RequestMapping(value={"/reservation","/reservation/"},method=RequestMethod.GET)
	public String getReservationPage()
	{
		
		return "frontend/reservation";
	}
	
	
	@RequestMapping(value={"/reserveSuccess","/reserveSuccess/"},method=RequestMethod.GET)
	public String getReserveSuccessPage()
	{
		
		return "frontend/reserveSuccess";
	}
	
	
	@RequestMapping(value={"/cancelSuccess","/cancelSuccess/"},method=RequestMethod.GET)
	public String getCancelSuccessPage()
	{
		
		return "frontend/cancelSuccess";
	}
	

	@RequestMapping(value={"/home","/"," "},method=RequestMethod.GET)
	public String getHomePage()
	{
		
		return "frontend/home";
	}
	
	@RequestMapping(value = {"/about","/about/"}, method = RequestMethod.GET)
	public String getAboutPage(Model model) {
		logger.info("About page !");
		
		return "frontend/about";
	}
	
	
	@RequestMapping(value = "/login/user-name/{userName}/user-authen-key/{userAuthenKey}", method = RequestMethod.GET)
	public ModelAndView getUserPage(@PathVariable String userName,@PathVariable String userAuthenKey) {
		logger.info("About page !");
		ModelAndView mav = new ModelAndView();
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		for(Reservation res:(List<Reservation>)reservationService.getReservations())
			if(res.getSubscriber().getAuthenKey().equals(userAuthenKey)&&res.getSubscriber().getName().equals(userName))
			{
				System.out.println("we find you: "+userName+" sub: "+res.getSubscriber().getName()+" "+res.getSubscriber().getEmail()+" "+res.getSubscriber().getId());
				//mav.addObject("subscriber",sub);
				
				Subscriber sub=new Subscriber(res.getSubscriber().getName(),res.getSubscriber().getEmail(),res.getSubscriber().getTelephone(),res.getSubscriber().getGender(),res.getSubscriber().getAge(),res.getSubscriber().getAuthenKey());
				sub.setId(res.getSubscriber().getId());
				
				Court ct=new Court(res.getCourt().getName(),res.getCourt().getIntroduction());
				
				Hall hl=new Hall(res.getCourt().getHall().getName(),res.getCourt().getHall().getOpenTime(),res.getCourt().getHall().getCloseTime(),res.getCourt().getHall().getIntroduction());
				
				String time="";
				for(TimeInterval tv:res.getTimeInterval())
					time+=" "+tv.getStartTime()+"h, "+tv.getDate();	
				model.put("subscriber", sub);
				model.put("reservation", res);
				model.put("hall", hl);
				model.put("court", ct);
				model.put("time",time);
				
				
				return new ModelAndView("frontend/cancel-reservation","model",model);
				
			}
		
		mav.setViewName("frontend/not-found");
		
		return new ModelAndView("frontend/not-found");
	
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
