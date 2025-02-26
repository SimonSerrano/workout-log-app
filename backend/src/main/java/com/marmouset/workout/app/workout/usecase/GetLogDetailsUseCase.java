package com.marmouset.workout.app.workout.usecase;

import com.marmouset.workout.app.workout.entity.WorkoutLog;
import com.marmouset.workout.app.workout.entity.WorkoutLogNotFoundException;
import java.util.UUID;

/**
 * Interface for the logContainer details collections use case.
 */
public interface GetLogDetailsUseCase {
  /**
   * Get the details of a logContainer.
   *
   * @param uuid the id of the logContainer
   * @return the workout logContainer as a response
   * @throws WorkoutLogNotFoundException if the logContainer is not found
   */
  WorkoutLog get(UUID uuid) throws WorkoutLogNotFoundException;
}
