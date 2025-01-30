package com.marmouset.workout.app.domain.exercise.impl;

import com.marmouset.workout.app.domain.exercise.Exercise;
import com.marmouset.workout.app.domain.exercise.TrainedExercise;
import com.marmouset.workout.app.domain.set.ExerciseSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Those are the exercises which have been trained.
 * It is composed of an exercise and multiple sets of that exercise.
 */
public class TrainedExerciseImpl implements TrainedExercise {

  private final List<ExerciseSet> sets;
  private Exercise exercise;

  /**
   * Constructor.
   */
  TrainedExerciseImpl(Exercise exercise) {
    sets = new ArrayList<>();
    this.exercise = exercise;
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
  public TrainedExercise removeSet(ExerciseSet set) {
    sets.remove(set);
    return this;
  }
}
