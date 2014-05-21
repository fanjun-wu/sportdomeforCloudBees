package org.groept.cloudMigration.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.bson.types.ObjectId;
import org.groept.cloudMigration.dao.AdminDao;
import org.groept.cloudMigration.model.Admin;
import org.groept.cloudMigration.model.CacheRecord;
import org.groept.cloudMigration.model.Capability;
import org.groept.cloudMigration.service.AdminService;
import org.groept.cloudMigration.service.CacheRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private CacheRecordService cacheRecordService; 
	
	
	@Override
	public void saveAdmin(Admin admin) {
		// TODO Auto-generated method stub
		adminDao.save(admin);
	}
	@Override
	public void editAdmin(Admin admin) {
		// TODO Auto-generated method stub
				
		  Query query = new Query(Criteria.where("id").is(admin.getId()));
		  Update update=new Update();
		  update.set("name", admin.getName());
		  update.set("email", admin.getEmail());
		  update.set("telephone", admin.getTelephone());
		  update.set("gender", admin.getGender());
		  update.set("age", admin.getAge());
		  update.set("privilege", admin.getPrivilege());
		  mongoTemplate.updateFirst(query, update, Admin.class);
		
	
	}

	@Override
	public void deleteAdmin(ObjectId adminId) {
		// TODO Auto-generated method stub
		adminDao.delete(adminDao.findById(adminId));
	}

	@Override
	public Admin getAdmin(ObjectId adminId) {
		// TODO Auto-generated method stub
		return adminDao.findById(adminId);
	}
	
	@Override
	public List getAdmins() {
		// TODO Auto-generated method stub
		
		
		return (List) adminDao.findAll();
	}

	
}
