package com.org.dentys.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.org.dentys.model.Appointment;
import org.springframework.stereotype.Service;

@Service
public interface AppointmentService {
public List<Appointment> getAppointmentData(Date from,Date to);

public List<Appointment> getAppointmentDataBasedOnId(String patientId);
}
