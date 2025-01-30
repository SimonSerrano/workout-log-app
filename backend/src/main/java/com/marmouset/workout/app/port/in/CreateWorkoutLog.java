package com.marmouset.workout.app.port.in;

import com.marmouset.workout.app.port.in.dto.CreateWorkoutLogCommand;
import com.marmouset.workout.app.port.out.dto.WorkoutLogResponse;

public interface CreateWorkoutLog {
  WorkoutLogResponse createWorkoutLog(CreateWorkoutLogCommand command);
}
