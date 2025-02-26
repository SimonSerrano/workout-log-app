package com.marmouset.workout.app.workout.usecase;

import com.marmouset.workout.app.workout.entity.WorkoutLog;
import com.marmouset.workout.app.workout.entity.WorkoutLogNotFoundException;
import com.marmouset.workout.app.workout.usecase.dto.UpdateWorkoutLogCommand;

/**
 * Interface for the update workout logContainer use case.
 */
public interface UpdateWorkoutLogUseCase {

  /**
   * Updates a workout log.
   *
   * @param command update command
   * @return the updated workout logContainer
   */
  WorkoutLog update(UpdateWorkoutLogCommand command)
      throws WorkoutLogNotFoundException;
}
