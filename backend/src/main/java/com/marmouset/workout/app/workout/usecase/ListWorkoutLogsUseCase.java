package com.marmouset.workout.app.workout.usecase;

import com.marmouset.workout.app.workout.entity.WorkoutLog;
import java.util.List;

/**
 * Interface for listing workout logs use case.
 */
public interface ListWorkoutLogsUseCase {
  /**
   * List workout logs.
   *
   * @return workout logs
   */
  List<? extends WorkoutLog> list();
}
