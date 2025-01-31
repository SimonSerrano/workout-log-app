package com.marmouset.workout.app.port.in.workout;

import com.marmouset.workout.app.port.out.workout.WorkoutLogResponse;

/**
 * Interface for creating workout logs use case.
 */
public interface CreateWorkoutLog {
  /**
   * Creates workout logs.
   *
   * @param command the command
   * @return the workout log response
   */
  WorkoutLogResponse create(CreateWorkoutLogCommand command);
}
