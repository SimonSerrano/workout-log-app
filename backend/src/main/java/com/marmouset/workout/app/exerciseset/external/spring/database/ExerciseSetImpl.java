package com.marmouset.workout.app.exerciseset.external.spring.database;

import com.marmouset.workout.app.exerciseset.entity.ExerciseSet;
import com.marmouset.workout.app.shared.external.database.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;

/**
 * Class representing an exercise set entity in the db.
 */
@Entity
@Table(name = "sets")
public class ExerciseSetImpl extends AbstractEntity implements ExerciseSet {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Min(1)
  private int reps;

  /**
   * Creates an exercise set entity.
   */
  public ExerciseSetImpl() {
  }

  /**
   * Creates an ExerciseSetImpl.
   *
   * @param reps the number of reps
   */
  public ExerciseSetImpl(int reps) {
    super();
    this.reps = reps;
  }

  public int getReps() {
    return reps;
  }

  /**
   * Sets the reps.
   *
   * @param reps the number of reps.
   * @return this
   */
  public ExerciseSet setReps(int reps) {
    this.reps = reps;
    return this;
  }

  public Long getId() {
    return id;
  }

}
