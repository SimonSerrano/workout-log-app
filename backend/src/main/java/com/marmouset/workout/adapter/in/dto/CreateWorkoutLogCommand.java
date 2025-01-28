package com.marmouset.workout.adapter.in.dto;

public class CreateWorkoutLogCommand {
  private String title;

  public CreateWorkoutLogCommand(String title) {
    this.title = title;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

}
