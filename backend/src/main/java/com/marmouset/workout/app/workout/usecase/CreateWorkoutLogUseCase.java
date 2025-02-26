package com.marmouset.workout.app.workout.usecase;

import com.marmouset.workout.app.workout.entity.WorkoutLog;
import com.marmouset.workout.app.workout.usecase.dto.CreateWorkoutLogCommand;

/**
 * Interface for creating workout logs use case.
 */
public interface CreateWorkoutLogUseCase {
  /**
   * Creates workout logs.
   *
   * @param command the command
   * @return the workout logContainer response
   */
  WorkoutLog create(CreateWorkoutLogCommand command);
}
