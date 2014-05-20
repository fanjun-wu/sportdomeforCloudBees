package org.groept.cloudMigration.service;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.bson.types.ObjectId;
import org.groept.cloudMigration.model.Capability;
import org.groept.cloudMigration.model.Court;
import org.groept.cloudMigration.model.Hall;
import org.groept.cloudMigration.model.Reservation;
import org.groept.cloudMigration.model.TimeInterval;


public interface CourtService{
	public void saveCourt(Court court);
	public void editCourt(Court court);
	public void deleteCourt(ObjectId courtId);
	public Court getCourt(ObjectId courtId);
	public List getCourts();
	public Hall getHall();
	public Court getCourtByName(String _nameOfCourtRecieved);
	public void saveAllCourt(Set<Court> allCourts );
	public List<Capability> listofCapabilitys(ObjectId courtId);
	List<Reservation> listofReservations(ObjectId courtId);
}
