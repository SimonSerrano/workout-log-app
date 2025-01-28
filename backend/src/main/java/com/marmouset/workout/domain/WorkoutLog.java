package com.marmouset.workout.domain;

import java.util.List;

import com.marmouset.workout.domain.exercise.trained.TrainedExercise;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class WorkoutLog extends AbstractEntity {

  private String title;

  @OneToMany
  private List<TrainedExercise> exercises;

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

  public List<TrainedExercise> getExercises() {
    return exercises;
  }

  public void setExercises(List<TrainedExercise> exercises) {
    this.exercises = exercises;
  }

}
