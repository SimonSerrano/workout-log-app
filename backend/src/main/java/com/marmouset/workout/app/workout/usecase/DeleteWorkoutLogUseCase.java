package com.marmouset.workout.app.workout.usecase;

import java.util.UUID;

/**
 * Interface for deleting a workout logContainer use case.
 */
public interface DeleteWorkoutLogUseCase {
  /**
   * Delete a workout logContainer.
   *
   * @param uuid the id
   */
  void delete(UUID uuid);
}
