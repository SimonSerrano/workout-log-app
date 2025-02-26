package com.marmouset.workout.app.workout.adapter;

import com.marmouset.workout.app.workout.entity.WorkoutLog;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Interface to convert from use cases to db and vice versa for workout logs.
 */
public interface WorkoutLogRepositoryGateway {

  /**
   * Find all workout logs order by createdAt descending.
   *
   * @return a list of workout logs
   */
  List<? extends WorkoutLog> findAllByOrderByCreatedAtDesc();

  /**
   * Find a workout log by its id.
   *
   * @param id the log id
   * @return an optional of workout log
   */
  Optional<? extends WorkoutLog> findById(UUID id);

  /**
   * Saves a workout log.
   *
   * @param entity the workout log to save
   * @return the saved workout log
   */
  WorkoutLog save(WorkoutLog entity);

  /**
   * Delete a workout log by its id.
   *
   * @param id the id
   */
  void deleteById(UUID id);

  /**
   * Get a workout log reference by its id.
   *
   * @param id the id
   * @return the workout log reference
   */
  WorkoutLog getReferenceById(UUID id);

  /**
   * Check if a workout log exists by its id.
   *
   * @param uuid the id
   * @return true if the workout log exists
   */
  boolean existsById(UUID uuid);
}
