package com.org.dentys.repository;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.org.dentys.model.Message;

public interface MessageRepository  extends MongoRepository<Message, String>{

}
