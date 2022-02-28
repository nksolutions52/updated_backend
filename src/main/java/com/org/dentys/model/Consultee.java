package com.org.dentys.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection = "consultees")
public class Consultee {
	  @Transient
	    public static final String SEQUENCE_NUMBER = "employee_sequence";
	@BsonId
	@JsonProperty("id")
	  private String id;

	  private String firstname;
	  private String lastname;
	  private String gender;
	  private int age;
	  private String address;
	  private String mobile;
	  private long consulteeCount;

	  @JsonFormat(pattern="yyyy-MM-dd")
private Date createdDate = new Date();


@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
private Date datetime;
	  public Consultee() {

	  }
	  public Consultee(String id,String firstname,String lastname,String gender,Integer age,String address,String mobile) {
		  this.id  = id;
		  this.firstname = firstname;
		  this.lastname = lastname;
		  this.gender = gender;
		  this.age = age;
		  this.address = address;
		  this.mobile  = mobile;
		  createdDate = new Date();
		  datetime = new Date();
		  
	  }


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public static String getSequenceNumber() {
		return SEQUENCE_NUMBER;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	public long getConsulteeCount() {
		return consulteeCount;
	}
	public void setConsulteeCount(long consulteeCount) {
		this.consulteeCount = consulteeCount;
	}

	
	 
}
