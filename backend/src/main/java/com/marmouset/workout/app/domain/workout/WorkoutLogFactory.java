package com.marmouset.workout.app.domain.workout;

import java.time.Instant;
import java.util.UUID;

/**
 * Factory to create workout logs.
 */
public interface WorkoutLogFactory {
  /**
   * Creates a workout log.
   *
   * @param id        the id
   * @param name      the name
   * @param createdAt the instant of creation
   * @return the workout log
   */
  WorkoutLog create(UUID id, String name, Instant createdAt);
}
