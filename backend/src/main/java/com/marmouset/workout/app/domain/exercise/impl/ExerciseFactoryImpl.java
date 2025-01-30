package com.marmouset.workout.app.domain.exercise.impl;

import com.marmouset.workout.app.domain.exercise.Exercise;
import com.marmouset.workout.app.domain.exercise.ExerciseFactory;
import java.util.UUID;
import org.springframework.stereotype.Component;

/**
 * Class to instantiate exercises.
 */
@Component
public class ExerciseFactoryImpl implements ExerciseFactory {
  @Override
  public Exercise create(UUID id, String name) {
    return new ExerciseImpl(name);
  }
}
