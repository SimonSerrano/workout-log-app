package com.marmouset.workout.external.database.exercise;

import com.marmouset.workout.app.domain.exercise.Exercise;
import com.marmouset.workout.app.domain.exercise.ExerciseFactory;
import com.marmouset.workout.external.database.AbstractMapper;
import org.springframework.stereotype.Component;


@Component
class ExerciseMapper extends
    AbstractMapper<ExerciseFactory, ExerciseEntity, Exercise> {

  /**
   * Creates this mapper.
   *
   * @param factory the factory to create O
   */
  public ExerciseMapper(ExerciseFactory factory) {
    super(factory);
  }

  public Exercise toExercise(ExerciseEntity entity) {
    return map(entity);
  }

  @Override
  protected Exercise map(ExerciseEntity toMap) {
    return factory.create(toMap.getId(), toMap.getName());
  }
}
