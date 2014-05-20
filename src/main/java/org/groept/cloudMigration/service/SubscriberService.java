package org.groept.cloudMigration.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.groept.cloudMigration.model.Reservation;
import org.groept.cloudMigration.model.Subscriber;


public interface SubscriberService {

	public void saveSubscriber(Subscriber subscriber);
	public void editSubscriber(Subscriber subscriber);
	public void deleteSubscriber(ObjectId subscriberId);
	public Subscriber getSubscriber(ObjectId subscriberId);
	public List getSubscribers();
	public void addReservationtoPerson(ObjectId subscriverId, Reservation reservationId);
}
