package com.marmouset.workout.external.web.workout;

import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Component;

@Component
class CreateWorkoutLogBody {
  @NotBlank(message = "Title is mandatory")
  private String title;

  CreateWorkoutLogBody() {

  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

}
