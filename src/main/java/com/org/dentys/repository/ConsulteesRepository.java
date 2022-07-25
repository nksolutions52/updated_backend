package com.org.dentys.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.org.dentys.model.Consultee;


@Repository
public interface ConsulteesRepository extends MongoRepository<Consultee, String> {

//	 List<Consultee> findAll();
//	 List<Consultee> findByFirstNameContaining(String name);
	 List<Consultee> findConsulteeByFirstnameContains(String firstname);
	// Optional<Consultee> findById(String firstname);

//	@Query("Select  p from Consultee p where p.firstname LIKE %:keyword%")
//	List<Consultee> findConsulteeByKeyword (@Param("firstname") String firstname);

}
