package com.marmouset.workout.external.database.set;

import com.marmouset.workout.external.database.UuidBasedAbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * Class representing an exerciseContainer set entity in the db.
 */
@Entity
@Table(name = "sets")
public class ExerciseSetEntity extends UuidBasedAbstractEntity {

  private int reps;

  /**
   * Creates an exerciseContainer set entity.
   */
  public ExerciseSetEntity() {
  }

  public int getReps() {
    return reps;
  }

  public void setReps(int reps) {
    this.reps = reps;
  }

}
