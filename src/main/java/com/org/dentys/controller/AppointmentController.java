package com.org.dentys.controller;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.dentys.model.Appointment;
import com.org.dentys.model.Consultee;
import com.org.dentys.repository.AppointmentRepository;
import com.org.dentys.repository.ConsulteesRepository;
import com.org.dentys.service.AppointmentService;
import com.org.dentys.uitl.GateWayResponse;


@CrossOrigin
@RestController
@RequestMapping("/dentys")
public class AppointmentController {
	@Autowired
	 ConsulteesRepository consulteesRepository;
	
	 @Autowired
	 AppointmentRepository appointmentRepository;
	 
     @Autowired
     AppointmentService appointmentService;
     
	  @PostMapping("/createAppointment")
	   public GateWayResponse<?>  createAppointment(@RequestBody Consultee consultee,@RequestParam(required = false)  Boolean isVisited) {
	    try {
	        	Optional<Consultee> _Consultee = consulteesRepository.findById(consultee.getId());
	    	     if(_Consultee.isPresent()) 
	    	     { 
	    	    	
	    	    		 appointmentRepository.save(new Appointment(consultee.getId(),consultee.getDatetime(),false,isVisited));
	    	    	 
	    	    	
	    	    	 return new GateWayResponse<>(HttpStatus.OK, /*ResourceUtil.getValue(language,"Record.Saved.Successfully")*/"Record Save Successfully");
	    	     }else {
	    	    	 return new GateWayResponse<>(HttpStatus.OK, /*ResourceUtil.getValue(language,"Record.Saved.Successfully")*/"No Record Found");
	    	     }
	        	
	    	  
	    	//return new ResponseEntity<>(_Consultee, HttpStatus.CREATED);
	        	
	    } catch (Exception e) {
	    //  return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    	return new GateWayResponse<>(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
	    }
	  }
	  @PutMapping("/editAppointment")
	   public GateWayResponse<?>  editAppointment(@RequestBody Appointment appointment) {
	    try {
	        	Optional<Appointment> _Appointment = appointmentRepository.findById(appointment.getId());
	    	     if(_Appointment.isPresent()) 
	    	     { 
	    	    	 Appointment appointmentData = _Appointment.get();
	    	    	 appointmentData.setAppDate(appointment.getAppDate());
					 appointmentData.setIsVisited(appointment.getIsVisited());
	    	    	 appointmentRepository.save(appointmentData);
	    	    	 return new GateWayResponse<>(HttpStatus.OK, /*ResourceUtil.getValue(language,"Record.Saved.Successfully")*/"Appointment Updated Successfully");
	    	     }else {
	    	    	 return new GateWayResponse<>(HttpStatus.OK, /*ResourceUtil.getValue(language,"Record.Saved.Successfully")*/"No Record Found");
	    	     }
	        	
	    	  
	    	//return new ResponseEntity<>(_Consultee, HttpStatus.CREATED);
	        	
	    } catch (Exception e) {
	    //  return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    	return new GateWayResponse<>(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
	    }
	  }
	  @GetMapping(value = "/getAppointmentsBasedOnDates")
	  public GateWayResponse<?> getAllAppointments(
				@RequestParam("startdate") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date startdate,
				@RequestParam("enddate") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date enddate) {
		  
		  
		    try {
			      List<Appointment> appointments = new ArrayList<Appointment>();
		
			      if (startdate != null)
			    	  appointments =  appointmentService.getAppointmentData(startdate,enddate);
			    
		
			      if (appointments.isEmpty()) {
			      //  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			        return new GateWayResponse<>(HttpStatus.NO_CONTENT,"Not Found");
			      }
			    //  return new ResponseEntity<>(Consultees, HttpStatus.OK);
			      return new GateWayResponse<>(HttpStatus.OK,appointments,"");
			    } catch (Exception e) {
			      // return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			      return new GateWayResponse<>(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
			    }
	  }
	  @GetMapping(value = "/getAppointmentsBasedOnId")
	  public GateWayResponse<?> getAllAppointmentsBasedonPatientId(
				@RequestParam("patientId") String patientId) {
		  
		  
		    try {
			      List<Appointment> appointments = new ArrayList<Appointment>();
		
			      if (patientId != null)
			    	  appointments =  appointmentService.getAppointmentDataBasedOnId(patientId);
			    
		
			      if (appointments.isEmpty()) {
			      //  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			        return new GateWayResponse<>(HttpStatus.NO_CONTENT,"Not Found");
			      }
			    //  return new ResponseEntity<>(Consultees, HttpStatus.OK);
			      return new GateWayResponse<>(HttpStatus.OK,appointments,"");
			    } catch (Exception e) {
			      // return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			      return new GateWayResponse<>(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
			    }
		    
	  }
	  @GetMapping(value = "/getAppointmentsCount")
	  public GateWayResponse<?> getAppointmentsCount(
				@RequestParam("startdate") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date startdate,
				@RequestParam("enddate") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date enddate) {
		  
		  
		    try {
			      List<Appointment> appointments = new ArrayList<Appointment>();
		
			      if (startdate != null)
			    	  appointments =  appointmentService.getAppointmentData(startdate,enddate);
			          int Count = appointments.size();
		
			      if (appointments.isEmpty()) {
			      //  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			        return new GateWayResponse<>(HttpStatus.NO_CONTENT,"Not Found");
			      }
			    //  return new ResponseEntity<>(Consultees, HttpStatus.OK);
			      return new GateWayResponse<>(HttpStatus.OK,Count,"");
			    } catch (Exception e) {
			      // return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			      return  sendGateWayResponse(HttpStatus.BAD_REQUEST, e.getMessage(), false);
			    }
	  }
	  
	  private GateWayResponse<?> sendGateWayResponse(HttpStatus httpStatus, String message, boolean isSuccess) {
	        GateWayResponse<?> gateWayResponse = new GateWayResponse<>(httpStatus, message);
	        gateWayResponse.setIsSuccess(isSuccess);
	        return gateWayResponse;
	    }
}
