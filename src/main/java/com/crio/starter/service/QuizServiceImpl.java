package com.crio.starter.service;

import com.crio.starter.exchange.QuizResponse;
import com.crio.starter.exchange.QuizResult;
import com.crio.starter.models.Question;
import com.crio.starter.models.QuizCheck;
import com.crio.starter.models.QuizQuestionRequest;
import com.crio.starter.models.UserResponse;
import com.crio.starter.repository.QuizRepository;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class QuizServiceImpl implements QuizService {

  @Autowired
  private QuizRepository quizRepository;

  @Autowired
  private MongoTemplate mongoTemplate;

  @Autowired
  private ObjectMapper mapper;

  @Override
  public List<Question> findAll() {
    // TODO Auto-generated method stub
    List<Question> res = quizRepository.findAll();
    return res;
  }

  @Override
  public List<QuizQuestionRequest> findByQuestionModId(String mid)
        throws JsonParseException, JsonMappingException, IOException {
    // TODO Auto-generated method stub
    Query query = new Query();
    query.addCriteria(Criteria.where("moduleId").is(mid));
    // List<Question> res = mongoTemplate.find(query, Question.class);
    List<Question> res = quizRepository.findAll();
    List<QuizQuestionRequest> questions = new ArrayList<>();
    if (res == null) {
      return null;
    }

    for (Question ques : res) {
      QuizQuestionRequest temp = mapper.convertValue(ques, QuizQuestionRequest.class);
      questions.add(temp);
    }
    return questions;
  }
  
  @Override
  public QuizResult checkQuiz(String moduleId, QuizResponse response)
        throws JsonParseException, JsonMappingException, IOException {
    // TODO Auto-generated method stub
    Query query = new Query();
    query.addCriteria(Criteria.where("moduleId").is(moduleId));
    List<Question> qestionsWithAnswers = mongoTemplate.find(query, Question.class);

    List<Question> filteredList = qestionsWithAnswers.stream()
            .filter(q -> response.getResponses().stream()
            .anyMatch(u -> u.getQuestionId().equals(q.getQuestionId().toString())
            // && u.getUserResponse().equals(q.getCorrectAnswer())
            )).collect(Collectors.toList());

    // Calculate marks by check from filtered list and response.getResponses()
    Collections.sort(filteredList, new Comparator<Question>() {
        public int compare(Question o1, Question o2) {
            return o1.getQuestionId().compareTo(o2.getQuestionId());
        }
    });

    Collections.sort(response.getResponses(), new Comparator<UserResponse>() {
        public int compare(UserResponse o1, UserResponse o2) {
            return o1.getQuestionId().compareTo(o2.getQuestionId());
        }
    });

    Map<String, Integer> summary = new HashMap<>();
    QuizResult returnValue = new QuizResult();
    List<QuizCheck> responseList = new ArrayList<>();
    int score = 0;
    for (int i = 0; i < filteredList.size(); i++) {
      QuizCheck temp = QuizCheck.builder()
                .questionId(filteredList.get(i).getQuestionId())
                .title(filteredList.get(i).getTitle())
                .description(filteredList.get(i).getDescription())
                .type(filteredList.get(i).getType()).options(filteredList.get(i).getOptions())
                .userAnswer(response.getResponses().get(i).getUserResponse())
                .correct(filteredList.get(i).getCorrectAnswer())
                .explanation(null).answerCorrect(filteredList.get(i)
                .getCorrectAnswer().equals(response.getResponses().get(i).getUserResponse()))
                .build();

      if (filteredList.get(i).getCorrectAnswer()
          .equals(response.getResponses().get(i).getUserResponse())) {
        score++;
      }

      responseList.add(temp);
    }
    returnValue.setQuestions(responseList);
    summary.put("score", score);
    summary.put("total", response.getResponses().size());
    returnValue.setSummary(summary);
    return returnValue;
  }

}
