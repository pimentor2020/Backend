package com.org.pimentorbackend.dao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.org.pimentorbackend.beans.InterviewSlot;

@Repository
public interface InterviewRespository 
						extends CrudRepository<InterviewSlot, Long> {

}
