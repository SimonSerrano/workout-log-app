package com.marmouset.workout.app.port.out;

/**
 * Interface to describe what a presenter is.
 *
 * @param <I> the input type
 * @param <O> the output type
 */
public interface Presenter<I, O> {
  /**
   * Present I in O.
   *
   * @param in the object to present
   * @return the presented object
   */
  O present(I in);
}
