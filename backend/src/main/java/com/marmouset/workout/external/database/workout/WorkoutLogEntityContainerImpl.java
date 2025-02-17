package com.marmouset.workout.external.database.workout;

import com.marmouset.workout.app.port.out.workout.WorkoutLogEntityContainer;

record WorkoutLogEntityContainerImpl(WorkoutLogEntityImpl reference)
    implements WorkoutLogEntityContainer {

}
