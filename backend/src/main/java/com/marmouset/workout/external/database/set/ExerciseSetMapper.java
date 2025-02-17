package com.marmouset.workout.external.database.set;

import com.marmouset.workout.app.domain.set.ExerciseSet;
import com.marmouset.workout.app.domain.set.ExerciseSetFactory;
import com.marmouset.workout.external.database.AbstractMapper;
import org.springframework.stereotype.Component;

/**
 * This class maps an exerciseContainer set entity to an exerciseContainer set.
 */
@Component
public class ExerciseSetMapper
    extends AbstractMapper<ExerciseSetFactory, ExerciseSetEntity, ExerciseSet> {
  /**
   * Creates this mapper.
   *
   * @param factory the factory to create O
   */
  public ExerciseSetMapper(ExerciseSetFactory factory) {
    super(factory);
  }

  /**
   * Maps an entity to a business object.
   *
   * @param entity the entity to map
   * @return the business object
   */
  public ExerciseSet toExerciseSet(ExerciseSetEntity entity) {
    return map(entity);
  }

  @Override
  protected ExerciseSet map(ExerciseSetEntity toMap) {
    return factory.create(toMap.getId(), toMap.getReps());
  }
}
