package com.marmouset.workout.app.domain.workout.impl;

import com.marmouset.workout.app.domain.exercise.TrainedExercise;
import com.marmouset.workout.app.domain.workout.WorkoutLog;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Implementation of the workout logContainer.
 */
public class WorkoutLogImpl implements WorkoutLog {

  private final UUID id;
  private final List<TrainedExercise> exercises;
  private final Instant createdAt;
  private String name;

  /**
   * Creates a workout logContainer.
   *
   * @param id        the id
   * @param name      the name
   * @param createdAt the instant of creation
   */
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
  public void rename(String name) {
    this.name = name;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    WorkoutLogImpl that = (WorkoutLogImpl) o;

    if (!id.equals(that.id)) {
      return false;
    }
    if (!exercises.equals(that.exercises)) {
      return false;
    }
    if (!createdAt.equals(that.createdAt)) {
      return false;
    }
    return name.equals(that.name);
  }

  @Override
  public int hashCode() {
    int result = id.hashCode();
    result = 31 * result + exercises.hashCode();
    result = 31 * result + createdAt.hashCode();
    result = 31 * result + name.hashCode();
    return result;
  }
}
