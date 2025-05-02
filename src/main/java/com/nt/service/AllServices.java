package com.nt.service;

import java.util.Map;

		


import java.util.Optional;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.client.result.UpdateResult;
import com.nt.enitity.Students;
import com.nt.repositry.PortalStudent;


@Service
public class AllServices implements StudentsService{
	 @Autowired
	 PortalStudent std;
	
	@Autowired
	private MongoTemplate temp;
	


	@Override
	public Students insertStudent(Students student) {
		  
		return std.save(student);
	}



	@Override
	public Optional<Students> findStudent(String mail) {
	
		
		return std.findByMailid(mail);
		
	}



	@Override
	public boolean updateStudentAppliedJob(Map<String, Object> info) {
		   Query query=new Query(Criteria.where("mailid").is((String)info.get("student_mailid")));
		   Update update=new Update().push("appliedjobs",Map.of("jobid",(String)info.get("id"),"status","applied"));
		   UpdateResult result=temp.updateFirst(query, update,Students.class);
		return result.getModifiedCount()>0;
	}



	@Override
	public boolean withDrawApplication(String mail,String jobid) {
		  Query query=new Query(Criteria.where("mailid").is(mail));
		   Update update=new Update().pull("appliedjobs",new Document("jobid",jobid));
		   UpdateResult result=temp.updateFirst(query, update,Students.class);
		return result.getModifiedCount()>0;
	
		
	}

}
