package com.marmouset.workout.domain;

import jakarta.persistence.Entity;

@Entity
public class WorkoutLog extends AbstractEntity {

  private String title;

  public WorkoutLog() {
  }

  public WorkoutLog(String title) {
    this.title = title;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

}
