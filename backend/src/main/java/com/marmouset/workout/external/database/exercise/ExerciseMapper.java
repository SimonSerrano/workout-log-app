package com.marmouset.workout.external.database.exercise;

import com.marmouset.workout.app.domain.exercise.Exercise;
import com.marmouset.workout.app.domain.exercise.ExerciseFactory;
import org.springframework.stereotype.Component;


@Component
class ExerciseMapper {

  private final ExerciseFactory factory;

  ExerciseMapper(ExerciseFactory factory) {
    this.factory = factory;
  }

  public Exercise toExercise(ExerciseEntity entity) {
    return factory.create(entity.getId(), entity.getName());
  }
}
