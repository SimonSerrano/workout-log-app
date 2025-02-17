package com.marmouset.workout.external.database.workout;

import com.marmouset.workout.app.port.out.workout.WorkoutLogEntity;
import com.marmouset.workout.external.database.UuidBasedAbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * This class represents a workout logContainer in the database.
 */
@Entity
@Table(name = "logs")
public class WorkoutLogEntityImpl
    extends UuidBasedAbstractEntity implements WorkoutLogEntity {

  private String name;

  /**
   * Constructs a WorkoutLogEntity.
   */
  public WorkoutLogEntityImpl() {
  }

  /**
   * Constructs a WorkoutLogEntity.
   *
   * @param name the name of the workout logContainer
   */
  public WorkoutLogEntityImpl(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
