package com.crio.starter.repository;

import java.util.List;

import com.crio.starter.models.Question;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends MongoRepository<Question, String> {

  

}