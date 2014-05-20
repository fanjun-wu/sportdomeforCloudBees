package org.groept.cloudMigration.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.groept.cloudMigration.model.Admin;

public interface AdminService {
	public void saveAdmin(Admin admin);
	public void editAdmin(Admin admin);
	public void deleteAdmin(ObjectId adminId);
	public Admin getAdmin(ObjectId adminId);
	public List getAdmins();
}
