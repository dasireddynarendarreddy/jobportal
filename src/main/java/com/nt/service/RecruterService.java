package com.nt.service;



import java.util.Optional;

import com.nt.DTO.UpdateDTO;
import com.nt.enitity.Recruter;

public interface RecruterService {
	
	public Recruter createRecruter(Recruter r);
	public Optional<Recruter> findByMail(String mail);
    public boolean addJobToRecruter(String postedBy,String id);
    public boolean deleteJobById(String id,String rid);
    public boolean updateStatus(UpdateDTO dto);
    

}
