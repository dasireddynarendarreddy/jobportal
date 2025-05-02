package com.nt.enitity;

import java.util.ArrayList;
import java.util.List;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection ="admin")
public class Recruter {
	
     @Id
	private String id;

	
	private String name;
	
	private String mail;
	private Long phonenumber;
	private String companyname;
	private List<String> jobsposted=new ArrayList<>();
	private String password;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Long getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(Long phonenumber) {
		this.phonenumber = phonenumber;
	}
	public List<String> getJobsposted() {
		return jobsposted;
	}
	public void setJobsposted(List<String> jobsposted) {
		this.jobsposted = jobsposted;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
