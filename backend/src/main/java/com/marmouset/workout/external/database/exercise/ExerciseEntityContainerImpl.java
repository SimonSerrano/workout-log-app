package com.marmouset.workout.external.database.exercise;

import com.marmouset.workout.app.port.out.exercise.ExerciseEntity;
import com.marmouset.workout.app.port.out.exercise.ExerciseEntityContainer;
import java.util.Objects;

record ExerciseEntityContainerImpl(ExerciseEntity reference)
    implements ExerciseEntityContainer {
  ExerciseEntityContainerImpl {
    Objects.requireNonNull(reference, "Exercise entity cannot be null");
  }
}
