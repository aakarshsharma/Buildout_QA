package com.crio.starter.controller;

import com.crio.starter.exchange.QuizQuestionGet;
import com.crio.starter.exchange.QuizResponse;
import com.crio.starter.exchange.QuizResult;
import com.crio.starter.models.Question;
import com.crio.starter.service.QuizService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;
// import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("quiz")
public class QuizController {

  @Autowired
  private QuizService quizService;

  @Autowired
  private ObjectMapper objMapper;

  @GetMapping("/all")
  public List<Question> getAllQuestions() {
    return quizService.findAll();
  }

  @GetMapping("{moduleId}")
  public QuizQuestionGet getQuestionsByModule(@PathVariable String moduleId) {
    try {
      QuizQuestionGet returnValue = new QuizQuestionGet(quizService.findByQuestionModId(moduleId));
      return returnValue;
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return null;
  }
  
  @RequestMapping(
  value = "{moduleId}", 
  produces = "application/json", 
  method = {RequestMethod.POST})
  public QuizResult submitByUser(@RequestBody QuizResponse response, @PathVariable String moduleId) {
    try {
      return quizService.checkQuiz(moduleId, response);
    } catch (JsonParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (JsonMappingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }
}