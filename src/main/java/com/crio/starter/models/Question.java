package com.crio.starter.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.mongodb.core.mapping.Document;

// import com.meesho.buildout.utils.TypesEnum;

// "questionId": "001",
// "title": "What is the default IP address of localhost?",
// "description": "General question",
// "type": "objective-single",
// "options": {
//   "1": "0.0.0.0",
//   "2": "192.168.0.12",
//   "3": "127.0.0.1",
//   "4": "255.255.255.255"
// },
// "correctAnswer": [
//   "4"
// ]
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor

@Data
@Document(collection = "qa")
public class Question {

  // @NotNull
  private String moduleId;
  // @NotNull
  private String questionId;
  // @NotNull
  private String title;
  // @NotNull
  private String description;
  // @NotNull
  private String type;

  @JsonProperty("options")
  // private Options options;
  private Map<String, String> options = null;

  // @NotNull
  private List<String> correctAnswer;

}   