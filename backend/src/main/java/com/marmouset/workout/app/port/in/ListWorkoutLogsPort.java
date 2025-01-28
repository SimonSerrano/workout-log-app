package com.marmouset.workout.app.port.in;

import com.marmouset.workout.domain.WorkoutLogListElementDTO;

public interface ListWorkoutLogsPort {
  Iterable<WorkoutLogListElementDTO> listWorkouts();
}
