package com.marmouset.workout.app.port.in;

import java.util.UUID;

import com.marmouset.workout.adapter.out.dto.WorkoutLogResponse;
import com.marmouset.workout.domain.WorkoutLogNotFound;

public interface GetLogDetailsPort {
  WorkoutLogResponse getDetails(UUID uuid) throws WorkoutLogNotFound;
}
