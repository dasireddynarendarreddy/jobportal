package com.nt.enitity;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection="jobsposted")
public class Jobs {
	
	@Id
	private String id;
	private String companyname;
	private String jobtitle;
	private String description;
	private String location;
	private List<String> skills;
	private String postedBy;
	private String postedOn;
	private Integer appliedBy=0;
	private List<Map<String,Object>> appliedMembers=new ArrayList<>();
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getJobtitle() {
		return jobtitle;
	}
	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPostedBy() {
		return postedBy;
	}
	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}
	public Integer getAppliedBy() {
		return appliedBy;
	}
	public void setAppliedBy(Integer appliedBy) {
		this.appliedBy = appliedBy;
	}
	public String getPostedOn() {
		return postedOn;
	}
	public void setPostedOn(String postedOn) {
		this.postedOn = postedOn;
	}
	public List<Map<String, Object>> getAppliedMembers(){
	    return appliedMembers;
	}

	public void setAppliedMembers(List<Map<String, Object>> appliedMembers){
	    this.appliedMembers = appliedMembers;
	}

}
