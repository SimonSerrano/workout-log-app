package com.marmouset.workout.app.port.out.exercise.trained;

import com.marmouset.workout.app.port.out.exercise.ExerciseEntityContainer;

public record GetTrainedExerciseByExerciseIdRepoRequest(
    ExerciseEntityContainer exerciseContainer) {
}
