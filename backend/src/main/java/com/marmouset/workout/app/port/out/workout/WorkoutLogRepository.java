package com.marmouset.workout.app.port.out.workout;

import com.marmouset.workout.app.domain.workout.WorkoutLog;
import com.marmouset.workout.external.database.exception.NotFoundException;
import java.util.List;
import java.util.UUID;

/**
 * Interface for the workout log repository.
 */
public interface WorkoutLogRepository {
  /**
   * Get the workout logs.
   *
   * @return a list of WorkoutLogs
   */
  List<WorkoutLog> read();

  /**
   * Get a workout log's details.
   *
   * @param uuid the log id
   * @return the workout log
   * @throws NotFoundException if the lof is not found
   */
  WorkoutLog read(UUID uuid) throws NotFoundException;

  /**
   * Creates a workout log.
   *
   * @param request the dto to create such log
   * @return the created workout log
   */
  WorkoutLog create(CreateWorkoutLogRepoRequest request);

  /**
   * Deletes a workout log.
   *
   * @param uuid the id of the log
   */
  void delete(UUID uuid);

  /**
   * Get a log object with only the id populated.
   *
   * @param uuid the id of the log
   * @return the workout log
   * @throws NotFoundException if the log is not found
   */
  WorkoutLog readReference(UUID uuid) throws NotFoundException;

  /**
   * Updates a workout log.
   *
   * @param request the request to update a log
   * @return the update log
   */
  WorkoutLog update(UpdateWorkoutLogRepoRequest request)
      throws NotFoundException;
}
