package org.groept.cloudMigration.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.bson.types.ObjectId;
import org.groept.cloudMigration.dao.TimeIntervalDao;
import org.groept.cloudMigration.model.CacheRecord;
import org.groept.cloudMigration.model.Capability;
import org.groept.cloudMigration.model.Reservation;
import org.groept.cloudMigration.model.TimeInterval;
import org.groept.cloudMigration.service.CacheRecordService;
import org.groept.cloudMigration.service.TimeIntervalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class TimeIntervalServiceImpl implements TimeIntervalService {

	@Autowired
	private TimeIntervalDao timeIntervalDao;
	
	//@Autowired
	//private CacheRecordService cacheRecordService; 
	
	
	@Override
	public void saveTimeInterval(TimeInterval timeInterval) {
		// TODO Auto-generated method stub
		timeIntervalDao.save(timeInterval);
	}
	@Override
	public void editTimeInterval(TimeInterval timeInterval) {
		// TODO Auto-generated method stub
		
		Set<Reservation> res=timeIntervalDao.findById(timeInterval.getId()).getReservation();
		timeInterval.setReservation(res);
		
		timeIntervalDao.save(timeInterval);
	}

	@Override
	public void deleteTimeInterval(ObjectId timeIntervalId) {
		// TODO Auto-generated method stub
		timeIntervalDao.delete(timeIntervalDao.findById(timeIntervalId));
	}

	@Override
	public TimeInterval getTimeInterval(ObjectId timeIntervalId) {
		// TODO Auto-generated method stub
		return timeIntervalDao.findById(timeIntervalId);
	}
	
	@Override
	public List getTimeIntervals() {
		// TODO Auto-generated method stub
					
		return (List) timeIntervalDao.findAll();
	}
	
	@Override
	public List getTimeIntervalByDate(Date date) {
		// TODO Auto-generated method stub
		List<TimeInterval> timeIntervalsTemp=new ArrayList<TimeInterval>();
		List<TimeInterval> timeIntervals=new ArrayList<TimeInterval>();
		timeIntervalsTemp=this.getTimeIntervals();
		for(TimeInterval t:timeIntervalsTemp)
		{
			if( t.getDate()==date)
			{
				timeIntervals.add(t);
			}
		}
		return timeIntervals;
		
		
	}
	
	@Override
	public void saveTimeSet(Set<TimeInterval> tals) {
		// TODO Auto-generated method stub
		timeIntervalDao.save(tals);
	}
	
}
