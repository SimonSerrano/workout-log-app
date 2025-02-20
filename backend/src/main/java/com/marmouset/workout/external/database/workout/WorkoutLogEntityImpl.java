package com.marmouset.workout.external.database.workout;

import com.marmouset.workout.app.port.out.workout.WorkoutLogEntity;
import com.marmouset.workout.external.database.UuidBasedAbstractEntity;
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
public class WorkoutLogEntityImpl
    extends UuidBasedAbstractEntity implements WorkoutLogEntity {

  @NotNull
  @NotEmpty
  @Size(min = 1, max = 200)
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
