package com.crio.starter.models;
import java.util.ArrayList;
import java.util.List;

// import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {
//   @NotNull
  private String questionId;

//   @NotNull
  private List<String> userResponse = new ArrayList<>();

    
}