package com.marmouset.workout.app.port.in.exercise;

import com.marmouset.workout.app.domain.workout.WorkoutLogNotFoundException;
import java.util.UUID;

/**
 * Interface for deleting a trained exerciseContainer.
 */
public interface DeleteTrainedExercise {
  /**
   * Deletes a trained exerciseContainer.
   *
   * @param logId     the id of the workout logContainer
   * @param trainedId the id of the exerciseContainer to delete
   */
  void delete(UUID logId, Long trainedId) throws WorkoutLogNotFoundException;
}
