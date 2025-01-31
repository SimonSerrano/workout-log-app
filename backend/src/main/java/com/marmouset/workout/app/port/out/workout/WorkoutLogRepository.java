package com.marmouset.workout.app.port.out.workout;

import com.marmouset.workout.app.domain.workout.WorkoutLog;
import com.marmouset.workout.external.database.exception.NotFoundException;
import java.util.UUID;

public interface WorkoutLogRepository {
  Iterable<WorkoutLog> getAllLogs();

  WorkoutLog getLogDetails(UUID uuid) throws NotFoundException;

  WorkoutLog createWorkoutLog(CreateWorkoutLogRepoRequest request);

  void deleteWorkoutLog(UUID uuid);

  WorkoutLog getLogReference(UUID uuid) throws NotFoundException;
}
