package com.marmouset.workout.app.port.out.workout;

import com.marmouset.workout.app.domain.workout.WorkoutLog;

public interface WorkoutLogPresenter {
  WorkoutLogResponse prepareSuccessfulResponse(WorkoutLog log);
}
