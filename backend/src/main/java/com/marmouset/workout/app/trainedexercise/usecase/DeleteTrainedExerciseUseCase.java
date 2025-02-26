package com.marmouset.workout.app.trainedexercise.usecase;

import com.marmouset.workout.app.workout.entity.WorkoutLogNotFoundException;
import java.util.UUID;

/**
 * Interface for deleting a trained exerciseContainer.
 */
public interface DeleteTrainedExerciseUseCase {
  /**
   * Deletes a trained exerciseContainer.
   *
   * @param logId     the id of the workout logContainer
   * @param trainedId the id of the exerciseContainer to delete
   */
  void delete(UUID logId, Long trainedId) throws WorkoutLogNotFoundException;
}
