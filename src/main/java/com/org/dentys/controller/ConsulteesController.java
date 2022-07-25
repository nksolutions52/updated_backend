package com.org.dentys.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.dentys.model.Appointment;
import com.org.dentys.model.Consultee;
import com.org.dentys.model.Message;
import com.org.dentys.repository.AppointmentRepository;
import com.org.dentys.repository.ConsulteesRepository;
import com.org.dentys.repository.MessageRepository;
import com.org.dentys.service.DbSequenceGenrService;
import com.org.dentys.uitl.GateWayResponse;
import com.org.dentys.uitl.JsonUtil;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/dentys")
public class ConsulteesController {
	
//	private Logger logger = LoggerFactory.getLogger(MyCustomRepository.class);
	
	 @Autowired
      JsonUtil jsonUtil;

	 @Autowired
	 ConsulteesRepository consulteesRepository;
	
	 @Autowired
	 MessageRepository messageRepository;
	 
	 @Autowired
	 AppointmentRepository appointmentRepository;
	 
	 @Autowired
	 DbSequenceGenrService sequenceGenr;
	 
	  @PostMapping("/createconsultee")
	  public GateWayResponse<?> createTutorial(@RequestBody Consultee consultee) {

		  if ((StringUtils.isEmpty(consultee.getMobile()))||( StringUtils.isEmpty(consultee.getFirstname()))) {
	            return sendGateWayResponse(HttpStatus.BAD_REQUEST, /*ResourceUtil.getValue(language, ResourceKeys.SITE_NOT_FOUND)*/"Consultee Not Found",false);
	        }
		  try {
	    	int idSequence = sequenceGenr.getNextSequence(Consultee.SEQUENCE_NUMBER);
	    	consultee.setId("SUR" + Integer.toString(idSequence));
	    	
	    	Consultee _Consultee = 	consulteesRepository.save(new Consultee(consultee.getId(),consultee.getFirstname(),consultee.getLastname(),consultee.getGender(),consultee.getAge(),consultee.getAddress(), consultee.getMobile()));
	    	
	    	   messageRepository.save(new Message(consultee.getFirstname(),consultee.getMobile()));
	    	  
	    	// return new ResponseEntity<>(_Consultee, HttpStatus.CREATED);
	    	    return new GateWayResponse<>(HttpStatus.OK,_Consultee, /*ResourceUtil.getValue(language,"Record.Saved.Successfully")*/"Record Save Successfully");
	    } catch (Exception e) {
	   //   return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	      return new GateWayResponse<>(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
	    }
	  }
	  
//	  @PostMapping("/createconsultees")
//	   public ResponseEntity<?>  createConsultee(@RequestBody Consultee consultee) {
//	    try {
//	        	Consultee _Consultee = consulteesRepository.save(new Consultee(consultee.getId(),consultee.getFirstname(),consultee.getLastname(),consultee.getGender(),consultee.getAge(),consultee.getAddress(), consultee.getMobile()));
//	    	 
//	    	    messageRepository.save(new Message(consultee.getFirstname(),consultee.getMobile()));
//	    	  
//	    	return new ResponseEntity<>(_Consultee, HttpStatus.CREATED);
//	    } catch (Exception e) {
//	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//	    }
//	  }
	  
	  @GetMapping("/getconsultees")
	  public GateWayResponse<?> getAllConsultees(@RequestParam(required = false) String firstname) {
	    try {
	      List<Consultee> Consultees = new ArrayList<Consultee>();

	      if (firstname == null) {
	    	  consulteesRepository.findAll().forEach(Consultees::add);
	           Consultee consuteeOfone = Consultees.get(0);
	           consuteeOfone.setConsulteeCount(Consultees.size());
	      }
	      else
	       consulteesRepository.findConsulteeByFirstnameContains(firstname).forEach(Consultees::add);
	      if (Consultees.isEmpty()) {
	      //  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        return new GateWayResponse<>(HttpStatus.NO_CONTENT,"Not Found");
	      }
	    //  return new ResponseEntity<>(Consultees, HttpStatus.OK);
	      return new GateWayResponse<>(HttpStatus.OK,Consultees,"");
	    } catch (Exception e) {
	      // return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	      return new GateWayResponse<>(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
	    }
	  }
	    private GateWayResponse<?> sendGateWayResponse(HttpStatus httpStatus, String message, boolean isSuccess) {
	        GateWayResponse<?> gateWayResponse = new GateWayResponse<>(httpStatus, message);
	        gateWayResponse.setIsSuccess(isSuccess);
	        return gateWayResponse;
	    }
}
