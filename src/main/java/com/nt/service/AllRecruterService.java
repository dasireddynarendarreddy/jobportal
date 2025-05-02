package com.nt.service;

import java.util.List;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.mongodb.client.result.UpdateResult;
import com.nt.DTO.UpdateDTO;
import com.nt.enitity.Jobs;
import com.nt.enitity.Recruter;
import com.nt.enitity.Students;
import com.nt.repositry.PortalRecruter;
@Service
public class AllRecruterService implements RecruterService {
	@Autowired
	private PortalRecruter pr;
	@Autowired
	private MongoTemplate temp;

	@Override
	public Recruter createRecruter(Recruter r) {
		
		return pr.save(r);
	}

	@Override
	public Optional<Recruter> findByMail(String mail) {
		
		return pr.findOptionalByMail(mail);
	}

	@Override
	public boolean addJobToRecruter(String postedBy, String id) {
		Query  query=new Query(Criteria.where("_id").is(new ObjectId(postedBy)));
	    Update update=new Update().push("jobsposted", id);
	    UpdateResult result=temp.updateFirst(query, update, Recruter.class);
		return result.getModifiedCount()>0;
		
	}

	@Override
	public boolean deleteJobById(String id, String rid) {
		Query query=new Query(Criteria.where("_id").is(new ObjectId(rid)));
		Update update=new Update().pull("jobsposted",id);
		UpdateResult result=temp.updateFirst(query, update,Recruter.class);
		return result.getModifiedCount()>0;
	}

	@Override
	public boolean updateStatus(UpdateDTO dto) {
		Query query=new Query(Criteria.where("_id").is(new ObjectId(dto.getStudent_id())).and("appliedjobs.jobid").is(dto.getId()));
		Update update=new Update().set("appliedjobs.$.status",dto.getStatus());
		UpdateResult result=temp.updateFirst(query, update,Students.class);

		return result.getModifiedCount()>0;
	}

	

	

	
	

	

	


}
