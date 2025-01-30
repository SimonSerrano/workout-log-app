package com.marmouset.workout.external.database.exercise;

import com.marmouset.workout.app.domain.exercise.Exercise;
import org.springframework.stereotype.Component;

/**
 * Mapper for the exercise db entity to the business entity
 */
@Component
public class ExerciseMapper {
  /**
   * Maps the db entity to the business entity.
   *
   * @param entity the db entity to map
   * @return the mapped db entity
   */
  public Exercise toExercise(ExerciseEntity entity) {
    return null;
  }
}
