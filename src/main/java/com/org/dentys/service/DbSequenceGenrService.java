package com.org.dentys.service;


import org.springframework.stereotype.Service;

@Service
public interface DbSequenceGenrService {
 int getNextSequence(String sequenceNumber) ;
}
