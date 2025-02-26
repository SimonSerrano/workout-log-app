package com.marmouset.workout.app.trainedexercise.external.spring.database;

import com.marmouset.workout.app.exercise.entity.Exercise;
import com.marmouset.workout.app.workout.entity.WorkoutLog;
import java.util.List;
import org.springframework.data.repository.ListCrudRepository;

/**
 * Interface to declare a JPA repository of trained exercise impl.
 */
public interface JpaTrainedExerciseRepository extends
    ListCrudRepository<TrainedExerciseImpl, Long> {
  /**
   * Find a list of trained exercises by a workout log.
   *
   * @param log the log
   * @return a list of trained exercise
   */
  List<TrainedExerciseImpl> findByLog(WorkoutLog log);

  /**
   * Find a list of trained exercises by an exercise.
   *
   * @param exercise the exercise
   * @return a list of trained exercise
   */
  List<TrainedExerciseImpl> findByExercise(Exercise exercise);
}
