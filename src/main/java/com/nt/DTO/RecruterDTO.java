package com.nt.DTO;

import java.util.List;

/*
 * companyname
: 
"hcl"
id
: 
"681312e064f9197e98d3145a"
jobsposted
: 
["6813130264f9197e98d3145b", "681319d764f9197e98d3145c"]
mail
: 
"rambabu@gmail.com"
name
: 
"rambabu"
 */
public class RecruterDTO {
	private String companyname;
	private String id;
	private List<String> jobposted;
	private String name;
	private String mail;
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<String> getJobposted() {
		return jobposted;
	}
	public void setJobposted(List<String> jobposted) {
		this.jobposted = jobposted;
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
	

}
