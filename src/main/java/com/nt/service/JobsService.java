package com.nt.service;

import java.util.List;

import java.util.Map;

import com.nt.DTO.JobUpdateDTO;
import com.nt.enitity.Jobs;

public interface JobsService {
	public Jobs addJob(Jobs j);
	public List<Jobs> findAllJobs(String id);
	public boolean deleteJob(String id);
	public boolean findJobAndApply(Map<String,Object> info);
	public boolean removeTheWithDrawPerson(String jobid,String studentid);
	public List<Jobs> findAllPostedJobs();
	public boolean jobDataUpdate(JobUpdateDTO dto);
}
