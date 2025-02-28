package com.marmouset.workout.app.progression.adapter;

/**
 * Interface representing a data point response for repetitions over time.
 */
public interface RepsDataPointResponse {
  /**
   * Get the date of the data point.
   *
   * @return the date as an UTC timestamp
   */
  Long timestamp();

  /**
   * Get the number of repetitions.
   *
   * @return the number of reps
   */
  Integer reps();
}
