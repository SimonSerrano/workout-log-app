package com.marmouset.workout.app.trainedexercise.entity;

import com.marmouset.workout.app.exercise.entity.Exercise;

/**
 * Factory to create trained exercises.
 */
public interface TrainedExerciseFactory {

  /**
   * Creates an empty trained exercise.
   *
   * @return an empty trained exercise
   */
  TrainedExercise create();

  /**
   * Creates a Trained exercise.
   *
   * @param exercise the trained exercise
   * @return the trained exercise
   */
  TrainedExercise create(Exercise exercise);
}
