package com.marmouset.workout.app.port.out.workout;

import com.marmouset.workout.app.domain.workout.WorkoutLog;

/**
 * Presenter for WorkoutLog.
 */
public interface WorkoutLogPresenter {
  /**
   * Presents a WorkoutLog to a WorkoutLogResponse.
   *
   * @param log the log to present
   * @return the response
   */
  WorkoutLogResponse present(WorkoutLog log);
}
