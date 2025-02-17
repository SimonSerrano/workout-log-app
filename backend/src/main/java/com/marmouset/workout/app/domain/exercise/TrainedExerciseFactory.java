package com.marmouset.workout.app.domain.exercise;

import java.util.UUID;

/**
 * Factory to create trained exercises.
 */
public interface TrainedExerciseFactory {
  /**
   * Creates a Trained exerciseContainer.
   *
   * @param id       the id of the exerciseContainer
   * @param logId    the id of the workout logContainer
   * @param exercise the trained exerciseContainer
   * @return the trained exerciseContainer
   */
  TrainedExercise create(Long id, UUID logId, Exercise exercise);
}
