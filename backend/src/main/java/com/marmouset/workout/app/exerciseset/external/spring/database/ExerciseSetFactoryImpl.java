package com.marmouset.workout.app.exerciseset.external.spring.database;

import com.marmouset.workout.app.exerciseset.entity.ExerciseSet;
import com.marmouset.workout.app.exerciseset.entity.ExerciseSetFactory;
import org.springframework.stereotype.Component;

/**
 * Creates exerciseContainer set implementations.
 */
@Component
public class ExerciseSetFactoryImpl implements ExerciseSetFactory {
  @Override
  public ExerciseSet create(int reps) {
    return new ExerciseSetImpl(reps);
  }
}
