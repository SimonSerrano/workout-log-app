package com.marmouset.workout.app.exercise;

import com.marmouset.workout.app.exercise.entity.Exercise;

/**
 * Exercise test double with static values.
 */
public class ExerciseTestDouble implements Exercise {

  private final String name = "Pull ups";

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getId() {
    return name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    ExerciseTestDouble that = (ExerciseTestDouble) o;

    return name.equals(that.name);
  }

  @Override
  public int hashCode() {
    return name.hashCode();
  }
}
