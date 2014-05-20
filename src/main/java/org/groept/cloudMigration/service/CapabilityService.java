package org.groept.cloudMigration.service;

import java.util.List;
import java.util.Set;

import org.bson.types.ObjectId;
import org.groept.cloudMigration.model.Capability;
import org.groept.cloudMigration.model.Court;


public interface CapabilityService {

	public void saveCapability(Capability capability);
	public void editCapability(Capability capability);
	public void deleteCapability(ObjectId capabilityId);
	public Capability getCapability(ObjectId capabilityId);
	public List getCapabilities();
	public List<Court> getCourts(ObjectId capId);
}
