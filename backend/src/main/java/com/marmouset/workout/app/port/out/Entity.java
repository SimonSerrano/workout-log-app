package com.marmouset.workout.app.port.out;

/**
 * Generic interface that represents an entity.
 *
 * @param <I> the id type of that entity
 */
public interface Entity<I> {

  /**
   * Get the id of this entity.
   *
   * @return the id
   */
  I getId();

}
