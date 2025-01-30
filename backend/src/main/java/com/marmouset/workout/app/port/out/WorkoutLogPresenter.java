package com.marmouset.workout.app.port.out;

import com.marmouset.workout.app.domain.workout.WorkoutLog;
import com.marmouset.workout.app.port.out.dto.WorkoutLogResponse;

public interface WorkoutLogPresenter {
  WorkoutLogResponse prepareSuccessfulResponse(WorkoutLog log);
}
