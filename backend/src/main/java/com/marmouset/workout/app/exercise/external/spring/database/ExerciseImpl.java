package com.marmouset.workout.app.exercise.external.spring.database;

import com.marmouset.workout.app.exercise.entity.Exercise;
import com.marmouset.workout.app.shared.external.database.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

/**
 * Class representing an Exercise in the db.
 */
@Entity
@Table(name = "exercises")
public class ExerciseImpl
    extends AbstractEntity implements Exercise {

  @Id
  @Column(unique = true)
  @Size(min = 2, max = 200)
  private String name;

  /**
   * Constructs an ExerciseEntity.
   */
  public ExerciseImpl() {
  }

  /**
   * Constructs an ExerciseEntity.
   *
   * @param name the name of the exerciseContainer
   */
  public ExerciseImpl(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String getId() {
    return name;
  }
}
