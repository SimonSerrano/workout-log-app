package com.marmouset.workout.external.database.workout;

import com.marmouset.workout.app.port.out.workout.WorkoutLogEntityContainer;
import java.util.Objects;

record WorkoutLogEntityContainerImpl(WorkoutLogEntityImpl reference)
    implements WorkoutLogEntityContainer {

  WorkoutLogEntityContainerImpl {
    Objects.requireNonNull(reference, "Workout log entity cannot be null");
  }
}
