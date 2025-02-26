package com.marmouset.workout.app.workout.external.spring.database;

import com.marmouset.workout.app.workout.entity.WorkoutLog;
import com.marmouset.workout.app.workout.entity.WorkoutLogFactory;

/**
 * Factory to create workout logs.
 */
public class WorkoutLogFactoryImpl implements WorkoutLogFactory {
  @Override
  public WorkoutLog create(String name) {
    return new WorkoutLogImpl(name);
  }
}
