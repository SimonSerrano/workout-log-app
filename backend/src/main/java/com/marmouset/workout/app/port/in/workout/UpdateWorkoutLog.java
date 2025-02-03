package com.marmouset.workout.app.port.in.workout;

import com.marmouset.workout.app.domain.workout.WorkoutLogNotFoundException;
import com.marmouset.workout.app.port.out.workout.WorkoutLogResponse;

/**
 * Interface for the update workout log use case.
 */
public interface UpdateWorkoutLog {

  /**
   * Updates a workout log.
   *
   * @param command update command
   * @return the updated workout log
   */
  WorkoutLogResponse update(UpdateWorkoutLogCommand command)
      throws WorkoutLogNotFoundException;
}
