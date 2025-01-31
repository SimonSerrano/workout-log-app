package com.marmouset.workout.app.port.in;

import com.marmouset.workout.app.domain.workout.WorkoutLogNotFound;
import com.marmouset.workout.app.port.out.dto.WorkoutLogResponse;
import java.util.UUID;

public interface GetLogDetails {
  WorkoutLogResponse getDetails(UUID uuid) throws WorkoutLogNotFound;
}
