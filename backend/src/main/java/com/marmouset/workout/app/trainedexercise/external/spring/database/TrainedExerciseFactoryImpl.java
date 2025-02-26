package com.marmouset.workout.app.trainedexercise.external.spring.database;

import com.marmouset.workout.app.exercise.entity.Exercise;
import com.marmouset.workout.app.trainedexercise.entity.TrainedExercise;
import com.marmouset.workout.app.trainedexercise.entity.TrainedExerciseFactory;

/**
 * Factory to create TrainedExerciseImpl.
 */
public class TrainedExerciseFactoryImpl implements TrainedExerciseFactory {
  @Override
  public TrainedExercise create() {
    return new TrainedExerciseImpl();
  }

  @Override
  public TrainedExercise create(Exercise exercise) {
    return new TrainedExerciseImpl().setExercise(exercise);
  }
}
