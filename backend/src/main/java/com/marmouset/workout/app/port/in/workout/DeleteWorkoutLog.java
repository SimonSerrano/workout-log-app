package com.marmouset.workout.app.port.in.workout;

import java.util.UUID;

/**
 * Interface for deleting a workout log use case.
 */
public interface DeleteWorkoutLog {
  /**
   * Delete a workout log.
   *
   * @param uuid the id
   */
  void delete(UUID uuid);
}
