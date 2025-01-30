package com.marmouset.workout.app.port.in;

import com.marmouset.workout.adapter.in.dto.CreateWorkoutLogCommand;
import com.marmouset.workout.adapter.out.dto.WorkoutLogResponse;

public interface CreateWorkoutLogPort {
  WorkoutLogResponse createWorkoutLog(CreateWorkoutLogCommand command);
}
