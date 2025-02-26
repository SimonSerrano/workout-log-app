package com.marmouset.workout.app.workout.external.spring.database;

import com.marmouset.workout.app.shared.external.database.UuidBasedAbstractEntity;
import com.marmouset.workout.app.workout.entity.WorkoutLog;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * This class represents a workout logContainer in the database.
 */
@Entity
@Table(name = "logs")
public class WorkoutLogImpl
    extends UuidBasedAbstractEntity implements
    WorkoutLog {

  @NotNull
  @NotEmpty
  @Size(min = 1, max = 200)
  private String name;

  /**
   * Constructs a WorkoutLogEntity.
   */
  public WorkoutLogImpl() {
  }

  /**
   * Constructs a WorkoutLogEntity.
   *
   * @param name the name of the workout logContainer
   */
  public WorkoutLogImpl(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public WorkoutLog rename(String name) {
    setName(name);
    return this;
  }

}
