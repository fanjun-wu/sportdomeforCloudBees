package org.groept.cloudMigration.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;



























import java.util.Set;
import java.util.UUID;

import org.bson.types.ObjectId;
import org.groept.cloudMigration.model.Admin;
import org.groept.cloudMigration.model.CacheRecord;
import org.groept.cloudMigration.model.Capability;
import org.groept.cloudMigration.model.Court;
import org.groept.cloudMigration.model.Hall;
import org.groept.cloudMigration.service.AdminService;
import org.groept.cloudMigration.service.CacheRecordService;
import org.groept.cloudMigration.service.CapabilityService;
import org.groept.cloudMigration.service.CourtService;
import org.groept.cloudMigration.service.HallService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
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
public class HallController  {
	
private static final Logger logger = LoggerFactory.getLogger(HallController.class);
	@Autowired
	private HallService hallService;
	@Autowired
	private CourtService courtService;
	@Autowired
	private CapabilityService capabilityService;
	@Autowired
	private AdminService adminService;
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private CacheRecordService cacheRecordService; 
	
	
	@RequestMapping(value="/hallList", method=RequestMethod.GET)
	public ModelAndView list() {
		logger.info("Listing halls.");
		
		System.out.println("getting hall list");
		
		List<Hall> halls = hallService.getHalls();
		//Collection<Hall> halls=null;
		Map<String,Object>model = new HashMap<String,Object>();
		model.put("halls", halls);
		return new ModelAndView("hall/hallList", model);
	}
	
	
	@RequestMapping(value="/showhallCourtList", method=RequestMethod.GET)
	public ModelAndView listofCourt(@RequestParam("hallId") ObjectId hallId) {
		logger.info("Listing courts.");
		Collection<Court> courts = hallService.listofCourts(hallId);
		Map<String,Object>model = new HashMap<String,Object>();
		model.put("courts", courts);
		return new ModelAndView("hall/showhallCourtList", model);
	}
	

	@RequestMapping(value="/getHall", method=RequestMethod.GET)
	public ModelAndView fetchHall(@RequestParam("hallId") ObjectId hallId) {
		logger.info("Fetching hall " + hallId);
		Hall hall = hallService.getHall(hallId);
		
		
		System.out.println("Hall Info: "+hall.getId()+"  "+hall.getName());
		
		

		CacheRecord cacheRecord=new CacheRecord(1,0,new java.util.Date());
		cacheRecordService.saveCacheRecord(cacheRecord);
				
		
		Map<String,Object>modelAndView = new HashMap<String,Object>();
		modelAndView.put("hall", hall);
		
		return new ModelAndView("hall/modifyHall", modelAndView);		
	}
	
	
	@RequestMapping(value="/deleteHall", method=RequestMethod.GET)
	public String deleteHall(@RequestParam("hallId") ObjectId hallId) {
		logger.info("Deleting hall " + hallId);
		
		Hall hall=hallService.getHall(hallId);
		
		System.out.println("Hall ID: "+hall.getId());
		
		for(Court ct:(List<Court>)courtService.getCourts())
		{
			if(ct.getHall().getId().equals(hall.getId()))
			{				
				for(Capability cap :courtService.listofCapabilitys(ct.getId()))
				{
					Set<ObjectId> ids=new HashSet<ObjectId>();
					ids=cap.getCourts();
					
					Iterator<ObjectId> ite = ids.iterator();
					
					while(ite.hasNext()) {
						ObjectId value = ite.next();
			               if(value.equals(ct.getId()))
			                    ite.remove();
			               else
			                    System.out.println(value);
			          }

					
		/*		//concurrent modification exception	
					for(ObjectId i :ids)
					{
						if(i.equals(ct.getId()))
						{
							ids.remove(i);
						}
					}
					
			*/
			
					
					
					  Query query3 = new Query(Criteria.where("id").is(cap.getId()));
					  Update update3=new Update();
					  update3.set("courts", ids);
					  mongoTemplate.updateFirst(query3, update3, Capability.class);
				}
				
				
				System.out.println("delete court before delete the hall");
				courtService.deleteCourt(ct.getId());	//delete courts
			}
							
		}
		
		
		System.out.println("remove the court in this hall for this capability before delete the hall");
		/*
		for(Capability cp:(List<Capability>)capabilityService.getCapabilities())
		{			
			Set<ObjectId> objTemp=new HashSet<ObjectId>();
			for(ObjectId obj:cp.getCourts())
			{				
				boolean t=false;
				for(Court ct:(List<Court>)courtService.getCourts())
				{
					if(ct.getHall().getId().equals(hall.getId()))
						if(obj.equals(ct.getId()))
						{
							t=true;
									//	cp.getCourts().remove(obj);       //HashSet remove not working??

						}
								
				}
				
				if(t==false)
					objTemp.add(obj);
				
			}
			
			cp.setCourts(objTemp);
			
		}
		*/
		
		
		
		hallService.deleteHall(hallId);
		return "redirect:hallList";
	}
	
	@RequestMapping(value="/hallCourtList", method=RequestMethod.GET)
	public ModelAndView HalladdCourt(@RequestParam("hallId") ObjectId hallId) {
		logger.info("Add court for hall " + hallId);
		Hall hall = hallService.getHall(hallId);
		Collection<Court> courts = courtService.getCourts();
		
		
		
		
		Map<String,Object>modelAndView = new HashMap<String,Object>();
		modelAndView.put("hall", hall);
		modelAndView.put("courts", courts);
		return new ModelAndView("hall/addCourt", modelAndView);
	}
	
	
	
	
	
	
	
	
	
