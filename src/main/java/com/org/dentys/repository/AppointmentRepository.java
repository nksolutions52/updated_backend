package com.org.dentys.repository;





import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.org.dentys.model.Appointment;

public interface AppointmentRepository extends MongoRepository<Appointment, String> {

	List<Appointment> findAllByAppDateBetween(Date from,Date to);
	
	List<Appointment> findAllByPatientId(String PatientId);
	
}
