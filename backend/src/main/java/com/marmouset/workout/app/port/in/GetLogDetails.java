package com.marmouset.workout.app.port.in;

import java.util.UUID;

import com.marmouset.workout.app.domain.WorkoutLogNotFound;
import com.marmouset.workout.app.port.out.dto.WorkoutLogResponse;

public interface GetLogDetails {
  WorkoutLogResponse getDetails(UUID uuid) throws WorkoutLogNotFound;
}
