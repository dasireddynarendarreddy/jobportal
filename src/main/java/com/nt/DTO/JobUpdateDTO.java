package com.nt.DTO;

import java.util.List;
import java.util.Optional;

public class JobUpdateDTO {
	
	
	/*
	 * id: '681c97189106c80f479e4c6d', companyname: 'Hcl', jobtitle: 'Web devloper', description: 'This position for the web devlopers', location: 'Hyderabad ', …}appliedBy: 0appliedMembers: []companyname: "Hcl"description: "This position for the web devlopers"id: "681c97189106c80f479e4c6d"jobtitle: "Web devloper"location: "Hyderabad "postedBy: "681312e064f9197e98d3145a"postedOn: "Thu May 08 2025"skills: (7) ['Html', 'css', 'java', 'Javascript', 'Reactjs', 'git', 'github'][[Prototype]]: Object
	 */
	private String id;
	private Optional<String>companyname;
	private Optional<String> jobtitle;
	private Optional<String> description;
	private Optional<String> location;		
	private Optional<List<String>> skills;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Optional<String> getCompanyname() {
		return companyname;
	}
	public void setCompanyname(Optional<String> companyname) {
		this.companyname = companyname;
	}
	public Optional<String> getJobtitle() {
		return jobtitle;
	}
	public void setJobtitle(Optional<String> jobtitle) {
		this.jobtitle = jobtitle;
	}
	public Optional<String> getDescription() {
		return description;
	}
	public void setDescription(Optional<String> description) {
		this.description = description;
	}
	public Optional<String> getLocation() {
		return location;
	}
	public void setLocation(Optional<String> location) {
		this.location = location;
	}
	public Optional<List<String>> getSkills() {
		return skills;
	}
	public void setSkills(Optional<List<String>> skills) {
		this.skills = skills;
	}
	

}
