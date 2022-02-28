package com.org.dentys.model;

import java.util.Date;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
@Document(collection = "appointments")
public class Appointment {

	@BsonId
	@JsonProperty("id")
	  private String id;

	  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	  private Date appDate;
	  private String patientId;
	  private Boolean isVisited;
	  private Boolean isActive;
	  public Appointment() {

	  }
	  public Appointment(String patientId,Date appDate,Boolean isActive,Boolean isVisited) {
		  this.patientId = patientId;
		  this.appDate  = appDate;
		  this.isActive = false;
		  this.isVisited = isVisited;

	  }
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	

	public Date getAppDate() {
		return appDate;
	}
	public void setAppDate(Date appDate) {
		this.appDate = appDate;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public Boolean getIsVisited() {
		return isVisited;
	}
	public void setIsVisited(Boolean isVisited) {
		this.isVisited = isVisited;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	  
}
