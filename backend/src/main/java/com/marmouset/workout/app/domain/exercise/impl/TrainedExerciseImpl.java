package com.marmouset.workout.app.domain.exercise.impl;

import com.marmouset.workout.app.domain.exercise.Exercise;
import com.marmouset.workout.app.domain.exercise.TrainedExercise;
import com.marmouset.workout.app.domain.set.ExerciseSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

/**
 * Those are the exercises which have been trained.
 * It is composed of an exerciseContainer and
 * multiple sets of that exerciseContainer.
 */
public class TrainedExerciseImpl implements TrainedExercise {

  private final Long id;
  private final List<ExerciseSet> sets;
  private final UUID logId;
  private Exercise exercise;
  private Integer weight;


  /**
   * Constructor.
   */
  TrainedExerciseImpl(Long id, UUID logId, Exercise exercise) {
    this.id = id;
    this.logId = logId;
    sets = new ArrayList<>();
    this.exercise = exercise;
  }


  @Override
  public Long getId() {
    return id;
  }

  @Override
  public UUID getLogId() {
    return logId;
  }

  @Override
  public Exercise getExercise() {
    return exercise;
  }

  @Override
  public TrainedExercise setExercise(Exercise exercise) {
    this.exercise = exercise;
    return this;
  }

  @Override
  public List<ExerciseSet> getSets() {
    return sets;
  }

  @Override
  public TrainedExercise addSet(ExerciseSet set) {
    sets.add(set);
    return this;
  }

  @Override
  public TrainedExercise addAllSets(Collection<ExerciseSet> sets) {
    this.sets.addAll(sets);
    return this;
  }

  @Override
  public TrainedExercise removeSet(ExerciseSet set) {
    sets.remove(set);
    return this;
  }

  @Override
  public Optional<Integer> getWeight() {
    return Optional.ofNullable(weight);
  }

  @Override
  public TrainedExercise setWeight(Integer weight) {
    this.weight = weight;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    TrainedExerciseImpl that = (TrainedExerciseImpl) o;

    if (!id.equals(that.id)) {
      return false;
    }
    if (!sets.equals(that.sets)) {
      return false;
    }
    if (!logId.equals(that.logId)) {
      return false;
    }
    if (!exercise.equals(that.exercise)) {
      return false;
    }
    return Objects.equals(weight, that.weight);
  }

  @Override
  public int hashCode() {
    int result = id.hashCode();
    result = 31 * result + sets.hashCode();
    result = 31 * result + logId.hashCode();
    result = 31 * result + exercise.hashCode();
    result = 31 * result + (weight != null ? weight.hashCode() : 0);
    return result;
  }
}
