package com.org.dentys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.org.dentys.repository.AppointmentRepository;
import com.org.dentys.repository.ConsulteesRepository;
//import org.springframework.context.annotation.ComponentScan;
@ServletComponentScan
@SpringBootApplication
//@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
//@ComponentScan(basePackages = {"com.org.dentys.service"})
//@ComponentScan({ "com.org.dentys.*" })
//@ComponentScan({"controllers", "reposistories"})
public class DentysApplication {

	public static void main(String[] args) {
		SpringApplication.run(DentysApplication.class, args);
	}

}
