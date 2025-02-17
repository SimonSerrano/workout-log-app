package com.marmouset.workout.app.port.out.exercise;

import com.marmouset.workout.app.port.out.Entity;
import java.util.UUID;

/**
 * Interface representing an exercise entity.
 */
public interface ExerciseEntity extends Entity<UUID> {

  /**
   * Gets the name of the exercise.
   *
   * @return the name
   */
  String getName();
}
