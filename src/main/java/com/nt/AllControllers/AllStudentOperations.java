package com.nt.AllControllers;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.DTO.UpdateDTO;
import com.nt.service.JobsService;
import com.nt.service.RecruterService;
import com.nt.service.StudentsService;
@CrossOrigin(origins ="http://localhost:5173")
@RestController
@RequestMapping("/student")
public class AllStudentOperations {
	
	@Autowired
	private StudentsService std;
	@Autowired
	private JobsService js;
	@Autowired
	private RecruterService rs;
	
	
	@PostMapping("/apply-to-job")
	public ResponseEntity<?> applyToJob(@RequestBody Map<String,Object> data)
	{
		System.out.println("the info"+data);
		boolean status=false;
		if(std.findStudent((String)data.get("student_mailid")).isPresent())
		{
			boolean b=js.findJobAndApply(data);
			if(b)
			{
				status=std.updateStudentAppliedJob(data);
				
			 
			
			}
			
			
		}
		return status?new ResponseEntity<>("job applied",HttpStatus.OK):new ResponseEntity<>("error while applying job",HttpStatus.NOT_FOUND);
		
		
		
	}
	@PatchMapping("/with-draw-application/{mailid}/{jobid}")
	public ResponseEntity<?> withDrawApplication(@PathVariable String mailid,@PathVariable String jobid)
	{
		boolean val=std.withDrawApplication(mailid, jobid);
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

}
