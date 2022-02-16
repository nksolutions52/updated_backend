package com.org.dentys.serviceImpl;


import java.time.LocalDate;

import java.time.ZoneOffset;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.dentys.model.Appointment;
import com.org.dentys.repository.AppointmentRepository;
import com.org.dentys.service.AppointmentService;
@Service
public class AppoinmentServiceImpl implements AppointmentService{
	
	 @Autowired
	 AppointmentRepository appointmentRepository;

	@Override
	public List<Appointment> getAppointmentData(Date from,Date to) {
		
		try {
			List<Appointment> appointmentData = appointmentRepository.findAllByAppDateBetween(from,to);
			return appointmentData;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}


		
		
	}

	@Override
	public List<Appointment> getAppointmentDataBasedOnId(String patientId) {
		try {
			List<Appointment> appointmentData = appointmentRepository.findAllByPatientId(patientId);
			return appointmentData;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	 

	

}
