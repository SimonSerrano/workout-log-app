package com.marmouset.workout.app.domain.exercise.impl;

import com.marmouset.workout.app.domain.exercise.Exercise;
import com.marmouset.workout.app.domain.exercise.TrainedExercise;
import com.marmouset.workout.app.domain.exercise.TrainedExerciseFactory;
import java.util.UUID;
import org.springframework.stereotype.Component;


@Component
class TrainedExerciseFactoryImpl implements TrainedExerciseFactory {

  @Override
  public TrainedExercise create(Long id, UUID logId, Exercise exercise) {
    return new TrainedExerciseImpl(id, logId, exercise);
  }
}
