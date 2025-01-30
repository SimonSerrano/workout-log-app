package com.marmouset.workout.app.domain.exercise;

import java.util.UUID;

/**
 * Factory to create Exercises.
 */
public interface ExerciseFactory {
  /**
   * Creates an exercise.
   *
   * @param id   the unique id of that exercise
   * @param name the unique name of that exercise
   * @return the exercise
   */
  Exercise create(UUID id, String name);
}
