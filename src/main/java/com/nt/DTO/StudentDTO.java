package com.nt.DTO;

import java.util.List;
import java.util.Map;

public class StudentDTO {
	/*id
: 
"6814a08a5fb03b13fa8f7fc9"
mailid
: 
"narendarreddy2002@gmail.com"
name
:*/
	private String mailid;
	private String name;
	private String id;
	private List<Map<String,Object>> appliedjobs;
	public String getMailid() {
		return mailid;
	}
	public void setMailid(String mailid) {
		this.mailid = mailid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Map<String, Object>> getAppliedjobs() {
		return appliedjobs;
	}
	public void setAppliedjobs(List<Map<String, Object>> appliedjobs) {
		this.appliedjobs = appliedjobs;
	}

}
