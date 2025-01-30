package com.marmouset.workout.external.database.set;

import com.marmouset.workout.external.database.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "sets")
public class ExerciseSetEntity extends AbstractEntity {

  private int reps;

  public ExerciseSetEntity() {
  }

  public ExerciseSetEntity(int reps) {
    this.reps = reps;
  }

  public int getReps() {
    return reps;
  }

  public void setReps(int reps) {
    this.reps = reps;
  }

}
