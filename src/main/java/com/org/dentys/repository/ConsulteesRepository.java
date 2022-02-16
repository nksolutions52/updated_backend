package com.org.dentys.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.org.dentys.model.Consultee;


@Repository
public interface ConsulteesRepository extends MongoRepository<Consultee, String> {

//	 List<Consultee> findAll();
//	 List<Consultee> findByFirstNameContaining(String name);
	 List<Consultee> findByFirstname(String firstname);
}
