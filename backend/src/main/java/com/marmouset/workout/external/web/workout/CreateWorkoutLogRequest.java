package com.marmouset.workout.external.web.workout;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotBlank;

@Component
public class CreateWorkoutLogRequest {
  @NotBlank(message = "Title is mandatory")
  private String title;

  public CreateWorkoutLogRequest() {

  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

}
