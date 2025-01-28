package com.marmouset.workout.app.port.in;

import com.marmouset.workout.adapter.in.dto.CreateWorkoutLogCommand;
import com.marmouset.workout.domain.WorkoutLog;

public interface CreateWorkoutLogPort {
  WorkoutLog createWorkoutLog(CreateWorkoutLogCommand command);
}
