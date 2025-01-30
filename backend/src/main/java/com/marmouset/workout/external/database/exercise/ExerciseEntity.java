package com.marmouset.workout.external.database.exercise;

import com.marmouset.workout.external.database.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * Class representing an Exercise in the db
 */
@Entity
@Table(name = "exercises")
public class ExerciseEntity extends AbstractEntity {

  @Column(unique = true)
  private String name;

  /**
   * Constructs an ExerciseEntity.
   */
  public ExerciseEntity() {
  }

  /**
   * Constructs an ExerciseEntity.
   *
   * @param name the title of the exercise
   */
  public ExerciseEntity(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
