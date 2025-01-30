package com.marmouset.workout.app.domain.workout.impl;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.marmouset.workout.app.domain.exercise.TrainedExercise;
import com.marmouset.workout.app.domain.workout.WorkoutLog;

public class WorkoutLogImpl implements WorkoutLog {

  private final UUID id;
  private String title;
  private final List<TrainedExercise> exercises;
  private final Instant createdAt;

  public WorkoutLogImpl(UUID id, String title, Instant createdAt) {
    this.id = id;
    this.title = title;
    this.createdAt = createdAt;
    exercises = new ArrayList<>();
  }

  @Override
  public UUID getId() {
    return id;
  }

  @Override
  public String getTitle() {
    return title;
  }

  @Override
  public void rename(String title) {
    this.title = title;
  }

  @Override
  public List<TrainedExercise> getExercises() {
    return exercises;
  }

  @Override
  public WorkoutLog addExercise(TrainedExercise exercise) {
    exercises.add(exercise);
    return this;
  }

  @Override
  public Instant getCreatedAt() {
    return createdAt;
  }

}
