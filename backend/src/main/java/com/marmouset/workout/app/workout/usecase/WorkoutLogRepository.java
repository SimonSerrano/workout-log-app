package com.marmouset.workout.app.workout.usecase;

import com.marmouset.workout.app.shared.external.database.exception.NotFoundException;
import com.marmouset.workout.app.workout.entity.WorkoutLog;
import com.marmouset.workout.app.workout.usecase.dto.CreateWorkoutLogRepoRequest;
import com.marmouset.workout.app.workout.usecase.dto.UpdateWorkoutLogRepoRequest;
import java.util.List;
import java.util.UUID;

/**
 * Interface for the workout logContainer repository.
 */
public interface WorkoutLogRepository {
  /**
   * Get the workout logs.
   *
   * @return a list of WorkoutLogs
   */
  List<? extends WorkoutLog> read();

  /**
   * Get a workout logContainer's details.
   *
   * @param uuid the logContainer id
   * @return the workout logContainer
   * @throws NotFoundException if the lof is not found
   */
  WorkoutLog read(UUID uuid) throws NotFoundException;

  /**
   * Creates a workout logContainer.
   *
   * @param request the dto to create such logContainer
   * @return the created workout logContainer
   */
  WorkoutLog create(CreateWorkoutLogRepoRequest request);

  /**
   * Deletes a workout logContainer.
   *
   * @param uuid the id of the logContainer
   */
  void delete(UUID uuid);

  /**
   * Get a logContainer object with only the id populated.
   *
   * @param uuid the id of the logContainer
   * @return the workout logContainer
   */
  WorkoutLog readReference(UUID uuid) throws NotFoundException;

  /**
   * Updates a workout logContainer.
   *
   * @param request the request to update a logContainer
   * @return the update logContainer
   */
  WorkoutLog update(UpdateWorkoutLogRepoRequest request)
      throws NotFoundException;

  /**
   * Checks whether a workout log exists by its id.
   *
   * @param id the id to check for
   * @return true if it exists
   */
  boolean exists(UUID id);
}
