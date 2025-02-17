package com.marmouset.workout.app.port.in.workout;

import com.marmouset.workout.app.domain.workout.WorkoutLogNotFoundException;
import com.marmouset.workout.app.port.out.workout.WorkoutLogResponse;
import java.util.UUID;

/**
 * Interface for the logContainer details collections use case.
 */
public interface GetLogDetails {
  /**
   * Get the details of a logContainer.
   *
   * @param uuid the id of the logContainer
   * @return the workout logContainer as a response
   * @throws WorkoutLogNotFoundException if the logContainer is not found
   */
  WorkoutLogResponse get(UUID uuid) throws WorkoutLogNotFoundException;
}
