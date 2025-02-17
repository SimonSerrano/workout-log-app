package com.marmouset.workout.external.database.exercise;

import com.marmouset.workout.app.port.out.exercise.ExerciseEntity;
import com.marmouset.workout.external.database.UuidBasedAbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * Class representing an Exercise in the db.
 */
@Entity
@Table(name = "exercises")
public class ExerciseEntityImpl
    extends UuidBasedAbstractEntity implements ExerciseEntity {

  @Column(unique = true)
  private String name;

  /**
   * Constructs an ExerciseEntity.
   */
  public ExerciseEntityImpl() {
  }

  /**
   * Constructs an ExerciseEntity.
   *
   * @param name the name of the exerciseContainer
   */
  public ExerciseEntityImpl(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
