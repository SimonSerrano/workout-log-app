package com.marmouset.workout.app.domain.exercise;

import java.util.UUID;

/**
 * Factory to create trained exercises.
 */
public interface TrainedExerciseFactory {
  /**
   * Creates a Trained exercise.
   *
   * @param id       the id of the exercise
   * @param logId    the id of the workout log
   * @param exercise the trained exercise
   * @return the trained exercise
   */
  TrainedExercise create(Long id, UUID logId, Exercise exercise);
}
