package com.marmouset.workout.external.database.set;

import com.marmouset.workout.app.domain.set.ExerciseSet;
import com.marmouset.workout.app.domain.set.ExerciseSetFactory;
import com.marmouset.workout.external.database.AbstractMapper;
import org.springframework.stereotype.Component;

@Component
class ExerciseSetMapper
    extends AbstractMapper<ExerciseSetFactory, ExerciseSetEntity, ExerciseSet> {
  /**
   * Creates this mapper.
   *
   * @param factory the factory to create O
   */
  public ExerciseSetMapper(ExerciseSetFactory factory) {
    super(factory);
  }

  public ExerciseSet toTrainedExercise(ExerciseSetEntity entity) {
    return map(entity);
  }

  @Override
  protected ExerciseSet map(ExerciseSetEntity toMap) {
    return factory.create(toMap.getId(), toMap.getReps());
  }
}
