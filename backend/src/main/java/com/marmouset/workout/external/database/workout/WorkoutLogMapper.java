package com.marmouset.workout.external.database.workout;

import com.marmouset.workout.app.domain.workout.WorkoutLog;
import com.marmouset.workout.app.domain.workout.WorkoutLogFactory;
import java.time.ZoneOffset;
import org.springframework.stereotype.Component;

@Component
class WorkoutLogMapper {

  private final WorkoutLogFactory factory;

  WorkoutLogMapper(WorkoutLogFactory factory) {
    this.factory = factory;
  }

  public WorkoutLog toWorkoutLog(WorkoutLogEntity entity) {
    return factory.create(entity.getId(), entity.getName(),
        entity.getCreatedAt().toInstant(
            ZoneOffset.UTC));
  }
}

