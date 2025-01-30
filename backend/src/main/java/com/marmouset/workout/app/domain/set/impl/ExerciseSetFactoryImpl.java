package com.marmouset.workout.app.domain.set.impl;

import com.marmouset.workout.app.domain.set.ExerciseSet;
import com.marmouset.workout.app.domain.set.ExerciseSetFactory;
import org.springframework.stereotype.Component;

/**
 * Creates exercise set implementations.
 */
@Component
public class ExerciseSetFactoryImpl implements ExerciseSetFactory {
  @Override
  public ExerciseSet create(int reps) {
    return new ExerciseSetImpl(reps);
  }
}
