package com.nt.AllControllers;

import java.util.List;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import com.nt.DTO.JobUpdateDTO;
import com.nt.DTO.RecruterDTO;
import com.nt.DTO.StudentDTO;
import com.nt.DTO.UpdateDTO;
import com.nt.enitity.Jobs;
import com.nt.enitity.Recruter;
import com.nt.enitity.Students;
import com.nt.service.AllRecruterService;
import com.nt.service.JobsService;
import com.nt.service.RecruterService;
import com.nt.service.StudentsService;

@CrossOrigin(origins={"https://firstjobportal.netlify.app/","http://localhost:5173"}) 
@RestController
@RequestMapping("/portal")
public class EndPoints {
	
	 @Autowired
	 private StudentsService service;
	 @Autowired
	 private RecruterService rs;
	 @Autowired
	 private JobsService js;
	 
		
	@PostMapping("/savestudent")
	public ResponseEntity<Students> saveStudent(@RequestBody Students s)
	{
		if(service.insertStudent(s)!=null) 
		return new ResponseEntity<Students>(s,HttpStatus.CREATED);
		else
			return new ResponseEntity<Students>(s,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	@GetMapping("/verify-student")
	public ResponseEntity<?> verifyStudent(@RequestParam String mail)
	{
		Optional<Students> std=service.findStudent(mail);
		
		
		if(std.isPresent())
		{
			Students ste=std.get();
			StudentDTO s=new StudentDTO();
			s.setMailid(ste.getMailid());
			s.setId(ste.getId());
			s.setName(ste.getName());
			s.setAppliedjobs(ste.getAppliedjobs());
			
		
			
			return new ResponseEntity(s,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity("student not found",HttpStatus.NOT_FOUND);
		}
		
		
	}
	@PostMapping("/saverecruter")
	public ResponseEntity<Recruter> saveRecruter(@RequestBody Recruter r)
	{
		if(rs.createRecruter(r)!=null)
			return new ResponseEntity<Recruter>(r,HttpStatus.CREATED);
		else
			return new ResponseEntity<Recruter>(r,HttpStatus.CREATED);
			
	}
	

	@GetMapping("/get-recruter")
	public ResponseEntity<?> getRecruter(@RequestParam String mail) {
	    Optional<Recruter> optionalRecruter = rs.findByMail(mail);

	    if (optionalRecruter.isPresent()) {
	    	Recruter rec=optionalRecruter.get();
	    	RecruterDTO dt=new RecruterDTO();
	    	dt.setCompanyname(rec.getCompanyname());
	    	dt.setId(rec.getId());
	    	dt.setJobposted(rec.getJobsposted());
	    	dt.setMail(rec.getMail());
	    	dt.setName(rec.getName());
	        return new ResponseEntity(dt ,HttpStatus.OK);
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Recruter not found");
	    }
	}
	@PostMapping("/post-job")
	public ResponseEntity<?> postJob(@RequestBody Jobs j) {
	    Jobs createdJob = js.addJob(j);

	    if (createdJob!= null&&rs.addJobToRecruter(createdJob.getPostedBy(),createdJob.getId())) {
	         
	        return new ResponseEntity<>(createdJob, HttpStatus.CREATED);
	    } else {
	       
	        return new ResponseEntity<>(
	            Map.of("error", "Job insertion failed", "status", 500),
	            HttpStatus.INTERNAL_SERVER_ERROR
	        );
	    }
	}
	@GetMapping("alljobs")
	public ResponseEntity<List<Jobs>> getAllRecruterJobs(@RequestParam String recruterid)
	{
		List<Jobs> l=js.findAllJobs(recruterid);
		return new ResponseEntity<List<Jobs>>(l,HttpStatus.OK);
		 
		
	}
	@DeleteMapping("/removejob")
	public ResponseEntity<?> removeJob(@RequestParam String id,@RequestParam String rid)
	{
		System.out.println("id:"+id+" "+"rid"+rid);
		if(rs.deleteJobById(id, rid))
		{
			 boolean val=js.deleteJob(id);
			 if(val)
			 {
			return new ResponseEntity<>("Job Deleted",HttpStatus.OK);
			 }
		}
		return new ResponseEntity<>("Job not Deleted",HttpStatus.NOT_FOUND);
		
	}
	@GetMapping("/getAllJobs")
	public ResponseEntity<?> getTheAllJobsPosted()
	{
		if(js.findAllPostedJobs()!=null)
		{
			return new ResponseEntity(js.findAllPostedJobs(),HttpStatus.OK);
		}
		return new ResponseEntity("Error while Fetching data",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@PostMapping("/apply-to-job")
	public ResponseEntity<?> applyToJob(@RequestBody Map<String,Object> data)
	{
		System.out.println("the info"+data);
		boolean status=false;
		if(service.findStudent((String)data.get("student_mailid")).isPresent())
		{
			boolean b=js.findJobAndApply(data);
			if(b)
			{
				status=service.updateStudentAppliedJob(data);
				
			 
			
			}
			
			
		}
		return status?new ResponseEntity<>("job applied",HttpStatus.OK):new ResponseEntity<>("error while applying job",HttpStatus.NOT_FOUND);
		
		
		
	}
	@PatchMapping("/with-draw-application/{mailid}/{jobid}")
	public ResponseEntity<?> withDrawApplication(@PathVariable String mailid,@PathVariable String jobid)
	{
		boolean val=service.withDrawApplication(mailid, jobid);
		 boolean isdel= js.removeTheWithDrawPerson(mailid,jobid);
		if(val&&isdel)
		
	   return new ResponseEntity<>("job was withdrawed",HttpStatus.OK);
	   else
		  return new ResponseEntity<>("the job was not found",HttpStatus.NOT_FOUND);
	}
	@PatchMapping("/update-status")
	public ResponseEntity<?> updateStatusOfStudent(@RequestBody UpdateDTO dto)
	{
		System.out.println(dto);
		if(rs.updateStatus(dto))
		{
			return new ResponseEntity<>("status of student updated",HttpStatus.OK);
		}
		
		return new ResponseEntity<>("error while updating",HttpStatus.NOT_FOUND);
		
	}
     @PutMapping("/update-job")
     public ResponseEntity<?> updateJob(@RequestBody JobUpdateDTO dto)
     {
    	  boolean val=js.jobDataUpdate(dto);
    	  if(val)
    		  return new ResponseEntity<>("job updated",HttpStatus.OK);
    	  
		return new ResponseEntity<>("job not found",HttpStatus.NOT_FOUND);
    	 
     }
	

}
