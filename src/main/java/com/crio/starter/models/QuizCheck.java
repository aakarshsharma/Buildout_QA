package com.crio.starter.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuizCheck {
    private String questionId;
    private String title;
    private String description;
    private String type;
    private Map<String, String> options = new HashMap<>();
    private List<String> userAnswer = new ArrayList<>();
    private List<String> correct = new ArrayList<>();
    private String explanation;
    private Boolean answerCorrect;
}