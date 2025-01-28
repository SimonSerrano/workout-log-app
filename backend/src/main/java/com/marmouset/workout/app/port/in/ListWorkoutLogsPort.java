package com.marmouset.workout.app.port.in;

import com.marmouset.workout.adapter.out.dto.WorkoutLogListElementResponse;

public interface ListWorkoutLogsPort {
  Iterable<WorkoutLogListElementResponse> listWorkouts();
}
