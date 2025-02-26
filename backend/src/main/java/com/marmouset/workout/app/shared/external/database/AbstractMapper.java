package com.marmouset.workout.app.shared.external.database;

/**
 * Abstract class for a mapper implementation.
 *
 * @param <F> the factory to create objects of type O
 * @param <I> the type of the input object
 * @param <O> the type of the output object
 */
public abstract class AbstractMapper<F, I, O> {
  protected F factory;

  /**
   * Creates this mapper.
   *
   * @param factory the factory to create O
   */
  public AbstractMapper(F factory) {
    this.factory = factory;
  }

  /**
   * Maps I to O.
   *
   * @param toMap the object to map
   * @return the mapped object
   */
  protected abstract O map(I toMap);
}
