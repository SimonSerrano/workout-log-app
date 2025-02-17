package com.marmouset.workout.app.port.in.workout;

import java.util.UUID;

/**
 * Interface for deleting a workout logContainer use case.
 */
public interface DeleteWorkoutLog {
  /**
   * Delete a workout logContainer.
   *
   * @param uuid the id
   */
  void delete(UUID uuid);
}
