package com.marmouset.workout.app.exercise.external.spring.database;

import com.marmouset.workout.app.exercise.entity.Exercise;
import com.marmouset.workout.app.exercise.entity.ExerciseFactory;

/**
 * Factory to create ExerciseImpl which are spring entities.
 */
public class ExerciseFactoryImpl
    implements ExerciseFactory {
  @Override
  public Exercise create(String name) {
    return new ExerciseImpl(name);
  }
}
