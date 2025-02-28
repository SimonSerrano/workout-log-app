package com.marmouset.workout.app.exercise.adapter;

import com.marmouset.workout.app.exercise.entity.Exercise;
import java.util.List;
import java.util.Optional;

/**
 * Proxy interface to interact with a repository.
 */
public interface ExerciseRepositoryGateway {

  /**
   * Find all exercise entities.
   *
   * @return a list of exercise entities
   */
  List<? extends Exercise> findAll();

  /**
   * Get an exercise entity by its id.
   *
   * @param id the exercise entity id
   * @return the exercise entity
   */
  Exercise getReferenceById(String id);

  /**
   * Saves an exercise entity.
   *
   * @param exercise the exercise to save
   * @return the saved exercise
   */
  Exercise save(Exercise exercise);

  /**
   * Find an exercise by its id.
   *
   * @param id the id
   * @return an optional containing the exercise or empty if not found
   */
  Optional<? extends Exercise> findById(String id);

}
