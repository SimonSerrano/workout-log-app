package com.marmouset.workout.app.port.in.workout;

import com.marmouset.workout.app.port.out.workout.WorkoutLogResponse;

public interface CreateWorkoutLog {
  WorkoutLogResponse createWorkoutLog(CreateWorkoutLogCommand command);
}
