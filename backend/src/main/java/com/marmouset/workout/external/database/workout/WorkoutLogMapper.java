package com.marmouset.workout.external.database.workout;

import com.marmouset.workout.app.domain.workout.WorkoutLog;
import com.marmouset.workout.app.domain.workout.WorkoutLogFactory;
import com.marmouset.workout.external.database.AbstractMapper;
import org.springframework.stereotype.Component;

@Component
class WorkoutLogMapper
    extends
    AbstractMapper<WorkoutLogFactory, WorkoutLogEntityImpl, WorkoutLog> {


  /**
   * Creates this mapper.
   *
   * @param factory the factory to create O
   */
  public WorkoutLogMapper(WorkoutLogFactory factory) {
    super(factory);
  }

  public WorkoutLog toWorkoutLog(WorkoutLogEntityImpl entity) {
    return map(entity);
  }

  @Override
  protected WorkoutLog map(WorkoutLogEntityImpl toMap) {
    return factory.create(
        toMap.getId(),
        toMap.getName(),
        toMap.getCreatedAt());
  }
}