	@RequestMapping(value="/hallAddCourt", method=RequestMethod.GET)
	public String hallAddCourt(@RequestParam("hallId") ObjectId hallId,@RequestParam("courtId") ObjectId courtId) {
		logger.info("Add hall to court " + hallId);
		hallService.addCourt(hallId, courtId);
		
		
		return "redirect:hallList";
	}
	
	
	
	@RequestMapping(value="/newHall", method=RequestMethod.GET)
	public ModelAndView newHall() {
		logger.info("Create new hall instance");
		Hall hall = new Hall();
		Map<String,Object>model = new HashMap<String,Object>();
		model.put("hall", hall);
		return new ModelAndView("hall/newHall", model);
	}
	
	
	
	@RequestMapping(value="/saveHall", method=RequestMethod.POST)
	public String createHall(@ModelAttribute("hall") Hall hall,
			BindingResult result, Model model) {
		logger.info("Save hall instance");
		
		System.out.println("Create Hall");
		UUID uniqueKey1= UUID.randomUUID();
		UUID uniqueKey2= UUID.randomUUID();
		//String key=uniqueKey1.toString()+uniqueKey2.toString();
		
		
		
		String key0=uniqueKey1.toString();
		String key1=key0.replaceAll("\\W","");	//remove none character
		String key2=key1.substring(0, Math.min(key0.length(), 24));
		
		System.out.println("Hall Id: "+key2);
		
		
		ObjectId objid=new ObjectId(key2);
		
		hall.setId(objid);
		
		
		hallService.saveHall(hall);
		return "redirect:hallList";
	}
	
	@RequestMapping(value="/updateHall", method=RequestMethod.POST)
	public String updateHall(@ModelAttribute("hall") Hall hall,
			BindingResult result, Model model) {
		logger.info("Save hall instance");
		hallService.editHall(hall);
		return "redirect:hallList";
	}
	
	
	@RequestMapping(value="/CreatCourtInHall", method=RequestMethod.GET)
	public ModelAndView CreatCourtInHall(@RequestParam("hallId") ObjectId hallId) {
		
		

		Court court = new Court();
		Map<String,Object>model = new HashMap<String,Object>();
		model.put("hallId", hallId);
		model.put("court", court);
		return new ModelAndView("hall/newCourt", model);
	}
	
	@RequestMapping(value="/saveCourtinHall", method=RequestMethod.POST)
	public String createCourtinHall(@RequestParam("hallId") ObjectId hallId,@ModelAttribute("court") Court court,
			BindingResult result, Model model) {
		logger.info("Save court instance");
		
		Hall hall =hallService.getHall(hallId);
		court.setHall(hall);
		//hall.addCourt(court);
		//List<Court> courts=hall.getCourts();
		
		courtService.saveCourt(court);
		
		
		/*  Query query = new Query(Criteria.where("name").is(hall.getName()));
		  Update update=new Update();
		  update.set("courts", courts);
		  mongoTemplate.updateFirst(query, update, Hall.class);*/
		
		
		//hallService.saveHall(hall);
		return "redirect:courtList";
	}
	
	@RequestMapping(value="/setAdmin", method=RequestMethod.GET)
	public ModelAndView AdminList(@RequestParam("hallId") ObjectId hallId) {
		logger.info("Listing capabilities.");
		Collection<Admin> admins = adminService.getAdmins();
		
		
		
		Map<String,Object>model = new HashMap<String,Object>();
		model.put("hallId",hallId);
		model.put("admins", admins);
		return new ModelAndView("hall/adminList", model);
	}
	
	@RequestMapping(value="/AdminLink", method=RequestMethod.GET)
	public String AdminLink(@RequestParam("hallId") ObjectId hallId,@RequestParam("adminId") ObjectId adminId) {
		
		Hall h =hallService.getHall(hallId);
		Admin a= adminService.getAdmin(adminId);
		
		Collection<Admin> admins = adminService.getAdmins();
		for(Admin admin: admins)
			
		{
			System.out.println("pa1   "+admin.getHallId());
			System.out.println("pa2   "+hallId);
			if(admin.getHallId().equals(hallId))
			{
				admin.setHallId(null);
				adminService.saveAdmin(admin);
				System.out.println("pa2  set");
			}
		}
		
		a.setHallId(h.getId());
		
		
		adminService.saveAdmin(a);
		
		
		return "redirect:hallList";
	}
	
	@RequestMapping(value="/checkAdmin", method=RequestMethod.GET)
	public ModelAndView checkAdmin(@RequestParam("hallId") ObjectId hallId) {
		logger.info("Listing capabilities.");
		Collection<Admin> admins = adminService.getAdmins();
		Admin aa= new Admin();
		for(Admin a: admins)
			
			
			
		{
			if(a.getHallId().equals(hallId))
			{
				aa=a;
			}
		}
		
		
		
		Map<String,Object>model = new HashMap<String,Object>();
		model.put("admin", aa);
		return new ModelAndView("hall/checkAdmin", model);
	}

	
	
}
