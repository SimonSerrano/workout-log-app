package com.marmouset.workout.app.port.in.exercise;

import java.util.UUID;

/**
 * Interface for deleting a trained exercise.
 */
public interface DeleteTrainedExercise {
  /**
   * Deletes a trained exercise.
   *
   * @param logId     the id of the workout log
   * @param trainedId the id of the exercise to delete
   */
  void delete(UUID logId, Long trainedId);
}
