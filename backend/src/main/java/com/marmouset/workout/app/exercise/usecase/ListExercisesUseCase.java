package com.marmouset.workout.app.exercise.usecase;

import com.marmouset.workout.app.exercise.entity.Exercise;
import java.util.List;

/**
 * Interface for listing exercises use case.
 */
public interface ListExercisesUseCase {
  /**
   * List exercises.
   *
   * @return exercises
   */
  List<? extends Exercise> list();
}
