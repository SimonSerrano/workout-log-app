package com.marmouset.workout.external.database.exercise.trained;

import com.marmouset.workout.app.domain.exercise.TrainedExercise;
import com.marmouset.workout.app.domain.exercise.TrainedExerciseFactory;
import com.marmouset.workout.external.database.AbstractMapper;
import com.marmouset.workout.external.database.exercise.ExerciseMapper;
import com.marmouset.workout.external.database.set.ExerciseSetMapper;
import org.springframework.stereotype.Component;


/**
 * Mapper between the database entity and the domain's entity.
 */
@Component
public class TrainedExerciseMapper extends
    AbstractMapper<TrainedExerciseFactory, TrainedExerciseEntity, TrainedExercise> {

  private final ExerciseMapper exerciseMapper;
  private final ExerciseSetMapper exerciseSetMapper;

  /**
   * Creates this mapper.
   *
   * @param factory           the factory to create O
   * @param exerciseMapper    mapper for the exercise
   * @param exerciseSetMapper mapper for the exercise set
   */
  public TrainedExerciseMapper(TrainedExerciseFactory factory,
                               ExerciseMapper exerciseMapper,
                               ExerciseSetMapper exerciseSetMapper) {
    super(factory);
    this.exerciseMapper = exerciseMapper;
    this.exerciseSetMapper = exerciseSetMapper;
  }

  /**
   * Maps db entity with business entity.
   *
   * @param entity the db entity to map
   * @return the business entity
   */
  public TrainedExercise toTrainedExercise(TrainedExerciseEntity entity) {
    return map(entity);
  }

  @Override
  protected TrainedExercise map(TrainedExerciseEntity toMap) {
    var result = factory.create(toMap.getId(),
        exerciseMapper.toExercise(toMap.getExercise()));
    return result.addAllSets(
        toMap.getSets().stream().map(exerciseSetMapper::toExerciseSet)
            .toList());
  }
}
