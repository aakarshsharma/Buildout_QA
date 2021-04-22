package com.crio.starter.models;
import java.util.HashMap;
import java.util.Map;

// import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuizQuestionRequest {
    
//   @NotNull
  private String questionId;
//   @NotNull
  private String title;
//   @NotNull
  private String type;

  private Map<String, String> options = new HashMap<>();
    
}