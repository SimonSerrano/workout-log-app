package com.marmouset.workout.app.port.in;

import com.marmouset.workout.app.port.out.dto.WorkoutLogResponse;

public interface ListWorkoutLogs {
  Iterable<WorkoutLogResponse> listWorkouts();
}
