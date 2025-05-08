package com.nt.service;

import java.util.List;

import java.util.Map;
import java.util.Optional;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.mongodb.client.result.UpdateResult;
import com.nt.DTO.JobUpdateDTO;
import com.nt.enitity.Jobs;
import com.nt.repositry.PortalJobs;
@Service
public class AllJobService implements JobsService {
	
	@Autowired
	private PortalJobs pj;
	@Autowired
	private MongoTemplate mt;
	
	@Override
	public Jobs addJob(Jobs j) {
		
		return pj.save(j);
	}
    public List<Jobs> findAllJobs(String id)
    {
    	return pj.findByPostedBy(id);
    }
	@Override
	public boolean deleteJob(String id) {
		boolean val=false;
		if(pj.existsById(id))
		{
			
		  pj.deleteById(id);
		   System.err.println("job deleted!");
		  val=true;
		}
		else
		{
			val=false;
		}
		return val;
	
	}
	@Override
	public boolean findJobAndApply(Map<String,Object> info) {
		
			Query query=new Query(Criteria.where("_id").is(new ObjectId((String)info.get("id"))));
			Update update=new Update().push("appliedMembers", info);
			UpdateResult res=mt.updateFirst(query, update,Jobs.class);
		
		return res.getModifiedCount()>0;
	}
	@Override
	public boolean removeTheWithDrawPerson(String mailid,String jobid) {
		Query query=new Query(Criteria.where("_id").is(new ObjectId(jobid)));
		Update update=new Update().pull("appliedMembers",new Document("student_mailid", mailid));
		UpdateResult result=mt.updateFirst(query, update, Jobs.class);
		System.out.println("the job withdrawed");
		return result.getModifiedCount()>0;
	}
	@Override
	public List<Jobs> findAllPostedJobs() {
		
		return pj.findAll();
	}
	@Override
	public boolean jobDataUpdate(JobUpdateDTO dto) {
		boolean status=true;
		Query query=new Query(Criteria.where("_id").is(new ObjectId(dto.getId())));
		Update update=new Update();
		dto.getCompanyname().ifPresent(cname->update.set("companyname",cname));
		dto.getDescription().ifPresent(desc->update.set("description", desc));
		dto.getJobtitle().ifPresent(title->update.set("jobtitle", title));
		dto.getLocation().ifPresent(loc->update.set("location", loc));
		dto.getSkills().ifPresent(skills->update.set("skills", skills));
		Jobs res=mt.findAndModify(query, update, Jobs.class);
		if(res==null)
		{
			status=false;
		}
		
		return status;
	}
}
