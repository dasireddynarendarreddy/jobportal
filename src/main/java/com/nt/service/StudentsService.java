package com.nt.service;

import java.util.Map;
import java.util.Optional;

import com.nt.enitity.Students;

public interface StudentsService {
	
	public Students insertStudent(Students std);
	public Optional<Students> findStudent(String mail);
	public boolean updateStudentAppliedJob(Map<String,Object> info);
	public boolean withDrawApplication(String mail,String jobid);

}
