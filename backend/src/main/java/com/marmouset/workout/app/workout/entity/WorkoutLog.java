package com.marmouset.workout.app.workout.entity;

import com.marmouset.workout.app.shared.entity.Entity;
import java.time.Instant;
import java.util.UUID;

/**
 * Interface that represents a workout logContainer.
 */
public interface WorkoutLog extends Entity<UUID> {

  /**
   * Get the name.
   *
   * @return the name
   */
  String getName();

  /**
   * Get the instant of creation.
   *
   * @return the instant of creation
   */
  Instant getCreatedAt();

  /**
   * Rename a workout log.
   *
   * @param name the new name
   * @return this
   */
  WorkoutLog rename(String name);

}
