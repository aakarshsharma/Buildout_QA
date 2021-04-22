package com.crio.starter.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import com.crio.starter.App;
import com.crio.starter.service.QuizService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.util.UriComponentsBuilder;

@SpringBootTest(classes = { App.class })
@MockitoSettings()
@AutoConfigureMockMvc
@DirtiesContext
@ActiveProfiles("test")
public class QuizControllerTest {
  
  
  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private MockMvc mvc;

  @MockBean
  private QuizService quizService;

  @InjectMocks
  private QuizController quizController;

  @BeforeEach
  public void setup() {
    objectMapper = new ObjectMapper();
    MockitoAnnotations.initMocks(this);
    mvc = MockMvcBuilders.standaloneSetup(quizController).build();
  }

  @Test
  public void getQuestionsTest() throws Exception {

    URI uri = UriComponentsBuilder.fromPath("/quiz/1").build().toUri();
    MockHttpServletResponse response = mvc.perform(get(uri.toString())
            ).andReturn()
            .getResponse();

    assertEquals(200, response.getStatus());

  }

  
}