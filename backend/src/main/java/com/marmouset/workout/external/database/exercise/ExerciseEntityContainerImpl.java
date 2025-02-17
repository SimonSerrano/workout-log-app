package com.marmouset.workout.external.database.exercise;

import com.marmouset.workout.app.port.out.exercise.ExerciseEntity;
import com.marmouset.workout.app.port.out.exercise.ExerciseEntityContainer;

record ExerciseEntityContainerImpl(ExerciseEntity reference)
    implements ExerciseEntityContainer {
}
