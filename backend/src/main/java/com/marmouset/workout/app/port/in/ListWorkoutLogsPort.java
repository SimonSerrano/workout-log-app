package com.marmouset.workout.app.port.in;

import com.marmouset.workout.adapter.out.dto.WorkoutLogResponse;

public interface ListWorkoutLogsPort {
  Iterable<WorkoutLogResponse> listWorkouts();
}
