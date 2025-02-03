package com.marmouset.workout.external.database.workout;

import com.marmouset.workout.external.database.UuidBasedAbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * This class represents a workout log in the database.
 */
@Entity
@Table(name = "logs")
public class WorkoutLogEntity extends UuidBasedAbstractEntity {

  private String name;

  /**
   * Constructs a WorkoutLogEntity.
   */
  public WorkoutLogEntity() {
  }

  /**
   * Constructs a WorkoutLogEntity.
   *
   * @param name the name of the workout log
   */
  public WorkoutLogEntity(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
