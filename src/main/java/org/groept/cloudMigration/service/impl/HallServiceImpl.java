package org.groept.cloudMigration.service.impl;

import java.util.List;
import java.util.Set;

import org.bson.types.ObjectId;
import org.groept.cloudMigration.dao.CourtDao;
import org.groept.cloudMigration.dao.HallDao;
import org.groept.cloudMigration.model.Admin;
import org.groept.cloudMigration.model.CacheRecord;
import org.groept.cloudMigration.model.Court;
import org.groept.cloudMigration.model.Hall;
import org.groept.cloudMigration.service.CacheRecordService;
import org.groept.cloudMigration.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HallServiceImpl implements HallService {

	@Autowired
	private HallDao hallDao;
	@Autowired
	private CourtDao courtDao;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private CacheRecordService cacheRecordService; 
	
	
	@Override
	public void saveHall(Hall hall) {
		// TODO Auto-generated method stub
		System.out.println("Save Hall");
		
		hallDao.save(hall);
	}
	
	@CacheEvict(value = "halls",key = "new String(#hall.id).concat('.Hall')")
	@Override
	public void editHall(Hall hall) {
		// TODO Auto-generated method stub
		
		System.out.println("Edit Hall");
		
		Admin ad=hallDao.findById(hall.getId()).getAdmin();
		hall.setAdmin(ad);
		
		
		hallDao.save(hall);
	}

	@CacheEvict(value = "halls",key = "new String(#hallId).concat('.Hall')")
	@Override
	public void deleteHall(ObjectId hallId) {
		// TODO Auto-generated method stub
		
		
		
		System.out.println("delete Hall");
		hallDao.delete(hallDao.findById(hallId));
	}
	
	@Cacheable(value = "halls",key = "new String(#hallId).concat('.Hall')")
	//@Cacheable(value = "halls",key = "new Integer(9999999).toString().concat('.Hall')")
	@Override
	public Hall getHall(ObjectId hallId) {
		// TODO Auto-generated method stub
		
		System.out.println("get single Hall");
		
		CacheRecord cacheRecord=new CacheRecord(0,1,new java.util.Date());
		cacheRecordService.saveCacheRecord(cacheRecord);
	
		
		
		return hallDao.findById(hallId);
	}
	
	
	@Override
	public List<Hall> getHalls() {
		// TODO Auto-generated method stub
		
		
		return (List<Hall>) hallDao.findAll();
	}
	@Override
	public void addCourt(ObjectId hallId, ObjectId courtId) {
		// TODO Auto-generated method stub
		
		Court c=courtDao.findById(courtId);
		
		Hall h=hallDao.findById(hallId);
		c.setHall(h);
		
		//h.addCourt(c);
		
		//hallDao.save(h);
		courtDao.save(c);
		

	}
	
	
	
	@Override
	public List<Court> listofCourts(ObjectId hallId){
		
		Hall h=hallDao.findById(hallId);
		
		Query query = new Query(Criteria.where("hall").is(h));
		
		
		return (List<Court>)mongoTemplate.find(query, Court.class);
	
	}
	
	
	

}
