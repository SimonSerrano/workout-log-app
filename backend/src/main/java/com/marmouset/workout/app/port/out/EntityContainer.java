package com.marmouset.workout.app.port.out;

/**
 * Interface that describes how a JPA interface is held.
 * This interface does not reference the db layer.
 */
public interface EntityContainer<I, R extends Entity<I>> {


  /**
   * Get the jpa reference.
   *
   * @return the entity
   */
  R reference();

}
