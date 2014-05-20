package org.groept.cloudMigration.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.groept.cloudMigration.dao.CapabilityDao;
import org.groept.cloudMigration.dao.CourtDao;
import org.groept.cloudMigration.model.CacheRecord;
import org.groept.cloudMigration.model.Capability;
import org.groept.cloudMigration.model.Court;
import org.groept.cloudMigration.service.CacheRecordService;
import org.groept.cloudMigration.service.CapabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class CapabilityServiceImpl  implements CapabilityService{

	
	@Autowired
	private CapabilityDao capabilityDao;
	@Autowired
	private CourtDao courtDao;
	
	
	@Autowired
	private CacheRecordService cacheRecordService; 
	
	@Override
	public void saveCapability(Capability capability) {
		// TODO Auto-generated method stub
		capabilityDao.save(capability);
	}
	@CacheEvict(value = "capabilities",key = "new String(#capability.id).concat('.Capability')")
	@Override
	public void editCapability(Capability capability) {
		// TODO Auto-generated method stub
		
		System.out.println("edit Capability()");
		capabilityDao.save(capability);
	}

	@CacheEvict(value = "capabilities",key = "new String(#capabilityId).concat('.Capability')")
	@Override
	public void deleteCapability(ObjectId capabilityId) {
		// TODO Auto-generated method stub
		System.out.println("delete single Capability()");
		
		capabilityDao.delete(capabilityDao.findById(capabilityId));
	}

	@Cacheable(value = "capabilities",key = "new String(#capabilityId).concat('.Capability')")
	@Override
	public Capability getCapability(ObjectId capabilityId) {
		// TODO Auto-generated method stub
		
		System.out.println("get single Capability()");
		
		CacheRecord cacheRecord=new CacheRecord(0,1,new java.util.Date());
		cacheRecordService.saveCacheRecord(cacheRecord);			
		return capabilityDao.findById(capabilityId);
	}
	

	@Override
	public List getCapabilities() {
		// TODO Auto-generated method stub
		
		System.out.println("getCapabilities()");
		
		return (List) capabilityDao.findAll();
	}
	
	public List<Court> getCourts(ObjectId capId)
	{
		Capability cap=getCapability(capId);
		List<Court> c= new ArrayList<Court>();
		List<Court> c2=(List<Court>) courtDao.findAll();
		for(Court cc: c2)
		{
			
			for(ObjectId id :cc.getCapabilities())
			{
				if(id.equals(capId))
				{
					c.add(cc);
				}
			}
			
			
		}
		return c;

		
	}
}
