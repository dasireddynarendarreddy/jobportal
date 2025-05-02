package com.nt.repositry;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.nt.enitity.Students;
@Repository
public interface PortalStudent extends MongoRepository<Students,String> {
     Optional<Students> findByMailid(String mail);
    Optional<Students> findById(String id);
    
}
