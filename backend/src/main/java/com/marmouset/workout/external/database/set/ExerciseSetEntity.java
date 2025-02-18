package com.marmouset.workout.external.database.set;

import com.marmouset.workout.external.database.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Class representing an exercise set entity in the db.
 */
@Entity
@Table(name = "sets")
public class ExerciseSetEntity extends AbstractEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

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

  public Long getId() {
    return id;
  }

  public void TEST_ONLY_setId(Long id) {
    this.id = id;
  }
}
