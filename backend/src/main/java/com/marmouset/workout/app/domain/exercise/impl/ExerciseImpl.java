package com.marmouset.workout.app.domain.exercise.impl;

import com.marmouset.workout.app.domain.exercise.Exercise;


record ExerciseImpl(String name) implements Exercise {
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    ExerciseImpl exercise = (ExerciseImpl) o;

    return name.equals(exercise.name);
  }

}
