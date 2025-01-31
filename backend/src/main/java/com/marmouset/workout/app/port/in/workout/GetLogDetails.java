package com.marmouset.workout.app.port.in.workout;

import com.marmouset.workout.app.domain.workout.WorkoutLogNotFoundException;
import com.marmouset.workout.app.port.out.workout.WorkoutLogResponse;
import java.util.UUID;

/**
 * Interface for the log details collections use case.
 */
public interface GetLogDetails {
  /**
   * Get the details of a log.
   *
   * @param uuid the id of the log
   * @return the workout log as a response
   * @throws WorkoutLogNotFoundException if the log is not found
   */
  WorkoutLogResponse get(UUID uuid) throws WorkoutLogNotFoundException;
}
