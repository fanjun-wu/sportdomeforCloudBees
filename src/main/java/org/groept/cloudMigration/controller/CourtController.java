package org.groept.cloudMigration.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bson.types.ObjectId;
import org.groept.cloudMigration.model.CacheRecord;
import org.groept.cloudMigration.model.Capability;
import org.groept.cloudMigration.model.Court;
import org.groept.cloudMigration.service.CacheRecordService;
import org.groept.cloudMigration.service.CapabilityService;
import org.groept.cloudMigration.service.CourtService;
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
public class CourtController {

private static final Logger logger = LoggerFactory.getLogger(CourtController.class);
	
	private CourtService courtService;
	
	private CapabilityService capabilityService;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private CacheRecordService cacheRecordService; 

	
	@RequestMapping(value="/courtList", method=RequestMethod.GET)
	public ModelAndView list() {
		logger.info("Listing courts.");
		
		
		Collection<Court> courts = courtService.getCourts();
		Map<String,Object>model = new HashMap<String,Object>();
		model.put("courts", courts);
		return new ModelAndView("court/courtList", model);
	}
	
	
	
	
	

	@RequestMapping(value="/getCourt", method=RequestMethod.GET)
	public ModelAndView fetchCourt(@RequestParam("courtId") ObjectId courtId) {
		logger.info("Fetching court " + courtId);
		

		CacheRecord cacheRecord=new CacheRecord(1,0,new java.util.Date());
		cacheRecordService.saveCacheRecord(cacheRecord);
		
		
		Court court = courtService.getCourt(courtId);
		Map<String,Object>modelAndView = new HashMap<String,Object>();
		modelAndView.put("court", court);
		return new ModelAndView("court/modifyCourt", modelAndView);
	}
	
	
	@RequestMapping(value="/deleteCourt", method=RequestMethod.GET)
	public String deleteCourt(@RequestParam("courtId") ObjectId courtId) {
		logger.info("Deleting court " + courtId);
		
		for(Capability cap :courtService.listofCapabilitys(courtId))
		{
			Set<ObjectId> ids=new HashSet<ObjectId>();
			ids=cap.getCourts();
			
			for(ObjectId i :ids)
			{
				if(i.equals(courtId))
				{
					ids.remove(i);
				}
			}
			
				Query query3 = new Query(Criteria.where("id").is(cap.getId()));
			  Update update3=new Update();
			  update3.set("courts", ids);
			  mongoTemplate.updateFirst(query3, update3, Capability.class);
		}
		
		
		courtService.deleteCourt(courtId);
		return "redirect:courtList";
	}
	
	
	
	@RequestMapping(value="/newCourt", method=RequestMethod.GET)
	public ModelAndView newCourt() {
		logger.info("Create new court instance");
		Court court = new Court();
		Map<String,Object>model = new HashMap<String,Object>();
		model.put("court", court);
		return new ModelAndView("court/newCourt", model);
	}
	
	
	
	@RequestMapping(value="/saveCourt", method=RequestMethod.POST)
	public String createCourt(@ModelAttribute("court") Court court,
			BindingResult result, Model model) {
		logger.info("Save court instance");
		courtService.saveCourt(court);
		return "redirect:courtList";
	}
	
	@RequestMapping(value="/updateCourt", method=RequestMethod.POST)
	public String updateCourt(@ModelAttribute("court") Court court,
			BindingResult result, Model model) {
		logger.info("Save court instance");
		courtService.editCourt(court);
		return "redirect:courtList";
	}
	
	@RequestMapping(value="/showCourtCapList", method=RequestMethod.GET)
	public ModelAndView listofCap(@RequestParam("courtId") ObjectId courtId) {
		logger.info("Listing courts.");
		
		Collection<Capability> capabilities = courtService.listofCapabilitys(courtId);
		Map<String,Object>model = new HashMap<String,Object>();
		model.put("capabilities", capabilities);
		return new ModelAndView("court/capabilityList", model);
	}
	
	
	@RequestMapping(value="/addcoutcap", method=RequestMethod.GET)
	public ModelAndView caplist(@RequestParam("courtId") ObjectId courtId) {
		logger.info("Listing capabilities.");
		Collection<Capability> capabilities = capabilityService.getCapabilities();
		/*Court c =courtService.getCourt(courtId);
		
		for(Capability cap: capabilities)
		{
			if(c.getCapabilitiesName().contains(cap.getResource()))
			{
				capabilities.remove(cap);
			}
		}*/
		
		
		Map<String,Object>model = new HashMap<String,Object>();
		model.put("courtId",courtId);
		model.put("capabilities", capabilities);
		return new ModelAndView("court/addcoutcap", model);
	}
	
	@RequestMapping(value="/capaCourtLink", method=RequestMethod.GET)
	public String capaCourtLink(@RequestParam("capabilityId") ObjectId capabilityId,@RequestParam("courtId") ObjectId courtId) {
		
Court c =courtService.getCourt(courtId);
		
		Capability cap= capabilityService.getCapability(capabilityId);
		
		List<ObjectId> courtname=new ArrayList<ObjectId>();
		Set<ObjectId> capname=new HashSet<ObjectId>();
		
		cap.getCourts().add(c.getId());
	c.getCapabilities().add(cap.getId());
		
		  Query query = new Query(Criteria.where("id").is(c.getId()));
		  Update update=new Update();
		  update.set("capabilities", c.getCapabilities());
		  mongoTemplate.updateFirst(query, update, Court.class);
		  
		  Query query2 = new Query(Criteria.where("id").is(cap.getId()));
		  Update update2=new Update();
		  update2.set("courts", cap.getCourts());
		  mongoTemplate.updateFirst(query2, update2, Capability.class);
		  
		/*c.addCapability(cap);
		cap.addCourt(c);
		
		courtService.saveCourt(c);
		capabilityService.saveCapability(cap);*/
		
		
		return "redirect:courtList";
	}
	
	

	
	@Autowired
	public void setCourtService(CourtService courtService) {
		this.courtService = courtService;
	}
	@Autowired
	public void setCapabilityService(CapabilityService capabilityService) {
		this.capabilityService = capabilityService;
	}
}
