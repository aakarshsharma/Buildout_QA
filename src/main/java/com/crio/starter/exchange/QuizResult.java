package com.crio.starter.exchange;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.crio.starter.models.QuizCheck;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;




@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class QuizResult {
  private List<QuizCheck> questions;
  private Map<String, Integer> summary = new HashMap<>();
}