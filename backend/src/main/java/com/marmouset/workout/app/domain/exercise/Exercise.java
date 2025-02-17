package com.marmouset.workout.app.domain.exercise;

import java.util.UUID;

/**
 * Interface for the Exercise business object.
 */
public interface Exercise {

  /**
   * Getter for the name.
   *
   * @return the name of the exerciseContainer
   */
  String name();

  /**
   * Getter for the id.
   *
   * @return the id of the exerciseContainer
   */
  UUID id();

}
