package com.crio.starter.exchange;

import java.util.ArrayList;
import java.util.List;

import com.crio.starter.models.UserResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuizResponse {
  private List<UserResponse> responses = new ArrayList<>();
    
}