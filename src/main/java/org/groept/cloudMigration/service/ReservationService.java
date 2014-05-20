package org.groept.cloudMigration.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.groept.cloudMigration.model.Reservation;


public interface ReservationService {

	public void saveReservation(Reservation reservation);
	public void editReservation(Reservation reservation);
	public void deleteReservation(ObjectId reservationId);
	public Reservation getReservation(ObjectId reservationId);
	public List getReservations();
	public void addTimeInterval(ObjectId tId, ObjectId rId);
}
