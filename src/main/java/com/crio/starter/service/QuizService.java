package com.crio.starter.service;

import com.crio.starter.exchange.QuizResponse;
import com.crio.starter.exchange.QuizResult;
import com.crio.starter.models.Question;
import com.crio.starter.models.QuizQuestionRequest;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import java.io.IOException;
import java.util.List;

public interface QuizService {
  List<Question> findAll();

  List<QuizQuestionRequest> findByQuestionModId(String mid)
  throws JsonParseException, JsonMappingException, IOException;
  
  QuizResult checkQuiz(String moduleId, QuizResponse response)
  throws JsonParseException, JsonMappingException, IOException;
}