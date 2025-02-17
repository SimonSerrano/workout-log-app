package com.marmouset.workout.app.port.out.workout;

import com.marmouset.workout.app.domain.workout.WorkoutLog;
import com.marmouset.workout.external.database.exception.NotFoundException;
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
  List<WorkoutLog> read();

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
   * @throws NotFoundException if the logContainer is not found
   */
  WorkoutLogEntityContainer readReference(UUID uuid)
      throws NotFoundException;

  /**
   * Updates a workout logContainer.
   *
   * @param request the request to update a logContainer
   * @return the update logContainer
   */
  WorkoutLog update(UpdateWorkoutLogRepoRequest request)
      throws NotFoundException;
}
