package com.marmouset.workout.app.exercise.practice;

import com.marmouset.workout.app.util.AbstractEntity;

import jakarta.persistence.Entity;

@Entity
public class Practice extends AbstractEntity {
  private Long repetition;

  public Practice() {
  }

  public Practice(Long repetition) {
    this.repetition = repetition;
  }

  public Long getRepetition() {
    return repetition;
  }

  public void setRepetition(Long repetition) {
    this.repetition = repetition;
  }

}
