package com.crio.starter.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import com.crio.starter.App;
import com.crio.starter.controller.QuizController;
import com.crio.starter.exchange.QuizQuestionGet;
import com.crio.starter.models.QuizQuestionRequest;
import com.crio.starter.repository.QuizRepository;
import com.crio.starter.utils.FixtureHelpers;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest(classes = { App.class })
@MockitoSettings
@DirtiesContext
@ActiveProfiles("test")
public class QuizServiceImplTest {
  private static final String FIXTURES = "fixtures";
  
  @InjectMocks
  private QuizServiceImpl quizService;

  @MockBean
  private QuizRepository quizRepositoryServiceMock;
  
  @Autowired
  private ObjectMapper objectMapper;
  
  @InjectMocks
  private QuizController quizController;

  @BeforeEach
  void setup() {
    MockitoAnnotations.initMocks(this);
    objectMapper = new ObjectMapper();
  }
 
  
  public void getQuestionService(List<QuizQuestionRequest> questions, String moduleId) 
      throws Exception {
    when(quizRepositoryServiceMock.findAll()).thenReturn(null);
    List<QuizQuestionRequest> check = quizService.findByQuestionModId(moduleId);
    assertEquals(null, check);
  }

  public List<QuizQuestionRequest> loadGetQuestion() 
        throws JsonParseException, JsonMappingException, IOException {
    String fixture = FixtureHelpers.fixture(FIXTURES + "/sample_get_questions_response.json");
    System.out.println(fixture);
    
    QuizQuestionGet returnVal = 
          objectMapper.readValue(fixture, QuizQuestionGet.class);

    return returnVal.getQuestions();
  }
   
  @Test
  public void getRequestHelper() throws Exception {
    getQuestionService(loadGetQuestion(),"1");
  }
  
}