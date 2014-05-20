package org.groept.cloudMigration.service.impl;

import java.util.List;

import org.bson.types.ObjectId;
import org.groept.cloudMigration.dao.ReservationDao;
import org.groept.cloudMigration.dao.SubscriberDao;
import org.groept.cloudMigration.model.CacheRecord;
import org.groept.cloudMigration.model.Reservation;
import org.groept.cloudMigration.model.Subscriber;
import org.groept.cloudMigration.service.CacheRecordService;
import org.groept.cloudMigration.service.ReservationService;
import org.groept.cloudMigration.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class SubscriberServiceImpl implements SubscriberService {

	@Autowired
	private SubscriberDao subscriberDao;
	@Autowired
	private ReservationDao reservationDao;
	//@Autowired
	//private CacheRecordService cacheRecordService; 
	
	
	
	@Override
	public void saveSubscriber(Subscriber subscriber) {
		// TODO Auto-generated method stub
		subscriberDao.save(subscriber);
	}
	@Override
	public void editSubscriber(Subscriber subscriber) {
		// TODO Auto-generated method stub
		subscriberDao.save(subscriber);
	}

	@Override
	public void deleteSubscriber(ObjectId subscriberId) {
		// TODO Auto-generated method stub
		subscriberDao.delete(subscriberDao.findById(subscriberId));
	}

	@Override
	public Subscriber getSubscriber(ObjectId subscriberId) {
		// TODO Auto-generated method stub
		return subscriberDao.findById(subscriberId);
	}
	
	@Override
	public List getSubscribers() {
		// TODO Auto-generated method stub
		
		return (List) subscriberDao.findAll();
	}
	
	@Override
	public void addReservationtoPerson(ObjectId subscriberId,Reservation reservation)
	{
		
		Subscriber s=subscriberDao.findById(subscriberId);
		
		s.addReservation(reservation);
		reservation.setSubscriber(s);
		
		
		reservationDao.save(reservation);
		
		subscriberDao.save(s);
		
		
		
	}

}
