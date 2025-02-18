package com.marmouset.workout.app.domain.exercise.impl;

import com.marmouset.workout.app.domain.exercise.Exercise;
import com.marmouset.workout.app.domain.exercise.ExerciseFactory;
import org.springframework.stereotype.Component;

/**
 * Class to instantiate exercises.
 */
@Component
public class ExerciseFactoryImpl implements ExerciseFactory {
  @Override
  public Exercise create(String name) {
    return new ExerciseImpl(name);
  }
}
