package com.marmouset.workout.external.database.exercise.trained;

import com.marmouset.workout.app.domain.exercise.TrainedExercise;
import org.springframework.stereotype.Component;


/**
 * Mapper between the database entity and the domain's entity.
 */
@Component
public class TrainedExerciseMapper {

  /**
   * Maps db entity with business entity.
   *
   * @param entity the db entity to map
   * @return the business entity
   */
  public TrainedExercise toTrainedExercise(TrainedExerciseEntity entity) {
    return null;
  }
}
