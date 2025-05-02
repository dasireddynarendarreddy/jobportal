package com.nt.repositry;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.nt.enitity.Recruter;
@Repository
public interface PortalRecruter extends MongoRepository<Recruter, String> {
	Optional<Recruter> findOptionalByMail(String mail);
	
}
