package com.marmouset.workout.app.progression.entity;

import java.time.Instant;

/**
 * Interface representing a data point of reps in time.
 */
public interface RepsDataPoint {
  /**
   * Get the date of this data point.
   *
   * @return the date
   */
  Instant date();

  /**
   * Get the number of reps of this data point.
   *
   * @return the number of reps
   */
  Integer reps();
}
