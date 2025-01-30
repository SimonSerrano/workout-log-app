package com.marmouset.workout.app.port.in.dto;

public class CreateWorkoutLogCommand {
  private String title;

  public CreateWorkoutLogCommand(String title) {
    this.title = title;
  }

  public String getName() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

}
