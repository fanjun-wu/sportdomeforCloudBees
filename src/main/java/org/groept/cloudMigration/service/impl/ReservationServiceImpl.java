package org.groept.cloudMigration.service.impl;

import java.util.List;

import org.bson.types.ObjectId;
import org.groept.cloudMigration.dao.ReservationDao;
import org.groept.cloudMigration.dao.TimeIntervalDao;
import org.groept.cloudMigration.model.CacheRecord;
import org.groept.cloudMigration.model.Reservation;
import org.groept.cloudMigration.model.TimeInterval;
import org.groept.cloudMigration.service.CacheRecordService;
import org.groept.cloudMigration.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService{

	@Autowired
	private ReservationDao reservationDao;
	@Autowired
	private TimeIntervalDao timeIntervalDao;
	//@Autowired
	//private CacheRecordService cacheRecordService; 
	
	
	
	@Override
	public void saveReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		reservationDao.save(reservation);
	}
	@Override
	public void editReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		reservationDao.save(reservation);
	}

	@Override
	public void deleteReservation(ObjectId reservationId) {
		// TODO Auto-generated method stub
		reservationDao.delete(reservationDao.findById(reservationId));
	}

	@Override
	public Reservation getReservation(ObjectId reservationId) {
		// TODO Auto-generated method stub
		return reservationDao.findById(reservationId);
	}
	

	@Override
	public List getReservations() {
		// TODO Auto-generated method stub
		
		return (List) reservationDao.findAll();
	}
	
	@Override
	public void addTimeInterval(ObjectId tId, ObjectId rId)
	{
		TimeInterval t=timeIntervalDao.findById(tId);
		Reservation r=reservationDao.findById(rId);
				
		
		r.addTimeInterval(t);
		
		t.addReservation(r);
		
		
		saveReservation(r);
		timeIntervalDao.save(t);
		
		
		
	}
}
