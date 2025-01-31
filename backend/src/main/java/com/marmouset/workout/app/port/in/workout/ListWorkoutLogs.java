package com.marmouset.workout.app.port.in.workout;

import com.marmouset.workout.app.port.out.workout.WorkoutLogResponse;
import java.util.List;

/**
 * Interface for listing workout logs use case.
 */
public interface ListWorkoutLogs {
  /**
   * List workout logs.
   *
   * @return workout logs
   */
  List<WorkoutLogResponse> list();
}
