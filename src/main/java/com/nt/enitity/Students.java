package com.nt.enitity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection="student")
public class Students {
	
	@Id 
	private String id;
	
	private String name;
	
	private String age;
	
	private String mailid;
	private List<Map<String,Object>> appliedjobs=new ArrayList<>();
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
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getMailid() {
		return mailid;
	}
	public void setMailid(String mailid) {
		this.mailid = mailid;
	}
	public List<Map<String,Object>> getAppliedjobs() {
		return appliedjobs;
	}
	public void setAppliedjobs(List<Map<String,Object>> appliedjobs) {
		this.appliedjobs = appliedjobs;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
