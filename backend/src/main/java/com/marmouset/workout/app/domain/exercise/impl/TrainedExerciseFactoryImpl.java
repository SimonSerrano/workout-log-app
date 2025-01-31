package com.marmouset.workout.app.domain.exercise.impl;

import com.marmouset.workout.app.domain.exercise.Exercise;
import com.marmouset.workout.app.domain.exercise.TrainedExercise;
import com.marmouset.workout.app.domain.exercise.TrainedExerciseFactory;
import org.springframework.stereotype.Component;

/**
 * Factory to instantiate trained exercises.
 */
@Component
public class TrainedExerciseFactoryImpl implements TrainedExerciseFactory {
  @Override
  public TrainedExercise create(Exercise exercise) {
    return new TrainedExerciseImpl(exercise);
  }
}
