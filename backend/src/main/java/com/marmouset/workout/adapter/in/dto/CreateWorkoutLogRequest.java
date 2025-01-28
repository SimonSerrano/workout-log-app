package com.marmouset.workout.adapter.in.dto;

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
