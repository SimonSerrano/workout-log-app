package com.marmouset.workout.app.domain.workout.impl;

import java.time.Instant;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.marmouset.workout.app.domain.workout.WorkoutLog;
import com.marmouset.workout.app.domain.workout.WorkoutLogFactory;

@Component
public class WorkoutLogFactoryImpl implements WorkoutLogFactory {

  @Override
  public WorkoutLog create(UUID id, String name, Instant createdAt) {
    return new WorkoutLogImpl(id, name, createdAt);
  }

}
