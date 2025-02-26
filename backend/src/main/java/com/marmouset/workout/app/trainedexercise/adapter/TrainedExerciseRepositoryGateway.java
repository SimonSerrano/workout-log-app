package com.marmouset.workout.app.trainedexercise.adapter;

import com.marmouset.workout.app.trainedexercise.entity.TrainedExercise;
import com.marmouset.workout.app.workout.entity.WorkoutLog;
import java.util.List;
import java.util.Optional;

/**
 * Interface to convert data from the use cases to the db and vice versa.
 */
public interface TrainedExerciseRepositoryGateway {

  /**
   * Find trained exercises by its log.
   *
   * @param log the log
   * @return a list of trained exercises
   */
  List<? extends TrainedExercise> findByLog(WorkoutLog log);


  /**
   * Saves a trained exercise.
   *
   * @param trainedExerciseEntity the entity to save
   * @return the saved trained exercise
   */
  TrainedExercise save(TrainedExercise trainedExerciseEntity);


  /**
   * Delete a trained exercise by its id.
   *
   * @param trainedId the id
   */
  void deleteById(Long trainedId);


  /**
   * Find a trained exercise by its id.
   *
   * @param id the id
   * @return an optional of trained exercise
   */
  Optional<? extends TrainedExercise> findById(Long id);
}
