package com.marmouset.workout.external.database.workout;

import com.marmouset.workout.external.database.AbstractEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "logs")
public class WorkoutLogEntity extends AbstractEntity {

  private String name;

  public WorkoutLogEntity() {
  }

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
