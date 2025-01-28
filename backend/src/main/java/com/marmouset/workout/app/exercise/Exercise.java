package com.marmouset.workout.app.exercise;

import com.marmouset.workout.app.util.AbstractEntity;

import jakarta.persistence.Entity;

@Entity
public class Exercise extends AbstractEntity {

  private String title;

  public Exercise() {
  }

  public Exercise(String title) {
    this.title = title;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

}
