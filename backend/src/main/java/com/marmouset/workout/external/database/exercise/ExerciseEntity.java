package com.marmouset.workout.external.database.exercise;

import com.marmouset.workout.external.database.AbstractEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "exercises")
public class ExerciseEntity extends AbstractEntity {

  @Column(unique = true)
  private String title;

  public ExerciseEntity() {
  }

  public ExerciseEntity(String title) {
    this.title = title;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

}
