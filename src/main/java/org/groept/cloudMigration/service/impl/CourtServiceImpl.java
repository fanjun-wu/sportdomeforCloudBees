package org.groept.cloudMigration.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.bson.types.ObjectId;
import org.groept.cloudMigration.dao.CapabilityDao;
import org.groept.cloudMigration.dao.CourtDao;
import org.groept.cloudMigration.dao.HallDao;
import org.groept.cloudMigration.model.CacheRecord;
import org.groept.cloudMigration.model.Capability;
import org.groept.cloudMigration.model.Court;
import org.groept.cloudMigration.model.Hall;
import org.groept.cloudMigration.model.Reservation;
import org.groept.cloudMigration.service.CacheRecordService;
import org.groept.cloudMigration.service.CourtService;
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
public class CourtServiceImpl implements CourtService{

	@Autowired
	private CourtDao courtDao;
	@Autowired
	private HallDao hallDao;
	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private CapabilityDao capabilityDao;
	
	@Autowired
	private CacheRecordService cacheRecordService; 
	
	@Override
	public void saveCourt(Court court) {
		// TODO Auto-generated method stub
		courtDao.save(court);
		
	}
	@CacheEvict(value = "courts",key = "new String(#court.id).concat('.Court')")
	@Override
	public void editCourt(Court court) {
		// TODO Auto-generated method stub
		
		System.out.println("inside editCourt()");
		
		courtDao.save(court);
		
	}

	@CacheEvict(value = "courts",key = "new String(#courtId).concat('.Court')")
	@Override
	public void deleteCourt(ObjectId courtId) {
		// TODO Auto-generated method stub
		
		System.out.println("inside deleteCourt()");
		
		courtDao.delete(courtDao.findById(courtId));
	
	}

	@Cacheable(value = "courts",key = "new String(#courtId).concat('.Court')")
	@Override
	public Court getCourt(ObjectId courtId) {
		// TODO Auto-generated method stub
		
		System.out.println("inside get Single court ()");

		CacheRecord cacheRecord=new CacheRecord(0,1,new java.util.Date());
		cacheRecordService.saveCacheRecord(cacheRecord);
		
		return courtDao.findById(courtId);
	}
	
	
	@Override
	public List getCourts() {
		// TODO Auto-generated method stub
		
		System.out.println("inside getCourts()");
		
		return (List) courtDao.findAll();
	}
	
	
	
	@Override
	public Hall getHall() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Court getCourtByName(String _nameOfCourtRecieved) {
		// TODO Auto-generated method stub
		return courtDao.findByname(_nameOfCourtRecieved);
	}
	@Override
	public void saveAllCourt(Set<Court> allCourts) {
		// TODO Auto-generated method stub
		courtDao.save(allCourts);
	}
	@Override
	public List<Capability> listofCapabilitys(ObjectId courtId) {
		// TODO Auto-generated method stub
		Court c=getCourt(courtId);
		List<Capability> cap= new ArrayList<Capability>();
		List<Capability> cap2=(List<Capability>) capabilityDao.findAll();
		for(Capability cc: cap2)
		{
			
			for(ObjectId id :cc.getCourts())
			{
				if(id.equals(courtId))
				{
					cap.add(cc);
				}
			}
			
			
		}
		return cap;
	}

	
	@Override
	public List<Reservation> listofReservations(ObjectId courtId){
		
		Court c=courtDao.findById(courtId);
		
		Query query = new Query(Criteria.where("court").is(c));
		
		
		return (List<Reservation>)mongoTemplate.find(query, Reservation.class);
	
	}
	
	
}
