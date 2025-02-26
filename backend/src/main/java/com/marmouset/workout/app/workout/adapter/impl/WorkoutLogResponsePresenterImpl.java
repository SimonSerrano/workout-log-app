package com.marmouset.workout.app.workout.adapter.impl;

import com.marmouset.workout.app.workout.adapter.WorkoutLogResponsePresenter;
import com.marmouset.workout.app.workout.adapter.dto.WorkoutLogResponse;
import com.marmouset.workout.app.workout.entity.WorkoutLog;

/**
 * Converts data from the use cases to the web for workout logs.
 */
public class WorkoutLogResponsePresenterImpl
    implements WorkoutLogResponsePresenter {

  @Override
  public WorkoutLogResponse present(WorkoutLog log) {
    return new WorkoutLogResponse(
        log.getId(),
        log.getName(),
        log.getCreatedAt().getEpochSecond());
  }

}
