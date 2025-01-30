package com.marmouset.workout.app.port.out;

import java.util.UUID;

import com.marmouset.workout.app.domain.WorkoutLogNotFound;
import com.marmouset.workout.app.domain.workout.WorkoutLog;
import com.marmouset.workout.app.port.out.dto.CreateWorkoutLogRepoRequest;

public interface WorkoutLogRepository {
  Iterable<WorkoutLog> getAllLogs();

  WorkoutLog getLogDetails(UUID uuid) throws WorkoutLogNotFound;

  WorkoutLog createWorkoutLog(CreateWorkoutLogRepoRequest request);

  void deleteWorkoutLog(UUID uuid);

  WorkoutLog getLogReference(UUID uuid);
}
