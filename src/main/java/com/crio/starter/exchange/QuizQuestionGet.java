package com.crio.starter.exchange;

import java.util.ArrayList;
import java.util.List;

import com.crio.starter.models.QuizQuestionRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class QuizQuestionGet {

  private List<QuizQuestionRequest> questions = new ArrayList<>();
}