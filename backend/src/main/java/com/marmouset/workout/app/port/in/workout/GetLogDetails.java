package com.marmouset.workout.app.port.in.workout;

import com.marmouset.workout.app.domain.workout.WorkoutLogNotFoundException;
import com.marmouset.workout.app.port.out.workout.WorkoutLogResponse;
import java.util.UUID;

public interface GetLogDetails {
  WorkoutLogResponse getDetails(UUID uuid) throws WorkoutLogNotFoundException;
}
