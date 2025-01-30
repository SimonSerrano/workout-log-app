package com.marmouset.workout.app.domain.workout.impl;

import com.marmouset.workout.app.domain.exercise.TrainedExercise;
import com.marmouset.workout.app.domain.workout.WorkoutLog;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class WorkoutLogImpl implements WorkoutLog {

  private final UUID id;
  private final List<TrainedExercise> exercises;
  private final Instant createdAt;
  private String name;

  public WorkoutLogImpl(UUID id, String name, Instant createdAt) {
    this.id = id;
    this.name = name;
    this.createdAt = createdAt;
    exercises = new ArrayList<>();
  }

  @Override
  public UUID getId() {
    return id;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void rename(String title) {
    this.name = title;
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
