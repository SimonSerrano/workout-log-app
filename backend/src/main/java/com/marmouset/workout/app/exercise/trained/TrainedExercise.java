package com.marmouset.workout.app.exercise.trained;

import java.util.List;

import com.marmouset.workout.app.exercise.Exercise;
import com.marmouset.workout.app.exercise.practice.Practice;
import com.marmouset.workout.app.util.AbstractEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class TrainedExercise extends AbstractEntity {
  @OneToOne
  private Exercise exercise;

  @OneToMany
  private List<Practice> practices;

  public TrainedExercise() {
  }

  public TrainedExercise(Exercise exercise, List<Practice> practices) {
    this.exercise = exercise;
    this.practices = practices;
  }

  public Exercise getExercise() {
    return exercise;
  }

  public void setExercise(Exercise exercise) {
    this.exercise = exercise;
  }

  public List<Practice> getPractices() {
    return practices;
  }

  public void setPractices(List<Practice> practices) {
    this.practices = practices;
  }

}
