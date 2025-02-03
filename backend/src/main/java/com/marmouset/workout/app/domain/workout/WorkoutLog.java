package com.marmouset.workout.app.domain.workout;

import com.marmouset.workout.app.domain.exercise.TrainedExercise;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

/**
 * Interface that represents a workout log.
 */
public interface WorkoutLog {

  /**
   * Get the id.
   *
   * @return the id
   */
  UUID getId();

  /**
   * Get the name.
   *
   * @return the name
   */
  String getName();

  /**
   * Rename the workout.
   *
   * @param name the new name
   */
  void rename(String name);

  /**
   * Get trained exercises.
   *
   * @return the trained exercises.
   */
  List<TrainedExercise> getExercises();

  /**
   * Add a trained exercise.
   *
   * @param exercise the exercise to add
   * @return this
   */
  WorkoutLog addExercise(TrainedExercise exercise);

  /**
   * Get the instant of creation.
   *
   * @return the instant of creation
   */
  Instant getCreatedAt();

}
