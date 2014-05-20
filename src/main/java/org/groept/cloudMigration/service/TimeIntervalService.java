package org.groept.cloudMigration.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.bson.types.ObjectId;
import org.groept.cloudMigration.model.TimeInterval;


public interface TimeIntervalService {

	public void saveTimeInterval(TimeInterval timeInterval);
	public void editTimeInterval(TimeInterval timeInterval);
	public void deleteTimeInterval(ObjectId timeIntervalId);
	public TimeInterval getTimeInterval(ObjectId timeIntervalId);
	public List getTimeIntervals();
	
	void saveTimeSet(Set<TimeInterval> tals);
	public List getTimeIntervalByDate(Date date);
}
