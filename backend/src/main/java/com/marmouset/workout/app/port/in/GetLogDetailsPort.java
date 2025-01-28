package com.marmouset.workout.app.port.in;

import java.util.UUID;

import com.marmouset.workout.domain.WorkoutLog;
import com.marmouset.workout.domain.WorkoutLogNotFound;

public interface GetLogDetailsPort {
  WorkoutLog getDetails(UUID uuid) throws WorkoutLogNotFound;
}
