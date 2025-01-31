package com.marmouset.workout.external.database.workout;

import com.marmouset.workout.app.domain.workout.WorkoutLog;
import com.marmouset.workout.app.domain.workout.WorkoutLogFactory;
import com.marmouset.workout.external.database.AbstractMapper;
import java.time.ZoneOffset;
import org.springframework.stereotype.Component;

@Component
class WorkoutLogMapper
    extends AbstractMapper<WorkoutLogFactory, WorkoutLogEntity, WorkoutLog> {


  /**
   * Creates this mapper.
   *
   * @param factory the factory to create O
   */
  public WorkoutLogMapper(WorkoutLogFactory factory) {
    super(factory);
  }

  public WorkoutLog toWorkoutLog(WorkoutLogEntity entity) {
    return map(entity);
  }

  @Override
  protected WorkoutLog map(WorkoutLogEntity toMap) {
    return factory.create(toMap.getId(), toMap.getName(),
        toMap.getCreatedAt().toInstant(
            ZoneOffset.UTC));
  }
}

